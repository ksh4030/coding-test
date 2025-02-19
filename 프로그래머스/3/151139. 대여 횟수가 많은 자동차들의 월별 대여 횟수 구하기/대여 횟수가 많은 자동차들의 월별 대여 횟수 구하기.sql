select month(start_date) as month, car_id, count(history_id) as records
from car_rental_company_rental_history
where month(start_date)>=8 and month(start_date) <=10 and car_id in (
    select car_id
    from car_rental_company_rental_history
    where month(start_date)>=8 and month(start_date) <=10
    group by car_id
    having count(car_id) >= 5
)
group by month, car_id
having records > 0
order by month, car_id desc
;