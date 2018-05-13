package com.apap.siperpusproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeminjamanLiteraturModel {
	private int id;
	private int id_literatur;
	private String username_peminjaman;
	private String tanggal_peminjaman;
	private String tanggal_pengembalian;
	private String status_peminjaman;
	private String id_surat;
}
