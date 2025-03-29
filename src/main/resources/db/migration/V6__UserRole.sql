CREATE TABLE roles (
    id serial not null PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE permissions (
    id serial not null PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE roles_permissions (
    role_id INTEGER NOT NULL,
    permission_id INTEGER NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (permission_id) REFERENCES permissions(id),
    PRIMARY KEY (role_id, permission_id)
);

CREATE TABLE user_roles (
    customer_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (role_id) REFERENCES roles(id),
    PRIMARY KEY (customer_id, role_id)
);

INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('CUSTOMER');

INSERT INTO user_roles (customer_id, role_id) VALUES (1, 1); -- User 1 is an ADMIN

INSERT INTO permissions (name) VALUES ('view_books');
INSERT INTO permissions (name) VALUES ('create_books');
INSERT INTO permissions (name) VALUES ('edit_books');
INSERT INTO permissions (name) VALUES ('delete_books');
INSERT INTO permissions (name) VALUES ('view_orders');
INSERT INTO permissions (name) VALUES ('create_orders');
INSERT INTO permissions (name) VALUES ('edit_orders');
INSERT INTO permissions (name) VALUES ('delete_orders');
INSERT INTO permissions (name) VALUES ('manage_users');
INSERT INTO permissions (name) VALUES ('view_users');
INSERT INTO permissions (name) VALUES ('edit_users');
INSERT INTO permissions (name) VALUES ('delete_users');

INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 1);  -- ADMIN - view_books
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 2);  -- ADMIN - create_books
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 3);  -- ADMIN - edit_books
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 4);  -- ADMIN - delete_books
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 5);  -- ADMIN - view_orders
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 6);  -- ADMIN - create_orders
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 7);  -- ADMIN - edit_orders
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 8);  -- ADMIN - delete_orders
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 9);  -- ADMIN - manage_users
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 10); -- ADMIN - view_users
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 11); -- ADMIN - edit_users
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 12); -- ADMIN - delete_users
INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 1);  -- CUSTOMER - view_books
INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 5);  -- CUSTOMER - view_orders
INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 6);  -- CUSTOMER - create_orders
