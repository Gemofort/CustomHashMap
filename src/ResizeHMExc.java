/**
 * The Exception class for resize in linear probing algorithm
 *
 * @author Ivan Feofanov
 * @version 1.0
 */
public class ResizeHMExc extends Exception {

    /**
     * Method which prints an message of need to resize a HashMap
     * */
    public ResizeHMExc(){
        super("There is no space for an element, please resize your HashMap");
    }
}