package nf.clear.infra.database;

import java.util.Properties;

import com.dieselpoint.norm.Database;

import nf.clear.infra.commons.GradlePropertiesUtil;

public class NeonContextAdapter implements NeonConnection{

    private Database context;

    @Override
    public Database createContext() throws Exception {
        if(this.context == null){
            Properties prop = GradlePropertiesUtil.getProperties();
            this.context = new Database();
            context.setJdbcUrl(prop.getProperty("database.url"));
            context.setUser(prop.getProperty("database.user"));
            context.setPassword(prop.getProperty("database.password"));
        }
        return context;
    }    
}
