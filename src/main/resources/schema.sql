create table Product (
                         id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                         description VARCHAR,
                         price INT,
                         name VARCHAR,
                         picture VARCHAR
);