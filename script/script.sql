create schema email_schema;

 create table t_email_delivary(id int primary key,
								_to nvarchar(2000),
								cc nvarchar(2000),
								bcc nvarchar(2000),
								subject varchar(50),
								body nvarchar(2000),
								status varchar(20),
								created_timestamp timestamp);
		
 insert into t_email_delivary values(
 									1,
 									"anmoldavane@gmail.com",
 									"anmoldavane@gmail.com",
 									"anmoldavane@gmail.com",
 									"Regarding",
 									"Please check the attachment",
 							        "email sent",
 							        current_timestamp());	
 							        
 create table t_template(template_no int primary key,
 						subject varchar(50),
 						body nvarchar(500));					        							
								