create type degreetype as enum ('BACHELOR', 'MASTER', 'DOCTORAL');
create type formtype as enum ('PRESENT', 'DISTANCE');


create table field_of_study_info
(
    id uuid default gen_random_uuid() primary key,
    name                           varchar not null,
    short_cut                      varchar not null,
    degree_type                    varchar not null,
    form_type                      varchar not null,
    study_period                   int     not null,
    description                    varchar not null,
    candidate_profile              varchar not null,
    graduate_profile               varchar not null,
    e_application_form_url         varchar not null,
    study_plan_url                 varchar not null,
    further_study_possibility      varchar,
    exam_waiver_option             varchar not null,
    admission_procedure            varchar,
    estimated_number_of_admissions int     not null,
    accreditation_until            timestamp
);

create table document_info
(
    id                uuid default gen_random_uuid() primary key,
    field_of_study_id uuid not null,
    name              varchar not null,
    url               varchar not null
);




