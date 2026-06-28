select
	*
from
	employee
where
	name like 'h%'
	or name like 'k%'
	or name like 't%'
	-- 3
// loai 1 
select
	*,
	(year(curdate()) - year(c.birthday))
from
	customer c
where
	(place like '% đà nẵng'
		or place like '% quảng trị')
	and ((year(curdate()) - year(c.birthday)) > 18
		and (year(curdate()) - year(c.birthday)) < 50)


select
	*,
	(year(curdate()) - year(c.birthday))
from
	customer c
where
	(place like '% đà nẵng'
		or place like '% quảng trị')
	and (timestampdiff(year, c.birthday , curdate()) >18
		and timestampdiff(year, c.birthday , curdate()) <50)
	-- 4
select
	cu.id,
	cu.name ,
	count(c.contract_id) as sl
from
	customer cu
join contract c on
	c.customer_id = cu.id
where
	cu.customer_type = 1
group by
	cu.id
order by
	sl asc
	-- 5
select
	c.id,
	c.name,
	ct.name,
	co.contract_id
from
	customer c
join customer_type ct on
	c.id = ct.id
left join contract co on
	co.customer_id = c.id