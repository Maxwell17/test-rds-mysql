CREATE TABLE users
(
    user_id    BIGINT             NOT NULL AUTO_INCREMENT,
    first_name varchar(50)        NOT NULL,
    last_name  varchar(50)        NOT NULL,
    position   varchar(50)        NOT NULL,
    username   varchar(50) UNIQUE NOT NULL,
    PRIMARY KEY (user_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE roles
(
    role_id BIGINT                               NOT NULL AUTO_INCREMENT,
    name    enum ('ADMIN', 'SUPER_USER', 'USER') NOT NULL,
    PRIMARY KEY (role_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE user_role
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id,
                 role_id),
    KEY user_id (user_id),
    CONSTRAINT user_role_ibfk_1
        FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT user_role_ibfk2
        FOREIGN KEY (role_id) REFERENCES roles (role_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;