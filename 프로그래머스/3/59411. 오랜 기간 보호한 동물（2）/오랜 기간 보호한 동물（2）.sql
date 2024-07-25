-- 코드를 입력하세요
SELECT a.animal_id, a.name
from animal_ins a
join animal_outs b on a.animal_id = b.animal_id
order by b.datetime - a.datetime desc
limit 2;