#language: es
Característica: Registro en ParaBank
Como usuario nuevo
Quiero registrarme en ParaBank
Para crear una cuenta

Antecedentes:
Dado que el usuario está en la página principal de ParaBank

Escenario: Registro exitoso de nuevo usuario
Cuando el usuario se registra con nombre "Samuel" apellido "Vera"
Entonces debe ver el mensaje "Your account was created successfully. You are now logged in."