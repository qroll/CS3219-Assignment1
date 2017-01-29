import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;

public class CircularShifter implements Observer {
    
    private LineStorage shiftedLines;
    private TreeSet<String> ignoreWords;

    public CircularShifter(TreeSet<String> iw, LineStorage ls) {
        shiftedLines = ls;
        ignoreWords = iw;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        LineStorage ls = (LineStorage) o;
        String line = ls.getLast();
        LinkedList<String> processedLines = process(line);
        shiftedLines.insert(processedLines);
    }
    
    private LinkedList<String> process(String str) {
        String[] words = str.split("\\s+");
        LinkedList<String> shiftedLines = new LinkedList<String>();
        for (int i = 0; i < words.length; i++) {
            if (!ignoreWords.contains(words[i].toLowerCase())) {                        
                String shiftedLine = "";
                for (int j = 0; j < words.length; j++) {
                    int index = (i + j) % words.length; 
                    shiftedLine += words[index] + " ";
                }
                shiftedLine = shiftedLine.trim();
                //System.out.println("shifted: " + shiftedLine);
                shiftedLines.add(shiftedLine);
            }
        }
        return shiftedLines;
    }
}
