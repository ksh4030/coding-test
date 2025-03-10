-- 코드를 입력하세요
SELECT a.apnt_no, p.pt_name, p.pt_no, d.mcdp_cd, d.dr_name, a.apnt_ymd
from appointment a
join patient p on a.pt_no = p.pt_no
join doctor d on a.mddr_id = d.dr_id
where date_format(a.apnt_ymd, '%Y-%m-%d') = '2022-04-13' and a.apnt_cncl_yn = 'N' and a.mcdp_cd = 'CS'
order by apnt_ymd;
