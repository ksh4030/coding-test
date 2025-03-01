select concat('/home/grep/src/', gf.board_id, '/', gf.file_id, gf.file_name, gf.file_ext) as file_path
from used_goods_board gb
join used_goods_file gf on gb.board_id = gf.board_id
where gf.board_id = (
    select board_id
    from used_goods_board
    order by views desc
    limit 1
)
order by file_path desc;