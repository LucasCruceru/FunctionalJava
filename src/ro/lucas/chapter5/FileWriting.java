package ro.lucas.chapter5;

import ro.lucas.chapter4.exceptions.UseInstance;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriting{
    private final FileWriter writer;

    private FileWriting(final String fileName) throws IOException{
        writer = new FileWriter(fileName);
    }

    private void close() throws IOException{
        System.out.println("Close automatically...");
        writer.close();
    }
    private void writeStuff(final String message) throws IOException{
        writer.write(message);
    }

    public static void main(String[] args) throws IOException{
        FileWriting.use( "stuff.txt", writer -> {
            writer.writeStuff("yeah");
            writer.writeStuff(" i do this");
        });
    }

    private static void use(final String fileName,
                            final UseInstance<FileWriting, IOException> block) throws IOException {
     final FileWriting writer = new FileWriting(fileName);
        try{
            block.accept(writer);
        }finally {
            writer.close();
        }

    }
}