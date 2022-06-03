```--insert into standard entititioti (id, version, created_at, updated_at, draft )	values (1, 1, current_date, current_date, false);


--USERS

insert into users (id, version, created_at, updated_at, draft, name, surname, initials, login, password, email, phone, enabled ) values (1, 1, current_date, current_date, false, 'admin', 'admin', 'AA', 'admin', 'admin', 'admin@admin.pl',6666666666, true);

insert into users (id, version, created_at, updated_at, draft, name, surname, initials, login, password, email, phone, enabled ) values (2, 1, current_date, current_date, false, 'rafal', 'pasternak', 'RP', 'rafal', 'rafal123', 'rafal.pasternak12@gmail.com',6666666666, true);

insert into users (id, version, created_at, updated_at, draft, name, surname, initials, login, password, email, phone, enabled ) values (3, 1, current_date, current_date, false, 'michal', 'witkowski', 'MW', 'michal', 'michal123', 'michal@admin.pl',6666666666, true);

insert into users (id, version, created_at, updated_at, draft, name, surname, initials, login, password, email, phone, enabled ) values (4, 1, current_date, current_date, false, 'eryk', 'wybranowski', 'EW', 'eryk', 'eryk123', 'eryk@admin.pl',6666666666, true);

insert into users (id, version, created_at, updated_at, draft, name, surname, initials, login, password, email, phone, enabled ) values (5, 1, current_date, current_date, false, 'lukasz', 'duda', 'LD', 'lukasz', 'lukasz123', 'lukasz@admin.pl',6666666666, true);

insert into users (id, version, created_at, updated_at, draft, name, surname, initials, login, password, email, phone, enabled ) values (6, 1, current_date, current_date, false, 'przemek', 'mika', 'PM', 'przemek', 'przemek123', 'przemek@admin.pl',6666666666, true);

--ACTIVITIES

insert into activities (id, version, created_at, updated_at, draft, activity_start, activity_end, subject, body, important)	values (1, 1, current_date, current_date, false, current_date, current_date, 'temat aktualności 1', 'tresc aktualności 1 waznej', true);

insert into activities (id, version, created_at, updated_at, draft, activity_start, activity_end, subject, body, important)	values (2, 1, current_date, current_date, false, current_date, current_date, 'temat aktualności 2', 'tresc bez piorytetu ', false);

insert into activities (id, version, created_at, updated_at, draft, activity_start, activity_end, subject, body, important)	values (3, 1, current_date, current_date, false, current_date, current_date, 'temat 3', 'tresc z piorytetem tematu 3', true);

insert into activities (id, version, created_at, updated_at, draft, activity_start, activity_end, subject, body, important)	values (4, 1, current_date, current_date, false, current_date, current_date, 'temat 4', 'tresc piorytetowa tematu czwartego', true);

insert into activities (id, version, created_at, updated_at, draft, activity_start, activity_end, subject, body, important)	values (5, 1, current_date, current_date, false, current_date, current_date, 'temat 5', 'tresc nie piorytetowa tematu piątego', true);

--TASKS

insert into tasks (id, version, created_at, updated_at, draft, date_from, date_to, subject, message, done, USER_ID)	values (1, 1, current_date, current_date, false, current_date, current_date, 'temat', 'treść pierwszego', false,  1);

insert into tasks (id, version, created_at, updated_at, draft, date_from, date_to, subject, message, done, USER_ID)	values (2, 1, current_date, current_date, false, current_date, current_date, 'temat 2', 'treść drugiego zadania', false,  1);

insert into tasks (id, version, created_at, updated_at, draft, date_from, date_to, subject, message, done, USER_ID)	values (3, 1, current_date, current_date, false, current_date, current_date, 'temat 3', 'długa treść trzeciego zadania', false,  1);

insert into tasks (id, version, created_at, updated_at, draft, date_from, date_to, subject, message, done, USER_ID)	values (4, 1, current_date, current_date, false, current_date, current_date, 'temat 4', 'batdzo dluga treść czwartego zadania', false,  1);

insert into tasks (id, version, created_at, updated_at, draft, date_from, date_to, subject, message, done, USER_ID)	values (5, 1, current_date, current_date, false, current_date, current_date, 'temat 5', 'naprawde bardzo dluga i rozwinięta treść piatego zadania które jest ukonczone ', true,  1);