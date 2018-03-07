import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: buleCode
 * Date: 2017/12/15
 */
public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trailingZeros(105));
        s.digitCounts(0, 19);
        System.out.println(s.isUgly(1));
        System.out.println(s.nthSuperUglyNumber(6,new int[]{2,3,5}));
        System.out.println(s.kthLargestElement(3,new int[]{9,3,2,4,8}));
        System.out.println(Arrays.toString(s.mergeSortedArray(new int[]{1}, new int[]{1})));
    }


    //----------------------2# trailingZeros start-----------------------------
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

    //----------------------3# digit-counts start -----------------------------
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


    //---------------------- 4# ugly-number-ii start -----------------------------
//    设计一个算法，找出只含素因子2，3，5 的第 n 小的数。
//    符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

    /*
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1;
        }

        List<Integer> ret = new LinkedList<>();
        ret.add(1);

        int l2 = 0;
        int l3 = 0;
        int l5 = 0;

        while (ret.size() < n) {
            Integer l2Num = ret.get(l2) * 2;
            Integer l3Num = ret.get(l3) * 3;
            Integer l5Num = ret.get(l5) * 5;

            int min = Math.min(l2Num, Math.min(l3Num, l5Num));

            if (ret.get(ret.size() - 1) != min) {
                ret.add(min);
            }
            if (l2Num == min) {
                l2++;
            }
            if (l3Num == min) {
                l3++;
            }
            if (l5Num == min) {
                l5++;
            }

        }

        return ret.get(n - 1);
    }


    //---------------------- ugly-number-ii end -----------------------------

    //----------------------#517 ugly-number start -----------------------------
    /*
     * @param num: An integer
     * @return: true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }
    //----------------------#517 ugly-number end -----------------------------

    //----------------------#518 super-ugly-number start -----------------------------
    /**
     * 写一个程序来找第 n 个超级丑数。
     超级丑数的定义是正整数并且所有的质数因子都在所给定的一个大小为 k 的质数集合内。
     比如给你 4 个质数的集合 [2, 7, 13, 19], 那么 [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] 是前 12 个超级丑数。
     注意事项

     1 永远都是超级丑数不管给的质数集合是什么。
     给你的质数集合已经按照升序排列。
     0 < k ≤ 100, 0 < n ≤ 10^6, 0 < primes[i] < 1000
     * */

    /*
     * @param n: a positive integer
     * @param primes: the given prime list
     * @return: the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0) {
            return -1;
        }

        List<Integer> ret = new LinkedList<>();
        ret.add(1);

        //每个质因子当前 乘以丑数的位置
        int[] nPointer = new int[primes.length];

        while (ret.size() < n) {
            //记录新丑数产生时是nPointer中的哪个位置产生的 可以有多个
            List<Integer> temp = new LinkedList<>();
            int min = ret.get(nPointer[0]) * primes[0];
            for (int i = 0; i < primes.length; i++) {
                int uglyNum = ret.get(nPointer[i]) * primes[i];
                if (min == uglyNum) {
                    temp.add(i);
                } else if (min > uglyNum){
                    min = uglyNum;
                    temp.clear();
                    temp.add(i);
                }
            }
            //temp 把产生新丑数的位置+1
            for (Integer i : temp) {
                nPointer[i] = nPointer[i] + 1;
            }

            if (min != ret.get(ret.size() - 1)) {
                ret.add(min);
            }
        }

        return ret.get(n - 1);
    }


    //----------------------#518 super-ugly-number end -----------------------------

    //---------------------- 5. kth-largest-element start-----------------------------

    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (true) {
            int pivotKeyPointer = oneQuickSort(start, end, nums);

            int k1 = nums.length - pivotKeyPointer; // pivotKeyPointer指向的元素在nums中第k1大
            if (k1 == k) {
                return nums[pivotKeyPointer];
            }

            if (k1 > k) {
                start = pivotKeyPointer + 1;
            } else {
                end = pivotKeyPointer - 1;
            }
        }
    }

    private int oneQuickSort(int start, int end, int[] nums) {
        int pivotKey  = nums[start];

        while (start < end) {
            while (start < end && nums[end] >= pivotKey) {
                end--;
            }
            if (start < end) {
                nums[start++] = nums[end];
            }

            while (start < end && nums[start] < pivotKey) {
                start++;
            }
            if (start < end) {
                nums[end--] = nums[start];
            }
        }
        nums[start] = pivotKey;

        return start;
    }

    //---------------------- 5. kth-largest-element end-----------------------------

    //---------------------- 5. merge-two-sorted-arrays start-----------------------------
    /*
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int[] ret = new int[A.length + B.length];

        int aPointer = 0;
        int bPointer = 0;

        for (int i = 0; i < ret.length; i++) {
            if (aPointer == A.length){
                System.arraycopy(B, bPointer, ret, aPointer + bPointer , B.length - bPointer );
                return ret;
            }
            if (bPointer == B.length) {
                System.arraycopy(A, aPointer, ret, aPointer + bPointer , A.length - aPointer);
                return ret;
            }

            ret[i] = Math.min(A[aPointer], B[bPointer]);
            if (ret[i] == A[aPointer]) {
                aPointer++;
            } else {
                bPointer++;
            }
        }
        return ret;
    }
    //---------------------- 5. merge-two-sorted-arrays end-----------------------------
}
