#language: es
Característica: Transferencia entre cuentas
Como usuario registrado
Quiero transferir fondos entre cuentas
Para mover mi dinero

Antecedentes:
Dado que el usuario está en la página principal de ParaBank

Escenario: Transferencia exitosa entre cuentas
Cuando el usuario se registra con nombre "Samuel" apellido "Vera"
Y el usuario abre una nueva cuenta de tipo "SAVINGS"
Y el usuario transfiere "500" entre sus cuentas
Entonces debe ver el título de transferencia "Transfer Complete!"