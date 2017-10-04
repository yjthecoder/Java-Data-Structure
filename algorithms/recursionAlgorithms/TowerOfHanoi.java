package algorithms.recursionAlgorithms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TowerOfHanoi<T>{

	//////////
	//////////
	//////////
	//////////
	
	//empty constructor, just for calling initializing methods
	public TowerOfHanoi(){

	}

	private int numberOfLayers;

	private Object[] towerA;
	private Object[] towerB;
	private Object[] towerC;

	public int towerHeightOf(Object[] theTower){
		int result =0;
		for(Object current: theTower){
			if(current != null){
				result++;
			}
		}
		return result;
	}


	// initialize the arrays that holds the integer that represent the plate in tower
	public void setLayerNbr(int layerNbr){
		this.numberOfLayers = layerNbr;
		this.moveCount = 0;

		towerA = new Object[numberOfLayers];
		towerB = new Object[numberOfLayers];
		towerC = new Object[numberOfLayers];

		//initialize the tower A
		for(int i=0; i< numberOfLayers; i++){
			towerA[i] = new Integer(layerNbr--);
		}
	}

	//these are the plate shifting method
	//return the top most element of the tower
	//warning, you are not only get the top plate, but remove it from the original racket as well
	//specifications is the hardest stuff
	@SuppressWarnings("unchecked")
	public T getTopPlate(Object[] tower){
		Object lastElement = null;
		if(tower[tower.length-1] != null){
			lastElement = tower[tower.length-1];
		}
		for(int i=tower.length-1; i>-1; i--){
			if(tower[i] != null){
				lastElement = tower[i];
				tower[i] = null;
				break;
			}
		}
		return (T) lastElement;
	}

	// add a plate to a tower
	public void addToTop(T currentPlate, Object[] targetTower){
		for(int i=0; i< numberOfLayers; i++){
			if(targetTower[i] == null){
				targetTower[i] = currentPlate;
				return;
			}
		}
	}

	// move the top plate from one to another
	public void movePlate(Object[] originalTower, Object[] targetTower){
		addToTop(getTopPlate(originalTower), targetTower);
	}

	public Object[] getTowerByName(char name){
		Object[] result = null;
		switch(name){
		case 'A':
			result = towerA;
			break;

		case 'B':
			result = towerB;
			break;

		case 'C':
			result = towerC;
			break;
		default:
			break;

		}
		return result;
	}

	public void showTower(char name){
		Object[] currentTower = getTowerByName(name);
		for(int i=currentTower.length-1; i>-1; i--){
			if(currentTower[i] != null){
				System.out.println(currentTower[i].toString());
			}else{
				return;
			}
		}
	}

	/**
	 * in most scenarios, nested components plus layout manager can achieve what you want
	 */

	private int moveCount;

	///////
	///////
	///////
	///////



	private JFrame windowFrame; // top level container

	private JPanel promptPanel; // contains the following two panels
	private JLabel messageLabel;
	private JLabel moveCountLabel;
	
	private JPanel animationPanel;
	
	private JPanel bottomeStaticPanel;// contains the following two panels

	private JPanel buttonPanel; // contains the following
	private JButton startBtn;
	private JButton pauseBtn;
	private JButton quitBtn;

	private JPanel racketPanel;			// contains the following 3 panels, using grid panel
	private JLabel aLabel = new JLabel("A");
	private JLabel bLabel = new JLabel("B");
	private JLabel cLabel = new JLabel("C");



	//display the static background of the window
	public void display(){

		windowFrame = new JFrame("Tower of Hanoi");
		windowFrame.setSize(1200, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowFrame.setBackground(Color.white);
		Container frameContainer = windowFrame.getContentPane();

		//set up the prompt panel
		promptPanel = new JPanel(new BorderLayout());
		messageLabel = new JLabel("Click \"Start\" to see the move!                          ");
		moveCountLabel = new JLabel("Moves Count: "+ moveCount+"    ");
		Font messageFont = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		Font moveCountFont = new Font(Font.DIALOG, Font.BOLD, 15);
		messageLabel.setFont(messageFont);
		moveCountLabel.setFont(moveCountFont);
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moveCountLabel.setHorizontalAlignment(SwingConstants.LEFT);
		promptPanel.add(messageLabel,BorderLayout.CENTER);
		promptPanel.add(moveCountLabel,BorderLayout.EAST);

		//set up the animation panel
		// todo: back ground color to be changed
		animationPanel = new JPanel();
		animationPanel.setPreferredSize(new Dimension(1200, 700));
		animationPanel.setBackground(Color.lightGray);
		animationPanel.setLayout(new BorderLayout());


		//set up the racket panel 
		aLabel = new JLabel("Tower A");
		bLabel = new JLabel("Tower B");
		cLabel = new JLabel("Tower C");
		Font racketFont = new Font(Font.SERIF, Font.BOLD, 17);
		aLabel.setFont(racketFont);
		bLabel.setFont(racketFont);
		cLabel.setFont(racketFont);
		aLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cLabel.setHorizontalAlignment(SwingConstants.CENTER);

		racketPanel = new JPanel(new GridLayout(1, 3));
		racketPanel.add(aLabel);
		racketPanel.add(bLabel);
		racketPanel.add(cLabel);
		racketPanel.setBackground(Color.lightGray);

		//set up the button panel
		buttonPanel = new JPanel();
		startBtn = new JButton("Start");
		pauseBtn = new JButton("Pause");
		quitBtn = new JButton("Quit");

		
		startBtn.setEnabled(false);
		pauseBtn.setEnabled(false);
		quitBtn.setEnabled(true);
		
		buttonPanel.add(startBtn);
		buttonPanel.add(pauseBtn);
		buttonPanel.add(quitBtn);

		//set up the bottom panel
		bottomeStaticPanel = new JPanel(new BorderLayout());
		bottomeStaticPanel.add(racketPanel, BorderLayout.NORTH);
		bottomeStaticPanel.add(buttonPanel, BorderLayout.SOUTH);

		//set up the whole window frame
		frameContainer.add(promptPanel,BorderLayout.NORTH);
		frameContainer.add(animationPanel, BorderLayout.CENTER);
		frameContainer.add(bottomeStaticPanel, BorderLayout.SOUTH);

		//position the window frame on screen and display it
		windowFrame.setLocation(dim.width/2-windowFrame.getSize().width/2, dim.height/2-windowFrame.getSize().height/2);
		windowFrame.setVisible(true);
		
		///*******////
		///*******////
		///*******////
		///*******////
		//NOTE: since the constructor of the paintable panel needs animation panel's size, we need to make the JFrame render first
		PaintablePanel canvas = new PaintablePanel();// the panel actually do the animation

		animationPanel.add(canvas, BorderLayout.CENTER); //make the canvas take up the entire animation panel
		//Why make this nested structure, this way we can get size of the container.
		
		//this is vital, you must repaint after adding something to the container?
		//Other wise the change will not show up
		windowFrame.revalidate();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setUpActionListeners(){
		startBtn.addActionListener(new startBtnListener());
		pauseBtn.addActionListener(new pauseBtnListener());
		quitBtn.addActionListener(new quitBtnListener());
	}
	

	public void move(int numberOfPlates, char homeStack
			, char targetStack
			, char mediaStack ){

		
		if(numberOfPlates == 1){
			//debug
			//debug
			windowFrame.revalidate();
			windowFrame.repaint();
			System.out.println("repaint() get called");
			
			System.out.println("Move "+ numberOfPlates+" from Stack \'"+ homeStack+"\' to "+"Stack \'"+targetStack+"\'");
			//Truly needed
			messageLabel.setText("Move "+ numberOfPlates+" from Stack \'"+ homeStack+"\' to "+"Stack \'"+targetStack+"\'");
			movePlate(getTowerByName(homeStack), getTowerByName(targetStack));
			moveCount++;
			moveCountLabel.setText("Moves Count: "+ moveCount+"         ");


			//delay the move step for one second
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return;
		}

		
		move(numberOfPlates-1, homeStack, mediaStack, targetStack);
		
		
		//debug
		windowFrame.revalidate();
		windowFrame.repaint();
		
		System.out.println("Move "+ numberOfPlates+" from Stack \'"+ homeStack+"\' to "+"Stack \'"+targetStack+"\'");
		//debug
		messageLabel.setText("Move "+ numberOfPlates+" from Stack \'"+ homeStack+"\' to "+"Stack \'"+targetStack+"\'");
		movePlate(getTowerByName(homeStack), getTowerByName(targetStack));

		moveCount++;
		moveCountLabel.setText("Moves Count: "+ moveCount+"         ");

		//delay the move step
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		
		
		move(numberOfPlates-1, mediaStack, targetStack, homeStack);
	}

	
	@SuppressWarnings("serial")
	class PaintablePanel extends JPanel{

		//dimension constant
		private final int HORIZONTAL_UNIT = animationPanel.getWidth()/1200; // 10 pixel per unit
		private final int PLATE_THICKNESS = animationPanel.getHeight()/(numberOfLayers+1);
		private final int BORDER_WIDTH = 2;
		private final int VERTICAL_BAR_STARTING_X = HORIZONTAL_UNIT*200-5;
		private final int BAR_HEIGHT =PLATE_THICKNESS*(numberOfLayers+1) ;
		private final int VERTICAL_BAR_STARTING_Y = animationPanel.getHeight()-BAR_HEIGHT;
		private final int PLATE_WIDTH_UNIT = 300*HORIZONTAL_UNIT/numberOfLayers;

		//color constant
		private final Color PLATE_COLOR = Color.CYAN;
		private final Color PLATE_BORDER_COLOR = Color.DARK_GRAY;
		private final Color VERTICAL_BAR_COLOR = Color.black;
		private final Color CHARACTER_COLOR = Color.blue;



		@Override
		public void paint(Graphics g){
			//todo : paint three towers according to its current status
			//paint the vertical bar;
			g.setColor(VERTICAL_BAR_COLOR);
			for(int i=0; i<3;i++){
				g.fillRect(VERTICAL_BAR_STARTING_X+i*400*HORIZONTAL_UNIT
						,VERTICAL_BAR_STARTING_Y
						,10
						,BAR_HEIGHT);
			}
			//debug
			int AHeight = towerHeightOf(towerA);
			int BHeight = towerHeightOf(towerB);
			int CHeight = towerHeightOf(towerC);



			for(int i=0; i<AHeight; i++){
				Integer currentPlate = (Integer)towerA[i];
				//NOTE: cast to double then cast back to int, make sure there is always something to display
				int outterX= (int) (200*HORIZONTAL_UNIT - ((double)currentPlate.intValue())/2*PLATE_WIDTH_UNIT);
				int outterY= animationPanel.getHeight() - PLATE_THICKNESS*(i+1); //the shifting amount of outterY relates to the layers accumulated
				int outterWidth = currentPlate.intValue()*PLATE_WIDTH_UNIT;
				int outterHeight = PLATE_THICKNESS;
				int innerX = outterX+BORDER_WIDTH;
				int innerY = outterY+BORDER_WIDTH;
				int innerWidth = outterWidth - 2*BORDER_WIDTH;
				int innerHeight = outterHeight - 2*BORDER_WIDTH;
				int centerX = 200*HORIZONTAL_UNIT;
				int centerY = outterY+PLATE_THICKNESS/2;
				Font characterFont = new Font(Font.SERIF, Font.BOLD, PLATE_THICKNESS/4);
				g.setColor(PLATE_BORDER_COLOR);
				g.fillRect(outterX, outterY, outterWidth, outterHeight);
				g.setColor(PLATE_COLOR);
				g.fillRect(innerX, innerY, innerWidth, innerHeight);
				g.setColor(CHARACTER_COLOR);
				g.setFont(characterFont);
				g.drawString(currentPlate.toString(), centerX-characterFont.getSize()/3, centerY+characterFont.getSize()/4);
			}

			for(int i=0; i<BHeight; i++){
				Integer currentPlate = (Integer)towerB[i];
				//NOTE: cast to double then cast back to int, make sure there is always something to display
				int outterX= (int) (600*HORIZONTAL_UNIT - ((double)currentPlate.intValue())/2*PLATE_WIDTH_UNIT);
				int outterY= animationPanel.getHeight() - PLATE_THICKNESS*(i+1); //the shifting amount of outterY relates to the layers accumulated
				int outterWidth = currentPlate.intValue()*PLATE_WIDTH_UNIT;
				int outterHeight = PLATE_THICKNESS;
				int innerX = outterX+BORDER_WIDTH;
				int innerY = outterY+BORDER_WIDTH;
				int innerWidth = outterWidth - 2*BORDER_WIDTH;
				int innerHeight = outterHeight - 2*BORDER_WIDTH;
				g.setColor(PLATE_BORDER_COLOR);
				g.fillRect(outterX, outterY, outterWidth, outterHeight);
				g.setColor(PLATE_COLOR);
				g.fillRect(innerX, innerY, innerWidth, innerHeight);
				int centerX = 600*HORIZONTAL_UNIT;
				int centerY = outterY+PLATE_THICKNESS/2;
				Font characterFont = new Font(Font.SERIF, Font.BOLD, PLATE_THICKNESS/4);
				g.setColor(CHARACTER_COLOR);
				g.setFont(characterFont);
				g.drawString(currentPlate.toString(), centerX-characterFont.getSize()/3, centerY+characterFont.getSize()/4);
			}

			for(int i=0; i<CHeight; i++){
				Integer currentPlate = (Integer)towerC[i];
				//NOTE: cast to double then cast back to int, make sure there is always something to display
				int outterX= (int) (1000*HORIZONTAL_UNIT - ((double)currentPlate.intValue())/2*PLATE_WIDTH_UNIT);
				int outterY= animationPanel.getHeight() - PLATE_THICKNESS*(i+1); //the shifting amount of outterY relates to the layers accumulated
				int outterWidth = currentPlate.intValue()*PLATE_WIDTH_UNIT;
				int outterHeight = PLATE_THICKNESS;
				int innerX = outterX+BORDER_WIDTH;
				int innerY = outterY+BORDER_WIDTH;
				int innerWidth = outterWidth - 2*BORDER_WIDTH;
				int innerHeight = outterHeight - 2*BORDER_WIDTH;
				g.setColor(PLATE_BORDER_COLOR);
				g.fillRect(outterX, outterY, outterWidth, outterHeight);
				g.setColor(PLATE_COLOR);
				g.fillRect(innerX, innerY, innerWidth, innerHeight);
				int centerX = 1000*HORIZONTAL_UNIT;
				int centerY = outterY+PLATE_THICKNESS/2;
				Font characterFont = new Font(Font.SERIF, Font.BOLD, PLATE_THICKNESS/4);
				g.setColor(CHARACTER_COLOR);
				g.setFont(characterFont);
				g.drawString(currentPlate.toString(), centerX-characterFont.getSize()/3, centerY+characterFont.getSize()/4);
			}

		}
	}



	/**
	 * This method prints out the steps to achieve Hanoi Tower
	 * 
	 * @param numberOfPlates  how many plates are in the number
	 * @param homeStack		  
	 * @param aimStack
	 * @param mediaStack
	 */
	

	
	class startBtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			startBtn.setEnabled(false);
			pauseBtn.setEnabled(true);
			quitBtn.setEnabled(true);
			
			System.out.println("move started");
			System.out.println(startBtn.getText());			

	    	move(numberOfLayers, 'A', 'C', 'B');
//			windowFrame.revalidate();
//			windowFrame.repaint();
//			System.out.println("move finished");
		}

	}

	// to be fixed
	class pauseBtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String status = "";
			if(pauseBtn.getText() == "Pause"){
				pauseBtn.setText("Resume");
				status = "Resume";
			}else{
				pauseBtn.setText("Pause");
			}
			
			//hang up the current thread
			while(status != "Resume"){

				try {
					Thread.sleep(250);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	}

	class quitBtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			userChoseQuit();
		}

	}


	
	
	////////////////
	////////////////
	////////////////
	
	
	//check if the input string represent a valid integer
	public boolean isAValidInteger(String rawInput) {
		try {
			Integer.parseInt(rawInput);// throw exception if rawInput is not
			// integer
			return true;

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Input must be an integer",
					"Invalid input", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}

	// This method show a message if the user click cancel during the execution
	// of the program
	// and terminate the program
	public void userChoseQuit() {
		JOptionPane.showMessageDialog(null,
				"Program terminated by user before finish execution.",
				"Program exit successfully, good bye! ", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	//recursively validating the input
	public int getInput(){
		String userInputLayersNbr = JOptionPane.showInputDialog(null,
				"Please Enter the Number Of Layers of Hanoi Tower:",
				"Wecome To Tower Of Hanoi Animation", JOptionPane.QUESTION_MESSAGE);

		if(userInputLayersNbr == null){
			this.userChoseQuit();
			return -1;
		}else{
			if(this.isAValidInteger(userInputLayersNbr)){
				int layerNbr = Integer.parseInt(userInputLayersNbr);
				if(layerNbr >= 1){
					return layerNbr;
				}else{
					JOptionPane.showMessageDialog(null,
							"Number of layers must be an integer greater than 0",
							"Try Again Please", JOptionPane.WARNING_MESSAGE);

					return this.getInput();
				}
			}
			return this.getInput();
		}

	}

	/////////////////
	/////////////////
	/////////////////



	public static void main(String[] args){


		TowerOfHanoi<Integer> theTower = new TowerOfHanoi<>();
		int layerNbr =theTower.getInput();
		theTower.setLayerNbr(layerNbr);

		theTower.display();
		theTower.setUpActionListeners();
		//let us use the button to call move now
		theTower.move(layerNbr, 'A', 'C', 'B');

		return;

	}

}
