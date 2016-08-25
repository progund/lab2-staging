package org.addressbook.storage;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

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
  public void load(){
    try{
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("/tmp/addressbook.apa"));
      Contact c;
      entries = (List<Contact>)in.readObject();
      /*
      while( (c=(Contact)in.readObject())!=null){
        entries.add(c);
      }
      */
      in.close();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public void save(){
    try{
      System.out.println("Saving in /tmp/addressbook.apa ...");
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/tmp/addressbook.apa"));
      out.writeObject(entries);
      /*
      for(Contact c : entries){
        out.writeObject(c);
      }
      */
      out.close();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
