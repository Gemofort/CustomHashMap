/**
 * The class Main contained the main method
 *
 * @author Ivan Feofanov
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put(31, 20L);
            hashMap.put(-124,4L);
            hashMap.put(120, 11L);
            hashMap.put(-2,  10L);
            System.out.println(hashMap.get(-2));
            System.out.println(hashMap.get(31));
            /*hashCodeNew(120) == 127
            hashCodeNew(-240) == 127
            hashCodeNew(-2) == 30
            hashCodeNew(31) == 30
            */
        } catch (ResizeHMExc | NotFoundExc exc){
            exc.printStackTrace();
        }
        System.out.println("Size of created hashMap = " + hashMap.size());
    }


}
