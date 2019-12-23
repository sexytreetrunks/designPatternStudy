package VisitorPtn;

import java.util.ArrayList;
import java.util.Iterator;

public class ElementArrayList extends ArrayList implements Element {

    @Override
    public void accept(Visitor v) {
        Iterator it = iterator();
        while (it.hasNext()) {
            Element a = (Element) it.next();
            a.accept(v);
        }
    }

}
