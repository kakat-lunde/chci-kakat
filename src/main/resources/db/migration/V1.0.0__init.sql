create table pooping_session
(
    id         bigint       not null
        primary key,
    end_time   datetime     null,
    start_time datetime     null,
    toilet_id  varchar(255) null,
    constraint FK5tm0yr8yx3nl4ks3f138kk8l4
        foreign key (toilet_id) references toilet (id)
);


create table toilet
(
    id              varchar(255) not null
        primary key,
    ip_address      varchar(255) null,
    last_session_id bigint       null,
    constraint FK9hotw3j1amcys8ofd3vsqa4j8
        foreign key (last_session_id) references pooping_session (id)
);
