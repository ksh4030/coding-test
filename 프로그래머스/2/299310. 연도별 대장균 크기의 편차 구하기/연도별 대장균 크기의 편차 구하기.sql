-- 코드를 작성해주세요
select year(e.differentiation_date) as year, (m.size - e.size_of_colony) as year_dev, id
from ecoli_data e 
join (
    select year(differentiation_date) as year, max(size_of_colony) as size
    from ecoli_data
    group by year
) m on year(e.differentiation_date) = m.year
order by year, year_dev