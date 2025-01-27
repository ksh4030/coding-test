-- 코드를 작성해주세요
select count(month(time)) as fish_count, month(time) as month
from fish_info
group by month(time)
order by month