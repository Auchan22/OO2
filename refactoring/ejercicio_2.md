# Ejercicio 2

## Ejercicio 2.1: Empleados

```java
    public class EmpleadoTemporario {
        public String nombre;
        public String apellido;
        public double sueldoBasico = 0;
        public double horasTrabajadas = 0;
        public int cantidadHijos = 0;
        // ......
        
        public double sueldo() {
        return this.sueldoBasico
        + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) 
        - (this.sueldoBasico * 0.13);
        }
    }
    
    
    public class EmpleadoPlanta {
        public String nombre;
        public String apellido;
        public double sueldoBasico = 0;
        public int cantidadHijos = 0;
        // ......
        
        public double sueldo() {
            return this.sueldoBasico 
            + (this.cantidadHijos * 2000)
            - (this.sueldoBasico * 0.13);
        }
    }
    
    public class EmpleadoPasante {
        public String nombre;
        public String apellido;
        public double sueldoBasico = 0;
        // ......
        
        public double sueldo() {
            return this.sueldoBasico - (this.sueldoBasico * 0.13);
        }
    }
```

### Bad Smells detectados:
* **Duplicated Code**: Podemos ver que en las clases se encuentran duplicadas ciertas propiedades, como lo son `nombre`, `apellido` y `sueldoBasico`. La solución a este problema es aplicar `Pull Up Field`, extrayendo estas variables a una clase superior, que podemos llamarle `Empleado`:
  ```java
    public abstract class Empleado {
      protected String nombre;
      protected String apellido;
      protected double sueldoBasico = 0;
    }

    public class EmpleadoTemporario extends Empleado {
        public double horasTrabajadas = 0;
        public int cantidadHijos = 0;
        // ......
        
        public double sueldo() {
        return this.sueldoBasico
        + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) 
        - (this.sueldoBasico * 0.13);
        }
    }
    
    
    public class EmpleadoPlanta extends Empleado {
        public int cantidadHijos = 0;
        // ......
        
        public double sueldo() {
            return this.sueldoBasico 
            + (this.cantidadHijos * 2000)
            - (this.sueldoBasico * 0.13);
        }
    }
    
    public class EmpleadoPasante extends Empleado {
        // ......
        
        public double sueldo() {
            return this.sueldoBasico - (this.sueldoBasico * 0.13);
        }
    }
  ```

* **Long Method**: si prestamos atención, el método `sueldo()` es un método largo, por lo que se podría extraer sus partes utilizando `Extract Method`:
  ```java
    public abstract class Empleado {
      protected String nombre;
      protected String apellido;
      protected double sueldoBasico = 0;
    }

    public class EmpleadoTemporario extends Empleado {
        public double horasTrabajadas = 0;
        public int cantidadHijos = 0;
        // ......
        
        public double sueldo() {
          return this.sueldoConDescuento() + this.aportes() + this.horasTrabajadas();
        }

        private double sueldoConDescuento(){
          return this.sueldoBasico - (this.sueldoBasico * 0.13);
        }

        private double aportes(){
          return this.cantidadHijos * 1000;
        }

        private double horasTrabajadas(){
          return this.horasTrabajadas * 500;
        }
    }
    
    
    public class EmpleadoPlanta extends Empleado {
        public int cantidadHijos = 0;
        // ......
        
        public double sueldo() {
          return this.sueldoConDescuento() + this.aportes();
        }

        private double sueldoConDescuento(){
          return this.sueldoBasico - (this.sueldoBasico * 0.13);
        }

        private double aportes(){
          return this.cantidadHijos * 1000;
        }
    }
    
    public class EmpleadoPasante extends Empleado {
        // ......

        public double sueldo() {
          return this.sueldoConDescuento();
        }

        private double sueldoConDescuento(){
          return this.sueldoBasico - (this.sueldoBasico * 0.13);
        }
    }
  ```

* **Duplicated Code**: ahora, podemos ver que todas las clases cuentan con código duplicado, es decir, los métodos `sueldo()` y `sueldoConDescuento`, por lo tanto, se resolvería con `Pull Up Methods`.
  
    ```java
    
    public abstract class Empleado {
      protected String nombre;
      protected String apellido;
      protected double sueldoBasico = 0;

       public double sueldo() {
          return this.sueldoConDescuento();
        }

        private double sueldoConDescuento(){
          return this.sueldoBasico - (this.sueldoBasico * 0.13);
        }
    }

    public class EmpleadoTemporario extends Empleado {
        public double horasTrabajadas = 0;
        public int cantidadHijos = 0;
        // ......
        
        public double sueldo() {
          return super.sueldo() + this.aportes() + this.horasTrabajadas();
        }

        private double aportes(){
          return this.cantidadHijos * 1000;
        }

        private double horasTrabajadas(){
          return this.horasTrabajadas * 500;
        }
    }
    
    
    public class EmpleadoPlanta extends Empleado {
        public int cantidadHijos = 0;
        // ......
        
        public double sueldo() {
          return super.sueldo() + this.aportes();
        }

        private double aportes(){
          return this.cantidadHijos * 1000;
        }
    }
    
    public class EmpleadoPasante extends Empleado {
        // ......
    }
    ```

* **Nombre poco significativo**: el método `sueldo()` no posee un nombre significativo, por lo que se podría renombrar:

  ```java
      public abstract class Empleado {
        protected String nombre;
        protected String apellido;
        protected double sueldoBasico = 0;

       public double calcularSueldo() {
          return this.sueldoConDescuento();
        }

        private double sueldoConDescuento(){
          return this.sueldoBasico - (this.sueldoBasico * 0.13);
        }
      }

      public class EmpleadoTemporario extends Empleado {
        public double horasTrabajadas = 0;
        public int cantidadHijos = 0;
        // ......
        
        public double calcularSueldo() {
          return super.calcularSueldo() + this.aportes() + this.horasTrabajadas();
        }

        private double aportes(){
          return this.cantidadHijos * 1000;
        }

        private double horasTrabajadas(){
          return this.horasTrabajadas * 500;
        }
      }
    
    
      public class EmpleadoPlanta extends Empleado {
        public int cantidadHijos = 0;
        // ......
        
        public double calcularSueldo() {
          return super.calcularSueldo() + this.aportes();
        }

        private double aportes(){
          return this.cantidadHijos * 1000;
        }
      }
    
      public class EmpleadoPasante extends Empleado {
        // ......
      }
  ```

  * **Lazy Class**: la clase `EmpleadoPasante` es una clase que existe, pero no tiene un proposito ni lógica propia como para mantenerla. **TODO:** como se resuelve??
  * **Duplicated Code**: tanto la clase `EmpleadoPlanta` como `EmpleadoTemporario` poseen código duplicado en lo que corresponde a `aportes()`. Un refactoring posible es `Pull Up Method`, pero no considero que sea conveniente crear una clase intermedia que tenga este método para luego ser heredado.
  
* **Duplicated Code**: todas las clases hijas presentan el metodo `sueldo()`, por lo que se podría aplicar `Pull Up`, llevando 
