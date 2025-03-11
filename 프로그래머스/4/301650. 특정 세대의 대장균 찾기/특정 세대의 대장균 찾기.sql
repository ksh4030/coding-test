# WITH RECURSIVE generation_cte AS (
#     -- 앵커: 최초 개체는 1세대 (PARENT_ID가 NULL)
#     SELECT ID, PARENT_ID, 1 AS generation
#     FROM ECOLI_DATA
#     WHERE PARENT_ID IS NULL

#     UNION ALL

#     -- 재귀: 부모의 세대에 1을 더해서 자식의 세대를 계산
#     SELECT e.ID, e.PARENT_ID, cte.generation + 1
#     FROM ECOLI_DATA e
#     JOIN generation_cte cte ON e.PARENT_ID = cte.ID
# )
# SELECT ID
# FROM generation_cte
# WHERE generation = 3
# ORDER BY ID;

with recursive generation_table as (
    select id, parent_id, 1 as generation
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, e.parent_id, g.generation + 1
    from ecoli_data e
    join generation_table g on e.parent_id = g.id
)

select id
from generation_table
where generation = 3
order by id;