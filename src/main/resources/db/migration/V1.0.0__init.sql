# create table nickname
# (
#     id bigint not null primary key,
#     name varchar(255) null
# );
#
# create table pooping_session
# (
#     id bigint not null primary key,
#     end_time datetime null,
#     start_time datetime null,
#     nickname_id bigint null,
#     toilet_id varchar(255) null
# );
#
# create table toilet
# (
#     id varchar(255) not null primary key,
#     ip_address varchar(255) null,
#     last_session_id bigint null
# );
#
# alter table pooping_session add constraint FK5tm0yr8yx3nl4ks3f138kk8l4 foreign key (toilet_id) references toilet (id);
# alter table pooping_session add constraint FKiiq7kf1hfv595m6mooohxua7i foreign key (nickname_id) references nickname (id);
# alter table toilet add constraint FK9hotw3j1amcys8ofd3vsqa4j8 foreign key (last_session_id) references pooping_session (id);
#
# insert into toilet (id, ip_address) values ('vlevo', 'http://192.168.43.128');
# insert into toilet (id, ip_address) values ('vpravo', 'http://192.168.43.129');
# insert into toilet (id, ip_address) values ('sprcha', 'http://192.168.43.130');
#
# insert into nickname (id, name) values (1, 'Mr. Brown');
# insert into nickname (id, name) values (2, 'Řitíř');
# insert into nickname (id, name) values (3, 'Toaletní tapír');
# insert into nickname (id, name) values (4, 'Robot kákulon');
# insert into nickname (id, name) values (5, 'Hrabě kákula');
# insert into nickname (id, name) values (6, 'Hovnimír');
# insert into nickname (id, name) values (7, 'Václav Kaklaus');
# insert into nickname (id, name) values (8, 'Kakačka Blátotlačka');
# insert into nickname (id, name) values (9, 'Zdeněk Svěrač');
# insert into nickname (id, name) values (10, 'Hnědkulín');
# insert into nickname (id, name) values (11, 'Mr. Hankey');
# insert into nickname (id, name) values (12, 'Kadimír');
# insert into nickname (id, name) values (13, 'Sir Poopalot');