create type universityeventtype as enum ('WORKSHOP', 'PRESENTATION', 'SIDE_EVENT');

alter type universityeventtype owner to postgres;


create table university_event
(
    id                         uuid default gen_random_uuid() primary key,
    name                       varchar(255)        not null,
    type                       universityeventtype not null,
    from_time                  timestamp           not null,
    to_time                    timestamp           not null,
    location                   varchar(255)        not null,
    repetition_time_in_minutes integer,
    description                text                not null
);


