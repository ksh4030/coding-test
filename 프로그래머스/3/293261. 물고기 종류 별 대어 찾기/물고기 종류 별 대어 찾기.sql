select a.id, b.fish_name, a.length
from fish_info a
join fish_name_info b on a.fish_type = b.fish_type
where (b.fish_name, a.length) in (
    select b.fish_name, max(a.length) as length
    from fish_info a
    join fish_name_info b on a.fish_type = b.fish_type
    group by b.fish_name
)
order by id