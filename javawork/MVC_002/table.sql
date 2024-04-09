create table course_tbl(
	id varchar2(5) primary key,
	name varchar2(40),
	credit number(2),
	lecturer number(2),
	week number(2),
	start_hour number(4),
	end_hour number(4),
	
	CONSTRAINT fk_lecturer FOREIGN KEY(lecturer)
    REFERENCES lecture_tbl(idx) ON DELETE CASCADE
);		

drop table course_tbl;
drop table lecture_tbl;

select * from LECTURE_TBL;

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

select id, name, credit,
decode(lecturer,1,'김교수','2','이교수','3','박교수','4','우교수','5','최교수','6','임교수') lecturer ,
decode(week ,'1','월요일' ,'2','화요일' ,'3','수요일' ,'4','목요일' ,'5','금요일') week,
start_hour, end_hour
from course_tbl order by id;


select id, name, credit, lecturer, week, 
start_hour, end_hour 
from course_tbl where id=50505;