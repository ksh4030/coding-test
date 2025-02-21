select he.emp_no, he.emp_name,
case
    when avg(score) >= 96 then 'S'
    when avg(score) >= 90 then 'A'
    when avg(score) >= 80 then 'B'
    else 'C'
end as grade,
case
    when avg(score) >= 96 then he.sal * 0.2
    when avg(score) >= 90 then he.sal * 0.15
    when avg(score) >= 80 then he.sal * 0.1
    else 0
end as bonus
from hr_grade hr
join hr_employees he on hr.emp_no = he.emp_no
group by he.emp_no, he.emp_name
order by he.emp_no 