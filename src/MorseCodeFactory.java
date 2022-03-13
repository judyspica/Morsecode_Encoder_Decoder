import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MorseCodeFactory {
    private final Map<String, String> ENCODER;
    private final Map<String, String> DECODER;

    public MorseCodeFactory() {
        var fileHandler = new MorseCodeFileHandler();
        var codec = fileHandler.createCodec();
        this.ENCODER = createEncoder(codec);
        this.DECODER = createDecoder(codec);
    }

    public String encodeInput(final String input) {
        return Arrays.stream(input.split(""))
                .map(key -> ENCODER.get(key) + " ")
                .collect(Collectors.joining());
    }

    public String decodeInput(final String input) {
        return Arrays.stream(input.split(" "))
                .map(DECODER::get)
                .collect(Collectors.joining());
    }

    private Map<String, String> createEncoder(Map<String, String> codec) {
        return codec
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map<String, String> createDecoder(Map<String, String> codec) {
        return codec
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }
}
