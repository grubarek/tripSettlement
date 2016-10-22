--przed wywołaniem tego skryptu nalezy wykonac skrypt 01-create-user.sql
--uwaga: create database musi byc wykonane jako pojedyncza komenda
CREATE DATABASE trip
  WITH OWNER = trip
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'pl_PL.UTF-8'
       LC_CTYPE = 'pl_PL.UTF-8'
       CONNECTION LIMIT = -1;
--dajemy uprawnienia
GRANT CONNECT, TEMPORARY ON DATABASE trip TO public;
GRANT ALL ON DATABASE trip TO trip;
--w kolejnym kroku należy utworzyć bazę poprzez 03-create-schema.sql (lub najnowszą wersję z katalogu /versions)
