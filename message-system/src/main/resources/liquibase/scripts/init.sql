--liquibase formatted sql

--changeset shadrinmd:create_orders_table
set schema 'retailer';
create table if not exists orders
(
    id        text,
    address   text,
    recipient text,
    primary key (id)
);
--rollback
--drop table orders;

--changeset shadrinmd:create_items_table
set schema 'retailer';
create table if not exists items
(
    id   bigint,
    name text,
    primary key (id)
);
--rollback
--drop table items;

--changeset shadrinmd:create_order_infos_table
set schema 'retailer';
create table if not exists order_infos
(
    order_id  text,
    status    int,
    signature text,
    primary key (order_id),
    constraint fk_order foreign key (order_id) references orders (id)
);
--rollback
--drop table order_infos;

--changeset shadrinmd:create_orders_items_table
set schema 'retailer';
create table if not exists orders_items
(
    order_id text,
    items_id bigint,
    primary key (order_id, items_id),
    constraint fk_order foreign key (order_id) references orders (id),
    constraint fk_item foreign key (items_id) references items (id)
);
--rollback
--drop table orders_items;
