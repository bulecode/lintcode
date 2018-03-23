import java.util.Arrays;

/**
 * @author nonpool
 * @version 1.0
 * @since 2018/3/23
 */
public class sort {


    public static void main(String[] args) {
        int[] ints = {3, 1, 4, 2, 7, 8, 6, 5};
        // insertionSort(ints);
        // bubbleSort(ints);
        quicklySort(ints);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 交换数组元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 简单选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;//每一趟循环比较时，min用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换。
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //进行交换，如果min发生变化，则进行交换
            if (min != i) {
                swap(arr,min,i);
            }
        }
    }

    /**
     * 快速排序
     *
     * @param arr
     */
    public static void quicklySort(int[] arr) {

        quicklySort(arr, 0, arr.length - 1);
    }

    private static void quicklySort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivote = partition(arr, start, end);

        quicklySort(arr, start, pivote - 1);
        quicklySort(arr, pivote + 1, end);

    }

    private static int partition(int[] arr, int start, int end) {

        int pivoteNum = pivoteNum(arr, start, end);
        while (end > start) {
            while (start < end && arr[end] >= pivoteNum) {
                end--;
            }
            if (start < end) {
                arr[start++] = arr[end];
            }
            while (start < end && arr[start] < pivoteNum) {
                start++;
            }
            if (start < end) {
                arr[end--] = arr[start];
            }
        }
        arr[start] = pivoteNum;
        return start;
    }

    private static int pivoteNum(int[] arr, int start, int end) {
        int middle = (start + end) / 2;
        if (arr[start] > arr[middle]) {
            swap(arr,start,middle);
        }
        if (arr[middle] > arr[end]) {
            swap(arr, middle, end);
        }

        if (arr[start] < arr[middle]) {
            swap(arr,start,middle);
        }

        return arr[start];
    }

}
