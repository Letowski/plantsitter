-- schema owner
CREATE USER plantsitter WITH password 'plantsitter' NOSUPERUSER NOCREATEROLE NOCREATEDB;

CREATE DATABASE "plantsitter" OWNER plantsitter CONNECTION LIMIT 100;

\connect "plantsitter";

-- schema user
CREATE USER plantsitter_user WITH password 'plantsitter_user';


-- create schema
CREATE SCHEMA plantsitter AUTHORIZATION plantsitter;

--add-extensions
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
ALTER EXTENSION "uuid-ossp" SET SCHEMA plantsitter;


--add-privileges
GRANT USAGE ON SCHEMA plantsitter TO plantsitter_user;


ALTER DEFAULT PRIVILEGES FOR USER plantsitter IN SCHEMA plantsitter GRANT SELECT,INSERT,UPDATE,DELETE  ON TABLES TO plantsitter_user;
ALTER DEFAULT PRIVILEGES FOR USER plantsitter IN SCHEMA plantsitter GRANT USAGE ON SEQUENCES TO plantsitter_user;
ALTER DEFAULT PRIVILEGES FOR USER plantsitter IN SCHEMA plantsitter GRANT EXECUTE ON FUNCTIONS  TO plantsitter_user;

ALTER DATABASE plantsitter SET DEFAULT_TRANSACTION_ISOLATION TO 'read committed';
