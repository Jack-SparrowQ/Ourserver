package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageUtils {
    
    public static byte[] imageToBytes(String imagePath) throws IOException {
        return Files.readAllBytes(Path.of(imagePath));
    }

    public static void bytesToImage(byte[] data, String outputPath) throws IOException {
        Files.write(Path.of(outputPath), data);
    }

}
