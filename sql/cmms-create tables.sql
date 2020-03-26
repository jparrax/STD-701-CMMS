CREATE TABLE "users" (
  "user_id" SERIAL PRIMARY KEY,
  "username" varchar(200),
  "password" varchar(255),
  "first_name" varchar(100),
  "last_name" varchar(100),
  "email" varchar(200),
  "fk_role_id" int,
  "is_active" boolean DEFAULT true,
  "created_at" timestamp  DEFAULT (now())
);

CREATE TABLE "roles" (
  "role_id" int PRIMARY KEY,
  "role_name" varchar(50),
  "is_active" boolean DEFAULT true,
  "created_at" timestamp  DEFAULT (now())
);

CREATE TABLE "raw_materials" (
  "material_id" SERIAL PRIMARY KEY,
  "name" varchar(255),
  "inci_name" varchar(255),
  "fk_user_id" int,
  "is_active" boolean DEFAULT true,
  "created_at" timestamp  DEFAULT (now())
);

CREATE TABLE "inventories" (
  "inv_id" SERIAL PRIMARY KEY,
  "material_id" int,
  "batch_number" varchar(100),
  "analysis_number" varchar(100),
  "expired_date" date,
  "supplier" int,
  "desc" varchar(255),
  "quantity" float,
  "is_active" boolean DEFAULT true,
  "created_at" timestamp  DEFAULT (now())
);

CREATE TABLE "formulas" (
  "formula_id" SERIAL PRIMARY KEY,
  "name" varchar(255),
  "desc" varchar(255),
  "fk_user_id" int,
  "is_active" boolean DEFAULT true,
  "created_at" timestamp  DEFAULT (now())
);


CREATE TABLE "ingredients" (
"ingredient_id" SERIAL PRIMARY KEY,
  "percentage" float,
  "fk_user_id" int,
  "fk_formula_id" int,
  "fk_material_id" int,
  "input_date" timestamp ,
  "desc" varchar(255),
  "is_active" boolean DEFAULT true,
  "created_at" timestamp  DEFAULT (now())
);

CREATE TABLE "suppliers" (
  "supplier_id" SERIAL PRIMARY KEY,
  "name" varchar(255),
  "is_active" boolean DEFAULT true,
  "created_at" timestamp  DEFAULT (now())
);

CREATE TABLE "orders" (
  "order_id" SERIAL PRIMARY KEY,
  "fk_user_id" int,
  "customer_name" varchar(255),
  "order_date" timestamp ,
  "desc" varchar(255),
  "is_active" boolean,
  "created_at" timestamp 
);

CREATE TABLE "order_transactions" (
  "transaction_id" SERIAL PRIMARY KEY,
  "fk_order_id" int,
  "fk_formula_id" int,
  "batch_size" float,
  "desc" varchar(255),
  "is_active" boolean DEFAULT true,
  "created_at" timestamp  DEFAULT (now())
);

ALTER TABLE "users" ADD FOREIGN KEY ("fk_role_id") REFERENCES "roles" ("role_id");

ALTER TABLE "inventories" ADD FOREIGN KEY ("supplier") REFERENCES "suppliers" ("supplier_id");

ALTER TABLE "raw_materials" ADD FOREIGN KEY ("fk_user_id") REFERENCES "users" ("user_id");

ALTER TABLE "formulas" ADD FOREIGN KEY ("fk_user_id") REFERENCES "users" ("user_id");

ALTER TABLE "ingredients" ADD FOREIGN KEY ("fk_user_id") REFERENCES "users" ("user_id");

ALTER TABLE "ingredients" ADD FOREIGN KEY ("fk_formula_id") REFERENCES "formulas" ("formula_id");

ALTER TABLE "ingredients" ADD FOREIGN KEY ("fk_material_id") REFERENCES "raw_materials" ("material_id");

ALTER TABLE "inventories" ADD FOREIGN KEY ("material_id") REFERENCES "raw_materials" ("material_id");

ALTER TABLE "orders" ADD FOREIGN KEY ("fk_user_id") REFERENCES "users" ("user_id");

ALTER TABLE "order_transactions" ADD FOREIGN KEY ("fk_order_id") REFERENCES "orders" ("order_id");

ALTER TABLE "order_transactions" ADD FOREIGN KEY ("fk_formula_id") REFERENCES "formulas" ("formula_id");
