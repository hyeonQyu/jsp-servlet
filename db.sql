create table member(
    name varchar2(20),
    id varchar2(20),
    pw varchar2(20),
    phone1 varchar2(5),
    phone2 varchar2(5),
    phone3 varchar2(5),
    gender varchar2(10)
);

commit;

update member set name = '김영미', phone1 = '010', phone2 = '1234', phone3 = '1234', gender = 'woman' where id = 'ym1010'; 

create table memberforpre (
    name varchar2(20),
    id varchar2(20),
    pw varchar2(20),
    phone varchar(20)
);

create table members(
    id varchar2(20),
    pw varchar2(20),
    name varchar2(20),
    eMail varchar2(20),
    rDate date,
    address varchar2(50)
);

delete from members where name='홍길짭';

update members set pw = '1111', eMail = 'newnew@naver.com' where id = 'newone';

create table mvc_board(
    bId number(4) primary key,
    bName varchar2(20),
    bTitle varchar2(100),
    bContent varchar2(300),
    bDate date default sysdate,
    bHit number(4) default 0,
    bGroup number(4),
    bStep number(4),
    bIndent number(4)
);
-- id값을 자동으로 증가시키기 위함
create sequence mvc_board_seq;

insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent)
values (mvc_board_seq.nextval, 'admin', 'test title', 'test content', 0, mvc_board_seq.currval, 0, 0);

commit;