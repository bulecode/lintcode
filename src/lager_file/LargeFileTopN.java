package lager_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 一个大文件(比内存大得多) 每行一个数字 找出数字top10
 *
 * @author nonpool
 * @version 1.0
 * @since 2018/3/23
 */
public class LargeFileTopN {
    public static void main(String[] args) throws IOException {
        top10(new File("E:/test.txt"), 10);
    }

    public static int[] top10(File file, int topN) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            for (String line = fileReader.readLine(); line != null; line = fileReader.readLine()) {
                line = line.trim();
                int i = Integer.parseInt(line);

            }

        }
        return null;
    }
}



