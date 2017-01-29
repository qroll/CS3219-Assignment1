import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class CircularShifter implements Observer {
    
    private LineStorage shiftedLines;

    public CircularShifter(LineStorage ls) {
        shiftedLines = ls;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        LineStorage ls = (LineStorage) o;
        String line = ls.getLast();
        LinkedList<String> processedLines = circularlyShift(line);
        for (String s : processedLines) {
            shiftedLines.insert(s);
        }
    }
    
    private LinkedList<String> circularlyShift(String str) {
        String[] words = str.split("\\s+");
        LinkedList<String> shiftedLines = new LinkedList<String>();
        for (int i = 0; i < words.length; i++) {
            String shiftedLine = "";
            for (int j = 0; j < words.length; j++) {
                int index = (i + j) % words.length; 
                shiftedLine += words[index] + " ";
            }
            shiftedLine = shiftedLine.trim();
            //System.out.println("shifted: " + shiftedLine);
            shiftedLines.add(shiftedLine);
        }
        return shiftedLines;
    }
}
