select b.user_id, b.nickname, sum(a.price) as total_sales
from used_goods_board a, used_goods_user b
where a.writer_id = b.user_id and status = 'DONE'
group by user_id
having total_sales >= 700000
order by total_sales