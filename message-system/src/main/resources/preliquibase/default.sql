--changeset shadrinmd:create_retailer_schema
create schema if not exists retailer;

--rollback
--drop schema retailer;
