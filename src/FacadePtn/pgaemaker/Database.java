package FacadePtn.pgaemaker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database() {

    }

    public static Properties getProperties(String dbname) {
        String filename = "src/FacadePtn/"+dbname + ".txt";
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
