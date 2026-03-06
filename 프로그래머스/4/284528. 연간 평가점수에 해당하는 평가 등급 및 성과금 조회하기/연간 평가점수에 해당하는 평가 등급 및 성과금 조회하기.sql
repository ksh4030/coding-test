select a.emp_no, a.emp_name, 
case 
    when sum(c.score) / 2 >= 96 then 'S'
    when sum(c.score) / 2 >= 90 then 'A'
    when sum(c.score) / 2 >= 80 then 'B'
    else 'C'
end as grade,
case
    when sum(c.score) / 2 >= 96 then a.sal * 0.2
    when sum(c.score) / 2 >= 90 then a.sal * 0.15
    when sum(c.score) / 2 >= 80 then a.sal * 0.1
    else 0
end as bonus
from HR_EMPLOYEES a
join HR_DEPARTMENT b on a.dept_id = b.dept_id
join HR_GRADE c on a.emp_no = c.emp_no
group by a.emp_no, a.emp_name
order by emp_no