-- 코드를 작성해주세요
select sum(b.score) as score, a.emp_no, a.emp_name, a.position, a.email
from hr_employees a
join hr_grade b on a.emp_no = b.emp_no
where b.year = '2022'
group by a.emp_no
order by score desc
limit 1
;