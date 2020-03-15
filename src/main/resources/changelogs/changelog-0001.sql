CREATE TABLE "donor"(
    id bigserial primary key,
    created timestamp not null,
    updated timestamp,
    email varchar (355) unique not null,
    password varchar (50) not null,
    first_name varchar (50) not null,
    last_name varchar (50) not null,
    address varchar (355) null
);

CREATE TABLE "address"(
    id bigserial primary key,
    created timestamp not null,
    updated timestamp,
    donor_id bigserial references donor(id),
    country varchar (50) unique not null,
    post_code varchar (50) not null,
    town varchar (50) not null,
    house_number bigint not null,
    street varchar (355) not null,
    street_number bigint not null
);