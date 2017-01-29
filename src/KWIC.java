import java.util.Scanner;
import java.util.TreeSet;

public class KWIC {
    
    public static void main(String[] args) {
        TreeSet<String> ignoreWords = new TreeSet<String>();
        LineStorage originalLines = new LineStorage();
        LineStorage shiftedLines = new LineStorage();

        CircularShifter cs = new CircularShifter(ignoreWords, shiftedLines);
        originalLines.addObserver(cs);
        Alphabetizer alp = new Alphabetizer();
        shiftedLines.addObserver(alp);
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter ignore keywords (end with an empty line):");
        while (true) {
            String word = sc.nextLine();
            if (word.trim().isEmpty()) {
                break;
            }
            ignoreWords.add(word.toLowerCase().trim());
        }
        
        System.out.println("Enter titles:");
        while (true) {
            String line = sc.nextLine();
            if (line.trim().isEmpty()) {
                break;
            }
            originalLines.insert(line);
        }

        for (int i = 0; i < shiftedLines.size(); i++) {
            System.out.println(shiftedLines.get(i));
        }
    }
    
}
