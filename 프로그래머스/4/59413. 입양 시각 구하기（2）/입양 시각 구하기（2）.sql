set @hour = -1;
SELECT (@hour := @hour + 1) as hour,
(
    select count(hour(datetime)) 
    from animal_outs
    where hour(datetime) = @hour
) as count
from animal_outs
where @hour < 23
;