package designParten.singleResponsibility.negtive;

import java.io.*;

public class AppTest {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("E:\\新建文件夹\\JavaWeb\\设计模式\\1.txt");
        int n, count;
        count = 0;

        while ((n = reader.read()) != -1){
            count++;
        }
        System.out.println(count);
        reader.close();

    }

}
