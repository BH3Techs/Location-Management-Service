create table if not exists  areas (
    area_id varchar(10) not null,
    area_name varchar(255) not null,
    area_type varchar(2048) default null,
    area_code varchar(10) default null,
    parental_area_id varchar(10),
    primary key (area_id)
    )  ;
create table if not exists  shops (
    shop_id varchar(255) not null,
    shop_name varchar(255) not null,
    shop_type varchar(2048) default null,
    primary key (area_id)
    )  ;