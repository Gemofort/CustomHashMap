/**
 * The HashMap class with open addressing and linear probing algorithm
 *
 * @author Ivan Feofanov
 * @version 1.0
 */

public class HashMap {

    private static final int SIZE_OF_TABLE = 128;
    private int currentSize = 0;
    private HashEntry[] table;
    HashMap() { table = new HashEntry[SIZE_OF_TABLE]; }

    /**
     * Method, which implements "Linear probing algorithm", adds element on it's position
     *
     * @param key is a key you need
     * @param value is a value you need
     * @throws ResizeHMExc if HashMap above index is full
     * */
    public void put(int key, long value) throws ResizeHMExc {
        int index = hashCodeNew(key); //hashed key as index
        boolean found = false; // it's boolean for tracking if place forward is found
        HashEntry hashEntry = new HashEntry(key, value); // our element we need to put
        if (table[index] == null) {
            table[index] = hashEntry;
            currentSize++;
        } else {
            for (int i = index; i<table.length; i++){
                if (table[i] == null){
                    table[i] = hashEntry;
                    currentSize++;
                    found = true;
                    break;
                }
                if (table[i].equals(hashEntry)) { //we don't have to change size if we have the same elements
                    table[i] = hashEntry;
                    found = true;
                    break;
                }
            }
            if (!found){//if there is no space we will have to resize a HashMap
                throw new ResizeHMExc();
            }
        }
    }

    /**
     * Method, which gets value by it's key
     *
     * @param key is a key of element which value you want to get
     * @return value of element you wanted
     * @throws NotFoundExc if element wasn't found
     * */
    public long get(int key) throws NotFoundExc {
        int index = hashCodeNew(key);
        for (int i = index; i < table.length; i++){
            if (table[i] != null){
                if(table[i].getKey() == key) {
                    return table[i].getValue();
                }
            }
        }
        throw new NotFoundExc();
    }

    /**
     * Method, which returns size of HashMap(Number of elements in it)
     * */
    public int size(){
        return currentSize;
    }

    /**
     * Method, which hashes an int number
     *
     * @param h is a number to be hashed
     * @return hashed number
     * */
    private int hashCodeNew(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        int hashCode = h ^ (h >>> 7) ^ (h >>> 4);
        return hashCode & (table.length-1);
    }

}

/**
 * The HashEntry class of element with key and value
 *
 * @author Ivan Feofanov
 * @version 1.0
 */
class HashEntry {
    private int key;
    private long value;

    /**
     * Constructor for HashEntry element
     * */
    public HashEntry(int key, Long value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Getter for key
     *
     * @return key
     * */
    public int getKey() {
        return this.key;
    }

    /**
     * Getter for value
     *
     * @return value
     * */
    public long getValue() {
        return this.value;
    }

    /**
     * Method for comparing keys of elements
     *
     * @return true is keys are identical, else false if not
     * */
    public boolean equals(HashEntry hs){
        return this.key == hs.getKey();
    }

}