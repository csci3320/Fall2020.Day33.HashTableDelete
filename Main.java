class Main {
  public static void main(String[] args) {
    new Main();
  }

 
  public Main() {
    HashTable<String> hashTable = new HashTable<String>();
    
    String[] strings = { "Happy", "Veterans", "Day", "computer", "science", "csci", "3320", "data", "structures" };
    for (int i = 0; i < strings.length; i++) {
      String string = strings[i];
      hashTable.add(string);
    }
    
    hashTable.remove("data");

    hashTable.print();

    System.out.println(hashTable.contains("Happy"));
    System.out.println(hashTable.contains("Sad"));
  }

  
}
