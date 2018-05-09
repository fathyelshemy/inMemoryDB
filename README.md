# In Memory db example with embaded derbydb #

this task make connection to derby db with JDBC connection 

## What is this repository for? ##

this repo containt example for creating simple db with only on table (Employee) with basic operation (CURD)

* create Employee table if not exist and return the table if exist
* add employee
* del employee
* update employee
* find specific employee with id
* get all employees
* exist from application 
## tools and technologies ##
### tools ### 
* eclipse IDE
* Maven
* derby db embadded
* JDK 1.8
### technologies ### 
 **just java se with JDBC**
## How do I get set up? ##

just go to 
```java
 InMemoryDBFire.java 
```
and run that application it run continouslly to exist just type *quit* **or** *Quit*

# operation to provided #

operation       | command input | parameters | operation explaination
:-------------- | :---- | :---------:| :--------------------
add employee |add | id-name-job discribtion-salary | Add a new employee to the DB
delete employee | del | id | Remove the employee with the supplied ID from DB
update employee | update | id <NAME/DESIG/SALARY/> New Value | Update the employee data
print employee | print | id |Prints employee details to the console
print all employee | printAll | <ASC/DESC> | Prints all employee details in ascending or descending order of the name


### Who do I talk to? ###

* Repo admin: fathy elshemy
* email: fathyelshemy8@gmail.com
