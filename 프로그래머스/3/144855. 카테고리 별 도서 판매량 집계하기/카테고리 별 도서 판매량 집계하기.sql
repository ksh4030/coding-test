select b.category, sum(bs.sales) as total_sales
from book_sales bs
join book b on bs.book_id = b.book_id
where date_format(bs.sales_date, "%Y-%m") = '2022-01'
group by b.category
order by category