package org.addressbook.main;
import org.addressbook.storage.*;
import org.addressbook.ui.cli.menu.Menu;
import org.addressbook.ui.cli.menu.MenuAction;

public class Application{
  private MutableList<Contact> list = new AddressBook();
  private Menu menu = new Menu("Address book");
  private void createMenu(){
    menu.addMenuItem("List", new MenuAction(){
        public void onItemSelected(){
          list.listEntries();
        }
      });
    menu.addMenuItem("Load", new MenuAction(){
        public void onItemSelected(){
          list.load();
        }
      });
    menu.addMenuItem("Fill", new MenuAction(){
        public void onItemSelected(){
          list.addEntry(new Contact("Henrik Sandklef", "hesa@apa", "1234"));
          list.addEntry(new Contact("Rikard Fröberg", "rikard@apa", "666"));
          list.addEntry(new Contact("Adam Ant", "someone@apa", "00000"));
          list.save();
        }
      });
    menu.addMenuItem("Add", new MenuAction(){
        public void onItemSelected(){
          list.addEntry(new Contact("Henrik Sandklef", "hesa@apa", "1234"));
          list.addEntry(new Contact("Rikard Fröberg", "rikard@apa", "666"));
          list.addEntry(new Contact("Adam Ant", "someone@apa", "00000"));
          list.save();
        }
      });
  }
  public void start(){
    createMenu();
    menu.start();
  }
}
