package oo2.ejercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DatabaseProxyTest {
    private DatabaseAccess database;
    private DatabaseAccessProxy proxy;

    @BeforeEach
    public void setUp() throws Exception {
        this.database = new DatabaseRealAccess();
        this.proxy = new DatabaseAccessProxy(database);
    }

    @Test
    void testGetSearchResults() {
        proxy.logIn();
        assertEquals(Arrays.asList("Spiderman", "Marvel"), this.proxy.getSearchResults("select * from comics where id=1"));
        assertEquals(Collections.emptyList(), this.proxy.getSearchResults("select * from comics where id=10"));

        proxy.logOut();
        Exception exceptionAuth =  assertThrows(RuntimeException.class, () -> this.proxy.getSearchResults("select * from comics where id=1"));
        assertEquals("Not authenticated", exceptionAuth.getMessage());
    }

    @Test
    void testInsertNewRow() {
        proxy.logIn();
        assertEquals(3, this.proxy.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
        assertEquals(Arrays.asList("Patoruzú", "La flor"), this.proxy.getSearchResults("select * from comics where id=3"));

        proxy.logOut();
        Exception exceptionAuth =  assertThrows(RuntimeException.class, () -> this.proxy.insertNewRow(Arrays.asList("Superman", "DC Comics")));
        assertEquals("Not authenticated", exceptionAuth.getMessage());
    }
}
