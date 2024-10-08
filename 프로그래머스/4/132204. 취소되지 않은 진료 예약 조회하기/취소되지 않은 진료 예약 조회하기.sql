-- 코드를 입력하세요
SELECT a.apnt_no, b.pt_name, a.pt_no, a.mcdp_cd, c.dr_name, a.apnt_ymd
from appointment a
join patient b on a.pt_no = b.pt_no
join doctor c on a.mddr_id = c.dr_id
where a.apnt_cncl_yn = 'N' and a.apnt_ymd like '2022-04-13%' and a.mcdp_cd = 'CS'
order by a.apnt_ymd;