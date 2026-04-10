#language: es
Característica: Agregar productos al carrito
Como usuario de la tienda
Quiero agregar productos al carrito
Para poder comprarlos

Antecedentes:
Dado que el usuario está en la página principal de OpenCart

Escenario: Agregar dos productos al carrito exitosamente
Cuando el usuario agrega un MacBook al carrito
Entonces debe ver el mensaje de éxito que contiene "Success: You have added MacBook"
Cuando el usuario agrega un iPhone al carrito
Entonces el carrito debe mostrar "2 item(s)"