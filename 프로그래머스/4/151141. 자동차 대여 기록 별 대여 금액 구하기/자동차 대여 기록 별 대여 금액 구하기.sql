with truck_history_table as (
    select h.history_id, c.car_type, c.daily_fee, datediff(h.end_date, h.start_date) + 1 as period,
    case
        when datediff(h.end_date, h.start_date) + 1 >= 90 then '90일 이상'
        when datediff(h.end_date, h.start_date) + 1 >= 30 then '30일 이상'
        when datediff(h.end_date, h.start_date) + 1 >= 7 then '7일 이상'
        else 'NONE'
    end as duration_type    
    from car_rental_company_rental_history h
    join car_rental_company_car c on h.car_id = c.car_id
    where c.car_type = '트럭'
)
SELECT h.history_id, round(h.daily_fee * h.period * (100 - ifnull(d.discount_rate, 0)) / 100) as fee
from truck_history_table h
left join car_rental_company_discount_plan d on h.car_type = d.car_type and h.duration_type = d.duration_type
order by fee desc, h.history_id desc;