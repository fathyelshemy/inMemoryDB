CONNECT CONNECT 'jdbc:derby:mondiaMediaTask.sql;create=true';
create table employee(
                        employee_id int not null unique,
                        employee_name varchar(50),
                        designation varchar(50),
                        salary double 
                        );