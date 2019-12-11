import java.util.Calendar;

/**
 * @ClassName instanceOfDemo
 * @Description Todo
 * @AUTHOR xingxf03
 * @Date 2019/8/21 14:48
 * @Version v1.0
 **/
public class instanceOfDemo {
    public static void main(String[] args) {

        boolean b1 = "String" instanceof Object;

        System.out.println("b1:"+b1);

        boolean b2 = "" instanceof String;

        System.out.println("b2:"+b2);

        boolean b3 = new Object() instanceof String;

        System.out.println("b3:"+b3);



    }
}
