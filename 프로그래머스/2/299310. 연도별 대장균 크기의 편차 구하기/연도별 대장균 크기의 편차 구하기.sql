select year(DIFFERENTIATION_DATE) as year,
(
    select max(size_of_colony) as m
    from ecoli_data
    where year(DIFFERENTIATION_DATE) = year
) - size_of_colony as year_dev, id
from ecoli_data
order by year, year_dev


