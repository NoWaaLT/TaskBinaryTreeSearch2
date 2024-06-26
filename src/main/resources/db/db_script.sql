-- H2 2.2.224;
;             
CREATE USER IF NOT EXISTS "SA" SALT 'c95b66d9103e625a' HASH 'cdf809c160abceebf4e1e82c42132b0e7ab7f6c37e8fd958d9b1787218e7e6c8' ADMIN;         
CREATE CACHED TABLE "PUBLIC"."RECORDS"(
    "ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 17) NOT NULL,
    "RECORD_TIMESTAMP" TIMESTAMP NOT NULL,
    "WORD" CHARACTER VARYING(255),
    "POSITION" INTEGER NOT NULL,
    "SOURCE" INTEGER NOT NULL
);       
ALTER TABLE "PUBLIC"."RECORDS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_6" PRIMARY KEY("ID");      
-- 16 +/- SELECT COUNT(*) FROM PUBLIC.RECORDS;
INSERT INTO "PUBLIC"."RECORDS" VALUES
(1, TIMESTAMP '2024-05-28 21:44:11.427747', 'Lorem', 1, 0),
(2, TIMESTAMP '2024-05-28 22:09:42.656599', 'Lorem', 1, 0),
(3, TIMESTAMP '2024-05-28 22:09:57.438772', 'dsadas', 0, 0),
(4, TIMESTAMP '2024-05-28 22:15:27.950604', 'Lorem', 1, 0),
(5, TIMESTAMP '2024-05-28 22:19:12.263472', 'dsadas', 0, 0),
(6, TIMESTAMP '2024-05-29 09:14:35.51262', 'Lorem', 0, 1),
(7, TIMESTAMP '2024-05-29 09:19:34.64493', 'Do', 347, 1),
(8, TIMESTAMP '2024-05-29 09:28:26.833126', 'Do', 347, 1),
(9, TIMESTAMP '2024-05-29 09:52:45.852404', 'Lorem', 1, 0),
(10, TIMESTAMP '2024-05-29 15:01:12.926305', 'Lorem', 1, 0),
(11, TIMESTAMP '2024-05-30 09:51:47.968799', 'Lorem', 1, 0),
(12, TIMESTAMP '2024-05-30 09:51:57.22244', 'Delfi', 0, 1),
(13, TIMESTAMP '2024-05-30 14:24:08.548962', 'Lorem', 1, 0),
(14, TIMESTAMP '2024-05-30 14:31:11.589676', 'Lorem', 1, 0),
(15, TIMESTAMP '2024-05-30 14:39:26.302333', 'Lorem', 1, 0),
(16, TIMESTAMP '2024-05-30 14:40:35.849191', 'Lorem', 1, 0);     
