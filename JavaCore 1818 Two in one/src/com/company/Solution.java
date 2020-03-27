package com.company;

/*
1818 Two in one
Read 3 file names from the console.
Write the contents of the second file to the first file, and then add the contents of the third file to the first file.
Close streams.

Requirements:
1. The program should read the file names from the console three times.
2. For the first file, create a stream for recording. For the other two, read threads.
3. The contents of the second file must be rewritten in the first file.
4. The contents of the third file must be added to the first file (in which the second file is already written).
5. Streams created for files must be closed.
 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        reader.close();

        FileOutputStream f1 = new FileOutputStream(fileName1, true);
        FileInputStream f2 = new FileInputStream(fileName2);
        FileInputStream f3 = new FileInputStream(fileName3);

        //File2 write to File1
        while (f2.available()>0) {
            byte[] buf = new byte[f2.available()];
            f2.read(buf);
            f1.write(buf);
        }

        f2.close();

        //File3 append to File1
        while (f3.available()>0) {
            byte[] buf = new byte[f3.available()];
            f3.read(buf);
            f1.write(buf);
        }

        f3.close();
        f1.close();
    }
}




