-- 코드를 작성해주세요
select a.emp_no, a.emp_name,
(case 
    when avg(score) >= 96 then 'S'
    when avg(score) >= 90 then 'A'
    when avg(score) >= 80 then 'B'
    else 'C' end
) as grade,
(case
    when avg(score) >= 96 then a.sal * 0.2
    when avg(score) >= 90 then a.sal * 0.15
    when avg(score) >= 80 then a.sal * 0.1
    else 0 end
) as bonus
from hr_employees a
join hr_grade b on a.emp_no = b.emp_no
group by a.emp_no
order by a.emp_no
;