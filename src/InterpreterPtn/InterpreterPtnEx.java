package InterpreterPtn;

import java.io.BufferedReader;
import java.io.FileReader;

public class InterpreterPtnEx {
    public static void main(String[] args) {
        String filename = "src/InterpreterPtn/program.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("text = \"" + line + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(line));
                System.out.println("node = " + node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
