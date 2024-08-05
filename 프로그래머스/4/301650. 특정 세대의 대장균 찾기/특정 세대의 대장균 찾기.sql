with first_tables as (
    select id
    from ecoli_data
    where parent_id is null
),
second_tables as (
    select id
    from ecoli_data
    where parent_id in (
        select id
        from first_tables
    )
)
select id
from ecoli_data
where parent_id in (select id from second_tables)
order by id
;

