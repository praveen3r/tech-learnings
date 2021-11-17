INSERT INTO USER(id,name,emailId,password,role) VALUES(1000,'admin','admin@gmail.com','1','admin');
INSERT INTO USER(id,name,emailId,password,role) VALUES(1001,'user','user@gmail.com','1','user');
INSERT INTO CAMPAIGN(title,campaign_id, start_date,end_date) values ('Default',CAMPAIGN_SEQ_ID.nextval,CURRENT_DATE, CURRENT_DATE);
INSERT INTO CAMPAIGN_QUESTION (campaign_id, answer_type, choice1, choice2, choice3, choice4, field_type, question, question_id) 
values (CAMPAIGN_SEQ_ID.currval,'Radio Button', 'Professional', 'Worker', 'Teacher', 'Fireman', '', 'Who are you', CAMPAIGN_QUES_SEQ_ID.nextval);