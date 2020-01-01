package FlyweightPtn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
    //큰 문자를 나타내는 클래스
    private char charName;
    private String fontData;
    
    public BigChar(char charname) {
        this.charName = charname;
        String filename = "src/FlyweightPtn/" + "big"+charname+".txt";
        BufferedReader reader = null;
        StringBuffer buff = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine())!=null) {
                buff.append(line);
                buff.append("\n");
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }            
        }
        fontData = buff.toString();
    }
    
    public void print() {
        System.out.println(fontData);
    }
}
