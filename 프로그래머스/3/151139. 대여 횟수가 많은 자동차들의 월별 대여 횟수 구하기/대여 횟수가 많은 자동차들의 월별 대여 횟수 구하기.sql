WITH CarRentalCounts AS (
    SELECT
        CAR_ID,
        COUNT(*) AS total_rentals
    FROM
        car_rental_company_rental_history
    WHERE
        START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY
        CAR_ID
    HAVING
        COUNT(*) >= 5
),
MonthlyRentalCounts AS (
    SELECT
        MONTH(START_DATE) AS month,
        CAR_ID,
        COUNT(*) AS records
    FROM
        car_rental_company_rental_history
    WHERE
        START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
        AND CAR_ID IN (SELECT CAR_ID FROM CarRentalCounts)
    GROUP BY
        MONTH(START_DATE),
        CAR_ID
)
SELECT
    month,
    CAR_ID,
    records
FROM
    MonthlyRentalCounts
ORDER BY
    month ASC,
    CAR_ID DESC;