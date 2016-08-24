package org.addressbook.storage;
import java.io.Serializable;

public final class Contact implements Serializable, Comparable<Contact>{
  private final String name;
  private final String email;
  private final String phone;
  public Contact(String name, String email, String phone){
    this.name  = name;
    this.email = email;
    this.phone = phone;
  }
  public String name() { return name; }
  public String email(){ return email; }
  public String phone(){ return phone; }

  public Contact changeName(String newName){
    return new Contact(newName, email, phone);
  }

  public Contact changeEmail(String newEmail){
    return new Contact(name, newEmail, phone);
  }
  
  public Contact changePhone(String newPhone){
    return new Contact(name, email, newPhone);
  }
  
  @Override
  public String toString(){
    return name + " " + email + " " + phone; 
  }
  
  @Override
  public int compareTo(Contact other){
    // TODO: Handle null
    return name.compareTo(other.name);
  }
  
  @Override
  public boolean equals(Object other){
    if(other == null || !(other instanceof Contact)){
      return false;
    }
    Contact otherContact = (Contact)other;
    return otherContact.name.equals(name) 
      && otherContact.email.equals(email) 
      && otherContact.phone.equals(phone);
  }
  @Override
  public int hashCode(){
    return 31*name.hashCode() * email.hashCode()
      * phone.hashCode();
  }
}
