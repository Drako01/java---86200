# **Ejercicios SQL para Principiantes a Avanzados**

#### **Bloque 1: Introducción y Operaciones Básicas**

1. **Crear una base de datos llamada `tienda`.**
2. **Crear una tabla llamada `productos` con las siguientes columnas: `id`, `nombre`, `precio`, `cantidad`.**
3. **Insertar 5 productos en la tabla `productos`.**
4. **Consultar todos los productos de la tabla `productos`.**
5. **Seleccionar los productos cuyo precio sea mayor a 100.**
6. **Seleccionar el producto con el precio más bajo.**
7. **Actualizar el precio de un producto.**
8. **Eliminar un producto con precio menor a 50.**
9. **Crear una tabla llamada `clientes` con columnas: `id_cliente`, `nombre`, `email`, `telefono`.**
10. **Insertar 5 clientes en la tabla `clientes`.**
11. **Consultar todos los clientes.**
12. **Consultar el nombre y email de los clientes cuyo nombre empiece con "A".**
13. **Actualizar el email de un cliente específico.**
14. **Eliminar un cliente con un teléfono específico.**
15. **Contar cuántos productos hay en la tabla `productos`.**

#### **Bloque 2: Filtrando y Ordenando Datos**

16. **Seleccionar todos los productos ordenados por precio de manera ascendente.**
17. **Seleccionar todos los productos con un nombre que contenga la palabra "cámara".**
18. **Contar cuántos productos tienen un precio mayor a 200.**
19. **Calcular el precio promedio de los productos.**
20. **Listar todos los productos que tienen más de 5 unidades en stock.**
21. **Listar los productos que no tienen stock.**
22. **Seleccionar los productos cuyo nombre sea "Cámara Digital" o "Smartphone".**
23. **Listar los productos cuyo precio esté entre 50 y 200.**
24. **Ordenar los productos por cantidad en stock de mayor a menor.**
25. **Mostrar los primeros 3 productos más caros.**

#### **Bloque 3: Funciones Agregadas y Agrupamiento**

26. **Calcular el precio total de todos los productos.**
27. **Encontrar el producto con el precio máximo.**
28. **Encontrar el producto con el precio mínimo.**
29. **Contar cuántos productos hay por cada precio.**
30. **Calcular la suma de todos los precios de los productos con nombre "Cámara".**
31. **Calcular el precio promedio de todos los productos.**
32. **Agrupar los productos por nombre y contar cuántas veces aparece cada nombre.**
33. **Agrupar los productos por su precio y contar cuántos productos hay en cada grupo.**
34. **Calcular el promedio de precio de los productos de cada marca.**
35. **Contar los productos con un precio mayor al promedio de todos los productos.**

#### **Bloque 4: Relaciones y Subconsultas**

36. **Crear una tabla llamada `ventas` con las columnas: `id_venta`, `id_cliente`, `id_producto`, `cantidad`, `fecha`.**
37. **Insertar 5 registros en la tabla `ventas`.**
38. **Seleccionar las ventas realizadas por un cliente específico.**
39. **Obtener el total gastado por cada cliente (usando la tabla `ventas` y la tabla `productos`).**
40. **Obtener el total de ventas por producto (usando `ventas` y `productos`).**
41. **Listar los productos que no se han vendido.**
42. **Encontrar el cliente que ha comprado más productos.**
43. **Mostrar el producto más vendido.**
44. **Calcular el total de ventas de cada cliente.**
45. **Obtener el total de ventas de cada producto en el último mes.**

#### **Bloque 5: JOINS**

46. **Realizar un INNER JOIN entre las tablas `clientes` y `ventas` para obtener los detalles de ventas por cliente.**
47. **Realizar un LEFT JOIN entre las tablas `clientes` y `ventas` para mostrar todos los clientes y las ventas realizadas por ellos (si las hay).**
48. **Realizar un RIGHT JOIN entre las tablas `productos` y `ventas` para obtener productos vendidos, incluyendo productos que no se hayan vendido.**
49. **Usar un JOIN para obtener el nombre del cliente y el producto comprado en cada venta.**
50. **Realizar un JOIN para obtener el total gastado por cada cliente, mostrando el nombre del cliente y la cantidad total gastada.**
51. **Mostrar los productos que no han sido comprados, utilizando un LEFT JOIN.**
52. **Obtener la lista de productos y clientes que han realizado una compra en común.**
53. **Realizar un JOIN entre tres tablas: `clientes`, `ventas`, y `productos` para obtener un reporte completo de las compras realizadas.**
54. **Realizar un SELF JOIN en la tabla `productos` para obtener productos que tengan un precio similar.**
55. **Usar un FULL OUTER JOIN para combinar los registros de `clientes` y `ventas`.**

#### **Bloque 6: Subconsultas**

56. **Seleccionar los productos cuyo precio sea mayor al precio promedio de todos los productos.**
57. **Obtener el nombre del cliente que más ha comprado, usando una subconsulta en el SELECT.**
58. **Listar todos los productos que tienen un precio mayor que el precio de "Cámara Digital", utilizando una subconsulta.**
59. **Obtener los clientes que no han realizado ninguna compra, utilizando una subconsulta.**
60. **Obtener el total gastado por un cliente específico en todas sus compras.**
61. **Mostrar los productos cuya cantidad en stock sea mayor que la cantidad de productos vendidos (usando una subconsulta).**
62. **Mostrar los productos cuyo precio es el más alto en cada categoría, usando una subconsulta.**
63. **Obtener el nombre de los clientes que han comprado productos cuyo precio es mayor al precio promedio.**
64. **Obtener el cliente con el mayor total gastado, utilizando una subconsulta en el SELECT.**
65. **Obtener la cantidad total de ventas realizadas por cada cliente, usando una subconsulta.**

#### **Bloque 7: Consultas Complejas y Avanzadas**

66. **Listar los clientes que han comprado más de 5 productos de la misma categoría.**
67. **Obtener un reporte de ventas que incluya el nombre del cliente, nombre del producto, cantidad y total gastado.**
68. **Calcular el total de ventas realizadas por cada cliente, agrupadas por mes.**
69. **Obtener los productos más vendidos por categoría, utilizando un JOIN entre `productos`, `ventas` y `categorias`.**
70. **Listar todos los productos que han sido vendidos más de 10 veces.**
71. **Calcular la cantidad total de ventas de productos que tienen un precio superior a 100.**
72. **Obtener un reporte que muestre los clientes que han comprado productos de más de 3 categorías diferentes.**
73. **Calcular la suma de ventas de productos cuyo precio esté entre 100 y 300.**
74. **Listar todos los productos cuyo nombre contenga la palabra "Smartphone" y hayan sido vendidos más de 20 veces.**
75. **Crear un reporte que muestre el total gastado por cliente y por categoría de productos.**
76. **Obtener los productos más caros que han sido vendidos, utilizando una subconsulta para obtener el precio máximo.**
77. **Calcular el promedio de ventas por cliente, mostrando la cantidad de productos comprados por cada uno.**
78. **Obtener el nombre de los clientes que han comprado todos los productos de una categoría específica.**
79. **Listar los productos que no se han vendido en el último mes, utilizando una subconsulta con un `LEFT JOIN`.**
80. **Obtener un listado de clientes que han comprado productos en más de 5 ocasiones.**

#### **Bloque 8: Operaciones Avanzadas**

81. **Realizar un `CROSS JOIN` entre las tablas `clientes` y `productos` para obtener todas las combinaciones posibles de cliente y producto.**
82. **Crear un índice en la columna `nombre` de la tabla `productos`.**
83. **Realizar una consulta utilizando una cláusula `HAVING` para filtrar resultados después de una agregación.**
84. **Calcular el porcentaje de ventas de cada producto con respecto al total de ventas.**
85. **Listar los productos que tienen un precio superior al promedio de su categoría.**
86. **Obtener los clientes cuyo total gastado en el último mes es mayor al promedio de todos los clientes.**
87. **Realizar una actualización masiva de los precios de productos que no se han vendido en el último trimestre.**
88. **Crear una vista que muestre el total gastado por cada cliente.**
89. **Crear un procedimiento almacenado que calcule la cantidad total de ventas realizadas.**
90. **Crear un trigger que se active cuando se inserte una nueva venta para actualizar el stock de un producto.**
91. **Realizar una consulta que liste las categorías de productos y el número de productos en cada categoría.**
92. **Crear una consulta que liste todos los clientes, junto con su total gastado, ordenado por el monto gastado.**
93. **Obtener el nombre del producto con más ventas utilizando una subconsulta.**
94. **Calcular el total gastado por cada cliente en los últimos 6 meses.**
95. **Realizar una consulta para listar todos los productos que han sido vendidos entre 5 y 10 veces.**
96. **Obtener el total de ventas de los productos de un cliente específico, filtrando por fecha.**
97. **Listar todos los productos cuyo nombre contiene la palabra "lente" y que sean vendidos más de 20 veces.**
98. **Calcular el promedio de precio de los productos vendidos en una categoría específica.**
99. **Obtener el cliente con el mayor número de productos vendidos, utilizando `JOINs` y `GROUP BY`.**
100. **Crear un reporte que combine los productos y clientes, mostrando los productos más comprados por cada cliente.**

---


