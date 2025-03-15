with possible_car as (
    select a.car_id, a.car_type, a.daily_fee
    from car_rental_company_car a
    where (a.car_type = 'SUV' or a.car_type = '세단') and 
    a.car_id not in (
        select b.car_id
        from car_rental_company_rental_history b
        where b.start_date <= '2022-11-30' and b.end_date >= '2022-11-01'
    )
),
discount_table as (
    select car_type, discount_rate
    from car_rental_company_discount_plan
    where car_type in ('SUV', '세단') and duration_type = '30일 이상'
)

select a.car_id, a.car_type, round((30 * (a.daily_fee - (a.daily_fee * (b.discount_rate / 100)))), 0) as fee
from possible_car a
join discount_table b on a.car_type = b.car_type
having fee >= 500000 and fee < 2000000
order by fee desc, a.car_type, a.car_id desc;
