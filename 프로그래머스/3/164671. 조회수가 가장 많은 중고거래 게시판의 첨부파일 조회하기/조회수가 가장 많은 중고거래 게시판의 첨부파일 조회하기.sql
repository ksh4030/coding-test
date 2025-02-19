select concat('/home/grep/src/', board_id, '/', file_id, file_name, file_ext) as file_path
from used_goods_file
where board_id = (
    select board_id 
    from used_goods_board 
    group by board_id 
    having max(views) 
    order by max(views) 
    desc limit 1
)
order by file_id desc;
