	-- 11
select
	*
from
	additional_services adds
left join detail_contracts dc on
	adds.id = dc.additional_service_id
join contract ct on
	ct.contract_id = dc.contract_id
join customer cu on
	ct.customer_id = cu.id
join customer_type cut on
	cut.id = cu.customer_type
where
	cut.name like 'diamond'
	and (cu.place like '% vinh'
		or cu.place like '% quảng ngãi')
	-- 12

select
	co.contract_id ,
	e.name ,
	cu.name ,
	cu.phone,
	s.id ,
	s.name,
	ifnull(sum(quantity), 0) as tong,
	co.deposit_amount
from
	contract co
join customer cu on
	cu.id = co.customer_id
join employee e on
	e.id = co.employee_id
join services s on
	co.service_id = s.id
left join detail_contracts dc on
	dc.contract_id = co.contract_id
where
	exists (
	select
		1
	from
		contract ct
	where
		ct.service_id = co.service_id
		and (year(ct.start_date) = 2020
			and month(ct.start_date) >= 10 )
)
	and not exists (
	select
		1
	from
		contract ct
	where
		ct.service_id = co.service_id
		and (year(ct.start_date) = 2021
			and month(ct.start_date) <= 6 )
)
group by
	co.contract_id
	-- 13
select
	t.id ,
	t.name,
	sum(dc.quantity) as tong
from
	additional_services t
join detail_contracts dc on
	t.id = dc.additional_service_id
group by
	t.id
having
	sum(dc.quantity) = (
	select
		max(t.tong)
	from
		(
		select
			sum(dc.quantity) as tong
		from
			additional_services t
		join detail_contracts dc on
			t.id = dc.additional_service_id
		group by
			t.id) as t)
;
-- 14 
select
	ct.contract_id ,
	st.name,
	t.name ,
	count(*)
from
	contract ct
join services se on
	ct.service_id = se.id
join service_type st on
	st.id = se.service_type
join detail_contracts dc on
	dc.contract_id = ct.contract_id
join additional_services t on
	dc.additional_service_id = t.id
where
	dc.additional_service_id in (
	select
		additional_service_id
	from
		detail_contracts
	group by
		additional_service_id
	having
		count(additional_service_id) = 1
)
group by
	ct.contract_id ,
	st.name,
	t.name
order by
	ct.contract_id;
-- 15
select
	e.id ,
	e.name ,
	q.name ,
	d.name ,
	e.phone ,
	e.place,
	count(c.contract_id)
from
	employee e
join department d on
	e.department = d.id
join `position` p on
	e.position_id = p.id
join qualification q on
	e.qualification_id = q.id
left join contract c on
	c.employee_id = e.id
group by
	e.id,
	e.name ,
	q.name ,
	d.name ,
	e.phone ,
	e.place
having
	count(c.contract_id) <= 3
	and count(c.contract_id) >0;
