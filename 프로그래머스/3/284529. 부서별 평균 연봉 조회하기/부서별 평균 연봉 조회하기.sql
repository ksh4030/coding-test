select hd.dept_id, hd.dept_name_en, round(avg(he.sal), 0) as avg_sal
from hr_employees he
join hr_department hd on he.dept_id = hd.dept_id
group by hd.dept_id, hd.dept_name_en
order by avg_sal desc;