Samuel Vera - Automatización E2E Serenity BDD + Cucumber + Selenium (2026)
--------------------------------------------------------------------------
DESCRIPCIÓN
-----------
Proyecto de automatización E2E con dos suites de pruebas independientes:
1. ParaBank  (https://parabank.parasoft.com)
     - Registro de usuario
     - Login
     - Transferencia de fondos entre cuentas
     - Pago de facturas

  2. OpenCart  (https://opencart.abstracta.us)
     - Agregar productos al carrito
     - Visualizar carrito
     - Checkout como invitado
     - Confirmación de compra

PRERREQUISITOS
--------------
Antes de ejecutar el proyecto, asegúrese de tener instalado:
 1. Java Development Kit (JDK) 17 o superior
     Verificar: java -version
     Descargar: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html

  2. Apache Maven 3.9 +
     Verificar: mvn -version
     Descargar: https://maven.apache.org/download.cgi?.

  3. Google Chrome (versión reciente)
     El proyecto usa WebDriverManager de Bonnie Garcia, descarga el driver instalado recientemente.

  4. Conexión a internet activa
     Las pruebas acceden a sitios en línea:
       - https://parabank.parasoft.com
       - https://opencart.abstracta.us

  5. Variables de entorno configuradas:
     - JAVA_HOME apuntando al directorio de instalación del JDK
     - Maven en el PATH del sistema


ESTRUCTURA DEL PROYECTO
------------------------
C:.
├── src/
│
│   ├── main/
│   │   └── java/
│   │       └── com/example/
│   │
│   │           ├── driver/   → Gestión de WebDriver (núcleo del framework)
│   │           │               - DriverManager: ciclo de vida del driver
│   │           │               - DriverFactory: creación de drivers (Factory Pattern)
│   │           │               - OptionsBuilder: configuración de navegadores
│   │
│   │           ├── pages/    → Implementación del patrón POM (Page Object Model)
│   │           │
│   │           │   ├── opencart/  
│   │           │   │             → Páginas de la aplicación OpenCart
│   │           │   │               (login, home, productos, etc.)
│   │           │   │
│   │           │   └── parabank/  
│   │           │                 → Páginas de la aplicación ParaBank
│   │           │                   (cuentas, transferencias, login, etc.)
│   │
│   │           └── utils/    → Clases utilitarias reutilizables
│   │                           (config, screenshots, etc.)
│
│   └── test/
│       ├── java/
│       │   └── com/example/
│       │
│       │       ├── opencart/
│       │       │
│       │       │   ├── runner/  
│       │       │   │           → Ejecutores para escenarios de ParaBank
│       │       │   │
│       │       │   └── steps/   → Steps de Cucumber para ParaBank
│       │       │
│       │       ├── parabank/
│       │       │
│       │       │   ├── runner/  → Ejecutores para escenarios de ParaBank
│       │       │   └── steps/   → Steps de Cucumber para ParaBank
│       │       │
│       │       └── report/  
│       │                   → Configuración y generación de reportes
│       │                   
│
│       └── resources/
│           └── features/
│
│               ├── opencart/  
│               │             → Archivos .feature de OpenCart
│               │
│               └── parabank/  
│                             → Features de ParaBank


INSTRUCCIONES DE EJECUCIÓN
---------------------------
PASO 1: Clonar o descomprimir el repositorio
--------------------------------------------
Opción A: Descarga el archivo .zip, descromprime en una carpeta local
Opción B: Clona el proyecto en Git con la instrucción:
          git clone <url_repositorio>

PASO 2: Navegar al directorio raíz del proyecto
------------------------------------------------
Abra una terminal (CMD, PowerShell o bash) y ejecute:
    cd "ruta/al/proyecto/automatizacion-selenium-qa"

PASO 3: Compilar el proyecto
----------------------------
    mvn compile test-compile

PASO 4: Ejecutar las pruebas
----------------------------
Opción A - Ejecutar AMBAS suites (ParaBank + OpenCart):
  mvn clean test

Opción B - Ejecutar solo la suite ParaBank:
  mvn clean test "-DsuiteFile=testng-parabank.xml"

Opción C - Ejecutar solo la suite OpenCart:
  mvn clean test "-DsuiteFile=testng-opencart.xml"

Opción D - Ejecutar archivos .feature
  mvn test "-DsuiteFile=testng-cucumber.xml"

PASO 5: Visualizar los reportes
--------------------------------
  Los reportes se generan en la carpeta target/extent-reports:
    Para los test: archivo.html
  Los reportes de los archivos .feature se generan en archivos .html por separado

  


