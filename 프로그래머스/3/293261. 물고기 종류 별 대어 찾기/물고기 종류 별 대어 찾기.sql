-- 코드를 작성해주세요
select id, fish_name, length
from fish_info fi
join fish_name_info fn on fi.fish_type = fn.fish_type
where (fi.fish_type, length) in (
    select fish_type, max(length)
    from fish_info subfi
    group by fish_type
)
order by id;