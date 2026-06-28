create database ss5;

use ss5;

	create table products(
		id int primary key,
		product_code varchar(10),
		product_name varchar(20),
		product_price double,
		product_amount int,
		product_description varchar(50),
		product_status varchar(20)
	);

INSERT INTO products
(id, product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES
(1, 'F001', 'Premium Jasmine Rice 5kg', 185000, 120, 'High quality fragrant jasmine rice', 'Available'),
(2, 'F002', 'Sunflower Cooking Oil 2L', 145000, 80, 'Refined sunflower cooking oil', 'Available'),
(3, 'F003', 'Organic Green Tea', 95000, 60, '100 tea bags', 'Available'),
(4, 'F004', 'Dark Chocolate Cookies', 68000, 150, 'Butter cookies with dark chocolate', 'Available'),
(5, 'F005', 'Instant Oatmeal', 125000, 90, 'Healthy breakfast oats 1kg', 'Available');



create unique index idx_code
on products(product_code);

create index idx_product
on products(product_name, product_price);


explain select * from products where product_code = 'F001';
explain select * from products where product_name = 'Sunflower Cooking Oil 2L' and product_price = 145000;


create view view_info as
select product_code,product_name,product_price,product_status 
from products;

select * from view_info;


create or replace view view_info as
select  product_code,  product_name,  product_price,  product_amount,  product_status
from  products;
    
drop view if exists view_info;



delimiter //
create procedure get_all_products()
begin 
select * from products;
end //
delimiter ;

delimiter //


call get_all_products()

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure addProduct(
	in p_id int,
    in p_code varchar(10),
    in p_name varchar(20),
    in p_price double,
    in p_amount int,
    in p_description varchar(50),
    in p_status varchar(20)
)
begin
	insert into products(
		id,
        product_code,
        product_name,
        product_price,
        product_amount,
        product_description,
        product_status
    )
    values(
		p_id,
        p_code,
        p_name,
        p_price,
        p_amount,
        p_description,
        p_status
    );
end //
delimiter ;

call addProduct(6, 'F006', 'Natural Honey 1L', 245000, 40, 'Pure forest honey', 'Available');

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure deleteProduct(
	in p_id int
)
begin
	delete
    from products
    where id = p_id;
end //
delimiter ;

call deleteProduct(1);

show procedure status
where db = database();

show create procedure updateProduct;
