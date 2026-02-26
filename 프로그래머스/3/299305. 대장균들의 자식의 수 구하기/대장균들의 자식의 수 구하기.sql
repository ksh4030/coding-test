select a.id, (
    select count(b.id)
    from ecoli_data b
    where a.id = b.parent_id
) as child_count
from ecoli_data a
order by a.id