package com.apap.siperpusproducer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.siperpusproducer.dao.PeminjamanLiteraturMapper;
import com.apap.siperpusproducer.model.PeminjamanLiteraturModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PeminjamanLiteraturServiceDatabase implements PeminjamanLiteraturService{
	@Autowired
	private PeminjamanLiteraturMapper peminjamanLiteraturMapper;
	
	@Override
	public PeminjamanLiteraturModel selectPeminjamanLiteraturByIdLiteratur(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PeminjamanLiteraturModel> selectAllPeminjamanLiteratur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertPeminjamanLiteratur(PeminjamanLiteraturModel peminjamanLiteratur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePeminjamanLiteraturByIdLiteratur(int idPeminajamanLiteratur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PeminjamanLiteraturModel selectPeminjamanLiteraturById(String id_literatur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PeminjamanLiteraturModel> selectPeminjamanLiteraturByUsername(String username) {
		return peminjamanLiteraturMapper.selectPeminjamanLiteraturByUsername(username);
	}

}
