select concat(quarter(differentiation_date), 'Q') as quarter, count(id) as ecoli_count
from ecoli_data
group by quarter
order by quarter