package CompositePtn;

public class FileTreatmentException extends RuntimeException {
    // 파일에 대해 add메소드를 잘못호출시 나타나는 예외
    public FileTreatmentException() {
        // TODO Auto-generated constructor stub
    }
    
    public FileTreatmentException(String msg) {
        super(msg);
    }
}
