package org.addressbook.ui.cli.menu;
import java.util.Date;

public class MenuExample{
  public static void main(String[] args){
    Menu m = new Menu("this is a menu");
    m.addMenuItem("Print today's date", new MenuAction(){
        public void onItemSelected(){
          System.out.println(new Date());
        }
      });
    m.addMenuItem("Print system info", new MenuAction(){
        public void onItemSelected(){
          System.out.println(System.getProperties().get("os.name")
                             + " - Java: " 
                             + System.getProperties().get("java.version"));
        }
      });
    m.addMenuItem("Say hello", new MenuAction(){
        public void onItemSelected(){
          System.out.println("Hello");
        }
      });
    m.start();
  }
}
