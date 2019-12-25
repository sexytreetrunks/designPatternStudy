package MementoPtn.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class MementoIO {
    private final static String SAVE_FILE = "game.dat";
    private File file = null;

    public MementoIO() {
    }

    public boolean exists() {
        if (file == null)
            file = new File(SAVE_FILE);
        return file.exists();
    }

    public void save(Memento m) {
        if (!exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fos = null;
        ObjectOutput oos = null; //항상 객체사용시 인터페이스를 사용하는 버릇을 들이도록 하자
        try {
            fos = new FileOutputStream(file);
            //oos = new ObjectOutputStream(fos);
            oos = new ObjectOutputStream(new DeflaterOutputStream(fos));//저장데이터 압축을 위해 DeflaterOutputStream을 사용. memento인스턴스가 클 경우 사용

            oos.writeObject(m);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public Memento load() {
        if (!exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Memento memento = null;
        FileInputStream fis = null;
        ObjectInput ois = null;
        try {
            fis = new FileInputStream(file);
            //ois = new ObjectInputStream(fis);
            ois = new ObjectInputStream(new InflaterInputStream(fis));//압축된 데이터를 읽기위해 InflaterInputStream 사용

            memento = (Memento) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return memento;
    }
}
