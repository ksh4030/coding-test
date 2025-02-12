select name, datetime
from animal_ins
where ANIMAL_ID not in (select ANIMAL_ID from animal_outs)
order by datetime
limit 3