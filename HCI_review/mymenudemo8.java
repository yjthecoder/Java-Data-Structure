package HCI_review;

import java.awt.event.*;
import javax.swing.*;
public class mymenudemo8 extends JFrame {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public mymenudemo8() { init(); }
 private void init() {
  setTitle("Simple menu");
  setSize(300, 200);

  JMenuItem item1a = new JMenuItem("Hello");
  item1a.addActionListener( (ActionEvent event)->{System.out.println("Hello!");} );

  JMenuItem item1b = new JMenuItem("About");
  JMenuItem item1e = new JMenuItem("Exit");
  item1b.addActionListener( (ActionEvent event)->{System.out.println("What about?");}  );
  item1e.addActionListener( (ActionEvent event)->{System.exit(0);} );

  JMenu mymenu1 = new JMenu("mymenu1");
  mymenu1.add(item1a);
  mymenu1.add(item1b);
  mymenu1.add(item1e);

  JMenu mymenu2 = new JMenu("vote");
  JMenuItem item2a = new JMenuItem("DEM");
  JMenuItem item2b = new JMenuItem("GOP");
  item2a.addActionListener( (ActionEvent event)->
                   { item1e.addActionListener(  (ActionEvent event2)->{System.exit(0); }  ); } );
  item2b.addActionListener( (ActionEvent event)->
                   { for( ActionListener j : item1e.getActionListeners() )
                                    item1e.removeActionListener( j ); } );
  mymenu2.add(item2a);
  mymenu2.add(item2b);
  mymenu2.add( new JMenuItem("neither"));
  mymenu2.add(item1e);
  mymenu1.add(item1e);

  JMenuBar menubar = new JMenuBar();
  menubar.add(mymenu1);
  menubar.add(mymenu2);
  setJMenuBar(menubar);
 } 
 public static void main(String[] args) {
  mymenudemo8 applic = new mymenudemo8();
  applic.setVisible(true);
 }
}

// "C:\Program Files (x86)\Java\jdk1.7.0_79\bin\javac" mymenudemo8.java
//


// You can even nest a lambda within a lambda (as long as you don't use the same parameter name:
// and the code in {braces} can be arbitrarily large:

// This line could be added to the JFrame:
//  setDefaultCloseOperation(EXIT_ON_CLOSE);

// if you have Java 8, you might consider using a lambda espression:
// item1e.addActionListener( (ActionEvent event)->{System.exit(0);} );
// 
// C:\Users\eagleson\javaexperiments>"C:\Program Files\Java\jdk1.8.0_121\bin\javac" mymenudemo8.java
// C:\Users\eagleson\javaexperiments>"C:\Program Files\Java\jdk1.8.0_121\bin\java" mymenudemo8



// keyboard accelerator for one of the menus:
//  mymenu1.setMnemonic(KeyEvent.VK_F);

// tooltips can be added:
//  item1a.setToolTipText("Exit application");