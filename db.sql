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

update member set name = '±è¿µ¹Ì', phone1 = '010', phone2 = '1234', phone3 = '1234', gender = 'woman' where id = 'ym1010'; 

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

delete from members where name='È«±æÂ¬';