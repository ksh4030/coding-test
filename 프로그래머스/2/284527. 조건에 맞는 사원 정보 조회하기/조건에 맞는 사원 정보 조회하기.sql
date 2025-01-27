select sum(b.score) as score, a.emp_no, a.emp_name, a.position, a.email
from hr_employees a, hr_grade b
where a.emp_no = b.emp_no
group by a.emp_no
order by score desc
limit 1;
