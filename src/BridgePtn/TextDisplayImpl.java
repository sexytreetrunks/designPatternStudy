package BridgePtn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TextDisplayImpl extends DisplayImpl {
    private String string;
    private String filename;
    private PrintWriter writer;

    public TextDisplayImpl(String string, String filename) {
        this.string = string;
        this.filename = filename + ".txt";
    }

    @Override
    public void rawOpen() {
        try {
            File file = new File(filename);
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rawPrint() {
        writer.write(string);
    }

    @Override
    public void rawClose() {
        writer.close();
    }

}
