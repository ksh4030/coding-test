with recursive hours as (
    select 0 as hour
    union all
    select hour + 1 from hours where hour < 23
)

select hour, count(a.datetime) as count
from hours h
left join animal_outs a on h.hour = hour(a.datetime)
group by hour
order by hour