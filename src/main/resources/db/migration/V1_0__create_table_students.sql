create table TB_STUDENTS(
    id integer primary key auto_increment,
    name varchar(100),
    ra varchar(10),
    created_date timestamp not null,
    last_created_date timestamp not null
)