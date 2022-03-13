import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MorseCodeFileHandler {
    private final File morseFile;

    public MorseCodeFileHandler() {
        morseFile = new File("D:\\morse_dictionary");
    }

    public Map<String, String> createCodec() {
        Map<String, String> morseCodec = new HashMap<>();
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(morseFile));
            while ((line = br.readLine()) != null) {
                String[] entry = line.split(";");
                morseCodec.put(entry[0], entry[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return morseCodec;
    }
}
