-- 코드를 입력하세요
SELECT history_id, car_id, 
date_format(start_date, "%Y-%m-%d"), 
date_format(end_date, "%Y-%m-%d"),
case when datediff(end_date, start_date) + 1 >= 30 then '장기 대여' else '단기 대여'
end as rent_type
from car_rental_company_rental_history
where date_format(start_date, "%Y-%m") like '%2022-09%'
order by history_id desc;