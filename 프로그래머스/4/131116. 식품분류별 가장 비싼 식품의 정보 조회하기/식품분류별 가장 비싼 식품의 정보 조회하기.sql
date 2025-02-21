select category, price as max_price, product_name
from food_product fp
where price = (
    select max(price)
    from food_product
    where category = fp.category and category in ('과자', '국', '김치', '식용유')
    group by category
)
order by max_price desc