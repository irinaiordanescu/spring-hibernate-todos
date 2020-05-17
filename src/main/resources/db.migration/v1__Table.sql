CREATE TABLE todo(
    idTask UUID NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(100),
    duration VARCHAR(100)
)