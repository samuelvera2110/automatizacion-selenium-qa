#language: es
Característica: Pago de factura
Como usuario registrado
Quiero pagar una factura
Para realizar un retiro

Antecedentes:
Dado que el usuario está en la página principal de ParaBank

Escenario: Pago de factura exitoso
Cuando el usuario se registra con nombre "Samuel" apellido "Vera"
Y el usuario paga una factura a "Servicios Varios" por "100.00"
Entonces debe ver el título de pago "Bill Payment Complete"