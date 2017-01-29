import java.util.TreeSet;

public class KWIC {
    
    public static void main(String[] args) {
        // initialise data structures
        TreeSet<String> ignoredWords = new TreeSet<String>();
        LineStorage originalLines = new LineStorage();
        LineStorage shiftedLines = new LineStorage();
        LineStorage filteredLines = new LineStorage();
        LineStorage sortedLines = new LineStorage();

        // initialise components
        CircularShifter cs = new CircularShifter(shiftedLines);
        IgnoredKeywordFilter ikf = new IgnoredKeywordFilter(ignoredWords, filteredLines);
        Alphabetizer alp = new Alphabetizer(sortedLines);

        // register observers
        originalLines.addObserver(cs);
        shiftedLines.addObserver(ikf);
        filteredLines.addObserver(alp);
        
        // begin data processing
        Input.read(ignoredWords, originalLines);
        Output.display(sortedLines);
    }
    
}
