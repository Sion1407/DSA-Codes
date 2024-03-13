package Exercises.hashTable;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.set("nails",100);
        hashTable.set("screws",200);
        hashTable.set("adsra",300);
        hashTable.printTable();

        System.out.println("searching in hashtable for value of nails: "+ hashTable.get("adsra"));

        System.out.println("Printing all the keys in the datamap: "+ hashTable.getKeys());

    }
}
