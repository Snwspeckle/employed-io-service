CREATE TABLE IF NOT EXISTS employ.users (
user_id timeuuid,
role text,
handle text,
login text,
password text,
matches set<text>,
pending_matches set<text>,
rejected_matches set<text>,
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

CREATE TABLE IF NOT EXISTS employ.users_credentials (
login text,
password text,
user_id timeuuid,
PRIMARY KEY(login));

ALTER TABLE employ.users_credentials WITH caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'};
ALTER TABLE employ.users_credentials WITH crc_check_chance = 1.0;
ALTER TABLE employ.users_credentials WITH dclocal_read_repair_chance = 0.1;
ALTER TABLE employ.users_credentials WITH default_time_to_live = 0;
ALTER TABLE employ.users_credentials WITH gc_grace_seconds = 864000;
ALTER TABLE employ.users_credentials WITH max_index_interval = 2048;
ALTER TABLE employ.users_credentials WITH memtable_flush_period_in_ms = 0;
ALTER TABLE employ.users_credentials WITH min_index_interval = 128;
ALTER TABLE employ.users_credentials WITH read_repair_chance = 0.0;
ALTER TABLE employ.users_credentials WITH speculative_retry = '99PERCENTILE';

CREATE TABLE IF NOT EXISTS employ.job_seekers (
user_id timeuuid,
first_name text,
last_name text,
email text,
phone_number text,
bio text,
avatar_url text,
headline text,
current_position text,
industry text,
latitude double,
longitude double,
street_address text,
city text,
state text,
country text,
zip text,
skills set<text>,
tags set<text>,
PRIMARY KEY(user_id));
CREATE INDEX ON job_seekers (tags);

ALTER TABLE employ.job_seekers WITH caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'};
ALTER TABLE employ.job_seekers WITH crc_check_chance = 1.0;
ALTER TABLE employ.job_seekers WITH dclocal_read_repair_chance = 0.1;
ALTER TABLE employ.job_seekers WITH default_time_to_live = 0;
ALTER TABLE employ.job_seekers WITH gc_grace_seconds = 864000;
ALTER TABLE employ.job_seekers WITH max_index_interval = 2048;
ALTER TABLE employ.job_seekers WITH memtable_flush_period_in_ms = 0;
ALTER TABLE employ.job_seekers WITH min_index_interval = 128;
ALTER TABLE employ.job_seekers WITH read_repair_chance = 0.0;
ALTER TABLE employ.job_seekers WITH speculative_retry = '99PERCENTILE';

CREATE TABLE IF NOT EXISTS employ.recruiters (
user_id timeuuid,
first_name text,
last_name text,
email text,
phone_number text,
bio text,
PRIMARY KEY(user_id));

ALTER TABLE employ.recruiters WITH caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'};
ALTER TABLE employ.recruiters WITH crc_check_chance = 1.0;
ALTER TABLE employ.recruiters WITH dclocal_read_repair_chance = 0.1;
ALTER TABLE employ.recruiters WITH default_time_to_live = 0;
ALTER TABLE employ.recruiters WITH gc_grace_seconds = 864000;
ALTER TABLE employ.recruiters WITH max_index_interval = 2048;
ALTER TABLE employ.recruiters WITH memtable_flush_period_in_ms = 0;
ALTER TABLE employ.recruiters WITH min_index_interval = 128;
ALTER TABLE employ.recruiters WITH read_repair_chance = 0.0;
ALTER TABLE employ.recruiters WITH speculative_retry = '99PERCENTILE';

CREATE TABLE IF NOT EXISTS employ.jobs (
job_id timeuuid,
title text,
description text,
short_description text,
company_id timeuuid,
company_name text,
company_avatar_url text,
recruiter_id timeuuid,
recruiter_first_name text,
recruiter_last_name text,
industry text,
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

CREATE TABLE IF NOT EXISTS employ.matches (
match_id timeuuid,
channel_id text,
users set<text>,
PRIMARY KEY(match_id));
CREATE INDEX ON matches (users);

ALTER TABLE employ.matches WITH caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'};
ALTER TABLE employ.matches WITH crc_check_chance = 1.0;
ALTER TABLE employ.matches WITH dclocal_read_repair_chance = 0.1;
ALTER TABLE employ.matches WITH default_time_to_live = 0;
ALTER TABLE employ.matches WITH gc_grace_seconds = 864000;
ALTER TABLE employ.matches WITH max_index_interval = 2048;
ALTER TABLE employ.matches WITH memtable_flush_period_in_ms = 0;
ALTER TABLE employ.matches WITH min_index_interval = 128;
ALTER TABLE employ.matches WITH read_repair_chance = 0.0;
ALTER TABLE employ.matches WITH speculative_retry = '99PERCENTILE';
