package com.apap.siperpusproducer.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.apap.siperpusproducer.model.PeminjamanLiteraturModel;

@Mapper
public interface PeminjamanLiteraturMapper {
	
	@Select("SELECT * FROM peminjaman_literatur WHERE id=#{id}")
	@Results({
		@Result(property="idLiteratur", column="id_literatur"),
		@Result(property="usernamePeminjam", column="username_peminjam"),
		@Result(property="tanggaPeminjaman", column="tanggal_peminjaman"),
		@Result(property="tanggalPengembalian", column="tanggal_pengembalian"),
		@Result(property="statusPeminjaman", column="status_peminjaman"),
		@Result(property="idSurat", column="is_surat")
	})
	PeminjamanLiteraturModel selectPeminjamanLiteraturByIdLiteratur(int id);
	
	@Select("SELECT * FROM peminjaman_literatur")
	@Results({
		@Result(property="idLiteratur", column="id_literatur"),
		@Result(property="usernamePeminjam", column="username_peminjam"),
		@Result(property="tanggaPeminjaman", column="tanggal_peminjaman"),
		@Result(property="tanggalPengembalian", column="tanggal_pengembalian"),
		@Result(property="statusPeminjaman", column="status_peminjaman"),
		@Result(property="idSurat", column="id_surat")
	})
	List<PeminjamanLiteraturModel> selectAllPeminjamanLiteratur();
	
	@Insert("INSERT INTO peminjaman_literatur VALUES '("
			+ "#{idLiteratur},"
			+ "#{usernamePeminjam},"
			+ "#{tanggalPeminjaman}"
			+ "#{tanggalPengembalian}"
			+ "#{statusPeminjaman}"
			+ "#{idSurat}"
			+ ")")
	void insertPeminjamanLiteratur(PeminjamanLiteraturModel peminjamanLiteratur);
	
	@Update("UPDATE peminjaman_literatur SET "
			+ "id_literatur=#{idLiteratur},"
			+ "username_peminjam=#{usernamePeminjam},"
			+ "tanggal_peminjaman=#{tanggalPeminjaman}, "
			+ "tanggal_pengembalian=#{tanggalPengembalian}, "
			+ "status_peminjaman=#{statusPeminjaman}, "
			+ "id_surat=#{idSurat} "
			+ "where id =#{idPeminajamanLiteratur}")
	void updatePeminjamanLiteraturByIdLiteratur(int idPeminajamanLiteratur);

	@Select("SELECT * FROM peminjaman_literatur where id = #{id_literatur}")
	PeminjamanLiteraturModel selectPeminjamanLiteraturById(@Param("id_literatur") String id_literatur);
	
	@Select("SELECT * FROM peminjaman_literatur where username_peminjaman = #{username}")
	List<PeminjamanLiteraturModel> selectPeminjamanLiteraturByUsername(String username);
}
