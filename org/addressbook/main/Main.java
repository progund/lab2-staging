package org.addressbook.main;

public class Main{
  public static void main(String[] args){
    try{
      new Application().start();
    }catch(Exception e){
      System.err.println("Fatal error. Please see logfile...bla");
    }

  }
}
