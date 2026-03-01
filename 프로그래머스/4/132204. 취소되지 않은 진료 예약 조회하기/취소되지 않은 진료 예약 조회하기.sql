SELECT a.apnt_no, b.pt_name, b.pt_no, a.mcdp_cd, c.dr_name, a.apnt_ymd
from APPOINTMENT a
join PATIENT  b on a.pt_no = b.pt_no
join DOCTOR c on a.mddr_id = c.dr_id
where date_format(a.APNT_YMD, '%Y-%m-%d') = '2022-04-13' and a.apnt_cncl_yn = 'N' and c.mcdp_cd = 'CS'
order by apnt_ymd