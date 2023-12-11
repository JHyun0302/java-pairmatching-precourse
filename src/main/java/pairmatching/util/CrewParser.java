package pairmatching.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import pairmatching.model.constant.Course;

public class CrewParser {
    public List<String> parseName(Course course) throws IOException {
        String filePath = String.format(
                "src/main/resources/%s-crew.md",
                course.name().toLowerCase(Locale.ROOT)
        );

        return readMarkdownFile(filePath);
    }

    private List<String> readMarkdownFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path);
    }
}
