use quan_ly_khu_nghi_duong_furama


-- 21
create view v_nhan_vien  as
select * from employee em
join contract co on em.id = co.employee_id 
where place like '%Nguyễn Chí Thanh%' and start_date = '2021-09-02'


select * from v_nhan_vien 

-- 22 

update v_nhan_vien
set place = 'Liên chiểu, Đà Nẵng'
where place like '4 Nguyễn %'

rollback
-- 23 
delimiter //
create procedure deleteCustomer(
	in c_id int
)
begin
	delete
    from customer
    where id = p_id;
end //
delimiter ;

start transaction

call deleteCustomer(1);
rollback

-- 24
select  * from contract

use quan_ly_khu_nghi_duong_furama
-- delimiter //
create procedure sp_them_moi_hop_dong(
	in contract_id int ,
	in start_date date,
	in end_date date,
	in deposit_amount double,
	in employee_id int,
	in customer_id int,
	in service_id int
)
begin 
	insert into contract(
	contract_id,
	start_date,
	end_date,
	deposit_amount,
	employee_id,
	customer_id,
	service_id
) values (contract_id,start_date,end_date,deposit_amount,employee_id,customer_id,service_id);

		
end 
-- delimiter ;

SHOW PROCEDURE STATUS
WHERE Db = 'quan_ly_khu_nghi_duong_furama';

call sp_them_moi_hop_dong(13, '2021-05-25', '2021-05-27',5000,10,10,1);

-- 25

-- ghi log thay cho việc ghi ở console.

create table log_contract (
    id int auto_increment primary key,
    message varchar(255),
    created_at datetime default current_timestamp
);

create trigger tr_xoa_hop_dong
after delete on contract 
for each row
begin 
	declare total int; 
	select count(*) into total 
	from contract;

	insert into log_contract(message)
	values (concat('so hop dong con lai: ',total));
end;


-- 26

create trigger tr_cap_nhap_hop_dong
before update 
on contract 
for each row
begin 
	if datediff(new.end_date,new.start_date) < 2 then
		signal sqlstate '45000'
		set message_text = 'ngay ket thuc hop dong phai lon hon ngay lam hop dong it nhat 2 ngay';
	end if;
end;

-- 27

-- 27-1
select * from contract 



create function func_dem_dich_vu()
returns int
reads sql data
begin 
	declare v_count int;
	select count(*) into v_count from contract c
	where c.deposit_amount >= 2000000;
	return v_count;
end;

SELECT func_dem_dich_vu();


-- 27-2
create function func_tinh_thoi_gian_hop_dong(p_customer_id int)
returns int
reads sql data
begin
    declare v_max_day int;

    select max(datediff(end_date, start_date))
    into v_max_day
    from contract
    where customer_id = p_customer_id;

    return ifnull(v_max_day, 0);
end;

-- 28 



create procedure sp_xoa_dich_vu_va_hd_room()
begin

    -- xóa chi tiết hợp đồng
    delete from detail_contracts
    where contract_id in (
        select contract_id
        from (
            select c.contract_id
            from contract c
            join services s on c.service_id = s.id
            join service_type st on s.service_type = st.id
            where st.name = 'room'
              and c.start_date between '2015-01-01' and '2019-12-31'
        ) t
    );

    -- xóa hợp đồng
    delete from contract
    where contract_id in (
        select contract_id
        from (
            select c.contract_id
            from contract c
            join services s on c.service_id = s.id
            join service_type st on s.service_type = st.id
            where st.name = 'room'
              and c.start_date between '2015-01-01' and '2019-12-31'
        ) t
    );

    -- xóa dịch vụ
    delete from services
    where id in (
        select id
        from (
            select s.id
            from services s
            join service_type st on s.service_type = st.id
            join contract c on c.service_id = s.id
            where st.name = 'room'
              and c.start_date between '2015-01-01' and '2019-12-31'
        ) t
    );

end 


