CREATE TABLE users (user_id BIGINT NOT NULL AUTO_INCREMENT,
                    first_name varchar(50) NOT NULL,
                    last_name varchar(50) NOT NULL,
                    position varchar(50) NOT NULL,
                    username varchar(50) UNIQUE NOT NULL,
                    PRIMARY KEY (user_id)) ENGINE=InnoDB;

CREATE TABLE roles (role_id BIGINT NOT NULL AUTO_INCREMENT,
                    name enum ('ADMIN', 'SUPER_USER', 'USER') NOT NULL,
                    user_id BIGINT NOT NULL,
                    FOREIGN KEY (user_id) REFERENCES users (user_id),
                    PRIMARY KEY (role_id)) ENGINE=InnoDB;