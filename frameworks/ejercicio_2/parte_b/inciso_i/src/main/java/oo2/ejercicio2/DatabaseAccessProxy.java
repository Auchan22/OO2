package oo2.ejercicio2;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public class DatabaseAccessProxy implements DatabaseAccess {
    private DatabaseAccess db;
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

    private void checkLog(){
        if(!this.isAuthenticated){
            Logger.getLogger("db").severe("You are not authenticated");
            throw new RuntimeException("Not authenticated");
        }
    }

    @Override
    public Collection<String> getSearchResults(String queryString) {
        this.checkLog();
        Logger.getLogger("db").info("Searching for: " + queryString);
        return this.db.getSearchResults(queryString);
    }

    @Override
    public int insertNewRow(List<String> rowData) {
        this.checkLog();
        Logger.getLogger("db").warning("Inserting " + rowData.size() + " rows");
        return this.db.insertNewRow(rowData);
    }
}
