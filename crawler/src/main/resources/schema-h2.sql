drop table culture if exists;
drop table culture_rowdata if exists;

create table culture (id bigint generated by default as identity, culture_name varchar(255), primary key (id));
create table culture_rowdata (id bigint generated by default as identity,startdate varchar(255), enddate varchar(255), image_url varchar(255), place varchar(255), title varchar(255), culture_id bigint, primary key (id));

alter table culture add constraint Uniquekey_constraint unique (culture_name);
alter table culture_rowdata add constraint rawdata_key_constraint foreign key (culture_id) references culture;

