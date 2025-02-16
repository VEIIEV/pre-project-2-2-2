SET search_path TO spring_app_tolya;

truncate spring_app_tolya.users cascade;
truncate spring_app_tolya.cars cascade;

CREATE SEQUENCE IF NOT EXISTS car_id_seq START 1 INCREMENT 1;
ALTER SEQUENCE car_id_seq RESTART WITH 1;

CREATE SEQUENCE IF NOT EXISTS user_id_seq START 1 INCREMENT 1;
ALTER SEQUENCE user_id_seq RESTART WITH 1;


INSERT INTO cars (car_id, model, series, cost)
VALUES (nextval('car_id_seq'), 'BMW X7', 2023, 2500000);
INSERT INTO cars (car_id, model, series, cost)
VALUES (nextval('car_id_seq'), 'Mercedes S-Class', 2022, 1800000);
INSERT INTO cars (car_id, model, series, cost)
VALUES (nextval('car_id_seq'), 'Toyota Camry', 2021, 900000);
INSERT INTO cars (car_id, model, series, cost)
VALUES (nextval('car_id_seq'), 'Lada Vesta', 2023, 800000);
INSERT INTO cars (car_id, model, series, cost)
VALUES (nextval('car_id_seq'), 'Audi A8', 2023, 2100000);
INSERT INTO cars (car_id, model, series, cost)
VALUES (nextval('car_id_seq'), 'Volkswagen Polo', 2022, 700000);
INSERT INTO cars (car_id, model, series, cost)
VALUES (nextval('car_id_seq'), 'Tesla Model S', 2023, 3200000);
INSERT INTO cars (car_id, model, series, cost)
VALUES (nextval('car_id_seq'), 'Ford Focus', 2021, 850000);
INSERT INTO cars (car_id, model, series, cost)
VALUES (nextval('car_id_seq'), 'Porsche Panamera', 2023, 2800000);
INSERT INTO cars (car_id, model, series, cost)
VALUES (nextval('car_id_seq'), 'Hyundai Solaris', 2022, 600000);

INSERT INTO users (user_id, name, last_name, email, revenue, car_id)
VALUES (nextval('user_id_seq'), 'John', 'Doe', 'john@example.com', 5000000, 1);
INSERT INTO users (user_id, name, last_name, email, revenue, car_id)
VALUES (nextval('user_id_seq'), 'Jane', 'Smith', 'jane@example.com', 4500000, 2);
INSERT INTO users (user_id, name, last_name, email, revenue, car_id)
VALUES (nextval('user_id_seq'), 'Alice', 'Johnson', 'alice@example.com', 1200000, 3);
INSERT INTO users (user_id, name, last_name, email, revenue, car_id)
VALUES (nextval('user_id_seq'), 'Bob', 'Brown', 'bob@example.com', 900000, 4);
INSERT INTO users (user_id, name, last_name, email, revenue, car_id)
VALUES (nextval('user_id_seq'), 'Charlie', 'Davis', 'charlie@example.com', 7000000, 5);
INSERT INTO users (user_id, name, last_name, email, revenue, car_id)
VALUES (nextval('user_id_seq'), 'David', 'Miller', 'david@example.com', 600000, 6);
INSERT INTO users (user_id, name, last_name, email, revenue, car_id)
VALUES (nextval('user_id_seq'), 'Ella', 'Taylor', 'ella@example.com', 8000000, 7);
INSERT INTO users (user_id, name, last_name, email, revenue, car_id)
VALUES (nextval('user_id_seq'), 'Frank', 'Wilson', 'frank@example.com', 400000, 8);
INSERT INTO users (user_id, name, last_name, email, revenue, car_id)
VALUES (nextval('user_id_seq'), 'Grace', 'Moore', 'grace@example.com', 6500000, 9);
INSERT INTO users (user_id, name, last_name, email, revenue, car_id)
VALUES (nextval('user_id_seq'), 'Harry', 'Anderson', 'harry@example.com', 300000, 10);
