select sum(hg.score) as score, he.emp_no, he.emp_name, he.position, he.email
from hr_grade hg 
join hr_employees he on hg.emp_no = he.emp_no
group by he.emp_no, he.emp_name, he.position, he.email
order by score desc
limit 1;