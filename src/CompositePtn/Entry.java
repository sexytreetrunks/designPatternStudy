package CompositePtn;

public abstract class Entry {
    protected Entry parent;
    public abstract String getName();
    public abstract int getSize();
    public Entry add(Entry entry) throws FileTreatmentException {
        /* add메소드를 오버라이드하지않는 File클래스에서 add메소드를 호출할경우
         * exception이 발생하게됨. 그렇다면 왜 이렇게 처리?
         * --> add메소드가 필요한 directory에서만 add메소드를 넣을 경우
         *     add할때 entry를 Directory형으로 매번 형변환을 해줘야함
         */
        throw new FileTreatmentException();
    }
    
    public void printList() {
        printList("");
    }
    
    protected abstract void printList(String preifx);
    public String toString() {
        return getName() +" {" + getSize() + "} ";
    }
    
    public String getPath() {
        Entry curEntry = this;
        StringBuilder builder = new StringBuilder();
        do {
            builder.insert(0, "/"  + curEntry.getName()); //현재자신의 값부터 parent로 거슬러 올라가는 형태이므로 항상 맨앞에 붙여야함
            curEntry = curEntry.parent;
        } while(curEntry!=null);
        return builder.toString();
    }
}
