INSERT INTO roles (name)
VALUES ('ADMIN');
INSERT INTO roles (name)
VALUES ('SUPER_USER');
INSERT INTO roles (name)
VALUES ('USER');

INSERT INTO users (first_name, last_name, position, username)
VALUES ('Viktor', 'Zahnitko', 'Expert Java', 'vzahnitko');

INSERT INTO user_role (user_id, role_id)
VALUES (1, 1);
INSERT INTO user_role (user_id, role_id)
VALUES (1, 2);