package com.apap.siperpusproducer.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.apap.siperpusproducer.model.PeminjamanLiteraturModel;


public interface PeminjamanLiteraturService {
	PeminjamanLiteraturModel selectPeminjamanLiteraturByIdLiteratur(int id);
	
	List<PeminjamanLiteraturModel> selectAllPeminjamanLiteratur();
	
	void insertPeminjamanLiteratur(PeminjamanLiteraturModel peminjamanLiteratur);
	
	void updatePeminjamanLiteraturByIdLiteratur(int idPeminajamanLiteratur);
	
	PeminjamanLiteraturModel selectPeminjamanLiteraturById(@Param("id_literatur") String id_literatur);
	
	List<PeminjamanLiteraturModel> selectPeminjamanLiteraturByUsername(String username);
}
