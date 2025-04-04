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

___

## Ejercicio 2.2: Juego

```java
    public class Juego {
        // ......
        public void incrementar(Jugador j) {
            j.puntuacion = j.puntuacion + 100;
        }
        public void decrementar(Jugador j) {
            j.puntuacion = j.puntuacion - 50;
        }
    }

    public class Jugador {
        public String nombre;
        public String apellido;
        public int puntuacion = 0;
    }
```

* **Romper la encapsulación:** la clase `Jugador` posee atributos públicos, esto provoca que se este violando el principio de encapsulamiento. La solución que se presenta es proteger dichos atributos, utilizando `Encapsulate Fields`, proveyendo los getters correspondientes.
  ```java
  public class Jugador {
      private String nombre;
      private String apellido;
      private int puntuacion = 0;

      public String getNombre(){
          return this.nombre;
      }

      public String getApellido(){
          return this.apellido;
      }

      public int getPuntuacion(){
          return this.puntuacion;
      }
          
  }
  ```
* **Nombres poco descriptivos**: en la clase `Juego`, los nombres de los metodos `incrementar` y `decrementar` son pocos descriptivos para su objetivo. La solución es aplicar `Rename Method`:
  ```java
    public class Juego {
        // ......
        public void incrementarPuntuacion(Jugador j) {
            j.puntuacion = j.puntuacion + 100;
        }
        public void decrementarPuntuacion(Jugador j) {
            j.puntuacion = j.puntuacion - 50;
        }
    }
  ```
* **Feature Envy**: los metodos `incrementarPuntuacion` y `decrementarPuntuacion` dentro de la clase `Juego` ejecutan lógica que le tendría que corresponder a `Jugador`, por lo que la solución sería aplicar `Move Method`
  ```java
      public class Juego {
          // ......
          public void incrementarPuntuacion(Jugador j) {
              j.incrementarPuntuacion();
          }
  
          public void decrementarPuntuacion(Jugador j) {
              j.decrementarPuntuacion();
          }
      }

      public class Jugador {
          private String nombre;
          private String apellido;
          private int puntuacion = 0;

          public String getNombre(){
              return this.nombre;
          }

          public String getApellido(){
              return this.apellido;
          }    

          public int getPuntuacion(){
              return this.puntuacion;
          }

          public void incrementarPuntuacion(){
              this.puntuacion = this.puntuacion + 100;
          }

          public void decrementarPuntuacion(){
              this.puntuacion = this.puntuacion - 50;
          }
      }
  ```

  ___

  ## Ejercicio 2.3: Publicaciones

  ```java
  /**
  * Retorna los últimos N posts que no pertenecen al usuario user
  */
  public List<Post> ultimosPosts(Usuario user, int cantidad) {
      
      List<Post> postsOtrosUsuarios = new ArrayList<Post>();
        for (Post post : this.posts) {
            if (!post.getUsuario().equals(user)) {
                postsOtrosUsuarios.add(post);
            }
        }
            
       // ordena los posts por fecha
       for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
           int masNuevo = i;
           for(int j= i +1; j < postsOtrosUsuarios.size(); j++) {
               if (postsOtrosUsuarios.get(j).getFecha().isAfter(
         postsOtrosUsuarios.get(masNuevo).getFecha())) {
                  masNuevo = j;
               }    
           }
          Post unPost = postsOtrosUsuarios.set(i,postsOtrosUsuarios.get(masNuevo));
          postsOtrosUsuarios.set(masNuevo, unPost);    
       }
            
        List<Post> ultimosPosts = new ArrayList<Post>();
        int index = 0;
        Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
        while (postIterator.hasNext() &&  index < cantidad) {
            ultimosPosts.add(postIterator.next());
        }
        return ultimosPosts;
    }

  ```

* **Long Method**: el método realiza muchas cosas, por lo que se podría separar la lógica en distintos métodos. Por eso, se podría solucionar utilizando `Extract Method`.
  ```java
      /**
      * Retorna los últimos N posts que no pertenecen al usuario user
      */
      public List<Post> ultimosPosts(Usuario user, int cantidad) {
          List<Post> postsOtrosUsuarios = new ArrayList<Post>();
          this.getPostsOtrosUsuarios(postOtrosUsuarios, user);
                
          this.ordenarPosts(postOtrosUsuarios);
                
          List<Post> ultimosPosts = new ArrayList<Post>();
          this.filtrarUltimosNPosts(ultimosPosts, postOtrosUsuarios, cantidad);

          return ultimosPosts;
      }

      private void getPostsOtrosUsuarios(List<Post> postOtrosUsuarios, Usuario user){
          for (Post post : this.posts) {
                  if (!post.getUsuario().equals(user)) {
                      postsOtrosUsuarios.add(post);
                  }
              }
      }

      /**
      * Ordena los posts por fecha
      */
      private void ordenarPosts(List<Post> postsOtrosUsuarios){
          for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
              int masNuevo = i;
              for(int j= i +1; j < postsOtrosUsuarios.size(); j++) {
                  if (postsOtrosUsuarios.get(j).getFecha().isAfter(
                      postsOtrosUsuarios.get(masNuevo).getFecha())) {
                      masNuevo = j;
                   }    
              }
              Post unPost = postsOtrosUsuarios.set(i,postsOtrosUsuarios.get(masNuevo));
              postsOtrosUsuarios.set(masNuevo, unPost);    
          }
      }

      private void filtarUltimosNPosts(List<Post> ultimosPosts, List<Post> postOtrosUsuarios, int cantidad){
          int index = 0;
          Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
          while (postIterator.hasNext() &&  index < cantidad) {
              ultimosPosts.add(postIterator.next());
          }
      }
  ```

* **Long Method**: el method `ultimosPosts` todavía sigue siendo largo, y se puede simplificar todavía más, esto se puede lograr removiendo las variables temporales utilizando `Remove Temp with Query`
  ```java
      /**
      * Retorna los últimos N posts que no pertenecen al usuario user
      */
      public List<Post> ultimosPosts(Usuario user, int cantidad) {
          List<Post> postsOtrosUsuarios = this.getPostsOtrosUsuarios(user);
                
          this.ordenarPosts(postOtrosUsuarios);

          return this.filtrarUltimosNPosts(ultimosPosts, postOtrosUsuarios, cantidad);;
      }

      private void getPostsOtrosUsuarios(Usuario user){
          List<Post> postOtrosUsuarios = new ArrayList<Post>();
          for (Post post : this.posts) {
                  if (!post.getUsuario().equals(user)) {
                      postsOtrosUsuarios.add(post);
                  }
              }
          return postOtrosUsuarios;
      }

      /**
      * Ordena los posts por fecha
      */
      private void ordenarPosts(List<Post> postsOtrosUsuarios){
          for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
              int masNuevo = i;
              for(int j= i +1; j < postsOtrosUsuarios.size(); j++) {
                  if (postsOtrosUsuarios.get(j).getFecha().isAfter(
                      postsOtrosUsuarios.get(masNuevo).getFecha())) {
                      masNuevo = j;
                   }    
              }
              Post unPost = postsOtrosUsuarios.set(i,postsOtrosUsuarios.get(masNuevo));
              postsOtrosUsuarios.set(masNuevo, unPost);    
          }
      }

      private void filtarUltimosNPosts(List<Post> postOtrosUsuarios, int cantidad){
          List<Post> ultimosPosts = new ArrayList<Post>();
          int index = 0;
          Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
          while (postIterator.hasNext() &&  index < cantidad) {
              ultimosPosts.add(postIterator.next());
          }

          return ultimosPosts;
      }
  ```

* **Reinventando la rueda**: los métodos `getPostsOtrosUsuarios`, `ordenarPosts` y `filtarUltimosNPosts` utilizan bucles cuando se podría resolver la lógica compleja por medio de la API `Stream`. Esto se soluciona utilizando `Replace Loop with Pipeline` en cada método correspondiente.
  ```java
      /**
      * Retorna los últimos N posts que no pertenecen al usuario user
      */
      public List<Post> ultimosPosts(Usuario user, int cantidad) {
          // Se podría aplicar refactor aca tambien?
          List<Post> postsOtrosUsuarios = this.getPostsOtrosUsuarios(user);
                
          this.ordenarPosts(postOtrosUsuarios);

          return this.filtrarUltimosNPosts(ultimosPosts, postOtrosUsuarios, cantidad);;
      }

      private void getPostsOtrosUsuarios(Usuario user){
          return this.posts.stream().filter(post -> !post.getUsuario().equals(user)).collect(Collectors.toList());
      }

      /**
      * Ordena los posts por fecha
      */
      private void ordenarPosts(List<Post> postsOtrosUsuarios){
          postsOtrosUsuarios.stream().sorted((post1, post2) -> post1.getFecha().compare(post2.getFecha())).collect(Collectors.toList());
      }

      private void filtarUltimosNPosts(List<Post> postOtrosUsuarios, int cantidad){
          return postOtrosUsuarios.stream().limit(cantidad).collect(Collectors.toList());
      }
  ```
