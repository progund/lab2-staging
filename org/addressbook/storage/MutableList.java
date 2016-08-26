package org.addressbook.storage;
import java.util.Iterator;

public interface MutableList<E>{
  public Iterator<E> search(String q);
  public int numberOfEntries();
  public void listEntries();
  public void addEntry(E entry);
  public boolean contains(E entry);
  public void removeEntry(E entry);
  public void replaceEntry(E oldEntry, E newEntry);
  public void save();  
  public void load();
  public E getEntry(int index);
}
