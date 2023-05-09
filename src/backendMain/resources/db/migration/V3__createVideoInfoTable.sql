create table video_info
(
    id          uuid default gen_random_uuid()  primary key,
    name        text                            not null,
    url         text                            not null,
    thumbnail   text,
    description text
);


