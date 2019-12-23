package VisitorPtn;

import java.util.Iterator;

public class VisitorPtnEx {
    public static void main(String[] args) {
        try {
            Directory root = new Directory("root");
            
            Directory bin = new Directory("bin");
            Directory tmp = new Directory("tmp");
            Directory usr = new Directory("usr");
            
            root.add(bin);
            root.add(tmp);
            root.add(usr);
            
            File vi = new File("vi", 10000);
            File latex = new File("latex", 20000);
            
            bin.add(vi);
            bin.add(latex);
            
            root.accept(new ListVisitor());
            System.out.println();
            
            Directory kim = new Directory("Kim");
            Directory lee = new Directory("Lee");
            Directory park = new Directory("Park");
            
            usr.add(kim);
            usr.add(lee);
            usr.add(park);
            
            kim.add(new File("diary.html",100));
            kim.add(new File("Composite.java", 100));
            lee.add(new File("memo.txt", 100));
            park.add(new File("game.doc", 100));
            park.add(new File("junk.mail", 1000));
            root.accept(new ListVisitor());
            
            System.out.println();
            FileFoundVisitor ffv = new FileFoundVisitor(".html");
            root.accept(ffv);
            System.out.println("HTML files are: ");
            Iterator it = ffv.getFoundFiles();
            while (it.hasNext()) {
                File file = (File) it.next();
                System.out.println(file.toString());
            }
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
