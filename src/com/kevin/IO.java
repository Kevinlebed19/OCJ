package com.kevin;

import java.io.*;

public class IO {

    public static void main(String[] args) throws IOException {

        System.out.println("\ndir1:");

        File dir1 = new File("resources" + File.separator + "IOdir1");
        System.out.println(dir1.exists());
        System.out.println(dir1.mkdir());
        System.out.println(dir1.exists());

        if (!dir1.exists()) return;

        File theFile = new File(dir1, "output.bin");
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(theFile))) {
            outputStream.write(255);
            outputStream.write(255);
            outputStream.flush();
        }
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(theFile))) {
            int b;
            while ((b = inputStream.read()) != -1) {
                System.out.println(b);
            }
        }

        System.out.println("Reader/Writer");

        File textFile = new File(dir1, "output.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(textFile))) {
            writer.write('A');
            writer.newLine();
            writer.write("\t");
            writer.write("Kevin");

            writer.flush();
        }

        try (Reader reader = new BufferedReader(new FileReader(textFile))) {
            int i;
            while ((i = reader.read()) != -1) {
                char c = (char) i;
                System.out.print(c);
            }
        }
        System.out.println("\n");
        try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        }
    }
}

