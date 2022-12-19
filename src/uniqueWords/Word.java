package uniqueWords;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Word {
    private final static Logger LOGGER = LogManager.getLogger(Word.class);
    public static void main(String[] args) throws IOException {
        List<String> lineList = FileUtils.readLines(new File(("src/uniqueWords/file")));
        LOGGER.info(lineList);
        HashMap<String, Integer> wordMap = new HashMap<>();

        for(String line : lineList){
            // Each different word used
            String[] words = StringUtils.split(line, " ");
            for(String word : words){
                if(wordMap.containsKey(word)){
                    wordMap.put(word, wordMap.get(word)+1);
                }else {
                    wordMap.put(word,1);
                }
            }
        }
        // Write results to the same file
        FileUtils.writeStringToFile(new File("src/uniqueWords/resultFile"), "Result here", "UTF-8");

        LOGGER.info(wordMap);
    }

}
