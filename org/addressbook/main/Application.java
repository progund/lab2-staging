package org.addressbook.main;
import org.addressbook.storage.*;
import org.addressbook.ui.cli.menu.Menu;
import org.addressbook.ui.cli.menu.MenuAction;
import java.util.Iterator;

public class Application{
  private MutableList<Contact> list;
  private Menu menu = new Menu("Address book");
  public Application(){
    list = new AddressBook();
    list.load();
    System.out.println(list.numberOfEntries() +
                       " items loaded from file.");
  }
  private void createMenu(){
    menu.addMenuItem("List", new MenuAction(){
        public void onItemSelected(){
          list.listEntries();
        }
      });
    menu.addMenuItem("Search", new MenuAction(){
        public void onItemSelected(){
          System.out.print("Search: ");
          String query = System.console().readLine();
          Iterator<Contact> it = list.search(query);
          if(!it.hasNext()){
            System.out.println("No results for " + query);
            return;
          }
          System.out.println("Matches for " + query + ":");
          
          while(it.hasNext()){
            Contact c = it.next();
            System.out.println(c);
          }
        }
      });
    menu.addMenuItem("Add", new MenuAction(){
        public void onItemSelected(){

          System.out.print("Name: ");
          String name = System.console().readLine();
          System.out.print("Email: ");
          String email = System.console().readLine();
          System.out.print("Phone: ");
          String phone = System.console().readLine();          
          list.addEntry(new Contact(name, email, phone));
          list.save();

        }
      });
    menu.addMenuItem("Delete", new MenuAction(){
        public void onItemSelected(){
          list.listEntries();
          System.out.print("Enter the name of the person to delete: ");
          String name = System.console().readLine();
          Contact c = new Contact(name,null, null);
          while(!list.contains(c)){
            System.out.print("Name not found. Try another: ");
            name = System.console().readLine();
            c = new Contact(name,null, null);
          }
          System.out.println("Deleting " + name + "...");
          list.removeEntry(c);
          list.save();
        }
      });
  }
  public void start(){
    createMenu();
    menu.start();
  }
}
