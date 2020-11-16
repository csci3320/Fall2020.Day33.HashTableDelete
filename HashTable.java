import java.util.ArrayList;
import java.util.List;

public class HashTable<T> {
    int tableLength = 1;
    int entries = 0;
    List<T>[] hashTable = (List<T>[])new ArrayList[tableLength];

    public HashTable() {
        for(int i = 0; i < hashTable.length; i++){
            hashTable[i] = new ArrayList<T>();
        }

    }

    public void add(T object) {
        int hash = hashObject(object);
        hashTable[hash].add(object);
        entries++;
        rehash();
    }

    private void rehash(){
        //Check to see if we need to rehash
        if(entries >= tableLength){
            System.out.println("I need to rehash " + tableLength);
            int newTableLength = tableLength * 2+1;
            // int newTableLength = tableLength << 1 + 1;
            List<T>[] newHashTable = (List<T>[])new ArrayList[newTableLength];
            for(int i = 0; i < newHashTable.length; i++){
                newHashTable[i] = new ArrayList<T>();
            }

            //Go through my current (old) table and put things in the new table
            for(int i = 0; i < tableLength; i++){
                List<T> tableEntry = hashTable[i];
                for(int j = 0; j < tableEntry.size(); j++){
                    T object = tableEntry.get(j);
                    int newHash = hashObject(object, newTableLength);
                    newHashTable[newHash].add(object);
                }
            }
            hashTable = newHashTable;
            tableLength = newTableLength;
        }
        //else do nothing
    }

    public void remove(T object){
        // Find out which list should contain this object.
        int hash = hashObject(object);

        //Then remove it from that list.
        hashTable[hash].remove(object);
    }

    private int hashObject(T object, int mod){
        return Math.abs(object.hashCode()) % mod;
    }

    public int hashObject(T object){
        return hashObject(object, tableLength);
    }

    

    public void print() {
        for (int i = 0; i < hashTable.length; i++) {
            List<T> hashTableEntries = hashTable[i];
            System.out.println("Hash entry for index " + i);
            for(int j = 0; j < hashTableEntries.size(); j++){
                System.out.println(" " + hashTableEntries.get(j));
            }
        }
    }

	public boolean contains(T object) {
		int hash = hashObject(object);
        return hashTable[hash].contains(object);
	}

}
