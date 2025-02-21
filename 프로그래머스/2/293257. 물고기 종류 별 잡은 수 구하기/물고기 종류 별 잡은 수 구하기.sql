select count(fi.id) as fish_count, fn.fish_name
from fish_name_info fn
join fish_info fi on fn.fish_type = fi.fish_type
group by fn.fish_type, fn.fish_name
order by fish_count desc;