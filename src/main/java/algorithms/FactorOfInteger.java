package algorithms;



import java.util.ArrayList;
import java.util.List;

/**
 * 因子分解 12=2*2*3
 */

public class FactorOfInteger {

    public static void main(String[] args) {
        int f = 30;
        List<Integer> store = new ArrayList<>();
        factor(f, store);
        StringBuffer sb = new StringBuffer();
        store.forEach(i -> {
            sb.append(i);
            sb.append("*");
        });
        sb.setLength(sb.length() - 1);
        String result = f + "=" + sb.toString();
        System.out.println(result);
    }

    public static void factor(int z, List<Integer> store) {
        if (isPrime(z)) {
            store.add(z);
            return;
        }
        int b = z;
        for (int i = 2; i <= Math.ceil((int) Math.sqrt(b)); i++) {
            if (isPrime(i) && b % i == 0) {
                store.add(i);
                b = b / i;
                break;
            }

        }
        factor(b, store);
    }

    public static boolean isPrime(int a) {
        if (a <= 1) return false;
        int up = (int) Math.floor(Math.sqrt(a));
        for (int i = 2; i <= up; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
