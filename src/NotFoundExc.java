/**
 * The Exception class for not found element in HashMap
 *
 * @author Ivan Feofanov
 * @version 1.0
 */

public class NotFoundExc extends Exception {

    /**
     * Method which prints an message of not found element exception
     * */
    public NotFoundExc (){
        super("Element not found");
    }
}