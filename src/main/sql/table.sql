CREATE TABLE `user` (
  `id` bigint NOT NULL PRIMARY KEY,
  `is_valid` tinyint(4) DEFAULT '1',
  `username` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `created_at` timestamp DEFAULT CURRENT_TIMESTAMP
)