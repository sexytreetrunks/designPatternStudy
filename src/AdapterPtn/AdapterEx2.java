package AdapterPtn;

import java.io.IOException;

public class AdapterEx2 {
    public static void main(String[] args) {
        FileIO f = new FileProperties();
        try {
            f.readFromFile("src/AdapterPtn/file.txt");
            //f.setValue("year", "2004");//주석처리하면 읽어들인 파일의 year값으로 저장됨
            f.setValue("month", "8");
            f.setValue("day", "29");
            f.writeToFile("src/AdapterPtn/newfile.txt");
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
