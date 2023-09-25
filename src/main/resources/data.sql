INSERT INTO users (id, birth_date, name) VALUES (1001, '2000-01-01', 'Ranga');
INSERT INTO users (id, birth_date, name) VALUES (1002, '2000-01-01', 'Ravi');
INSERT INTO users (id, birth_date, name) VALUES (1003, '2000-01-01', 'Satish');

INSERT INTO posts (id, description, ref_user) VALUES (2001, 'I want to learn AWS', 1001);
INSERT INTO posts (id, description, ref_user) VALUES (2002, 'I want to learn DevOps', 1001);
INSERT INTO posts (id, description, ref_user) VALUES (2003, 'I want to learn Docker', 1002);
INSERT INTO posts (id, description, ref_user) VALUES (2004, 'I want to learn Kubernetes', 1003);

