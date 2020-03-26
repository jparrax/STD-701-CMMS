CREATE TABLE `users` (
  `user_id` int PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(200),
  `password` varchar(255),
  `first_name` varchar(100),
  `last_name` varchar(100),
  `email` varchar(200),
  `fk_role_id` int,
  `is_active` boolean DEFAULT true,
  `created_at` datetime DEFAULT (now())
);

CREATE TABLE `roles` (
  `role_id` int PRIMARY KEY,
  `role_name` varchar(50),
  `is_active` boolean DEFAULT true,
  `created_at` datetime DEFAULT (now())
);

CREATE TABLE `raw_materials` (
  `material_id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `inci_name` varchar(255),
  `fk_user_id` int,
  `is_active` boolean DEFAULT true,
  `created_at` datetime DEFAULT (now())
);

CREATE TABLE `inventories` (
  `inv_id` int PRIMARY KEY AUTO_INCREMENT,
  `material_id` int,
  `batch_number` varchar(100),
  `analysis_number` varchar(100),
  `expired_date` date,
  `suplier` int,
  `desc` varchar(255),
  `quantity` float,
  `is_active` boolean DEFAULT true,
  `created_at` datetime DEFAULT (now())
);

CREATE TABLE `formulas` (
  `formula_id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `desc` varchar(255),
  `fk_user_id` int,
  `is_active` boolean DEFAULT true,
  `created_at` datetime DEFAULT (now())
);

CREATE TABLE `ingredients` (
  `percentage` float,
  `fk_user_id` int,
  `fk_formula_id` int,
  `fk_material_id` int,
  `input_date` datetime,
  `desc` varchar(255),
  `is_active` boolean DEFAULT true,
  `created_at` datetime DEFAULT (now())
);

CREATE TABLE `supliers` (
  `suplier_id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `is_active` boolean DEFAULT true,
  `created_at` datetime DEFAULT (now())
);

CREATE TABLE `orders` (
  `order_id` int PRIMARY KEY AUTO_INCREMENT,
  `fk_user_id` int,
  `customer_name` varchar(255),
  `order_date` datetime,
  `desc` varchar(255),
  `is_active` boolean,
  `created_at` datetime
);

CREATE TABLE `order_transactions` (
  `transaction_id` int PRIMARY KEY AUTO_INCREMENT,
  `fk_order_id` int,
  `fk_formula_id` int,
  `batch_size` float,
  `desc` varchar(255),
  `is_active` boolean DEFAULT true,
  `created_at` datetime DEFAULT (now())
);

ALTER TABLE `users` ADD FOREIGN KEY (`fk_role_id`) REFERENCES `roles` (`role_id`);

ALTER TABLE `inventories` ADD FOREIGN KEY (`suplier`) REFERENCES `supliers` (`suplier_id`);

ALTER TABLE `raw_materials` ADD FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `formulas` ADD FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `ingredients` ADD FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `ingredients` ADD FOREIGN KEY (`fk_formula_id`) REFERENCES `formulas` (`formula_id`);

ALTER TABLE `ingredients` ADD FOREIGN KEY (`fk_material_id`) REFERENCES `raw_materials` (`material_id`);

ALTER TABLE `inventories` ADD FOREIGN KEY (`material_id`) REFERENCES `raw_materials` (`material_id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `order_transactions` ADD FOREIGN KEY (`fk_order_id`) REFERENCES `orders` (`order_id`);

ALTER TABLE `order_transactions` ADD FOREIGN KEY (`fk_formula_id`) REFERENCES `formulas` (`formula_id`);
