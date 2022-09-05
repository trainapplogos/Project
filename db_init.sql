CREATE SCHEMA IF NOT EXISTS acomah;
CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

use acomah;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `apartment` varchar(255) DEFAULT NULL,
  `building` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `password_confirm` varchar(255) DEFAULT NULL,
  `patronymic` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `users` 
VALUES 
/*LOGIN: root PASSWORD: root */
(1,'','','root@company.com','root',_binary '',_binary '\0','root','$2a$10$X9fzsg/YBRky98YPwaZocuU7rx4CQ8TZFsR8Iba12c7WcO88CGhiK','$2a$10$Hl5L.n/TdrwNyBCn0VF86urKgQnoceTM/JF8xs.S.FtTolUwsTPE.','','','ROLE_ADMIN','',''),

/*LOGIN: a@a.a PASSWORD: a */
(2,'54','bld. 50a (Default building)','a@a.a','Administrator',_binary '',_binary '\0','Admin','$2a$10$8XvaTlY8wsmgnicHHnqwaOYqw2PxokJuvR1JVyeT91qIqLvg2pHTS','$2a$10$BzqVpduywYur8rxRgpx0jOp9sOQZBKOIDFjrh9gmL97X27Y0oF4UO','Adm','0981234567','ROLE_ADMIN','str. Some Street','191554A (Default ZIP-CODE)'),

/*LOGIN: supervisor, PASSWORD: super, ROLE:ROLE_SUPERVISOR */
(3,'','','supervisor@company.com','supervisor',_binary '',_binary '\0','supervisor','$2a$10$X9fzsg/YBRky98YPwaZocuU7rx4CQ8TZFsR8Iba12c7WcO88CGhiK','$2a$10$Hl5L.n/TdrwNyBCn0VF86urKgQnoceTM/JF8xs.S.FtTolUwsTPE.','','','ROLE_SUPERVISOR','','')

