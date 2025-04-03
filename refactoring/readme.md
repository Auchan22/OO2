# Ejercicios Refactoring

<details>
<summary>Ejercicio 1: Algo huele mal</summary>

### 1.1 Protocolo de Cliente
  ```java
  /** 
  * Retorna el límite de crédito del cliente
  */
  public double lmtCrdt() {...
  
  /** 
  * Retorna el monto facturado al cliente desde la fecha f1 a la fecha f2
  */
  protected double mtFcE(LocalDate f1, LocalDate f2) {...
  
  /** 
  * Retorna el monto cobrado al cliente desde la fecha f1 a la fecha f2
  */
  private double mtCbE(LocalDate f1, LocalDate f2) {...

  ```

  En base al código propuesto, identifico los siguientes **Bad Smells**:
  * **Nombres poco explicativo:** los metodos presentados cuentan con nombres poco descriptivos.
    Su solución es aplicar `Rename Method`, logrando nombres más claros.
    ```java
    public double getLimiteCredito(){...}
    protected double getMontoFacturadoEntre(LocalDate f1, LocalDate f2){...}
    private double getMontoCobradoEntre(LocalDate f1, LocalDate f2){...}
    ```
  * **Parámetros poco explicativos:** los nombres de los parámetros son poco explicativos, no definen el propósito. Su solución es **renombrarlos**, así dandole un mejor nombre:
    ```java
    protected double getMontoFacturadoEntre(LocalDate fechaInicio, LocalDate fechaFin){...}
    private double getMontoCobradoEntre(LocalDate fechaInicio, LocalDate fechaFin){...}
    ```
___

### 1.2 Participación en proyectos

Dentro del ejemplo propuesto, se puede ver que el Bad Smell presente es el **Feature Envy**. Esto se debe a que la clase `Persona` usa datos de `Proyecto` para poder evaluar si dicha persona existe o no en un proyecto, produciendo un código reiterativo.
Esto se soluciona si el análisis lo hacemos desde `Proyecto`, dado que no hace falta pasar el proyecto para evaluar.
En conclusión, esta bien aplicado el refactoring.

___

### 1.3 Cálculos

```java
public void imprimirValores() {
  int totalEdades = 0;
  double promedioEdades = 0;
  double totalSalarios = 0;

  for (Empleado empleado : personal) {
    totalEdades = totalEdades + empleado.getEdad();
    totalSalarios = totalSalarios + empleado.getSalario();
  }

  promedioEdades = totalEdades / personal.size();
  String message = String.format("El promedio de las edades es %s y el total de
salarios es %s", promedioEdades, totalSalarios);

  System.out.println(message);
}
```

El siguiente código propuesto presenta los siguientes bad smells:
* **Long Method**: el método posee declaraciones de variables innecesarias, que se podrían ahorrar usando la API `Stream` de las Collections.

El código corregido sería el siguiente:

```java
public void imprimirValores() {

  System.out.println("El promedio de las edades es". personal.stream().mapToDouble(empleado->empleado.getEdad().average().orElse(0) ." y el total de salarios es ". personal.stream().mapToDouble(empleado->empleado.getSalario()).sum());
}
```

</details>
