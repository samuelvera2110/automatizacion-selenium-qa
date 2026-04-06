Feature: Gestión de Ciclo de Vida de Usuarios en ReqRes

  Background:
    * url 'https://reqres.in/api'
    * configure headers = { 'Accept': 'application/json', 'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 'Referer': 'https://reqres.in/', 'Origin': 'https://reqres.in' }
    * def userId = 2

  Scenario: 1. Consultar un usuario creado por ID
    Given path 'users', userId
    When method get
    Then status 200
    And match response.data.id == userId
    And match response.data.first_name == '#present'

  Scenario: 2. Actualizar datos de un usuario y verificar actualización
    Given path 'users', userId
    And request { "name": "Samuel Vera", "job": "Software Intern" }
    When method put
    Then status 200
    And match response.name == 'Samuel Vera'

    Given path 'users', userId
    When method get
    Then status 200

  Scenario: 3. Eliminar un usuario del sistema
    Given path 'users', userId
    When method delete
    Then status 204

  Scenario: 4. Consultar lista completa y verificar que el usuario no existe
    Given path 'users'
    And param page = 2
    When method get
    Then status 200
    And match response.data[*].id !contains userId