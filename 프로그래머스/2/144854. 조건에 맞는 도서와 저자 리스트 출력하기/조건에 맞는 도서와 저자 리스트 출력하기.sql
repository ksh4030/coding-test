-- 코드를 입력하세요
SELECT a.book_id, b.author_name, date_format(a.published_date, '%Y-%m-%d') as publish_date
from book a, author b
where a.author_id = b.author_id and a.category = '경제'
order by a.published_date;
