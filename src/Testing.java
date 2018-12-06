import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

/**
 * The Testing class
 *
 * @author Ivan Feofanov
 * @version 1.0
 */

public class Testing extends Assert {

    /**
     * Test of basics
     * */
    @Test
    public void testBasic() throws ResizeHMExc, NotFoundExc {
        HashMap hashMap = new HashMap();

        hashMap.put(10, 16L);
        hashMap.put(23, 25L);
        hashMap.put(21, 36L);
        hashMap.put(20, 49L);

        long value = hashMap.get(20);
        Assert.assertEquals(49, value);

    }

    /**
     * Test to see if we can put negative values
     * */
    @Test
    public void testNegative() throws ResizeHMExc, NotFoundExc {
        HashMap hashMap = new HashMap();

        hashMap.put(-11, -20L);
        hashMap.put(-13, -11L);
        hashMap.put(-12, -1L);
        hashMap.put(-20, -10L);

        long value = hashMap.get(-20);
        Assert.assertEquals(-10, value);
    }

    /**
     * Test to see if linear algorithm works well
     * */
    @Test
    public void testCollisions(){
        HashMap hashMap = new HashMap();
        try{
            hashMap.put(-2,20L);
            hashMap.put(31,10L);
            /*31 and -2 have same hashcode which is 30*/
            long value = hashMap.get(31);
            Assert.assertEquals(10L, value);
        } catch(ResizeHMExc | NotFoundExc exc){
            exc.printStackTrace();
        }
    }

    /**
     * Test to see if size() works correctly with non-repeated elements
     * */
    @Test
    public void testSize() throws ResizeHMExc {
        int size = 8;
        HashMap hashMap = new HashMap();

        hashMap.put(-1, -20L);
        hashMap.put(-3, -11L);
        hashMap.put(-2, -1L);
        hashMap.put(-20, -10L);
        hashMap.put(10, 16L);
        hashMap.put(20, 25L);
        hashMap.put(21, 36L);
        hashMap.put(23, 49L);
        Assert.assertEquals(size, hashMap.size());
    }

    /**
     * Test to see if size() works correctly with repeated elements
     * */
    @Test
    public void testSizeWithRepeats() throws ResizeHMExc {
        int size = 5;
        HashMap hashMap = new HashMap();

        hashMap.put(-1, -20L);
        hashMap.put(-3, -11L);
        hashMap.put(-2, -1L);
        hashMap.put(-20, -10L);
        hashMap.put(-1, 16L);
        hashMap.put(-20, 25L);
        hashMap.put(21, 36L);
        hashMap.put(-20, 49L);
        Assert.assertEquals(size, hashMap.size());
    }

    /**
     * Test to see if ResizeHMEc works
     * */
    @Test
    public void NotEnoughSize(){
        HashMap hashMap = new HashMap();
        try{
            hashMap.put(120, 11L);
            hashMap.put(-240,  10L);
            /*120 and -240 have same hashCode which is 128*/
        } catch (ResizeHMExc exc){
            exc.printStackTrace();
        }

    }

    /**
     * Test to see if we can get no existing element and NotFoundExc works
     * */
    @Test
    public void testGet(){
        HashMap hashMap = new HashMap();
        try{
            hashMap.get(4);
        } catch (NotFoundExc exc){
            exc.printStackTrace();
        }
    }

    /**
     * Method that is executed after tests are done
     * */
    @AfterClass
    public static void authorName() {
        System.out.println("Author - Ivan Feofanov");
    }
}
