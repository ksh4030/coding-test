-- 코드를 입력하세요
SELECT cart_id
from cart_products
where name = 'Milk' and cart_id in (
    select cart_id
    from cart_products
    where name = 'Yogurt'
)
order by cart_id;