-- 코드를 작성해주세요
select a.item_id, a.item_name
from item_info a, item_tree b
where a.item_id = b.item_id and b.parent_item_id is null
order by a.item_id
;