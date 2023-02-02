package com.kevin;

import java.io.File;
import java.util.Optional;

public class Files {

    public static void main(String[] args) {
        File testFile = new File("resources" + File.separator + "test.txt");
        System.out.println(testFile.exists());
        boolean deleted = testFile.delete();
        System.out.println(deleted);
        System.out.println(testFile.getAbsolutePath());
        System.out.println(testFile.getName());
        System.out.println(testFile.getParent());
        System.out.println(testFile);
        System.out.println(testFile.length());
        System.out.println(testFile.isDirectory());
        System.out.println(testFile.isFile());
        System.out.println(testFile.lastModified());

        System.out.println("\ndir1:");

        File dir1 = new File("resources" + File.separator + "dir1");
        System.out.println(dir1.exists());
        System.out.println(dir1.mkdir());
        System.out.println(dir1.exists());
        System.out.println(dir1.delete());

        System.out.println("\ndir2:");

        File dir2 = new File("resources" + File.separator + "dir2" + File.separator + "subdir2");
        System.out.println(dir2.exists());
        System.out.println(dir2.mkdirs());
        System.out.println(dir2.exists());
        System.out.println(dir2.delete());
        File dir2Parent = new File(dir2.getParent());
        System.out.println(dir2Parent.delete());

        System.out.println("\ndir3:");

        File dir3 = new File("resources" + File.separator + "dir3" + File.separator + "subdir3");
        System.out.println(dir3.exists());
        System.out.println(dir3.mkdirs());
        System.out.println(dir3.exists());
        System.out.println(dir3.renameTo(dir1));

        System.out.println("presentWorkingDirectory:");
        File presentWorkingDirectory = new File("");
        File presentWorkingDirectoryAbsolute = new File(presentWorkingDirectory.getAbsolutePath());
        File[] pwdFiles = presentWorkingDirectoryAbsolute.listFiles();
        System.out.println(pwdFiles);
        System.out.println(presentWorkingDirectoryAbsolute);
        Optional<File[]> optionalFiles = Optional.ofNullable(pwdFiles);
        optionalFiles.ifPresent(
                files2 -> {
                    for (File pwdFile : pwdFiles) {
                        System.out.println("filePath: " + pwdFile.getAbsolutePath());
                    }
                }
        );
    }


}
