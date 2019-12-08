package PrototypePtn;

import PrototypePtn.framework.Manager;
import PrototypePtn.framework.Product;

public class PrototypeEx {
    public static void main(String[] args) {
        Manager m_manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        
        m_manager.register("strong message", upen);
        m_manager.register("warning box", mbox);
        m_manager.register("slash box", sbox);
        
        Product p1 = m_manager.create("strong message");
        p1.use("hello, world");
        Product p2 = m_manager.create("warning box");
        p2.use("Hello, korea");
        Product p3 = m_manager.create("slash box");
        p3.use("hello, seoul");
    }
}
