create table contract (
	id_contract int not null primary key,
	description text,
	amount numeric,
	periods integer,
	date timestamp
);

create table payment (
	id_payment int not null primary key,
	id_contract int references contract (id_contract),
	amount numeric,
	date timestamp
);