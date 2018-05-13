package com.apap.siperpusproducer.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apap.siperpusproducer.model.PeminjamanLiteraturModel;
import com.apap.siperpusproducer.service.PeminjamanLiteraturService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/siperpus/api")
public class PeminjamanLiteraturRestController {
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	
	private static final String OVERDUE = "overdue";
	
	@Autowired
	PeminjamanLiteraturService peminjamanLiteraturDAO;
	
	@RequestMapping("/v1/isOverdue/{username}")
	public Map<String, String> checkOverduePeminjamanByUsername(@PathVariable(value = "username") String username, Model model) {
		Map<String, String> response = new HashMap<>();
		int countLiteratur = 0;
		
		try {
			
			List<PeminjamanLiteraturModel> listPeminjamanLiteraturLate = new ArrayList<PeminjamanLiteraturModel>();
			
			List<PeminjamanLiteraturModel> listPeminjamanLiteratur = peminjamanLiteraturDAO.selectPeminjamanLiteraturByUsername(username);
			
			for(PeminjamanLiteraturModel peminjaman : listPeminjamanLiteratur) {
				if(checkDatePassed(peminjaman.getTanggal_pengembalian()) 
						|| 
					peminjaman.getStatus_peminjaman().toLowerCase().equals(OVERDUE)) {
					listPeminjamanLiteraturLate.add(peminjaman);
					countLiteratur++;
				}
			}
			
			//Construct success response
			boolean isOverdue = (countLiteratur >= 1 ? true : false);
			String message = username + " memilki literatur yang belum dikembalikan. ";
			if(!isOverdue) {
				message = username + " tidak memilki literatur yang belum dikembalikan. ";
			}
			
			response.put("status", String.valueOf(200));
			response.put("message", message);
			response.put("jumlah_literatur_overdue", String.valueOf(countLiteratur));
			response.put("username", username);
		} catch (Exception e) {
			log.error("PeminjamanLiteraturRestController, checkOverduePeminjamanByUsername, username " 
					+ username
					, e);
			
			//Construct error response
			response.put("status", String.valueOf(500));
			response.put("message", "Internal Server Error");
			response.put("username", username);
		}
		
		return response;
	}
	
	private boolean checkDatePassed(String dateStr) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		Date datePengembalian = dateFormat.parse(dateStr);
		Date dateCurr = new Date();
		
		return dateCurr.after(datePengembalian);
	}

}