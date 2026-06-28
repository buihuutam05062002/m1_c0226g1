--16

start transaction;

delete
from
	employee e
where
	not exists (
	select
		1
	from
		contract c
	where
		e.id = c.employee_id
)
	-- show result and backup
select
	e.id,
	e.name,
	count(c.contract_id)
from
	employee e
left join contract c on
	e.id = c.employee_id
	-- where year(c.start_date ) between 2019 and 2021
group by
	e.id,
	e.name 	
rollback;
-- 17
start transaction;

update
	customer
set
	customer_type = 1
where
	id in (
	select
		id
	from
		(
		select
			cu.id
		from
			customer cu
		join customer_type ct on
			ct.id = cu.id
		left join contract c on
			c.customer_id = cu.id
		join services s on
			s.id = c.service_id
		where
			ct.id = 2
			and year(c.start_date) = 2021
		group by
			cu.id ,
			cu.name
	)t

);

rollback
-- check
select
	cu.id ,
	cu.name,
	sum(s.rental_cost)
from
	customer cu
join customer_type ct on
	ct.id = cu.id
left join contract c on
	c.customer_id = cu.id
join services s on
	s.id = c.service_id
where
	ct.id = 2
	and year(c.start_date) = 2021
group by
	cu.id ,
	cu.name
;
-- 18
start transaction ;

delete
from
	customer
where
	id in (
	select
		id
	from
		(
		select
			c.id
		from
			contract co
		join customer c on
			co.customer_id = c.id
		where
			year(co.start_date) < 2021
	)t

);

rollback
;

select
	c.id ,
	c.name
from
	contract co
join customer c on
	co.customer_id = c.id
where
	year(co.start_date) < 2021

--19
start transaction ;

update
	additional_services
set
	price = price * 2
where
	additional_services.id in (
	select
		id
	from
		(
		select
			de.additional_service_id
		from
			detail_contracts de
		join contract co on
			de.contract_id = co.contract_id
		join additional_services t on
			t.id = de.additional_service_id
		where
			year(co.start_date) = 2020
		group by
			de.additional_service_id
		having
			sum(de.quantity) > 10
	) t

);

rollback;

select
	co.contract_id ,
	de.additional_service_id ,
	sum(de.quantity)
from
	detail_contracts de
join contract co on
	de.contract_id = co.contract_id
join additional_services t on
	t.id = de.additional_service_id
where
	year(co.start_date) = 2020
group by
	co.contract_id,
	de.additional_service_id
having
	sum(de.quantity) > 10
	-- 20
select
	e.id ,
	e.name ,
	e.email ,
	e.phone ,
	e.birthday ,
	e.place
from
	employee e
union all
select
	c.id ,
	c.name ,
	c.email ,
	c.phone ,
	c.birthday ,
	c.place
from
	customer c
