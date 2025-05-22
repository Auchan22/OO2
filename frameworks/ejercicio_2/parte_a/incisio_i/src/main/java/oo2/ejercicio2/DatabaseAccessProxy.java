package oo2.ejercicio2;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public class DatabaseAccessProxy implements DatabaseAccess {
    private DatabaseAccess db;
    private static final Logger logger = Logger.getLogger(DatabaseAccessProxy.class.getName());
    private boolean isAuthenticated;

    public DatabaseAccessProxy(DatabaseAccess db) {
        this.db = db;
        this.isAuthenticated = false;
    }

    public void logIn(){
        this.isAuthenticated = true;
    }

    public void logOut() {
        this.isAuthenticated = false;
    }


    @Override
    public Collection<String> getSearchResults(String queryString) {
        if(!this.isAuthenticated){
            logger.severe("You are not authenticated");
            throw new RuntimeException("Not authenticated");
        }
        logger.info("Searching for " + queryString);
        return this.db.getSearchResults(queryString);
    }

    @Override
    public int insertNewRow(List<String> rowData) {
        if(!this.isAuthenticated){
            logger.severe("You are not authenticated");
            throw new RuntimeException("Not authenticated");
        }
        logger.warning("Inserting " + rowData.size() + " rows");
        return this.db.insertNewRow(rowData);
    }
}
