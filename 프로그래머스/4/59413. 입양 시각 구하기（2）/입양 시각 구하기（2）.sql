with recursive hours as (
    select 0 as hour
    union all
    select hour + 1 from hours where hour < 23
)

SELECT h.hour, count(animal_id) as count
from hours h
left join animal_outs a on h.hour = hour(a.datetime)
group by h.hour
order by h.hour;