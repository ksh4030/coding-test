select a.author_id, a.author_name, b.category, sum(b.price * bs.sales) as totsla_sales
from book_sales bs
join book b on bs.book_id = b.book_id
join author a on b.author_id = a.author_id
where date_format(bs.sales_date, "%Y-%m") = '2022-01'
group by a.author_id, b.category
order by a.author_id, b.category desc;