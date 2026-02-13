select a.dept_id, a.dept_name_en, round(avg(b.sal)) as avg_sal
from hr_department a
join hr_employees b on a.dept_id = b.dept_id
group by a.dept_id, a.dept_name_en
order by avg_sal desc;