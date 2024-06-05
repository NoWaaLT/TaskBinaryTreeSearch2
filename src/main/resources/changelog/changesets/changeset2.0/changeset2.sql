--liquibase formatted sql

--changeset Vytautas:2

ALTER TABLE RECORDS
ADD TEST CHARACTER VARYING(255) NULL;