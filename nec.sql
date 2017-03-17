CREATE USER nec
IDENTIFIED BY nec
DEFAULT TABLESPACE userdata
QUOTA 30m ON userdata
ACCOUNT UNLOCK;

GRANT dba TO nec;
GRANT Connect TO nec;
GRANT CREATE TABLE TO nec;
GRANT CREATE SEQUENCE TO nec;
GRANT CREATE VIEW TO nec;


--�û���
CREATE TABLE userinfo(
userid NUMBER(10) constraint userinfo_id_pk PRIMARY KEY,
username VARCHAR2(20) constraint userinfo_name_un UNIQUE constraint userinfo_name_nn NOT NULL,
userpwd  VARCHAR2(20) constraint userinfo_pwd_nn NOT NULL,
employeeid NUMBER(10) constraint userinfo_emid_nn NOT NULL
);

comment on table userinfo is '�û���';
comment on column userinfo.userid is '�û����';
comment on column userinfo.username is '�û�����';
comment on column userinfo.username is '�û�����';
comment on column userinfo.employeeid is 'Ա�����';

CREATE SEQUENCE userid_seq 
INCREMENT BY 1
START WITH 1
NOCACHE;

INSERT INTO userinfo(userid, username, userpwd, employeeid)
VALUES (userid_seq.nextval,'hewei','123456','1004');
INSERT INTO userinfo(userid, username, userpwd, employeeid)
VALUES (userid_seq.nextval,'lily','123456','1001');
INSERT INTO userinfo(userid, username, userpwd, employeeid)
VALUES (userid_seq.nextval,'lisi','123456','1002');
INSERT INTO userinfo(userid, username, userpwd, employeeid)
VALUES (userid_seq.nextval,'wangming','123456','1003');




--Ա����
CREATE TABLE employee(
employeeid NUMBER(10) constraint employee_id_pk PRIMARY KEY,
postname CHAR(2) constraint employee_pname_nn NOT NULL,
realname VARCHAR(20) constraint employee_rname_nn NOT NULL,
sex CHAR(1),
phone VARCHAR(20)
);

comment on table employee is 'Ա����';
comment on column employee.employeeid is 'Ա�����';
comment on column employee.postname is 'ְ�����';
comment on column employee.realname is '��ʵ����';
comment on column employee.sex is '�Ա�';
comment on column employee.phone is '�绰';

CREATE SEQUENCE employeeid_seq
INCREMENT BY 1
START WITH 1000
NOCACHE;

INSERT INTO employee(employeeid, postname, realname, sex, phone)
VALUES (employeeid_seq.nextval,'AD','����','1','12345678901');
INSERT INTO employee(employeeid, postname, realname, sex, phone)
VALUES (employeeid_seq.nextval,'RM','����','0',NULL);
INSERT INTO employee(employeeid, postname, realname, sex, phone)
VALUES (employeeid_seq.nextval,'CS','����','1',NULL);
INSERT INTO employee(employeeid, postname, realname, sex, phone)
VALUES (employeeid_seq.nextval,'RP','����','1',NULL);

--�ͷ���
CREATE TABLE room(
roomid char(4) CONSTRAINT room_id_pk PRIMARY KEY,
type_id CHAR(1) CONSTRAINT room_tyid_nn NOT NULL,
locations VARCHAR(200) CONSTRAINT room_lo_nn NOT NULL,
remark VARCHAR2(200) ,
status CHAR(1) CONSTRAINT roon_stu_nn NOT NULL
);

comment on table room is '�ͷ���';
comment on column room.roomid is '�ͷ����';
comment on column room.type_id is '�ͷ����';
comment on column room.locations is '�ͷ�λ��';
comment on column room.remark is '�豸���';
comment on column room.status is '����״̬';


--�������ͱ�
CREATE TABLE roomtype(
type_id CHAR(1) constraint type_id_pk primary key,
typename VARCHAR2(20) constraint type_name_un  unique,
price NUMBER(6,2) constraint type_price_nn NOT��NULL
);

comment on table roomtype is '�ͷ����ͱ�';
comment on column roomtype.type_id is '���ͱ��';
comment on column roomtype.typename is '��������';
comment on column roomtype.price is '�۸�';

CREATE SEQUENCE typeid_seq
INCREMENT BY 1
START WITH 1
NOCACHE;

INSERT INTO roomtype(type_id, typename, price)
VALUES (typeid_seq.nextval,'���˱�׼��',168);
INSERT INTO roomtype(type_id, typename, price)
VALUES (typeid_seq.nextval,'˫�˱�׼��',268);
INSERT INTO roomtype(type_id, typename, price)
VALUES (typeid_seq.nextval,'����˫�˼�',288);
INSERT INTO roomtype(type_id, typename, price)
VALUES (typeid_seq.nextval,'�������˼�',368);
INSERT INTO roomtype(type_id, typename, price)
VALUES (typeid_seq.nextval,'��ͳ�׷�',588);



--������  orderid��ʽΪ��λ��+�·�+���ڼ�+ʱ����+��λ�����
CREATE TABLE Orders(
orderid varchar2(20) constraint orders_id_pk PRIMARY KEY,
orderdate DATE constraint orders_date_nn  NOT NULL,
roomid char(4) constraint orders_rid_un unique constraint orders_id_nn not null,  
customername VARCHAR2(20) constraint orders_cname_nn NOT null
);



comment on table orders is '������';
comment on column orders.orderid is '�������';
comment on column orders.orderdate is '��������';
comment on column orders.roomid is '�ͷ����';
comment on column orders.customername is '�ͻ�����';


CREATE SEQUENCE ordersid_seq
INCREMENT BY 1
START WITH 10
maxvalue 99
cycle
NOCACHE;

--�ͻ���
CREATE TABLE customer(
customerid VARCHAR2(20) constraint customer_id_pk PRIMARY KEY,
customername VARCHAR2(20) constraint customer_name_nn NOT NULL,
idcard VARCHAR2(20) constraint customer_idcard_nn NOT NULL constraint customer_id_card_un unique,
sex CHAR(1),
phone VARCHAR2(20),
address VARCHAR2(200),
ischeckin CHAR(1)
);



CREATE SEQUENCE customerid_seq
INCREMENT BY 1
START WITH 100000
NOCACHE;

--��ס��Ϣ�� checkinidΪ��ʽΪ��λ��+�·�+���ڼ�+ʱ����+��λ�����
CREATE TABLE checkin(
checkinid VARCHAR2(20) constraint checkin_id_pk PRIMARY KEY,
roomid CHAR(4) constraint checkin_roomid_nn not null,
customerid VARCHAR2(20) constraint checkin_cid_nn not null,
checkindate DATE constraint checkin_date_nn not null,
checkoutdate DATE,
pledge NUMBER(6,2),
NET_WORK CHAR(1),
neton CHAR(1)
);



--��������
CREATE TABLE NET_WORK(
networkid NUMBER(4) constraint net_id_pk PRIMARY KEY,
checkinid VARCHAR2(20) NOT NULL,
ondate DATE constraint net_ondate_nn not null,
offdate DATE
);

CREATE SEQUENCE networkid_seq
INCREMENT BY 1
START WITH 1
NOCACHE;

--��ͼ

create or replace view roomquery
as
select roomid, t.typename, locations, remark, decode (r.status, '0', '��', '1', '��Ԥ��', '2', '����ס') status, price
from room r join roomtype t
on(r.type_id = t.type_id);


create or replace view checkinQuery
as 
select checkinid, roomid, c.customerid, customername, checkindate, pledge, decode(net_work, '0','����Ҫ','1','��Ҫ') network , decode(neton, '0','δ��ͨ','1','�ѿ�ͨ') neton, c.checkoutdate
from checkin c join customer cc
on (c.customerid = cc.customerid);


CREATE OR REPLACE VIEW V$ROOMMESSAGE AS
SELECT roomid,typename,locations,remark,status,price,type_id
      FROM room NATURAL JOIN roomtype
WITH READ ONLY;

CREATE OR REPLACE VIEW V$NETWORK AS
SELECT r.checkinid networkid,roomid,customerid,ondate, offdate
      FROM net_work n JOIN checkin r
      on (n.checkinid = r.checkinid)
      where r.checkoutdate is null
WITH READ ONLY;

CREATE OR REPLACE VIEW V$CHECKOUTMESSAGE AS
SELECT ck.checkinid,ck.roomid,c.customername,checkindate,checkoutdate,pledge,net_work,neton,ondate,offdate,price,typename
       FROM checkin ck JOIN customer c ON (ck.customerid = c.customerid)
       JOIN v$roommessage v ON (v.roomid = ck.roomid)
       left JOIN net_work n ON (ck.checkinid = n.checkinid)
WITH READ ONLY;


create or replace view roomquery as
select roomid, t.typename, locations, remark, decode (r.status, '0', '��', '1', '��Ԥ��', '2', '����ס') status, price
from room r join roomtype t
on(r.type_id = t.type_id);

create or replace view checkinquery as
select checkinid, roomid, c.customerid, customername, checkindate, pledge, decode(net_work, '0','����Ҫ','1','��Ҫ') network , decode(neton, '0','δ��ͨ','1','�ѿ�ͨ') neton, c.checkoutdate
from checkin c join customer cc
on (c.customerid = cc.customerid);



--��ס��Ϣ�� checkinidΪ��ʽΪ��λ��+�·�+���ڼ�+ʱ����+��λ�����       *********��ṹ�޸�



--�ͻ���      *****************��ṹ�޸�



/* �����ͼ */
CREATE OR REPLACE VIEW v$roommessage
AS
      SELECT roomid,typename,locations,remark,status,price,type_id
      FROM room NATURAL JOIN roomtype 
WITH READ ONLY;

CREATE OR REPLACE VIEW v$networkmessage
AS
      SELECT n.networkid,roomid,c.customername,n.ondate,n.offdate
      FROM net_work n JOIN checkin ck ON (ck.checkinid = n.checkinid)
      JOIN customer c ON (ck.customerid = c.customerid) 
WITH READ ONLY;

CREATE OR REPLACE VIEW v$checkoutmessage
AS
       SELECT c.customerid,ck.checkinid,ck.roomid,c.customername,checkindate,checkoutdate,pledge,net_work,neton,ondate,offdate,price,typename
       FROM checkin ck JOIN customer c ON (ck.customerid = c.customerid)
       JOIN v$roommessage v ON (v.roomid = ck.roomid)
       LEFT JOIN net_work n ON (ck.checkinid = n.checkinid)
WITH READ ONLY;


CREATE OR REPLACE VIEW EMPS AS
SELECT e.employeeid, postname, realname, sex, phone, userid, username, userpwd
FROM userinfo u RIGHT OUTER JOIN employee e ON( u.employeeid = e.employeeid);

CREATE OR REPLACE TRIGGER TRI_DELEMP
  AFTER DELETE ON EMPLOYEE
  FOR EACH ROW

BEGIN

  DELETE FROM USERINFO WHERE USERINFO.EMPLOYEEID = :OLD.EMPLOYEEID;
END;

























