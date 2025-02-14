with ranked as (
    select id, size_of_colony, ntile(4) over(order by size_of_colony desc) as group_rank
    from ecoli_data
)

select id, 
    case
        when group_rank = 1 then 'CRITICAL'
        when group_rank = 2 then 'HIGH'
        when group_rank = 3 then 'MEDIUM'
        else 'LOW'
    end as colony_name
from ranked
order by id;