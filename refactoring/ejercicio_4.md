# Ejercicio 4

```java
public class Pedido {
  private Cliente cliente;
  private List<Producto> productos;
  private String formaPago;
  public Pedido(Cliente cliente, List<Producto> productos, String formaPago) {
     if (!"efectivo".equals(formaPago)
        && !"6 cuotas".equals(formaPago)
        && !"12 cuotas".equals(formaPago)) {
          throw new Error("Forma de pago incorrecta");
    }
    this.cliente = cliente;
    this.productos = productos;
    this.formaPago = formaPago;
   }
   public double getCostoTotal() {
     double costoProductos = 0;
     for (Producto producto : this.productos) {
       costoProductos += producto.getPrecio();
     }
     double extraFormaPago = 0;
     if ("efectivo".equals(this.formaPago)) {
       extraFormaPago = 0;
     } else if ("6 cuotas".equals(this.formaPago)) {
       extraFormaPago = costoProductos * 0.2;
     } else if ("12 cuotas".equals(this.formaPago)) {
       extraFormaPago = costoProductos * 0.5;
     }
     int añosDesdeFechaAlta = Period.between(this.cliente.getFechaAlta(), LocalDate.now()).getYears();
     // Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad
     if (añosDesdeFechaAlta > 5) {
       return (costoProductos + extraFormaPago) * 0.9;
     }
     return costoProductos + extraFormaPago;
   }
 }
 public class Cliente {
   private LocalDate fechaAlta;
   public LocalDate getFechaAlta() {
     return this.fechaAlta;
   }
 }
 public class Producto {
   private double precio;
   public double getPrecio() {
     return this.precio;
   }
 }
```

1. **Replace Loop with Pipeline (líneas 16 a 19)**
```java
public class Pedido {
  private Cliente cliente;
  private List<Producto> productos;
  private String formaPago;
  public Pedido(Cliente cliente, List<Producto> productos, String formaPago) {
     if (!"efectivo".equals(formaPago)
        && !"6 cuotas".equals(formaPago)
        && !"12 cuotas".equals(formaPago)) {
          throw new Error("Forma de pago incorrecta");
    }
    this.cliente = cliente;
    this.productos = productos;
    this.formaPago = formaPago;
   }
   public double getCostoTotal() {
     double costoProductos = this.productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
     double extraFormaPago = 0;
     if ("efectivo".equals(this.formaPago)) {
       extraFormaPago = 0;
     } else if ("6 cuotas".equals(this.formaPago)) {
       extraFormaPago = costoProductos * 0.2;
     } else if ("12 cuotas".equals(this.formaPago)) {
       extraFormaPago = costoProductos * 0.5;
     }
     int añosDesdeFechaAlta = Period.between(this.cliente.getFechaAlta(), LocalDate.now()).getYears();
     // Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad
     if (añosDesdeFechaAlta > 5) {
       return (costoProductos + extraFormaPago) * 0.9;
     }
     return costoProductos + extraFormaPago;
   }
 }
 public class Cliente {
   private LocalDate fechaAlta;
   public LocalDate getFechaAlta() {
     return this.fechaAlta;
   }
 }
 public class Producto {
   private double precio;
   public double getPrecio() {
     return this.precio;
   }
 }
```

2. **Replace Conditional with Polymorphism (líneas 21 a 27)**
```java
public class Pedido {
  private Cliente cliente;
  private List<Producto> productos;
  private FormaPago formaPago;
  public Pedido(Cliente cliente, List<Producto> productos, FormaPago formaPago) {
    this.cliente = cliente;
    this.productos = productos;
    this.formaPago = formaPago;
   }
   public double getCostoTotal() {
     double costoProductos = this.productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
     double extraFormaPago = this.formaPago.calcularExtra(costoProductos);
     int añosDesdeFechaAlta = Period.between(this.cliente.getFechaAlta(), LocalDate.now()).getYears();
     // Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad
     if (añosDesdeFechaAlta > 5) {
       return (costoProductos + extraFormaPago) * 0.9;
     }
     return costoProductos + extraFormaPago;
   }
 }
 public interface FormaPago {
   public double calcularExtra(double costoProductos);
 }
 public class Efectivo implements FormaPago {
   public double calcularExtra(double costoProductos){
     return 0;
   }
 }
 public class 6Cuotas implements FormaPago {
   public double calcularExtra(double costoProductos){
     return costoProductos * 0.2;
   }
 }
 public class 12Cuotas implements FormaPago {
   public double calcularExtra(double costoProductos){
     return costoProductos * 0.5;
   }
 }
 public class Cliente {
   private LocalDate fechaAlta;
   public LocalDate getFechaAlta() {
     return this.fechaAlta;
   }
 }
 public class Producto {
   private double precio;
   public double getPrecio() {
     return this.precio;
   }
 }
```

3. **Extract method y move method (línea 28)**
```java
public class Pedido {
  private Cliente cliente;
  private List<Producto> productos;
  private FormaPago formaPago;
  public Pedido(Cliente cliente, List<Producto> productos, FormaPago formaPago) {
    this.cliente = cliente;
    this.productos = productos;
    this.formaPago = formaPago;
   }
   public double getCostoTotal() {
     double costoProductos = this.productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
     double extraFormaPago = this.formaPago.calcularExtra(costoProductos);
     int añosDesdeFechaAlta = this.cliente.calcularAntiguedad();
     // Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad
     if (añosDesdeFechaAlta > 5) {
       return (costoProductos + extraFormaPago) * 0.9;
     }
     return costoProductos + extraFormaPago;
   }
 }
 public interface FormaPago {
   public double calcularExtra(double costoProductos);
 }
 public class Efectivo implements FormaPago {
   public double calcularExtra(double costoProductos){
     return 0;
   }
 }
 public class 6Cuotas implements FormaPago {
   public double calcularExtra(double costoProductos){
     return costoProductos * 0.2;
   }
 }
 public class 12Cuotas implements FormaPago {
   public double calcularExtra(double costoProductos){
     return costoProductos * 0.5;
   }
 }
 public class Cliente {
   private LocalDate fechaAlta;
   public LocalDate getFechaAlta() {
     return this.fechaAlta;
   }
   public int calcularAntiguedad() {
     return Period.between(this.fechaAlta, LocalDate.now()).getYears(); 
   }
 }
 public class Producto {
   private double precio;
   public double getPrecio() {
     return this.precio;
   }
 }
```
4. **Extract method y replace temp with query (líneas 28 a 33)**
```java
public class Pedido {
  private Cliente cliente;
  private List<Producto> productos;
  private FormaPago formaPago;
  public Pedido(Cliente cliente, List<Producto> productos, FormaPago formaPago) {
    this.cliente = cliente;
    this.productos = productos;
    this.formaPago = formaPago;
   }
   public double getCostoTotal() {
     double costoProductos = this.productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
     double extraFormaPago = this.formaPago.calcularExtra(costoProductos);
     return this.calcularDescuento(costoProductos, estraFormaPago);
   }
   private double calcularDescuento(double costoProductos, double extraFormaPago) {
     // Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad
     if (this.cliente.calcularAntiguedad() > 5) {
       return (costoProductos + extraFormaPago) * 0.9;
     }
     return costoProductos + extraFormaPago;
   }
 }
 public interface FormaPago {
   public double calcularExtra(double costoProductos);
 }
 public class Efectivo implements FormaPago {
   public double calcularExtra(double costoProductos){
     return 0;
   }
 }
 public class 6Cuotas implements FormaPago {
   public double calcularExtra(double costoProductos){
     return costoProductos * 0.2;
   }
 }
 public class 12Cuotas implements FormaPago {
   public double calcularExtra(double costoProductos){
     return costoProductos * 0.5;
   }
 }
 public class Cliente {
   private LocalDate fechaAlta;
   public LocalDate getFechaAlta() {
     return this.fechaAlta;
   }
   public int calcularAntiguedad() {
     return Period.between(this.fechaAlta, LocalDate.now()).getYears(); 
   }
 }
 public class Producto {
   private double precio;
   public double getPrecio() {
     return this.precio;
   }
 }
```
