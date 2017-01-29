import java.util.Scanner;
import java.util.TreeSet;

public class Input {

    private static final String MESSAGE_ENTER_IGNORED_KEYWORDS = "Key in each word to ignore on a new line. To end, enter an empty line.";
    private static final String MESSAGE_ENTER_LINES = "Key in each title on a new line. To end, enter an empty line.";

    public static void read(TreeSet<String> ignoredWords, LineStorage originalLines) {
        Scanner sc = new Scanner(System.in);
        readIgnoredKeywords(ignoredWords, sc);
        readLines(originalLines, sc);
    }

    public static void readLines(LineStorage originalLines, Scanner sc) {
        System.out.println(MESSAGE_ENTER_LINES);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            originalLines.insert(line);
        }
    }

    public static void readIgnoredKeywords(TreeSet<String> ignoredWords, Scanner sc) {
        System.out.println(MESSAGE_ENTER_IGNORED_KEYWORDS);
        while (sc.hasNextLine()) {
            String word = sc.nextLine().trim();
            if (word.isEmpty()) {
                break;
            }
            String wordInLowercase = word.toLowerCase();
            ignoredWords.add(wordInLowercase);
        }
    }
}
