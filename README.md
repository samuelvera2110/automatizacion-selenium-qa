# Automatización E2E — Selenium, TestNG, Cucumber

**Samuel Vera · 2026**

Proyecto Maven (`prueba-qa`) de pruebas end-to-end sobre **Selenium WebDriver 4**, **TestNG**, **Cucumber** y reportes **ExtentReports**. La gestión del **ChromeDriver** la resuelve **WebDriverManager** (Boni García).

---

## Aplicaciones bajo prueba

| Aplicación | URL usada en código | Casos cubiertos (resumen) |
|------------|---------------------|---------------------------|
| **ParaBank** | [parabank.parasoft.com](https://parabank.parasoft.com/parabank/index.htm) | Registro, login, transferencia entre cuentas, pago de facturas |
| **OpenCart** | [opencart.abstracta.us](http://opencart.abstracta.us/index.php?route=common/home) | Carrito, checkout invitado, confirmación de pedido |

> OpenCart se navega con **HTTP** en `BaseTest`; ParaBank con **HTTPS**.

---

## Requisitos

1. **JDK 17+** — `java -version`  
   [Descargas JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
2. **Apache Maven 3.9+** — `mvn -version`  
   [Descargar Maven](https://maven.apache.org/download.cgi)
3. **Google Chrome** (reciente). El driver se alinea automáticamente vía WebDriverManager.
4. **Internet** activa (los SUT son sitios públicos).
5. **JAVA_HOME** y **Maven en el PATH**.

---

## Tecnologías principales

- Java 17, Selenium 4.21, TestNG 7.10, Cucumber 7.15  
- WebDriverManager 5.8  
- ExtentReports 5.1 (listener TestNG + capturas en pass/fail)  
- Patrón **Page Object** con `BasePage` común (`com.example.pages.BasePage`)

---

## Estructura del código

```
src/main/java/com/example/
├── driver/          # DriverManager (ThreadLocal), ChromeDriverFactory, opciones
├── pages/           # POM: BasePage + subpaquetes opencart/ y parabank/
└── utils/           # DataGenerator, etc.

src/test/java/com/example/
├── opencart/        # Tests TestNG + runner/ + steps/ (Cucumber)
├── parabank/        # Tests TestNG + runner/ + steps/ (Cucumber)
└── report/          # ExtentReports, listener, capturas

src/test/resources/features/
├── opencart/        # .feature OpenCart
└── parabank/      # .feature ParaBank
```

Los escenarios **Gherkin** y los *step definitions* (`io.cucumber.java.es`) están en **español**.

---

## Cómo ejecutar

Desde la raíz del repositorio:

```bash
cd automatizacion-selenium-qa
mvn compile test-compile
```

### Suites TestNG (`suiteFile` en `pom.xml`)

La propiedad Maven **`suiteFile`** apunta al XML de TestNG (por defecto `testng.xml`).

| Comando | Contenido |
|---------|-----------|
| `mvn clean test` | **`testng.xml`**: pruebas **TestNG solo OpenCart** (4 clases). |
| `mvn clean test "-DsuiteFile=testng-parabank.xml"` | Pruebas **TestNG solo ParaBank** (registro, login, transferencia, retiro). |
| `mvn clean test "-DsuiteFile=testng-bdd.xml"` | **Cucumber**: runners **OpenCart** y **ParaBank** (`.feature`). |

**Windows (PowerShell):** las comillas alrededor de `-DsuiteFile=...` son importantes.

### Clonar el repositorio

```bash
git clone <url-del-repositorio>
cd automatizacion-selenium-qa
```

---

## Reportes

Tras una ejecución con el **ExtentTestListener** activo en la suite, los HTML se generan en:

`target/extent-reports/`

Cada corrida puede crear un informe con marca de tiempo. La carpeta **`target/`** está ignorada por Git (véase `.gitignore`).

---

## Documentación adicional

- **`conclusiones.txt`**: decisiones de diseño, hallazgos y mejoras propuestas (assessment).

---

## Notas

- Los entornos de demostración son **compartidos e inestables**; conviene re-ejecutar ante fallos intermitentes.
- Los usuarios de prueba en ParaBank se generan de forma **dinámica** (`DataGenerator`) para evitar colisiones.
