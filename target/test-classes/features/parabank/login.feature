#language: es
Característica: Login en ParaBank
Como usuario registrado
Quiero iniciar sesión en ParaBank
Para acceder a mis cuentas

Antecedentes:
Dado que el usuario está en la página principal de ParaBank

Escenario: Login exitoso con usuario registrado
Cuando el usuario se registra con nombre "Samuel" apellido "Vera"
Y el usuario cierra sesión
Cuando el usuario inicia sesión
Entonces debe ver la página "Accounts Overview"