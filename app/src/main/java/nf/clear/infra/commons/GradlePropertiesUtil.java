package nf.clear.infra.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GradlePropertiesUtil {

        public static Properties getProperties() throws IOException {
            Properties prop = new Properties();
            InputStream input = null;
            input = new FileInputStream("gradle.properties");
            prop.load(input);
        return prop;
    }
    
}
