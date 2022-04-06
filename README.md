# ZOiZ
System wspomagający zarządzaniem ogłoszeniami i zadaniami w firmie

## Project setup
For java backend prefer Intellij IDEA

### Clone repository
`git clone https://github.com/Mojzesz007/ZOiZ.git`
### Install PostgreSQL 12 
https://www.postgresql.org/download/ 
### Install pgAdmin 4 desktop 
https://www.pgadmin.org/
### In pgAdmin add new serwer: 
![image](https://user-images.githubusercontent.com/72619211/160450424-8f8da34d-0bc6-4c9a-8916-5c76affc6110.png)
### Running Backend 
If you run spring server in project in _zoiz/zoiz-backend/backend_ (`src/main/java/BackendAplication.java`) you should see:
![image](https://user-images.githubusercontent.com/72619211/160449790-4ff5038e-0028-4819-9ae2-38f612655eb4.png)
### Running FrontEnd 
Go to _zoiz/zoiz-front_ and run `npm i` and then `ng serve`

### DataBase configuration
Go to _src/main/resources/application.properties_ and setup your server username and password

#### Generate DB schema from SQL script

```
create sequence hibernate_sequence start 1 increment 1;
create table activities (id int8 not null, created_at timestamp, draft boolean not null, updated_at timestamp, version int4, activity_end timestamp, activity_date timestamp, body text, important boolean, subject varchar(1024), primary key (id));
create table employees (employee_id int4 not null, commission_pct numeric(2, 2), email varchar(25) not null, first_name varchar(20), hire_date date not null, last_name varchar(25) not null, phone_number varchar(20), salary numeric(8, 2), manager_id int4, primary key (employee_id));
create table tasks (id int8 not null, created_at timestamp, draft boolean not null, updated_at timestamp, version int4, date_from timestamp, date_to timestamp, done boolean, message varchar(2048), parent_token int8, send_notification boolean, subject varchar(255), user_id int8, primary key (id));
create table users (id int8 not null, created_at timestamp, draft boolean not null, updated_at timestamp, version int4, email varchar(255), enabled boolean, initials varchar(255), login varchar(255), name varchar(255), password varchar(255), phone varchar(255), surname varchar(255), primary key (id));
alter table if exists employees add constraint FKi4365uo9af35g7jtbc2rteukt foreign key (manager_id) references employees;
alter table if exists tasks add constraint FK6s1ob9k4ihi75xbxe2w0ylsdh foreign key (user_id) references users;
```
