Feature: Gestion de Mascotas en la Tienda

  Background:
    * url 'https://petstore.swagger.io/v2'
    * header Accept = 'application/json'
    * def miMascotaId = 456789123
    * def mascotaBase = { id: '#(miMascotaId)', name: 'Bruno', status: 'available' }

  Scenario: 1. Añadir una nueva mascota exitosamente
    Given path 'pet'
    And request mascotaBase
    When method post
    Then status 200
    And match response.name == 'Bruno'

  Scenario: 2. Consultar mascota por su ID
    Given path 'pet', miMascotaId
    When method get
    Then status 200
    And match response.id == miMascotaId

  Scenario: 3. Actualizar nombre y estado de la mascota a sold
    Given path 'pet'
    And request { id: '#(miMascotaId)', name: 'Bruno Editado', status: 'sold' }
    When method put
    Then status 200
    And match response.status == 'sold'

  Scenario: 4. Consultar mascotas filtrando por estado sold
    Given path 'pet', 'findByStatus'
    And param status = 'sold'
    When method get
    Then status 200
    And match response[*].id contains miMascotaId