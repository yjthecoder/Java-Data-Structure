package HCI_review;



import java.awt.event.*;
import javax.swing.*;
public class cascade8 extends JFrame {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public cascade8() { init(); }

 private void init() {
  setTitle("Simple menu");
  setSize(300, 200);

  JMenuItem item1a = new JMenuItem("Hello");
  
  item1a.addActionListener( (ActionEvent event)->{System.out.println("Hello!");} );

  JMenuItem item1b = new JMenuItem("About");
  JMenuItem item1e = new JMenuItem("Exit");
  item1b.addActionListener( (ActionEvent event)->{System.out.println("What about?");}  );
  item1e.addActionListener( (ActionEvent event)->{
	  							System.out.println("Binding Program Exiting");
	  							
	  							item1e.addActionListener(  (ActionEvent event2)->{
	  								System.out.println("Program Exiting2");
	  		                	   System.out.println("Program new Exiting"); 
	  		                	   System.exit(0);});
	  							
	  							} );
  
  item1e.addActionListener( (ActionEvent event)->{
		System.out.println("2 Binding Program Exiting");});
  
  
  item1e.setToolTipText("Exit application");

  JMenu mymenu1 = new JMenu("mymenu1");
  mymenu1.add(item1a);
  mymenu1.add(item1b);
  mymenu1.add(item1e);
  
  /////
  mymenu1.setMnemonic(KeyEvent.VK_F); //alt + f trigger the menu

  
  JMenu mymenu2 = new JMenu("vote");
  JMenuItem item2a = new JMenuItem("DEM");
  JMenuItem item2b = new JMenuItem("GOP");
  
  ///////
  ///////
  ///////
  ///////
  //item1a.addActionListener( (ActionEvent event)->{ //things to do when item1a raise an event} );
  //thins inside {} can be another item1a.addActionListener(ActionEvent event2)->{ //things to do when item1a raise an event} 
  
  
  // () -> {}   is equivalent to a instantiation of an anonymous class
  
  //like 
  /*
  new Comparator<Person>(){
  	public int compare(Person p1, Person p2){
    	return p1.firstName.compareTo(p2.firstName);
  	}
  }
  	
  
  */
  //or
  /*
  new HelloWorld() {
       String name = "tout le monde";
       public void greet() {
         greetSomeone("tout le monde");
       }
       public void greetSomeone(String someone) {
          name = someone;
          System.out.println("Salut " + name);
       }
   }  
   
   */
  
  
  
  
//You can even nest a lambda within a lambda (as long as you don't use the same parameter name:
//and the code in {braces} can be arbitrarily large:
  
  
  
  
  item2a.addActionListener( (ActionEvent event)->
                   { 
                	   System.out.println("Set Exit button's functionalty");
                	   item1e.addActionListener(  (ActionEvent event2)->{
                	   System.out.println("Program new Exiting"); 
                	   System.exit(0); }  ); } );
  
  
  //when event raised by item2b, remove the actionlisteners of item1e
  item2b.addActionListener( (ActionEvent event)->
                   { for( ActionListener j : item1e.getActionListeners() ){
                	   System.out.println("remove Exit button's functionalty");
                                    item1e.removeActionListener( j );} } );
  mymenu2.add(item2a);
  mymenu2.add(item2b);
  mymenu2.add( new JMenuItem("neither"));

  JMenu extramenu = new JMenu("extras");
  JMenuItem item3a = new JMenuItem("more");
  JMenuItem item3b = new JMenuItem("stuff");
  JMenuItem item3c = new JMenuItem("here");
  extramenu.add(item3a);
  extramenu.add(item3b);
  extramenu.add(item3c);
  mymenu2.add( extramenu );

  //make JMenuItem, make JMenu, add JMenuItem s to JMenu, make JMenuBar, add JMenu s to JMenuBar
  
  // finally, setJMenuBar in a JFrame
  
  //memu can be nested, not menuitem !
  
  
  JMenuBar menubar = new JMenuBar();
  menubar.add(mymenu1);
  menubar.add(mymenu2);
  this.setJMenuBar(menubar);
  
 } 
 public static void main(String[] args) {
  cascade8 applic = new cascade8();
  
  /////
  /////do not forget
  applic.setVisible(true);
 }
}









 


