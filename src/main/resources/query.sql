create table book_details(

	book_id serial primary key,
	name varchar(255) not null,
	description varchar(255) not null,
	publisher varchar(255) not null,
	author varchar(255) not null
);

select
    bd.author,
    bd.book_id,
    bd.description,
    bd."name",
    bd.publisher
from
    book_details bd;

