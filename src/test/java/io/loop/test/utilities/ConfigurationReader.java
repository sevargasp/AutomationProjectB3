package io.loop.test.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;//almacena las propiedades cargadas desde el archivo

    //lo corre solo una vez
    static {
        try {
            String path = "configuration.properties";//this is the name to find, which will send us to that file Stream
            FileInputStream input = new FileInputStream(path);//permite leer archivos en forma de flujos bytes
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }//porque vamos a usar java input stream y puede mostrar exceptiones
    }

    public static String getProperties(String keyName) {
        return properties.getProperty(keyName);//este es un metodo propio
    }
}