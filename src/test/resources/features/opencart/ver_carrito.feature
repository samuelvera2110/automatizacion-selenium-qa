#language: es
Característica: Ver productos en el carrito
Como usuario de la tienda
Quiero ver los productos que agregué al carrito
Para revisar mi selección antes de comprar

Antecedentes:
Dado que el usuario está en la página principal de OpenCart

Escenario: Verificar productos agregados en el carrito
Cuando el usuario agrega un MacBook al carrito
Y el usuario agrega un iPhone al carrito
Y navega al carrito de compras
Entonces debe estar en la página del carrito
Y debe ver la lista de productos agregados