drop sequence hibernate_sequence;
create sequence hibernate_sequence start with 1001 increment by 1;

DROP TABLE PATIENT;
DROP TABLE APPOINTMENT cascade constraints;
DROP TABLE DOCTOR cascade constraints;
DROP TABLE SYMPTOMSPC;

----------------------------------
----APPOINTMENT
----------------------------------

CREATE TABLE APPOINTMENT(
APPID NUMBER(2) PRIMARY KEY,
SYMPTOM1 VARCHAR2(100) NOT NULL,
SYMPTOM2 VARCHAR2(100),
SYMPTOM3 VARCHAR2(100),
DOCTORID NUMBER(6),
DAYS NUMBER(3) ,
DATEOFAPP DATE ,
STATUS VARCHAR2(50) default 'Pending'
);

----------------------------------
----PATIENT
----------------------------------

CREATE TABLE PATIENT(
PID Number(3) PRIMARY KEY,
PNAME VARCHAR2(20) NOT NULL,
GENDER VARCHAR2(10) NOT NULL CHECK (GENDER IN ('Male','Female')),
AGE NUMBER(3) NOT NULL CHECK(AGE BETWEEN 1 AND 100),
ANNUALINC NUMBER(10) NOT NULL,
HISTOFILL VARCHAR2(100) NOT NULL,
HISTOFMEDS VARCHAR2(100),
PASSWORD  VARCHAR2(20)  NOT NULL,
EMAIL  VARCHAR2(50)  UNIQUE NOT NULL,
APPID NUMBER(2) REFERENCES APPOINTMENT(APPID)
);

INSERT INTO APPOINTMENT VALUES(10,'Cold','Cough','null',1001,3,'20-May-2019','Pending');
INSERT INTO APPOINTMENT VALUES(11,'ChestPain','Heartburn','null',1002,4,'21-May-2019','Pending');

INSERT INTO PATIENT VALUES(101,'John','Male',23,10000,'cold','vicks','asd','john@gmail.com',10);
INSERT INTO PATIENT VALUES(102,'Clara','Female',26,5000,'cough','syrup','asd','clara@gmail.com',11);
INSERT INTO PATIENT VALUES(103,'Vipin','Male',23,10000,'headache','aspirin','asd','vipin@gmail.com',null);
INSERT INTO PATIENT VALUES(104,'Tarang','Male',26,5000,'cough','vicks','asd','tarang@gmail.com',null);
INSERT INTO PATIENT VALUES(105,'Kunal','Male',24,20000,'bruishes','antiseptic','asd','kunal@gmail.com',null);
INSERT INTO PATIENT VALUES(106,'Ricky','Male',24,20000,'rashes','anti-bacterial','asd','ricky@gmail.com',null);
INSERT INTO PATIENT VALUES(107,'Scarlett','Female',27,15000,'pimples','nomarks','asd','scarlett@gmail.com',null);
INSERT INTO PATIENT VALUES(108,'Suman','Female',27,15000,'stomach-ache','liquiprin','asd','suman@gmail.com',null);
INSERT INTO PATIENT VALUES(109,'Tiffany','Female',22,25000,'headache','paracetamol','asd','tiffany@gmail.com',null);
INSERT INTO PATIENT VALUES(110,'Sikha','Female',22,25000,'cough','strepsils','asd','sikha@gmail.com',null);


----------------------------------
----DOCTOR
----------------------------------


CREATE TABLE DOCTOR(
DID NUMBER(4) PRIMARY KEY,
DNAME VARCHAR2(20) NOT NULL,
YRSOFEXP NUMBER(3) NOT NULL,
--AVAIL VARCHAR2 (20) NOT NULL CHECK (AVAI"histofill": null,L IN ('T','F')), 
VISITHOURS VARCHAR2(20) NOT NULL,
VISITHOURSEND VARCHAR2(20) NOT NULL,
FEE NUMBER(10) NOT NULL,
SPC VARCHAR2(20) NOT NULL,
PASSWORD  VARCHAR2(200)  NOT NULL,
EMAIL  VARCHAR2(50)  unique NOT NULL
);

INSERT INTO DOCTOR VALUES(1001,'Carl',10,'09:00','18:00',800,'ent','rty','carl@gmail.com');
INSERT INTO DOCTOR VALUES(1002,'Nora',5,'08:30','17:30',550,'cardiologist','rty','nora@gmail.com');
INSERT INTO DOCTOR VALUES(1003,'Harsh',18,'09:30','18:30',1900,'pediatrician','rty','harsh@gmail.com');
INSERT INTO DOCTOR VALUES(1004,'James',10,'09:00','18:00',850,'gynocologist','rty','james@gmail.com');
INSERT INTO DOCTOR VALUES(1005,'Sharma',23,'08:30','19:00',2300,'oncologist','rty','sharma@gmail.com');
INSERT INTO DOCTOR VALUES(1006,'Singh',20,'08:30','18:30',2200,'gastroenterologist','rty','singh@gmail.com');
INSERT INTO DOCTOR VALUES(1007,'Simran',9,'08:15','17:30',750,'endocrinologist','rty','simran@gmail.com');
INSERT INTO DOCTOR VALUES(1008,'Seema',10,'09:30','18:45',500,'dermatologist','rty','seema@gmail.com');
INSERT INTO DOCTOR VALUES(1009,'Tomar',5,'09:45','19:15',600,'nephrologist','rty','tomar@gmail.com');
INSERT INTO DOCTOR VALUES(1010,'Harbhajan',6,'10:15','20:30',700,'cardiologist','rty','harbhajan@gmail.com');
INSERT INTO DOCTOR VALUES(1011,'Sreenath',8,'08:15','17:30',1000,'hematologist','rty','sreenath@gmail.com');
INSERT INTO DOCTOR VALUES(1012,'Sachin',4,'09:30','18:45',450,'dermatologist','rty','sachin@gmail.com');
INSERT INTO DOCTOR VALUES(1013,'Abhijeet',13,'10:00','20:00',900,'pediatrician','rty','abhijeet@gmail.com');
INSERT INTO DOCTOR VALUES(1014,'Barath',12,'09:15','18:40',800,'gynocologist','rty','barath@gmail.com');
INSERT INTO DOCTOR VALUES(1015,'Taimur',7,'10:00','20:00',450,'ent','rty','taimur@gmail.com');
INSERT INTO DOCTOR VALUES(1016,'Natalie',4,'08:30','17:30',350,'ent','rty','natalie@gmail.com');
INSERT INTO DOCTOR VALUES(1017,'Arya',6,'10:15','20:30',650,'hematologist','rty','arya@gmail.com');
INSERT INTO DOCTOR VALUES(1018,'Gaurav',19,'09:45','19:15',1800,'endocrinologist','rty','gaurav@gmail.com');
INSERT INTO DOCTOR VALUES(1019,'Harry',2,'08:30','18:30',300,'gastroenterologist','rty','harry@gmail.com');
INSERT INTO DOCTOR VALUES(1020,'Gairola',14,'09:30','18:30',1400,'pediatrician','rty','gairola@gmail.com');
INSERT INTO DOCTOR VALUES(1021,'Chand',9,'09:00','18:15',1000,'ent','rty','chand@gmail.com');
INSERT INTO DOCTOR VALUES(1022,'Mukesh',4,'08:30','19:00',500,'pediatrician','rty','mukesh@gmail.com');
INSERT INTO DOCTOR VALUES(1023,'Jackson',25,'09:00','18:15',2500,'dermatologist','rty','jackson@gmail.com');
INSERT INTO DOCTOR VALUES(1024,'David',22,'09:15','18:40',2000,'endocrinologist','rty','david@gmail.com');
INSERT INTO DOCTOR VALUES(1025,'Sakshi',15,'10:15','20:30',950,'cardiologist','rty','sakshi@gmail.com');




----------------------------------
----SYMPTOMS AND SPECIALISATION
----------------------------------

CREATE TABLE SYMPTOMSPC(
SPECIALIZATION VARCHAR2(100) PRIMARY KEY,
SYMPTOM1 VARCHAR2(100) NOT NULL,
SYMPTOM2 VARCHAR2(100)

);

INSERT INTO SYMPTOMSPC VALUES('ent','cold','cough');
INSERT INTO SYMPTOMSPC VALUES('cardiologist','chest pain','heartburn');
INSERT INTO SYMPTOMSPC VALUES('gynocologist','menopause','missed periods');
INSERT INTO SYMPTOMSPC VALUES('dermatologist','skin rashes','acne problems');
INSERT INTO SYMPTOMSPC VALUES('endocrinologist','diabetic problems','thyroid problems');
INSERT INTO SYMPTOMSPC VALUES('gastroenterologist','nausea', 'loose motion');
INSERT INTO SYMPTOMSPC VALUES('hematologist','persistent fatigue and weakness', 'easy bleeding or bruising');
INSERT INTO SYMPTOMSPC VALUES('nephrologist','decrease in urination', 'swelling in legs or feet');
INSERT INTO SYMPTOMSPC VALUES('oncologist','blood in urine or stool', 'thickening/lump under the skin');
INSERT INTO SYMPTOMSPC VALUES('pediatrician','vaccination', 'child illness');



commit;



SELECT * FROM PATIENT;
SELECT * FROM DOCTOR;
SELECT * FROM APPOINTMENT;
SELECT * FROM SYMPTOMSPC;
