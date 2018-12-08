create table people (
   id UUID unique,
   firstname text,
   lastname text,
   primary key(id)
);

insert into people(id, firstname, lastname) values (uuid_generate_v4(), 'Tereza', 'Holm');