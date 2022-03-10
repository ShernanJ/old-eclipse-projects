INSERT INTO sec_user (firstName, email, encryptedPassword, enabled)
VALUES ('Simon','simon.hood@sheridancollege.ca', '$2a$10$1ltibqiyyBJMJQ4hqM7f0OusP6np/IHshkYc4TjedwHnwwNChQZCy', 1);

INSERT INTO sec_user (firstName, email, encryptedPassword, enabled)
VALUES ('Jonathan', 'jonathan.penava@sheridancollege.ca', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

INSERT INTO sec_user (firstName, email, encryptedPassword, enabled)
VALUES ('Admin', 'admin@allbooks.ca', '$2a$10$/EHDfNVFLnt42p1DujQUteT7bsbb67S.ioBQYEOA0FgHXedgNeaA6', 1);
 
INSERT INTO sec_role (roleName)
VALUES ('ROLE_ADMIN');
 
INSERT INTO sec_role (roleName)
VALUES ('ROLE_USER');
 

 
INSERT INTO user_role (userId, roleId)
VALUES (1, 1);
 
INSERT INTO user_role (userId, roleId)
VALUES (1, 2);
 
INSERT INTO user_role (userId, roleId)
VALUES (2, 2);

INSERT INTO user_role (userId, roleId)
VALUES (3, 1);

INSERT INTO user_role (userId, roleId)
VALUES (3, 2);

INSERT INTO book(name, author) VALUES
('Naruto', 'Masashi Kishimoto'),
('Attack on Titan', 'Hajime Isayama'),
('How to get Swag', 'Shernan Javier');