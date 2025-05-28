package TestData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    @Test
    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
        // Read JSON to string
        String jsonContent = FileUtils.readFileToString(
                new File(System.getProperty("user.dir") + "/src/test/java/TestData/purchaseOrder.json"),
                StandardCharsets.UTF_8
        );

        // Convert JSON string to List of HashMaps
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(
                jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {
                }
        );
        return data;

    }
}