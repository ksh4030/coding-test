select a.id, b.fish_name, a.length
from fish_info a
join fish_name_info b on a.fish_type = b.fish_type
where a.length = (
    select max(length)
    from fish_info
    where fish_type = a.fish_type
)
order by id;