SELECT b.author_id, b.author_name, a.category, sum(c.sales * a.price) as total_sales
from book a
join author b on a.author_id = b.author_id
join book_sales c on a.book_id = c.book_id
where month(c.sales_date) = 1
group by b.author_id, b.author_name, a.category
order by author_id, category desc;
