package com.kevin;

import java.io.*;
import java.util.Objects;

public class ObjectIO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File objectDir = new File("resources" + File.separator + "objectDir");

        System.out.println(objectDir.mkdir());

        if (!objectDir.exists()) return;

        File objectFile = new File(objectDir, "objects.bin");

        writeZebra(objectFile);
        readZebra(objectFile);
    }

    private static void writeZebra(File objectFile) throws IOException {
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(objectFile)))) {
            Zebra zebra1 = new Zebra("Zebrha", 26);
            objectOutputStream.writeObject(zebra1);
            objectOutputStream.flush();
        }
    }

    private static void readZebra(File objectFile) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream =
                     new ObjectInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(objectFile)))) {
            Zebra zebra2 = (Zebra) objectInputStream.readObject();
            System.out.println(zebra2);
        }
    }
}

class Snufilupigus {
}
