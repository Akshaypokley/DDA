package l;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by akshay.pokley on 5/29/2017.
 */
public class ReadObject{

    Properties p = new Properties();
    public Properties getObjectRepository() throws IOException {
        //Read object repository file
        InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\Utilites\\object1.properties"));
        //load all objects
        p.load(stream);
        return p;
    }

}
