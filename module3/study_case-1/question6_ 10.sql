select
	s.id,
	s.name,
	s.usable_area,
	s.rental_cost,
	st.name as type_of_service
from
	services s
join service_type st on
	s.service_type = st.id
where
	s.id not in (
	select
		co.service_id
	from
		contract co
	join customer cu on
		co.customer_id = cu.id
	where
		year(co.start_date) = 2021
			and month(co.start_date) <= 3 )
	-- 7 
select
	se.id,
	se.name,
	se.usable_area,
	se.number_of_participants,
	se.rental_cost,
	ser.name
from
	services se
join service_type ser on
	se.service_type = ser.id
left join contract ct on
	se.id = ct.service_id
where
	exists(
	select 1 from contract ct 
	where ct.service_id = se.id and year(start_date) = 2020
)
	and not exists (
	select
		1
	from
		contract ct
	where
		ct.service_id = se.id
		and year(start_date) = 2021
)
group by
	se.id
	-- 8 
select
	*
from
	customer c
	-- 9 
select
	month(ct.start_date),
	count(customer_id)
from
	contract ct
where
	year(ct.start_date) = 2021
group by
	month(ct.start_date)
order by
	month(ct.start_date)
	-- 10

select
	ct.contract_id,
	ct.start_date ,
	ct.end_date ,
	ct.deposit_amount ,
	ifnull(sum(dc.quantity) , 0)
from
	contract ct
left join detail_contracts dc on
	ct.contract_id = dc.contract_id
group by
	ct.contract_id