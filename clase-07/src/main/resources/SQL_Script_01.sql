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
/*
Bloque 2: Filtrando y Ordenando Datos
-----------------------------------------
	Seleccionar todos los productos ordenados por precio de manera ascendente.
	Seleccionar todos los productos con un nombre que contenga la palabra "cámara".
	Contar cuántos productos tienen un precio mayor a 200.
	Calcular el precio promedio de los productos.
	Listar todos los productos que tienen más de 5 unidades en stock.
	Listar los productos que no tienen stock.
	Seleccionar los productos cuyo nombre sea "Cámara Digital" o "Smartphone".
	Listar los productos cuyo precio esté entre 50 y 200.
	Ordenar los productos por cantidad en stock de mayor a menor.
	Mostrar los primeros 3 productos más caros.
*/
/*
Bloque 3: Funciones Agregadas y Agrupamiento
---------------------------------------------
	Calcular el precio total de todos los productos.
	Encontrar el producto con el precio máximo.
	Encontrar el producto con el precio mínimo.
	Contar cuántos productos hay por cada precio.
	Calcular la suma de todos los precios de los productos con nombre "Cámara".
	Calcular el precio promedio de todos los productos.
	Agrupar los productos por nombre y contar cuántas veces aparece cada nombre.
	Agrupar los productos por su precio y contar cuántos productos hay en cada grupo.
	Calcular el promedio de precio de los productos de cada marca.
	Contar los productos con un precio mayor al promedio de todos los productos.
*/

SELECT SUM(precio) AS precio_total FROM productos;
SELECT * FROM productos WHERE precio = (SELECT MAX(precio) FROM productos); -- -> Subconsultas SQL
SELECT * FROM productos WHERE precio = (SELECT MIN(precio) FROM productos); 

SELECT precio, COUNT(*) FROM productos GROUP BY precio; 
SELECT SUM(precio) FROM productos WHERE nombre = 'Laptop';

SELECT AVG(precio) AS precio_promedio FROM productos;

SELECT ROUND(AVG(precio)) AS precio_promedio_redondeado FROM productos;

SELECT nombre, COUNT(*) FROM productos GROUP BY nombre; 

-- Agregar columna a Tabla existente (porque ya tiene productos)
ALTER TABLE productos ADD COLUMN marca VARCHAR(150); -- -> Agregarla con NULL por defecto
ALTER TABLE productos ADD COLUMN marca VARCHAR(150) NOT NULL; -- -> Agregarla sin NULL (Cuando la tabla esta vacia)
ALTER TABLE productos ADD COLUMN marca VARCHAR(150) DEFAULT 'Desconocida'; -- -> Agregarla con 'Desconocida' por defecto

SELECT marca, AVG(precio) FROM productos GROUP BY marca;
 
 -- --------------------------------------------------
 
 /*
 Bloque 4: Relaciones y Subconsultas
 -------------------------------------
	Crear una tabla llamada ventas con las columnas: id_venta, id_cliente, id_producto, cantidad, fecha.
	Insertar 5 registros en la tabla ventas.
	Seleccionar las ventas realizadas por un cliente específico.
	Obtener el total gastado por cada cliente (usando la tabla ventas y la tabla productos).
	Obtener el total de ventas por producto (usando ventas y productos).
	Listar los productos que no se han vendido.
	Encontrar el cliente que ha comprado más productos.
	Mostrar el producto más vendido.
	Calcular el total de ventas de cada cliente.
	Obtener el total de ventas de cada producto en el último mes.
*/

CREATE TABLE ventas (
	id_venta INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    id_producto INT,
    cantidad INT,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY (id_producto) REFERENCES productos(id)
);
SELECT * FROM productos;
SELECT * FROM clientes;
SELECT * FROM ventas;
INSERT INTO ventas (id_cliente, id_producto, cantidad) VALUES
	(1, 1, 5), (2, 4, 1), (3, 6, 4), (4, 3, 1), (1, 6, 4);
    
SELECT * FROM ventas WHERE id_cliente = 1;
-- Uso de JOINS

SELECT v.id_cliente, SUM(p.precio * v.cantidad) AS total_gastado
	FROM ventas v
	JOIN productos p ON v.id_producto = p.id
	GROUP BY v.id_cliente;
SELECT id_producto FROM ventas;
SELECT * FROM productos WHERE id NOT IN (SELECT id_producto FROM ventas);

SELECT id_cliente, SUM(cantidad) AS total_comprado
	FROM ventas
    GROUP BY id_cliente
    ORDER BY total_comprado DESC LIMIT 1;
    

SELECT p.nombre, SUM(v.cantidad) AS total_vendido
	FROM ventas v
    JOIN productos p ON v.id_producto = p.id
    GROUP BY p.nombre
    ORDER BY total_vendido DESC LIMIT 1;

-- -------------------------------------------------

/*
Bloque 5: JOINS
------------------
	Realizar un INNER JOIN entre las tablas clientes y ventas para obtener los detalles de ventas por cliente.
	Realizar un LEFT JOIN entre las tablas clientes y ventas para mostrar todos los clientes y las ventas realizadas por ellos (si las hay).
	Realizar un RIGHT JOIN entre las tablas productos y ventas para obtener productos vendidos, incluyendo productos que no se hayan vendido.
	Usar un JOIN para obtener el nombre del cliente y el producto comprado en cada venta.
	Realizar un JOIN para obtener el total gastado por cada cliente, mostrando el nombre del cliente y la cantidad total gastada.
	Mostrar los productos que no han sido comprados, utilizando un LEFT JOIN.
	Obtener la lista de productos y clientes que han realizado una compra en común.
	Realizar un JOIN entre tres tablas: clientes, ventas, y productos para obtener un reporte completo de las compras realizadas.
	Realizar un SELF JOIN en la tabla productos para obtener productos que tengan un precio similar.
	Usar un FULL OUTER JOIN para combinar los registros de clientes y ventas.
*/

SELECT c.nombre, v.cantidad, p.nombre AS producto
	FROM clientes c
    INNER JOIN ventas v ON c.id_cliente = v.id_cliente
    INNER JOIN productos p ON v.id_producto = p.id;
    
SELECT c.nombre, v.cantidad, p.nombre AS producto
	FROM clientes c
    LEFT JOIN ventas v ON c.id_cliente = v.id_cliente
    LEFT JOIN productos p ON v.id_producto = p.id;
    
SELECT c.nombre, v.cantidad, p.nombre AS producto
	FROM clientes c
    RIGHT JOIN ventas v ON c.id_cliente = v.id_cliente
    RIGHT JOIN productos p ON v.id_producto = p.id;
    
SELECT c.id_cliente, c.nombre, v.id_venta, v.cantidad, v.fecha, p.nombre AS producto
	FROM clientes c
    LEFT JOIN ventas v ON c.id_cliente = v.id_cliente   
    LEFT JOIN productos p ON v.id_producto = p.id
	UNION
SELECT c.id_cliente, c.nombre, v.id_venta, v.cantidad, v.fecha, p.nombre AS producto
	FROM clientes c
    RIGHT JOIN ventas v ON c.id_cliente = v.id_cliente
    RIGHT JOIN productos p ON v.id_producto = p.id;