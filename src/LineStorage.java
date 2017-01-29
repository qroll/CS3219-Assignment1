import java.util.ArrayList;
import java.util.Observable;

public class LineStorage extends Observable {

    private ArrayList<String> lines = new ArrayList<String>();
    
    public void insert(String newLine) {
        lines.add(newLine);
        setChanged();
        notifyObservers();
    }

    public void insert(int i, String newLine) {
        lines.add(i, newLine);
        setChanged();
        notifyObservers();
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
    
    public String toString() {
        String result = "";
        for (String s : lines) {
            result += s + " ";
        }
        return result;
    }
}
