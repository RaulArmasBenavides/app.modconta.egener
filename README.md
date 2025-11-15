# java1

java apps

# Sistema de Gestión de Equipos y Empleados (Java Desktop)

Aplicación de escritorio desarrollada en **Java** para la gestión básica de recursos de TI de una organización: **empleados**, **marcas**, **modelos** y **equipos**.  
El sistema utiliza una arquitectura simple basada en DAOs y una base de datos **SQL Server**.

---

## Características principales

- Módulo de **Empleados**:
  - Registro y actualización de empleados (nombre, apellidos, DNI, teléfono, dirección, contrato, etc.).
  - Listado y búsqueda por nombre.

- Módulo de **Marcas y Modelos**:
  - Registro de marcas de equipos (por ejemplo: Lenovo, HP, Dell).
  - Registro de modelos asociados a una marca.
  - Relación 1:N entre **Marca → Modelos**.

- Módulo de **Equipos**:
  - Registro de equipos de cómputo:
    - Nombre del equipo
    - Sistema operativo
    - Procesador
    - RAM
    - Tarjeta madre
    - Stock, stock mínimo y máximo
    - Asociación a un **Modelo** (y por ende a una **Marca**).
  - Actualización de equipos existentes.

- Persistencia en **SQL Server** usando JDBC:
  - Clase `dbBean` para manejo de conexión.
  - DAOs (`EmpleadoDAO`, `EquipoDAO`, etc.) para operaciones CRUD.

---

## Tecnologías utilizadas

- **Lenguaje**: Java (versión 8+ recomendada)
- **Interfaz gráfica**: Swing (formularios, botones, tablas, etc.)
- **Base de datos**: Microsoft SQL Server
- **Conectividad**: JDBC con el driver `com.microsoft.sqlserver.jdbc.SQLServerDriver`
- **IDE recomendado**: NetBeans o IntelliJ IDEA (proyecto clásico de escritorio)

---

## Estructura general del proyecto

Ejemplo de paquetes (puede variar según tu estructura real):

```text
src/
├─ app.modconta.database/
│  └─ dbBean.java                // Manejo de conexión JDBC
│
├─ app.modconta.entity/
│  ├─ Empleado.java
│  ├─ Marca.java
│  ├─ Modelo.java
│  └─ Equipo.java
│
├─ app.modconta.dao/
│  ├─ EmpleadoDAO.java           // CRUD Empleado
│  ├─ EquipoDAO.java             // CRUD Equipo
│  ├─ MarcaDAO.java              // CRUD Marca
│  └─ ModeloDAO.java             // CRUD Modelo
│
└─ app.modconta.ui/
   ├─ FrmEmpleado.java           // Formulario de mantenimiento de empleados
   ├─ FrmEquipo.java             // Formulario de mantenimiento de equipos
   ├─ FrmMarca.java              // Formulario de marcas
   ├─ FrmModelo.java             // Formulario de modelos
   └─ MainApp.java               // Punto de entrada de la aplicación


Test with  

RMB       	test123 

