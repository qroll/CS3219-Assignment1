import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;

public class IgnoredKeywordFilter extends Observable implements Observer {
    
    private LineStorage filteredLines;
    private TreeSet<String> ignoredKeywords;

    public IgnoredKeywordFilter(TreeSet<String> ik, LineStorage ls) {
        filteredLines = ls;
        ignoredKeywords = ik;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        String line = filteredLines.getLast();
        String[] words = line.split("\\s+", 2);
        if (ignoredKeywords.contains(words[0].toLowerCase())) {
            filteredLines.delete(filteredLines.size() - 1);
        } else {
            setChanged();
            notifyObservers();
        }
    }
    
}
