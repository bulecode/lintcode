/**
 * Author: buleCode
 * Date: 2017/12/15
 */
public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trailingZeros(105));
        s.digitCounts(0, 19);
    }


    //---------------------- trailingZeros start-----------------------------
    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
    */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        //通过分析得出 此题实际是需要统计n以内能因式分解出多个5
        long count = 0;

        for (long temp = n / 5; temp != 0;temp /= 5) {
            count += temp;

        }
        return count;
    }
    //---------------------- trailingZeros start-----------------------------

    //---------------------- digit-counts start -----------------------------
    /*
    计算数字k在0到n中的出现的次数，k可能是0~9的一个值
    例如n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]，我们发现1出现了5次 (1, 10, 11, 12)

     * @param : An integer
     * @param : An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        if (k == 0 && n == 0) {
            return 1;
        }

        int count = 0;
        int base = 1;

        while (n / base != 0) {
            int current = (n / base) % 10;
            int high = n / base / 10;
            int low = n % base;

            if (k == 0 && high == 0) {
                base *= 10;
                continue;
            }

            if (k < current) {
                count += ((high + 1) * base);
            } else if (k == current) {
                count += (high * base + low + 1);
            } else {
                count += (high * base);
            }

            base *= 10;

        }

        return count;
    }


    //---------------------- digit-counts end -----------------------------



}
