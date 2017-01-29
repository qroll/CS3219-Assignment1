import java.util.Observable;
import java.util.Observer;

public class Alphabetizer implements Observer {

    private LineStorage sortedLines;
    
    public Alphabetizer(LineStorage ls) {
        sortedLines = ls;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        String lastLine = sortedLines.getLast();
        int index = findInsertionIndex(sortedLines, lastLine.toLowerCase(), 0, sortedLines.size()-1);
        sortedLines.delete(sortedLines.size() - 1);
        sortedLines.insert(index, lastLine);
    }

    private int findInsertionIndex(LineStorage ls, String key, int left, int right) {
        if (left == right) {
            return left;
        }

        int mid = (left + right) / 2;
        String midVal = ls.get(mid).toLowerCase();
        
        if (key.compareTo(midVal) > 0) {
            return findInsertionIndex(ls, key, mid + 1, right);
        } else if (key.compareTo(midVal) < 0) {
            return findInsertionIndex(ls, key, left, mid);
        }
        return mid;
    }

}
