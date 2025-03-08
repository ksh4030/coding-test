-- 코드를 작성해주세요
select e.id, (
    select count(se.id)
    from ecoli_data se
    where e.id = se.parent_id
) as child_count 
from ecoli_data e
order by id;