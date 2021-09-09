CREATE TABLE USER (
    id int NOT NULL,
    name varchar2(255) NOT NULL,
    email varchar2(255) NOT NULL,
    password varchar2(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ROLE (
    id int NOT NULL,
    role_name varchar2(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE USER_ROLE (
    user_id int NOT NULL,
    role_id int NOT NULL,
    FOREIGN KEY (user_id) REFERENCES USER(id),
    FOREIGN KEY (role_id) REFERENCES ROLE(id)
);

INSERT INTO USER (id, name, email, password) VALUES (1, 'Nina Brown', 'nina@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
INSERT INTO USER (id, name, email, password) VALUES (2, 'Leia Red', 'leia@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');

INSERT INTO ROLE (id, role_name) VALUES (1, 'ROLE_OPERATOR');
INSERT INTO ROLE (id, role_name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 1);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 1);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2);