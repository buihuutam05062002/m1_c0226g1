create table nha_ncc(
	ma_ncc int primary key,
	ten_ncc varchar(50),
	dia_chi varchar(255)
);

create table sdt(
	sdt varchar(20) primary key,
	ma_ncc int,
	foreign key (ma_ncc) references nha_ncc(ma_ncc)
	);


create table don_dh(
	so_dh int primary key,
	ngay_dh date,
	ma_ncc int ,
	constraint fk_nha_ncc_don_dh foreign key (ma_ncc) references nha_ncc(ma_ncc)
	
);
create table phieuxuat(
	so_px int primary key,
	ngay_xuat date
);

create table vattu(
	ma_vtu int primary key, 
	ten_vtu varchar(50)
);
create table phieunhap(
	so_pn int primary key,
	ngay_nhap date
);

create table chi_tiet_phieu_xuat(
	so_px int,
	ma_vtu int,
	dg_xuat double,
	sl_xuat int,
	
	primary key (so_px, ma_vtu),
	foreign key (so_px) REFERENCES  phieuxuat(so_px),
	foreign key (ma_vtu) REFERENCES vattu(ma_vtu)
);
create table chi_tiet_phieu_nhap(
	so_pn int ,
	ma_vtu int ,
	dg_nhap double,
	sl_nhap int,
	primary key (so_pn, ma_vtu),
	foreign key (so_pn) references phieunhap(so_pn),
	foreign key (ma_vtu) references vattu(ma_vtu)
);
create table chi_tiet_don_dat_hang(
	so_dh int ,
	ma_vtu int ,
	primary key (so_dh,ma_vtu),
	foreign key  (so_dh) references don_dh(so_dh),
	foreign key (ma_vtu) references vattu(ma_vtu)
);
