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



