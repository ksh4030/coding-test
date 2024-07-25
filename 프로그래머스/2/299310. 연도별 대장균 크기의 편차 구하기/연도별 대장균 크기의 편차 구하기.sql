-- 코드를 작성해주세요
select year(a.DIFFERENTIATION_DATE) as year, b.max_size - a.size_of_colony as year_dev, a.id
from ecoli_data a
join (
    select year(DIFFERENTIATION_DATE) as year, max(size_of_colony) as max_size
    from ecoli_data
    group by year
) b on year(a.DIFFERENTIATION_DATE) = b.year
order by year(a.DIFFERENTIATION_DATE), b.max_size - a.size_of_colony
;