create table tbl_artist_201905(
	artist_id varchar2(4) primary key,
	artist_name varchar2(20),
	artist_birth varchar2(8),
	artist_gender varchar2(1),
	talent varchar2(1),
	agency varchar2(20)
);
drop table tbl_artist_201905;
drop table tbl_mento_201905;
drop table tbl_point_201905;

select * from tbl_artist_201905;
select * from tbl_mento_201905;
select * from tbl_point_201905;

insert into TBL_ARTIST_201905 
values('A001','황스타','19970101','F','1','A엔터테이먼트');
insert into TBL_ARTIST_201905 
values('A002','정스타','19970201','M','2','B엔터테이먼트');
insert into TBL_ARTIST_201905 
values('A003','박스타','19970301','M','3','C엔터테이먼트');
insert into TBL_ARTIST_201905 
values('A004','김스타','19970401','M','1','D엔터테이먼트');
insert into TBL_ARTIST_201905 
values('A005','서스타','19970501','F','2','E엔터테이먼트');

create table tbl_mento_201905(
	mento_id varchar2(4) primary key,
	mento_name varchar2(20)
);

insert into tbl_mento_201905 values('J001','이멘토');
insert into tbl_mento_201905 values('J002','안멘토');
insert into tbl_mento_201905 values('J003','한멘토');

create table tbl_point_201905(
	serial_no varchar2(4) primary key,
	artist_id varchar2(20),
	mento_id varchar2(8),
	point number(6)
);

insert into tbl_point_201905 values('P001','A001','J001','84');
insert into tbl_point_201905 values('P002','A001','J002','82');
insert into tbl_point_201905 values('P003','A001','J003','86');
insert into tbl_point_201905 values('P004','A002','J001','98');
insert into tbl_point_201905 values('P005','A002','J002','99');
insert into tbl_point_201905 values('P006','A002','J003','100');
insert into tbl_point_201905 values('P007','A003','J001','23');
insert into tbl_point_201905 values('P008','A003','J002','43');
insert into tbl_point_201905 values('P009','A003','J003','34');
insert into tbl_point_201905 values('P010','A004','J001','67');
insert into tbl_point_201905 values('P011','A004','J002','56');
insert into tbl_point_201905 values('P012','A004','J003','89');
insert into tbl_point_201905 values('P013','A005','J001','3');
insert into tbl_point_201905 values('P014','A005','J002','6');
insert into tbl_point_201905 values('P015','A005','J003','9');


select artist_id, artist_name,
substr(a.artist_birth,1,4) ||'년'|| substr(a.artist_birth,5,2)||'월'|| substr(a.artist_birth,7,2)||'일',
decode(a.artist_gender,'M','남','F','여'), decode(a.talent,'1','보컬','2','댄스','3','랩'), a.agency
from tbl_artist_201905 a
order by a.artist_id;



select c.serial_no, a.artist_name, 
	substr(a.artist_birth,1,4) ||'년'|| substr(a.artist_birth,5,2)||'월'|| substr(a.artist_birth,7,2)||'일' as artist_birth, c.point,
	case when c.point >=90 then 'A'
				when c.point >=80 then 'B'
				when c.point >=70 then 'C'
				when c.point >=60 then 'D'
		else 'F' end as point_rank,
b.mento_name 
from tbl_artist_201905 a, tbl_mento_201905 b, tbl_point_201905 c
where a.artist_id = c.artist_id and b.mento_id = c.mento_id;


select a.artist_name, sum(b.point) as s1, round(avg(b.point),2) as r1, RANK() OVER(order by sum(b.point) desc) as r2
from tbl_artist_201905 a, tbl_point_201905 b
where a.artist_id = b.artist_id
group by a.artist_name
order by sum(b.point) desc;
		
		 
create table course_tbl(
	id varchar2(5) primary key,
	name varchar2(40),
	credit number(2),
	lecturer number(2),
	week number(2),
	atart_hour number(4),
	end_hour number(4)
);		

insert into course_tbl values('10001', '애플리케이션 배포', 2, 1, 1, 0900, 1100);
insert into course_tbl values('10002', '프로그래밍 언어 활용', 2, 2, 2, 0900, 1200);
insert into course_tbl values('10003', '응용 SW기초기술 활용', 3, 6, 3, 0900, 1100);
insert into course_tbl values('10004', '화면구현', 2, 4, 4, 0900, 1100);
insert into course_tbl values('20001', '에플리케이션 테스트 수행', 2, 5, 1, 1300, 1600);
insert into course_tbl values('20002', 'SQL 활용', 3, 5, 2, 1500, 1800);
insert into course_tbl values('20003', 'UI 테스트', 3, 6, 3, 1330, 1630);
insert into course_tbl values('30001', '화면 설계', 2, 3, 4, 1330, 1530);
insert into course_tbl values('30002', '네트워크 프로그래밍 구현', 3, 3, 5, 0900, 1200);
insert into course_tbl values('40001', '스마트문화앱 구현', 2, 1, 1, 1300, 1600);

select * from course_tbl;

create table lecture_tbl(
	idx number(2) primary key,
	name varchar2(10),
	credit varchar2(40)
);
		
insert into lecture_tbl values(1, '김교수', '소프트웨어공학');
insert into lecture_tbl values(2, '이교수', '프로그래밍');
insert into lecture_tbl values(3, '박교수', '네트워크');
insert into lecture_tbl values(4, '우교수', '운영체제');
insert into lecture_tbl values(5, '최교수', '자료구조');
insert into lecture_tbl values(6, '임교수', '인공지능');

select * from lecture_tbl;