package dataCollector;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DataSampleReaderSimImpl implements DataSampleReader {
    @Override
    public List<Double> loadData() {
        try {
            System.out.println(Paths.get("").toAbsolutePath());
            List<String> strings = Files.readAllLines(Paths.get("C:\\Users\\m\\IdeaProjects\\IT2EKG\\IT2EKG\\src\\dataCollector\\Ekg100Hz.csv"));
            System.out.println("Data indlæst");
            return strings.stream().map(s-> Double.parseDouble(s)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}