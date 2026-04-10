#language: es
Característica: Checkout como invitado
Como usuario no registrado
Quiero completar una compra como invitado
Para no tener que crear una cuenta

Antecedentes:
Dado que el usuario está en la página principal de OpenCart

Escenario: Flujo completo de checkout como invitado
Cuando el usuario agrega un MacBook al carrito
Y navega al carrito de compras
Y selecciona la opción de checkout
Y elige checkout como invitado
Y completa los datos de facturación con nombre "Samuel", apellido "Vera" y correo "samuel.vera@test.com"
Y confirma el envío y método de pago
Y confirma la orden
Entonces la URL debe contener "success" o "checkout"