package org.addressbook.main;
import org.addressbook.storage.*;

public class Test{
  public static void main(String[] args){
    MutableList<Contact> list = new AddressBook();
    list.addEntry(new Contact("Henrik Sandklef", "hesa@apa", "1234"));
    list.addEntry(new Contact("Rikard Fröberg", "rikard@apa", "666"));
    list.addEntry(new Contact("Adam Ant", "someone@apa", "00000"));
    list.listEntries();
    System.out.println("Testing contains...");
    System.out.println(list.contains(new Contact("Adam Ant", "someone@apa", "00000")));
    Contact adam = new Contact("Adam Ant", "someone@apa", "00000");    
    System.out.println("Changing email of adam ant...");
    list.replaceEntry(adam,adam.changeEmail("adam@the.ants"));
    list.listEntries();
  }
}
