-- 코드를 입력하세요
SELECT a.product_code, sum(a.price * b.sales_amount) as sales
from product a, offline_sale b
where a.product_id = b.product_id
group by b.product_id
order by sales desc, a.product_code;