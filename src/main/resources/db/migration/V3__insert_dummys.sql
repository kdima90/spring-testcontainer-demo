-- add some example users via flyway script (do not want use spring boot commandlinerunner :))
insert into person.person(id, name) values (1, 'John Doe');
insert into person.person(id, name) values (2, 'Jane Doe');