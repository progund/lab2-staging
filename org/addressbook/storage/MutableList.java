package org.addressbook.storage;

public interface MutableList<E>{
  public void listEntries();
  public void addEntry(E entry);
  public boolean contains(E entry);
  public void removeEntry(E entry);
  public void replaceEntry(E oldEntry, E newEntry);
  public void save();  
  public void load();
}
