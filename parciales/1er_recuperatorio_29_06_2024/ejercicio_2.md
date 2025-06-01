# Ejercicio 2 - Refactoring

Ejercicio: 
```java
public class Pago {
	private List<Producto> productos;
	private String tipo;
	private static final double ADICIONAL_TARJETA = 1000.0;
	private static final double DESCUENTO_EFECTIVO = 2000.0;
	
	public Pago(String tipo, List<Producto> productos){
		this.productos = productos;
		this.tipo = tipo;
	}

	public double calcularMontoFinal(){
		double total = 0.0;
		if(this.tipo == "EFECTIVO"){
			for(Producto producto: this.productos){
				total = total + producto.getPrecio() + (producto.getPrecio*producto.getIVA())
			}
			if(total > 100000){
				total = total - DESCUENTO_EFECTIVO
			}
		}else if (this.tipo == "TARJETA"){
			for(Producto producto: this.productos){
				total = total + producto.getPrecio() + (producto.getPrecio*producto.getIVA())
			}
			total = total + ADICIONAL_TARJETA;
		}
		return total;
	}
}

public class Producto {
	private double precio;
	private double IVA;

	public Producto(double Precio, double IVA){
		this.precio = precio;
		this.IVA = IVA
	}

	public double getPrecio(){
		return this.precio;
	}

	public double getIVA(){
		return this.IVA;
	}
}
```

## Resolución
1. **Feature Envy**: el primer bad smell que se identifica es la no correspondencia de calcular el monto final de un producto. Por lo tanto, se aplica *Move Method*, para mover esta lógica a la clase `Producto`.
	* Identificamos que la sección `producto.getPrecio() + (producto.getPrecio*producto.getIVA())` se podría hacer dentro de `Producto`
    * Creamos el método `calcularMontoFinal` dentro de `Producto`, ejecutando esa lógica:
		```java
		//Dentro de Producto
		public double calcularMontoFinal(){return 0;}
		```
  	* Copiamos y pegamos el código dentro de dicho método:
	  ```java
	  //Dentro de Producto
	  public double calcularMontoFinal(){
    	return this.precio + (this.precio * this.IVA);
	  } 
	  ```
    * Compilamos 
    * Reemplazamos cada lugar del código original con la llamada al nuevo método:
      ```java
      //Dentro de Pago
      public double calcularMontoFinal(){
        double total = 0.0;
        if(this.tipo == "EFECTIVO"){
          for(Producto producto: this.productos){
              total = total + producto.calcularMontoFinal();
          }
          if(total > 100000){
            total = total - DESCUENTO_EFECTIVO;
          }
    	   }else if (this.tipo == "TARJETA"){
    	     for(Producto producto: this.productos){
                  total = total + producto.calcularMontoFinal();
              }
              total = total + ADICIONAL_TARJETA;
          }
          return total;
      }
      ```
    * Compilar y testear
2. **Duplicated Code**: Podemos observar que el código  que se encarga de calcular el total en `Pago.calcularMontoFinal` se repita para ambos tipos de pago. En este caso, podemos aplicar *Replace Temp with Query*, para eliminar la doble iteración (además, realiza un duplicated code).
	* Extraemos la variable temporal a un método:
	  ```java
      // Dentro de Pago
      public double calcularTotal(){return this.productos.stream().mapToDouble(p->p.calcularMontoFinal()).sum();}
      ```
    * Reemplazamos las referencias en la expresión.
    * Se elimina la declaración y sus asignaciones:
	  ```java
      //Dentro de Pago
      public double calcularMontoFinal(){
        double total = this.calcularTotal();
        if(this.tipo == "EFECTIVO"){
          if(total > 100000){
            total = total - DESCUENTO_EFECTIVO;
          }
        }else if (this.tipo == "TARJETA"){
              total = total + ADICIONAL_TARJETA;
          }
          return total;
      }
      ```
    * Compilar y testear.
3. **Switch Statements**: como podemos ver, tenemos un if, que dependiendo un string (tipo de pago), hace una u otra cosa. No es algo escalable, por lo que aplicamos *Replace Conditional with Polimorfism* para solucionar esto:
	* Creamos la jerarquía, a partir de una clase padre `TipoPago`.
   	  ```java
      public abstract class TipoPago{
      	public abstract double calcularMonto(double total);
      }
      ```
    * Reemplazamos los tipos correspondientes dentro de la clase que invoca o utiliza dicha variable:
   	  ```java
      //Dentro de Pago
      private TipoPago tipo;
      public Pago(TipoPago tipo, List<Producto> productos){
          this.productos = productos;
          this.tipo = tipo;
      }
      ```
    * Por cada variante, se crea una subclase que redefina el método abstracto de `TipoPago`:
      ```java
      public class Efectivo extends TipoPago {
        public double calcularMonto(double total){
          return 0; 
        }
      }
      public class Tarjeta extends TipoPago {
        public double calcularMonto(double total){
          return 0; 
        }
      }
      ```
    * Se copia el método correspondiente del condicional a cada subclase:
	  ```java
	  public class Efectivo extends TipoPago {
	    public double calcularMonto(double total){
	      return (total > 10000) ? total - 1000 : total;
	    }
	  }
	  public class Tarjeta extends TipoPago {
	    public double calcularMonto(double total){
	      return total + 2000;
	    }
	  }
	  ```
   * Se borra de la clase `Pago` lo correspondiente a la lógica que se movio:
	 ```java
	 //Dentro de Pago
	 public double calcularMontoFinal(){
	   double total = this.calcularTotal();
	   return tipo.calcularMonto(total);
	 }
	  ```
   * Compilar y testear