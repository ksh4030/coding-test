-- 코드를 작성해주세요
select count(*) as COUNT
from ecoli_data
where !(genotype & 2) and (genotype & 1 or genotype & 4);