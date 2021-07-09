DROP TABLE IF EXISTS brands CASCADE;
DROP TABLE IF EXISTS models CASCADE;
DROP TABLE IF EXISTS owners CASCADE;
DROP TABLE IF EXISTS vehicles CASCADE;


CREATE TABLE "vehicles"
(
    "id"         BIGSERIAL PRIMARY KEY,
    "owner_id"   integer,
    "brand_id"   integer,
    "model_id"   integer,
    "created_at" timestamp DEFAULT (now())
);

CREATE TABLE "brands"
(
    "id"   SERIAL PRIMARY KEY,
    "name" text UNIQUE
);

CREATE TABLE "models"
(
    "id"              SERIAL PRIMARY KEY,
    "name"            text UNIQUE,
    "characteristics" text,
    "brand_id"        integer
);

CREATE TABLE "owners"
(
    "id"         SERIAL PRIMARY KEY,
    "first_name" text NOT NULL,
    "last_name"  text NOT NULL,
    "patronymic" text NOT NULL
);

ALTER TABLE "vehicles"
    ADD FOREIGN KEY ("brand_id") REFERENCES "brands" ("id");

ALTER TABLE "vehicles"
    ADD FOREIGN KEY ("model_id") REFERENCES "models" ("id");

ALTER TABLE "models"
    ADD FOREIGN KEY ("brand_id") REFERENCES "brands" ("id");

ALTER TABLE "vehicles"
    ADD FOREIGN KEY ("owner_id") REFERENCES "owners" ("id");

COMMENT
ON COLUMN "vehicles"."owner_id" IS 'Id владельца';

COMMENT
ON COLUMN "vehicles"."brand_id" IS 'Id бренда';

COMMENT
ON COLUMN "vehicles"."model_id" IS 'Id модели';

COMMENT
ON COLUMN "brands"."name" IS 'Название бренда';

COMMENT
ON COLUMN "models"."name" IS 'Название модели';

COMMENT
ON COLUMN "models"."characteristics" IS 'Характеристики';

COMMENT
ON COLUMN "models"."brand_id" IS 'Id бренда';

COMMENT
ON COLUMN "owners"."first_name" IS 'Имя';

COMMENT
ON COLUMN "owners"."last_name" IS 'Фамилия';

COMMENT
ON COLUMN "owners"."patronymic" IS 'Отчество';
