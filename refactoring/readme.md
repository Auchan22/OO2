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

</details>
