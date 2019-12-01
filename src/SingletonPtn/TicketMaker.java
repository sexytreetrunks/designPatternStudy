package SingletonPtn;

public class TicketMaker {
    private static TicketMaker m_instance;
    private int n_ticket = 1000;
    
    private TicketMaker() {}
    
    public static TicketMaker getInstance() {
        if(m_instance == null) {
            m_instance = new TicketMaker();
        }
        return m_instance;
    }

    public int getNextTicketNumber() {
        return n_ticket++;
    }
}
