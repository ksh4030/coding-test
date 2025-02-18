select hg.emp_no, he.emp_name, 
case
    when avg(hg.score) >= 96 then 'S'
    when avg(hg.score) >= 90 then 'A'
    when avg(hg.score) >= 80 then 'B'
    else 'C'
end as grade,
case
    when avg(hg.score) >= 96 then he.sal * 0.2
    when avg(hg.score) >= 90 then he.sal * 0.15
    when avg(hg.score) >= 80 then he.sal * 0.1
    else 0
end as bonus
from hr_grade hg
join hr_employees he on hg.emp_no = he.emp_no
group by hg.emp_no
order by hg.emp_no