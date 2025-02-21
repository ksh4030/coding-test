select mcdp_cd, count(mcdp_cd) as 5월예약건수
from appointment
where date_format(apnt_ymd, "%Y-%m") = '2022-05'
group by mcdp_cd
order by 5월예약건수, mcdp_cd
;