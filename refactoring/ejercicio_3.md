# Ejercicio 3

```java
public class Document {
  List<String> words;

  public long characterCount() {
    long count = this.words
      .stream()
      .mapToLong(w -> w.length())
      .sum();
    	return count;
	}

  public long calculateAvg() {
    long avgLength = this.words
      .stream()
      .mapToLong(w -> w.length())
      .sum() / this.words.size();
 	    return avgLength;
	}
  // Resto del código que no importa
}
```

* **Romper el encapsulamiento**: La clase `Document`, cuyo atributo es `words`, no posee una privacidad, es público. Esto se soluciona por medio de `Encapsulate Field`
```java
public class Document {
  private List<String> words;

  public long characterCount() {
    long count = this.words
      .stream()
      .mapToLong(w -> w.length())
      .sum();
    	return count;
	}

  public long calculateAvg() {
    long avgLength = this.words
      .stream()
      .mapToLong(w -> w.length())
      .sum() / this.words.size();
 	    return avgLength;
	}
  // Resto del código que no importa
}
```

* **Duplicated Code**: la primer parte del método `calculateAvg` repite el código que esta definido por `characterCount`, por lo que se puede solucionar aplicando `Extract Method`.
```java
public class Document {
  private List<String> words;

  public long characterCount() {
    long count = this.words
      .stream()
      .mapToLong(w -> w.length())
      .sum();
    	return count;
	}

  public long calculateAvg() {
    long avgLength = this.characterCount() / this.words.size();
 	    return avgLength;
	}
  // Resto del código que no importa
}
```

* **Inline Variable**: tanto `characterCount` como `calculateAvg` poseen variables temporales, que se podrían eliminar por medio de `Replace Temp with Query`.
```java
public class Document {
  private List<String> words;

  public long characterCount() {
    	return this.words
      .stream()
      .mapToLong(w -> w.length())
      .sum();
	}

  public long calculateAvg() {
 	    return this.characterCount() / this.words.size();
	}
  // Resto del código que no importa
}
```

A su vez, este código presenta los siguientes errores:
* *Error 1*: el tipo de retorno de `calculateAvg` debería ser `double`, ya que acepta decimales, mientras que `long` no estaría bien utilizado. Pero al ser refactoring, esto no se puede modificar.
* *Error 2*: la división por 0 puede ocurrir en caso que `words` este vacía, pero esto no se puede solucionar, dado que no podemos cambiar el comportamiento del código.
