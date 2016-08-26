package org.addressbook.storage;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.Iterator;

public class AddressBook implements MutableList<Contact>{

  private static final String ADDRESS_FILE = 
    System.getProperty("user.home") +
    System.getProperty("file.separator") +
    ".address_book";
  
  private List<Contact> entries;
  
  public AddressBook(){
    entries = new ArrayList<>();
  }
  
  public Contact getEntry(int index){
    return entries.get(index);
  }
  
  public Iterator<Contact> search(String query){    
    ArrayList<Contact> results = new ArrayList<>();
    for(Contact c : entries){
      if(c.name().toLowerCase()
         .startsWith(query.toLowerCase())){
        results.add(c);
      }
    }
    return results.iterator();
  }

  public int numberOfEntries(){
    return entries.size();
  }

  public void listEntries(){
    List<Contact> copy = new ArrayList<>(entries);
    Collections.sort(copy);
    int entryNumber = 0;
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

  @SuppressWarnings("unchecked")
  public void load(){
    try{
      if (!new File(ADDRESS_FILE).exists()){
        System.out.println("INFO: There is no address book file.");
        return;
      }
      ObjectInputStream in = 
        new ObjectInputStream(new FileInputStream
                              (ADDRESS_FILE));
      Contact c;
      entries = (List<Contact>)in.readObject();
      in.close();
    }catch(Exception e){
      System.err.println("Could not load address book");
      try{
        e.printStackTrace(new PrintWriter(new FileWriter("/home/rikard/addressbook.log"),true));
      }catch(Exception ignoramus){
        System.err.println("error log couldn't be written");
      }
      throw new RuntimeException("Your address book is corrupted.");
    }
  }
  public void save(){
    try{
      System.out.println("Saving in " + ADDRESS_FILE + "...");
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ADDRESS_FILE));
      out.writeObject(entries);
      out.close();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
