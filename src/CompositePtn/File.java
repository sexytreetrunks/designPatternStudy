package CompositePtn;

public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        // TO DO Auto-generated method stub
        return name;
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    protected void printList(String preifx) {
        // TODO Auto-generated method stub
        System.out.println(preifx + "/" + this);
    }

}
