package utils;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String readProperty(String key) { // THIS IS HIDDING DATA FROM OTHER PEOPLE TEAM MEMEBERS

        File file =new File("configuration.properties");
        Properties properties=new Properties();// this properties object will read  the properties file
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try{
            properties.load(new FileInputStream(file));
        }catch (IOException e){
            throw  new RuntimeException(e);

        }
        return  properties.getProperty(key);
    }


}
