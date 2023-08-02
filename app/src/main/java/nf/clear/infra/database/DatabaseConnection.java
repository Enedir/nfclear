package nf.clear.infra.database;


public interface DatabaseConnection<T> {
    
    T createContext() throws Exception;

}
