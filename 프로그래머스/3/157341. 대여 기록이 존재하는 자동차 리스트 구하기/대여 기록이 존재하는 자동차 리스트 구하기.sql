select distinct a.car_id
from car_rental_company_car a, car_rental_company_rental_history b
where a.car_id = b.car_id and a.car_type = '세단' and month(b.start_date) = 10
order by a.car_id desc