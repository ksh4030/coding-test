-- 코드를 입력하세요
SELECT a.product_id, a.product_name, sum(a.price * b.amount) as total_sales
from food_product a
join food_order b on a.product_id = b.product_id
where month(b.produce_date) = 5
group by a.product_id, a.product_name
order by total_sales desc, product_id
;