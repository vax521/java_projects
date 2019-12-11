import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ClassName FourDropFiveInput
 * @Description Todo
 * @AUTHOR xingxf03
 * @Date 2019/8/21 19:17
 * @Version v1.0
 **/
public class FourDropFiveInput {
    public static void main(String[] args) {
        BigDecimal d = new BigDecimal("888888");
        BigDecimal r = new BigDecimal(0.001875*3);
        BigDecimal i = d.multiply(r).setScale(2, RoundingMode.HALF_EVEN);
        System.out.println("季利息："+i);
    }
}
