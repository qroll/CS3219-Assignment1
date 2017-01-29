import java.util.TreeSet;

public class KWIC {
    
    public static void main(String[] args) {
        // initialise data structures
        TreeSet<String> ignoredWords = new TreeSet<String>();
        LineStorage originalLines = new LineStorage();
        LineStorage shiftedLines = new LineStorage();

        // initialise components
        CircularShifter cs = new CircularShifter(shiftedLines);
        IgnoredKeywordFilter ikf = new IgnoredKeywordFilter(ignoredWords, shiftedLines);
        Alphabetizer alp = new Alphabetizer(shiftedLines);

        // register observers
        originalLines.addObserver(cs);
        cs.addObserver(ikf);
        ikf.addObserver(alp);
        
        // begin data processing
        Input.read(ignoredWords, originalLines);
        Output.display(shiftedLines);
    }
    
}
