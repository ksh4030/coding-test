-- 코드를 작성해주세요
with a as (
    select id, ntile(4) over(order by size_of_colony desc) as p
    from ecoli_data
)
select id,
case when p = 1 then 'CRITICAL'
when p = 2 then 'HIGH'
when p = 3 then 'MEDIUM'
when p = 4 then 'LOW'
end as colony_name
from a
order by id;