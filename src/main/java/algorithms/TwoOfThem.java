package algorithms;

import java.util.HashMap;
import java.util.Set;

/**
 * 找出数组中两个数的和等于给定值 O(n)实现
 */
public class TwoOfThem {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 8, 5, 9, 6};
        int total = 11;
        findTwoOfThem(array, total);
    }

    public static void findTwoOfThem(int[] numbers, int total) {
        HashMap<Integer, Integer> tmp = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            tmp.put(total - numbers[i], numbers[i]);
        }
        Set<Integer> set = tmp.keySet();
        for (int i = 0; i < numbers.length; i++) {
            boolean contained = set.contains(numbers[i]);
            if (contained) {
                System.out.println(numbers[i]);
                System.out.println(",");
                System.out.println(tmp.get(numbers[i]));
            }
        }
    }
}
