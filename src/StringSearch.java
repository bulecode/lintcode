/**
 * K.M.P
 * Author: buleCode
 * Date: 2017/12/19
 */
public class StringSearch {


    public static void main(String[] args) {
        StringSearch stringSearch = new StringSearch();
        System.out.println(stringSearch.strStr("", ""));
    }

    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (source.length() < target.length()) {
            return -1;
        }
        if (target.isEmpty()) {
            return 0;
        }


        char[] t = source.toCharArray();
        char[] p = target.toCharArray();

        int i = 0;
        int j = 0;

        int[] next = calNextArray(target);

        while (i < t.length && j < p.length) {
            if (j == -1) {
                i++;
                j = 0;
                continue;
            }

            if (t[i] != p[j]) {
                j = next[j];
            } else {
                if (j == p.length - 1) {
                    return i - p.length + 1;
                } else {
                    i++;
                    j++;
                }
            }
        }


        return -1;
    }


    private int[] calNextArray(String target) {
        char[] p = target.toCharArray();
        int[] next = new int[p.length];

        next[0] = -1;

        int j = 0;
        int k = -1;

        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }

        return next;
    }
}
