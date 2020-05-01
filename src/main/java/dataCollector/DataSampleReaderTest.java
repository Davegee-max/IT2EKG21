package dataCollector;
import java.util.List;

public class DataSampleReaderTest {
    public static void main(String[] args) {

         new DataSampleReaderTest().go();
    }

    public void go() {
        DataSampleReader reader = new DataSampleReaderSimImpl();
        List<Double> doubles = reader.loadData();
        System.out.println(doubles);
    }

}