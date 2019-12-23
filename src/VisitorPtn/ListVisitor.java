package VisitorPtn;

import java.util.Iterator;

public class ListVisitor extends Visitor {
    private String currDir = "";//현재 주목하고있는 디렉토리 이름 저장

    @Override
    public void visit(File file) {
        System.out.println(currDir + "/" + file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currDir + "/" + directory);
        String saveDir = currDir;
        currDir = currDir + "/" + directory.getName();
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            entry.accept(this);
        }
        currDir = saveDir;
    }

}
