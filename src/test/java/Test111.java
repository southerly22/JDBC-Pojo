import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test111 {

    public String a="123";
    private String bbb;

    public String getBbb() {
        return bbb;
    }

    public void setBbb(String bbb) {
        this.bbb = bbb;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public static void main(String[] args) {
        // Test111 t = Test111.class.newInstance();
        Test111 t1 = new Test111();
        // t1.setA(new Object());

    }
}
