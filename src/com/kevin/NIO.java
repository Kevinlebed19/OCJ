package com.kevin;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO {
    public static void main(String[] args) throws URISyntaxException {

        var uri = new URI("file://c:/Users/lebed/IdeaProjects/OCJ/resources/IOdir1/output.txt");
        var fileDir = Path.of("IOdir1", "output.txt");
        var dir1 = Path.of("dir1");
        var fileSystem = FileSystems.getDefault();
        var objectsBin = fileSystem.getPath("objectDir", "objects.bin");
        var pathFromUri = Paths.get(uri);
        var fileName = dir1.getFileName();
        var ioFile = new File("resources", "dir2");
        var nio2Path = ioFile.toPath();
        var ioPathFile = nio2Path.toFile();
        var dir3 = Path.of(dir1.toString(), "../dir3");
        var dir3File = Path.of(dir3.toString(), "./file.whatev");
        System.out.println(dir3File);
        System.out.println(dir3);
        System.out.println(ioFile.mkdir());
        System.out.println(objectsBin);
        System.out.println(fileName);
        System.out.println(dir1.compareTo(fileDir));
        System.out.println(pathFromUri);
        System.out.println(fileName.compareTo(pathFromUri));
    }
}
