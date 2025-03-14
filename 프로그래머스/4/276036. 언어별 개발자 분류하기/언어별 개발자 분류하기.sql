with isFront as (
    select sum(code)
    from skillcodes
    where category = 'Front End'
)

select 
case 
    when skill_code & (select code from skillcodes where name = 'Python') and skill_code & (select * from isFront) then 'A'
    when skill_code & (select code from skillcodes where name = 'C#') then 'B'
    when skill_code & (select * from isFront) then 'C'
end as grade, id, email
from DEVELOPERS
having grade is not null
order by grade, id