-- 코드를 작성해주세요
select count(*) as fish_count
from fish_info a, fish_name_info b
where a.fish_type = b.fish_type and (b.fish_name = 'BASS' or b.fish_name = 'SNAPPER')
;