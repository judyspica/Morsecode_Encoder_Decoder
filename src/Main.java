import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MorseCodeFactory morseCodeFactory = new MorseCodeFactory();
        Scanner scanner = new Scanner(System.in);

        while (true){
            //String encodedValue = morseCodeFactory.encodeInput(scanner.nextLine());

            String DecodedValue= morseCodeFactory.decodeInput(scanner.nextLine());
            System.out.println(DecodedValue);
        }
    }
}
