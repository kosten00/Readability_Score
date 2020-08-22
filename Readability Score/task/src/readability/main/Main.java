package readability.main;

import readability.ReadabilityAnalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "/home/konstantinvasilev/IdeaProjects/Readability Score/Readability Score/task/src/readability/main/text.txt";
        String text = new String(Files.readAllBytes(Paths.get(args[0])));
        System.out.println(text);
        ReadabilityAnalyzer ra = new ReadabilityAnalyzer(text);

        ra.printTextStats();

        ra.printScore(new Scanner(System.in).next());
    }
}