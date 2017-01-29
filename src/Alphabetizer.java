import java.util.Observable;
import java.util.Observer;

public class Alphabetizer implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        LineStorage ls = (LineStorage) o;
        ls.sort();
    }

}
