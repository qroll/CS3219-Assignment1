import java.util.Observable;
import java.util.Observer;

public class Alphabetizer implements Observer {

    private LineStorage sortedLines;
    
    public Alphabetizer(LineStorage ls) {
        sortedLines = ls;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        LineStorage ls = (LineStorage) o;
        String lastLine = ls.getLast();
        int index = findInsertionIndex(sortedLines, lastLine);
        sortedLines.insert(index, lastLine);
    }

    private int findInsertionIndex(LineStorage ls, String key) {
        String keyInLowercase = key.toLowerCase();
        int low = 0;
        int high = ls.size();
        int mid = (low + high) / 2;
        
        while (low < high) {
            String midVal = ls.get(mid).toLowerCase();
            if (keyInLowercase.compareTo(midVal) > 0) {
                low = mid + 1;
            } else if (keyInLowercase.compareTo(midVal) < 0) {
                high = mid;
            } else {
                break;
            }
            mid = (low + high) / 2;
        }
        if (low == high) {
            return low;
        }
        return mid;
    }

}
