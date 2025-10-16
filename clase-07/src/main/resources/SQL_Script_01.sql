-- Comentario de 1 linea
/*
Bloque 1: Introducción y Operaciones Básicas
	-----------------------------------------
	Crear una base de datos llamada tienda.
	Crear una tabla llamada productos con las siguientes columnas: id, nombre, precio, cantidad.
	Insertar 5 productos en la tabla productos.
	Consultar todos los productos de la tabla productos.
	Seleccionar los productos cuyo precio sea mayor a 100.
	Seleccionar el producto con el precio más bajo.
	Actualizar el precio de un producto.
	Eliminar un producto con precio menor a 50.
	Crear una tabla llamada clientes con columnas: id_cliente, nombre, email, telefono.
	Insertar 5 clientes en la tabla clientes.
	Consultar todos los clientes.
	Consultar el nombre y email de los clientes cuyo nombre empiece con "A".
	Actualizar el email de un cliente específico.
	Eliminar un cliente con un teléfono específico.
	Contar cuántos productos hay en la tabla productos.
*/

-- SQL -> Structured Query Lenguage

CREATE DATABASE IF NOT EXISTS tienda;
USE tienda;

CREATE TABLE productos (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    precio DECIMAL(10, 2),
    cantidad INT
);

INSERT INTO productos (nombre, precio, cantidad) VALUES
		("Camara", 150.50, 30),
        ("Smartphone", 350.50, 50),
        ("Laptop", 800.00, 10),
        ("Tablet", 200.00, 25),
        ("Auriculares", 50.00, 100);
        
SELECT * FROM productos;
SELECT * FROM productos WHERE precio > 100;
SELECT * FROM productos ORDER BY precio ASC LIMIT 1;

SET SQL_SAFE_UPDATES = 0; -- -> Esto deshabilita la proteccion de Update
UPDATE productos SET precio = 120 WHERE nombre = 'Camara';
SET SQL_SAFE_UPDATES = 1; -- -> Esto habilita la proteccion de Update

UPDATE productos SET precio = 45 WHERE id = 5;
DELETE FROM productos WHERE precio < 150;

INSERT INTO productos (nombre, precio, cantidad) VALUES
		("Camara 1", 150.50, 30),
        ("Smartphone 1", 350.50, 50),
        ("Laptop 1", 800.00, 10),
        ("Tablet 1 ", 200.00, 25),
        ("Auriculares 2", 50.00, 100);
        
DROP TABLE clientes;
CREATE TABLE clientes (
	id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    email VARCHAR(100),
    telefono VARCHAR(15)
);

INSERT INTO clientes (nombre, email, telefono) VALUES
	("Juan Perez", "juan@mail.com", "123456"),
    ("Edmundo Gomez", "edmundo@mail.com", "2355655"),
    ("Natalia Gonzalez", "naty@mail.com", "8532323"),
    ("Carlos Martinez", "carlos@mail.com", "632323"),
    ("Ana Garcia", "ana@mail.com", "4221212");

SELECT * FROM clientes;

SELECT nombre, email FROM clientes WHERE nombre LIKE 'A%';

DELETE FROM clientes WHERE telefono = '632323';

SELECT COUNT(*) AS cantidad_productos FROM productos;

-- ------------------------------------------------------------

