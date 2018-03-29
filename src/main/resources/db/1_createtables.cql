CREATE TABLE IF NOT EXISTS employ.users (
user_id uuid,
creation_date timestamp,
handle text,
first_name text,
last_name text,
bio text,
email text,
phone_number text,
PRIMARY KEY(user_id));

ALTER TABLE employ.users WITH caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'};
ALTER TABLE employ.users WITH crc_check_chance = 1.0;
ALTER TABLE employ.users WITH dclocal_read_repair_chance = 0.1;
ALTER TABLE employ.users WITH default_time_to_live = 0;
ALTER TABLE employ.users WITH gc_grace_seconds = 864000;
ALTER TABLE employ.users WITH max_index_interval = 2048;
ALTER TABLE employ.users WITH memtable_flush_period_in_ms = 0;
ALTER TABLE employ.users WITH min_index_interval = 128;
ALTER TABLE employ.users WITH read_repair_chance = 0.0;
ALTER TABLE employ.users WITH speculative_retry = '99PERCENTILE';

CREATE TABLE IF NOT EXISTS employ.jobs (
job_id uuid,
creation_date timestamp,
title text,
description text,
short_description text,
company_id uuid,
company_name text,
company_avatar_url text,
recruiter_first_name text,
recruiter_last_name text,
category_type text,
employment_type text,
salary int,
min_salary int,
max_salary int,
latitude double,
longitude double,
street_address text,
city text,
state text,
country text,
zip text,
number_of_hires int,
required_experience text,
preferred_experience text,
skills set<text>,
responsibilities text,
experience int,
education_level set<text>,
tags set<text>,
PRIMARY KEY(job_id));
CREATE INDEX ON jobs (tags);

ALTER TABLE employ.jobs WITH caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'};
ALTER TABLE employ.jobs WITH crc_check_chance = 1.0;
ALTER TABLE employ.jobs WITH dclocal_read_repair_chance = 0.1;
ALTER TABLE employ.jobs WITH default_time_to_live = 0;
ALTER TABLE employ.jobs WITH gc_grace_seconds = 864000;
ALTER TABLE employ.jobs WITH max_index_interval = 2048;
ALTER TABLE employ.jobs WITH memtable_flush_period_in_ms = 0;
ALTER TABLE employ.jobs WITH min_index_interval = 128;
ALTER TABLE employ.jobs WITH read_repair_chance = 0.0;
ALTER TABLE employ.jobs WITH speculative_retry = '99PERCENTILE';

//
//CREATE TABLE IF NOT EXISTS employ.jobs_by_tag (
//tag text,
//job_id uuid,
//creation_date timestamp,
//title text,
//description text,
//short_description text,
//company_id uuid,
//company_name text,
//company_avatar_url text,
//recruiter_first_name text,
//recruiter_last_name text,
//category_type text,
//employment_type text,
//salary int,
//min_salary int,
//max_salary int,
//latitude double,
//longitude double,
//street_address text,
//city text,
//state text,
//country text,
//zip text,
//number_of_hires int,
//required_experience text,
//preferred_experience text,
//skills set<text>,
//responsibilities text,
//experience int,
//education_level set<text>,
//PRIMARY KEY(tag, job_id));
//
//ALTER TABLE employ.jobs_by_tag WITH caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'};
//ALTER TABLE employ.jobs_by_tag WITH crc_check_chance = 1.0;
//ALTER TABLE employ.jobs_by_tag WITH dclocal_read_repair_chance = 0.1;
//ALTER TABLE employ.jobs_by_tag WITH default_time_to_live = 0;
//ALTER TABLE employ.jobs_by_tag WITH gc_grace_seconds = 864000;
//ALTER TABLE employ.jobs_by_tag WITH max_index_interval = 2048;
//ALTER TABLE employ.jobs_by_tag WITH memtable_flush_period_in_ms = 0;
//ALTER TABLE employ.jobs_by_tag WITH min_index_interval = 128;
//ALTER TABLE employ.jobs_by_tag WITH read_repair_chance = 0.0;
//ALTER TABLE employ.jobs_by_tag WITH speculative_retry = '99PERCENTILE';


