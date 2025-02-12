select a.category, sum(b.sales) as total_sales
from book a, book_sales b
where a.book_id = b.book_id and date_format(b.sales_date, '%Y-%m') = '2022-01'
group by a.category
order by category