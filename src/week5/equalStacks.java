package week5;
import java.util.*;

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */
public class EqualStacks {
        public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
// Write your code here
            int height = 0;
            int s1 = h1.size() - 1, s2 = h2.size() - 1, s3 = h3.size() - 1;
            int ss1 = 0, ss2 = 0, ss3 = 0;
            int sum1 = 0, sum2 = 0, sum3 = 0;
            for (int i = 0; i <= s1; i++) sum1 += h1.get(i);
            for (int i = s2; i >= 0; i--) sum2 += h2.get(i);
            for (int i = s3; i >= 0; i--) sum3 += h3.get(i);
            if (s1 == s2 && s1 == s3) {
                if (sum1 == sum2 && sum1 == sum3) return sum1;
            }
            while (ss1 != s1 && ss2 != s2 && ss3 != s3) {
                if (sum1 == sum2 && sum1 == sum3) {
                    height = sum1;
                    break;
                }
                if (sum1 > sum2 && sum1 > sum3) {
                    sum1 -= h1.get(ss1);
                    ss1++;
                }
                if (sum2 > sum1 && sum2 > sum3) {
                    sum2 -= h2.get(ss2);
                    ss2++;
                }
                if (sum3 > sum1 && sum3 > sum2) {
                    sum3 -= h3.get(ss3);
                    ss3++;
                }
            }
            return height;
    }
}
