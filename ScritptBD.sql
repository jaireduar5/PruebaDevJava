CREATE DATABASE mi_base_de_datos;
use mi_base_de_datos;

CREATE TABLE `mi_base_de_datos`.`clientes` (
  `idclientes` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(255) NULL,
  `apellido` VARCHAR(255) NULL,
  `direccion` VARCHAR(255) NULL,
  `email` VARCHAR(75) NULL,
  `telefono` VARCHAR(45) NULL,
  `fregistro` DATETIME NULL,
  `factualizacion` DATETIME NULL,
  PRIMARY KEY (`idclientes`));
  
select * from clientes;

INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
VALUES ('John', 'Doe', 'Calle Principal 123', 'johndoe@example.com', '123456789', NOW(), NOW());

INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
VALUES ('Jane', 'Smith', 'Avenida Central 456', 'janesmith@example.com', '987654321', NOW(), NOW());

INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
VALUES ('Michael', 'Johnson', 'Calle Secundaria 789', 'michaeljohnson@example.com', '456789123', NOW(), NOW());
INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
VALUES ('Sarah', 'Williams', 'Avenida Principal 987', 'sarahwilliams@example.com', '321654987', NOW(), NOW());
INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
VALUES ('David', 'Brown', 'Calle Secundaria 654', 'davidbrown@example.com', '789123456', NOW(), NOW());
INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
VALUES ('Emily', 'Jones', 'Avenida Central 321', 'emilyjones@example.com', '654987321', NOW(), NOW());
INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
VALUES ('Robert', 'Davis', 'Calle Principal 456', 'robertdavis@example.com', '987321654', NOW(), NOW());
INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
VALUES ('Jessica', 'Miller', 'Avenida Secundaria 654', 'jessicamiller@example.com', '321987654', NOW(), NOW());
INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
VALUES ('Christopher', 'Taylor', 'Calle Principal 789', 'christophertaylor@example.com', '654321987', NOW(), NOW());
INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
VALUES ('Amanda', 'Anderson', 'Avenida Principal 654', 'amandaanderson@example.com', '987654321', NOW(), NOW());
INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
VALUES ('Matthew', 'Wilson', 'Calle Secundaria 987', 'matthewwilson@example.com', '321456789', NOW(), NOW());
INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
VALUES ('Olivia', 'Brown', 'Avenida Central 123', 'oliviabrown@example.com', '789654123', NOW(), NOW());
INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
VALUES ('William', 'Johnson', 'Calle Principal 321', 'williamjohnson@example.com', '456321789', NOW(), NOW());
INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
VALUES ('Sophia', 'Miller', 'Avenida Secundaria 789', 'sophiamiller@example.com', '987789654', NOW(), NOW());
INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
VALUES ('James', 'Smith', 'Calle Principal 987', 'jamessmith@example.com', '654123789', NOW(), NOW());




DELIMITER //

CREATE PROCEDURE InsertarClientes()
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE total INT DEFAULT 30;

    WHILE i <= total DO
        INSERT INTO mi_base_de_datos.clientes (nombres, apellido, direccion, email, telefono, fregistro, factualizacion)
        VALUES (CONCAT('Nombre', i), CONCAT('Apellido', i), CONCAT('Dirección', i), CONCAT('email', i, '@example.com'), CONCAT('12345678', i), NOW(), NOW());

        SET i = i + 1;
    END WHILE;
END //

DELIMITER ;


CALL InsertarClientes();
