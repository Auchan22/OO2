package oo2.ejercicio2;

import oo2.ejercicio2.logger.fomatter.JSONFormatter;
import oo2.ejercicio2.logger.fomatter.ShoutingSimpleFormatter;
import oo2.ejercicio2.logger.handler.FilterHandler;
import oo2.ejercicio2.logger.handler.JSONHandler;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DatabaseProxyTest {
    private DatabaseAccess database;
    private DatabaseAccessProxy proxy;
    private static final Logger logger = Logger.getLogger("db");

    @BeforeAll
    public static void configLogger() {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.INFO);
        Handler jsonHandler;

        try {
            jsonHandler = new FileHandler("logs/myLogs.json");
            jsonHandler.setFormatter(new JSONFormatter());
            Logger.getLogger("db").addHandler(jsonHandler);
        } catch (IOException e) {
            System.out.println(e);
        }

        Handler normalHandler = new ConsoleHandler();
        normalHandler.setFormatter(new ShoutingSimpleFormatter());
        Logger.getLogger("db").addHandler(normalHandler);

        List<String> wordsToHide = new ArrayList<String>();
        wordsToHide.add("from");
        Handler filterHandler = new FilterHandler(new ConsoleHandler(), wordsToHide);
        Logger.getLogger("db").addHandler(filterHandler);
    }

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
