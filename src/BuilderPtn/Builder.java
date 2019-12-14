package BuilderPtn;

public abstract class Builder {
    /*
     * makeTitle이 사용된여부를 알수있는 변수를 만들고
     * Templete method패턴을 이용하여 메소드실행시 initialize 여부를 점검함
     * 기존엔 override해서 구현하는 함수(buildXXX)와 외부에서 사용하는 함수(makeXXX)를 분리시킴으로써 
     * 외부(Director)에서 코드변경이 이뤄지지않도록 함
     * 암튼 핵심은 외부에서 코드변경이 최대한 이루어지지 않도록 하는것.
     * 이렇게 메소드를 변경해야할땐 메소드 내에서 기존에 핵심 코드를 담당했던 부분을 함수로 따로 분리하고 로직을 변경하는게 좋음
     * 또한 함수를 변경하면서 함수의 껍데기(메소드명이나 파라미터 등등)는 최대한 변경이 안일어나도록 해야함
     */
    private boolean initialized = false;

    public void makeTitle(String title) {
        if (!initialized) {
            buildTitle(title);
            initialized = true;
        }
    }

    public void makeString(String str) {
        if (initialized) {
            buildString(str);
        }
    }

    public void makeItems(String[] items) {
        if (initialized) {
            buildItems(items);
        }
    }

    public void close() {
        if (initialized) {
            buildDone();
        }
    }

    protected abstract void buildTitle(String title);

    protected abstract void buildString(String str);

    protected abstract void buildItems(String[] items);

    protected abstract void buildDone();
}
