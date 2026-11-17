package part1_textfilestatistics;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

class Part1TextFileStatistics {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the file directory (for example data/input.txt): ");
        String directory = in.nextLine();
        Path path1 = Path.of(directory);

        List<String> lines = null;
        try {
            lines = Files.readAllLines(path1, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;
        for (String line : lines) {
            System.out.println(line);
            i++;
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("File path: " + directory);
        System.out.println("");
        System.out.println("There is " + i + " lines, " + findCharacters(lines) + " characters");
        System.out.println("Lines with content " + findContentLines(lines));


    }

    public static int findCharacters(List<String> lines) {
        int counter = 0;

        for (String line : lines) {
            counter += line.length();
        }
        return counter;
    }
    public static int findContentLines(List<String> lines) {
        int counter = 0;
        for (String line : lines) {
            if (line == null || line.trim().isEmpty()) {
                continue;
            }
            else {
                counter++;
            }
        }
        return counter;
    }
}