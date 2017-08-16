package ro.lucas.chapter3;


import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class ListingFiles {
    public static void main(String[] args) throws IOException, InterruptedException {

        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);

        Files.newDirectoryStream(
                Paths.get("."), path -> path.toString().endsWith(".java"))
                .forEach(System.out::println);

        System.out.println(Arrays.toString(
                new File(".").listFiles(File::isHidden)));


        listTheHardWay();
        betterWay();

        System.out.println("--------------");

        final Path path = Paths.get(".");
        final WatchService watchService =
                path.getFileSystem()
                .newWatchService();

        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        System.out.println("Report any file changed withing next 1 minute...");


        final WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);

        assert watchKey != null;
            watchKey.pollEvents()
                    .forEach(event ->
                            System.out.println(event.context()));
        }



    private static void listTheHardWay(){
        List<File> files = new ArrayList<>();

        File[] filesInCurentDir = new File(".").listFiles();
        assert filesInCurentDir != null;
        for (File file:filesInCurentDir){
            File[] filesInSubDir = new File(".").listFiles();
            if(filesInSubDir != null){
                files.addAll(Arrays.asList(filesInSubDir));
            }else{
                files.add(file);
            }
            System.out.println("Count: " + files.size());
        }
    }
    private static void betterWay(){
        List<File> files =
                Stream.of(new File(".").listFiles())
                        .flatMap(file -> file.listFiles() == null ?
                Stream.of(file) : Stream.of(file.listFiles()))
                        .collect(toList());
        System.out.println("Count: "+ files.size());
    }
}
