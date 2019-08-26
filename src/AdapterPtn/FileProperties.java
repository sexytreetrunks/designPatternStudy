package AdapterPtn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileProperties extends Properties implements FileIO{
    @Override
    public void readFromFile(String filename) throws IOException {
        //super.load(new FileInputStream(new File(filename))); //요렇게 해도 되긴한데 걍 file경로만 파라미터로 넣어줘도됨
        super.load(new FileInputStream(filename));
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        super.store(new FileOutputStream(filename), "written by FileProperties"); 
    }

    @Override
    public void setValue(String key, String value) {
        super.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return super.getProperty(key);
    }
}
