package oo2.ejercicio2;

import java.util.Collection;
import java.util.List;

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


    @Override
    public Collection<String> getSearchResults(String queryString) {
        if(!this.isAuthenticated){
            throw new RuntimeException("Not authenticated");
        }
        return this.db.getSearchResults(queryString);
    }

    @Override
    public int insertNewRow(List<String> rowData) {
        if(!this.isAuthenticated){
            throw new RuntimeException("Not authenticated");
        }
        return this.db.insertNewRow(rowData);
    }
}
