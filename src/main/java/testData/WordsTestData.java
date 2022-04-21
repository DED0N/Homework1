package testData;

import lombok.Data;
import utils.PropertyLoader;

@Data
public class WordsTestData extends BaseTestData {

    public String word1;
    public String word2;
    public String word3;
    public String word4;

    public WordsTestData(final String key) {
        String standKey = System.getProperty("standKey");
        String propPath = "testData/words.properties";

        word1 = PropertyLoader.loadProperty(standKey + "_" + key, propPath);
        word2 = PropertyLoader.loadProperty(standKey + "_" + key, propPath);
        word3 = PropertyLoader.loadProperty(standKey + "_" + key, propPath);
        word4 = PropertyLoader.loadProperty(standKey + "_" + key, propPath);
    }
}
