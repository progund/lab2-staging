package org.addressbook.storage;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class AddressBook implements MutableList<Contact>{
  private List<Contact> entries;
  
  public AddressBook(){
    entries = new ArrayList<>();
  }
  
  public void listEntries(){
    List<Contact> copy = new ArrayList<>(entries);
    Collections.sort(copy);
    for(Contact c : copy){
      System.out.println(c);
    }
  }

  public void addEntry(Contact c){
    entries.add(c);
  }

  public boolean contains(Contact c){
    return entries.contains(c);
  }

  public void removeEntry(Contact c){
    entries.remove(c);
  }
  public void replaceEntry(Contact old, Contact newContact){
    entries.remove(old);
    entries.add(newContact);
  }
  public void save(){
    System.out.println("Saving.... totally fake...");
  }
}
