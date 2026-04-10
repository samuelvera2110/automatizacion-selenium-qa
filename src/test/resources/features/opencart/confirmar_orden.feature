#language: es
Característica: Confirmación de orden
Como usuario que completó una compra
Quiero ver la confirmación de mi orden
Para saber que fue procesada correctamente

Antecedentes:
Dado que el usuario está en la página principal de OpenCart

Escenario: Visualizar el heading de confirmación de orden
Cuando el usuario agrega un MacBook al carrito
Y navega al carrito de compras
Y selecciona la opción de checkout
Y elige checkout como invitado
Y completa los datos de facturación con nombre "Samuel", apellido "Vera" y correo "samuel.vera@test.com"
Y confirma el envío y método de pago
Y confirma la orden
Entonces debe visualizarse el mensaje "Your order has been placed!"