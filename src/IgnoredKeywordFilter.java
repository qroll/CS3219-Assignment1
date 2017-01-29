import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;

public class IgnoredKeywordFilter implements Observer {
    
    private LineStorage filteredLines;
    private TreeSet<String> ignoredKeywords;

    public IgnoredKeywordFilter(TreeSet<String> ik, LineStorage ls) {
        filteredLines = ls;
        ignoredKeywords = ik;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        LineStorage ls = (LineStorage) o;
        String line = ls.getLast();
        String[] words = line.split("\\s+", 2);
        if (!ignoredKeywords.contains(words[0].toLowerCase())) {
            filteredLines.insert(line);
        }
    }
    
}
