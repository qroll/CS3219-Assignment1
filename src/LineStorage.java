import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Observable;

public class LineStorage extends Observable {

    private ArrayList<String> lines = new ArrayList<String>();
    
    public void insert(String shiftedLine) {
        lines.add(shiftedLine);
        setChanged();
        notifyObservers();
        clearChanged();
    }

    public void insert(Collection<String> shiftedLines) {
        lines.addAll(shiftedLines);
        setChanged();
        notifyObservers();
        clearChanged();
    }
    
    public void delete(int i) {
        lines.remove(i);
    }
    
    public String get(int i) {
        return lines.get(i);
    }
    
    public void set(int i, String line) {
        lines.set(i, line);
    }
    
    public String getFirst() {
        return lines.get(0);
    }
    
    public String getLast() {
        return lines.get(lines.size() - 1);
    }

    public int size() {
        return lines.size();
    }
    
    public void sort() {
        Collections.sort(lines);
    }

    public String toString() {
        String result = "";
        for (String s : lines) {
            result += s + " ";
        }
        return result;
    }
}
