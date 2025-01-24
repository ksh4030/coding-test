-- 코드를 작성해주세요
select id, ifnull(length, 10) as length
from fish_info
order by length desc, id
limit 10;

