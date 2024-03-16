# Patron_observer
Teniendo los siguientes microservicios:

Usuario
Payment
CarritoDeCompras
Inventario

La idea es que deben realizar un código que implemente el patron observer despues de que se halla realizado la compra en el servicio de payment, 
debe notificar al servicio de carrito de compras que elimine todos los productos que tiene el carro, al servicio de inventario que descuenta esas unidades y al servicio de usuario de los productos que compro.
