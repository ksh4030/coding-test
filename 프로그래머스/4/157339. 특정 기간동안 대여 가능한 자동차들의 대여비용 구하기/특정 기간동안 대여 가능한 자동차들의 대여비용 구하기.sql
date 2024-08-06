WITH available_cars AS (
    SELECT a.car_id, a.car_type, a.daily_fee
    FROM CAR_RENTAL_COMPANY_CAR a
    WHERE a.car_type IN ('세단', 'SUV')
    AND a.car_id NOT IN (
        SELECT b.car_id
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY b
        WHERE b.start_date <= '2022-11-30' AND b.end_date >= '2022-11-01'
    )
), price_cars as (
    SELECT a.car_id, a.car_type, a.daily_fee, 
           30 * a.daily_fee * (1 - COALESCE(d.discount_rate, 0) / 100) AS fee
    FROM available_cars a
    LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN d ON a.car_type = d.car_type
    WHERE d.duration_type = '30일 이상'
)

select car_id, car_type, round(fee) as fee
from price_cars
where fee between 50000 and 2000000
;