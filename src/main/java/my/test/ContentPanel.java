/*
 * ContentPanel.java
 * CS 321 Team 9 Fall 2020
 * Creates the ContentPanel class for the Map Class to build GUI
 * Apart of main.java.my.test package so it can use other classes in package
 */
package main.java.my.test;

/**
 * Import statements that allow graphical content and functionality in class
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 * Extends JPanel to represent panel for GUI items Implements ActionListener to
 * allow action based on user button click
 */
public class ContentPanel extends JPanel implements ActionListener
{
	/**
	 * Constructs the panel of the application where the GUI items will be and
	 * the user will interact with
         * includes instances of classes in order to use methods and pass to Map
	 */
	public ContentPanel(Player player, Enemy enemy, Item item)
	{
                this.user = player;
                this.guard = enemy;
                this.object = item;
                eTimer = new Timer(750, this);
		/**
		 * Panel dimensions and attributes layout null so items determine
		 * placement individually arbitrary initial dimensions on personal
		 * computer
		 */
		Dimension dim = new Dimension(940, 640);
		setMinimumSize(dim);
		setPreferredSize(dim);
		setLayout(null);
		setBackground(Color.white);

		/**
		 * Try-Catch block for file read by ImageIO in case of exception throw
		 */
		try
		{
			backgroundImage = ImageIO.read(new File("assets/map silhouette.png"));
                        northImage = ImageIO.read(new File("assets/north.png"));
                        eastImage = ImageIO.read(new File("assets/east.png"));
                        westImage = ImageIO.read(new File("assets/west.png"));
                        southImage = ImageIO.read(new File("assets/south.png"));
                        
		} catch (IOException e)
		{
			System.out.println("Incorrect Image");
		}

		/**
		 * Label1 placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer
		 */
		label1 = new JLabel("Dungeon Crawler");
		Dimension size = label1.getPreferredSize();
		label1.setBounds(80, 240, size.width, size.height);
		add(label1);
                label1.setVisible(true);

		/**
		 * Label2 placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer
		 */
		label2 = new JLabel("Welcome to the Dungeon.");
		size = label2.getPreferredSize();
		label2.setBounds(45, 255, size.width, size.height);
		add(label2);
                label2.setVisible(true);
                
		/**
		 * Label3 placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer
		 */
		label3 = new JLabel("Enter your name for the leaderboard.");
		size = label3.getPreferredSize();
		label3.setBounds(10, 270, size.width, size.height);
		add(label3);
                label3.setVisible(true);
                
                /**
		 * Label4 placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer
		 */
		label4 = new JLabel("");
		add(label4);
                label4.setVisible(false);
                
                /**
		 * Label5 placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer
		 */
		label5 = new JLabel("<html>Press Play to Start the Game.<br/>"
                                    + " Press Help to see Game instructions.");
		size = label5.getPreferredSize();
		label5.setBounds(10, 290, size.width, size.height);
		add(label5);
                label5.setVisible(false);
                
		/**
		 * Play Button placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer left in for possible later
		 * use
		 */
		play = new JButton("Play");
                size = play.getPreferredSize();
                play.setBounds(100, 335, size.width, (size.height+10));
                play.addActionListener(this);
                add(play);
                play.setVisible(false);
                
                /**
		 * Help Button placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer left in for possible later
		 * use
		 */
		help = new JButton("Help");
                size = help.getPreferredSize();
                help.setBounds(10, 15, size.width, (size.height+10));
                help.addActionListener(this);
                add(help);
                help.setVisible(false);
                
                /**
		 * Leaderboard Button placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer left in for possible later
		 * use
		 */
		leaderboard = new JButton("Leaderboard");
                size = leaderboard.getPreferredSize();
                leaderboard.setBounds(10, 15, size.width, (size.height+10));
                leaderboard.addActionListener(this);
                add(leaderboard);
                leaderboard.setVisible(true);
                
		/**
		 * Text Field placement and attributes add to panel for display and
		 * function to take user input and save to file arbitrary initial
		 * dimensions on personal computer
		 */
		nameEntry = new JTextField(20);
		nameEntry.addActionListener(this);
		size = nameEntry.getPreferredSize();
		nameEntry.setBounds(25, 285, size.width, size.height);
		add(nameEntry);
                
                /**
		 * North Button placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer left in for possible later
		 * use
		 */
		north = new JButton(new ImageIcon(northImage));
                size = north.getPreferredSize();
                north.setBounds(95, 440, (size.width-20), size.height);
                north.addActionListener(this);
                add(north);
                north.setVisible(false);
                
                /**
		 * East Button placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer left in for possible later
		 * use
		 */
		east = new JButton(new ImageIcon(eastImage));
                size = east.getPreferredSize();
                east.setBounds(185, 520, (size.width-20), size.height);
                east.addActionListener(this);
                add(east);
                east.setVisible(false);
                
                /**
		 * West Button placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer left in for possible later
		 * use
		 */
		west = new JButton(new ImageIcon(westImage));
                size = west.getPreferredSize();
                west.setBounds(10, 520, (size.width-20), size.height);
                west.addActionListener(this);
                add(west);
                west.setVisible(false);
                
                /**
		 * South Button placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer left in for possible later
		 * use
		 */
		south = new JButton(new ImageIcon(southImage));
                size = south.getPreferredSize();
                south.setBounds(95, 520, (size.width-20), size.height);
                south.addActionListener(this);
                add(south);
                south.setVisible(false);
	}

	/**
	 * References super method and overrides functionality Draws the image onto
	 * screen with dimensions parameter drawer uses Graphics class to draw images
	 */
	@Override
	public void paintComponent(Graphics drawer)
	{
		super.paintComponent(drawer);
		drawer.drawImage(backgroundImage, 300, 0, 640, 640, this);
		drawer.drawImage(playerImage, playerX, playerY, PERSONDIM, PERSONDIM, this);
		drawer.drawImage(enemy1Image, SQUARE3X-PERSONDIM, enemy1Y, PERSONDIM, PERSONDIM, this);
		drawer.drawImage(enemy2Image, SQUARE7X-PERSONDIM, enemy2Y, PERSONDIM, PERSONDIM, this);
		drawer.drawImage(armorImage, SQUARE4X-ITEMDIM, SQUARE7Y-ITEMDIM, ITEMDIM, ITEMDIM, this);
		drawer.drawImage(lootImage, SQUARE7X-ITEMDIM, SQUARE7Y-ITEMDIM, ITEMDIM, ITEMDIM, this);
		drawer.drawImage(potionImage, SQUARE7X-ITEMDIM, SQUARE1Y-ITEMDIM,POTIONDIM, POTIONDIM, this);
		drawer.drawImage(swordImage, SQUARE6X-ITEMDIM, SQUARE0Y-PERSONDIM, ITEMDIM, ITEMDIM, this);
	}

	/**
	 * Method for actions to be performed based on ActionEvent
	 * overridden from ActionListener interface parameter e is input action
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
            Dimension size;
		/**
                 * nameEntry entry field ActionEvent on enter
                 * Clears scores.txt if leaderboard is greater than  or equal to 6
                 * Copies user input name along with initial score to scores.txt
                 * Shows label4 with Greeting and label5 with direction
                 * Shows play and help buttons
                 * hides leaderboard button, extra labels and nameEntry text field
                 */
                if (e.getSource() == nameEntry)
		{
			user = new Player();
                        user.setScore(0);
                        String input = nameEntry.getText();
			nameEntry.selectAll();
			nameSave = new Save();
                        nameSave.lineCheck();
			nameSave.write(input, user);
                        
                        label1.setVisible(false);
                        label2.setVisible(false);
                        label3.setVisible(false);
                        
                        label4.setText("Hello " + nameSave.getName(nameSave.namesSize()-1) + ".");
                        size = label4.getPreferredSize();
                        label4.setBounds(10, 270, size.width, size.height);
                        label4.setVisible(true);
                        
                        label5.setVisible(true);
                        
                        nameEntry.setVisible(false);
                        leaderboard.setVisible(false);
                        help.setVisible(true);
                        play.setVisible(true);
		}
                
                /**
                 * Play Button ActionEvent on click
                 * Shows health and score labels
                 * Paints game level with entities
                 * Starts Timer and establishes instances
                 * hides help button, extra labels and play button
                 */
                if (e.getSource() == play)
                {
                        user = new Player();
                        guard = new Enemy();
                        object = new Item();
                        
                        north.setVisible(true);
                        east.setVisible(true);
                        west.setVisible(true);
                        south.setVisible(true);
                        
                        label4.setVisible(false);
                        label5.setVisible(false);
                        
                        help.setVisible(false);
                        
                        label1.setText("Health: " + user.getHealth());
                        size = label1.getPreferredSize();
                        label1.setBounds(10, 270, size.width, size.height);

                        label2.setText("Score: " + user.getScore());
                        size = label2.getPreferredSize();
                        label2.setBounds(10, 290, size.width, size.height);

                        label1.setVisible(true);
                        label2.setVisible(true);
                        play.setVisible(false);
                        
                        /**
                         * Try-Catch block for IMageIO read in order to load images
                         * into variables
                         */
                        try
                        {	
                                playerImage = ImageIO.read(new File("assets/player silhouette.png"));	
                                enemy1Image = ImageIO.read(new File("assets/enemy silhouette.png"));	
                                enemy2Image = ImageIO.read(new File("assets/enemy silhouette.png"));
                                armorImage = ImageIO.read(new File("assets/armor item silhouette.png"));
                                lootImage = ImageIO.read(new File("assets/loot chest silhouette.png"));	
                                potionImage = ImageIO.read(new File("assets/potion silhouette.png"));	
                                swordImage = ImageIO.read(new File("assets/sword item silhouette.png"));
                        } catch (IOException io)
                        {
                                System.out.println("Incorrect Image");
                        }
                        repaint();
                        
                        eTimer.start();
                }
                
                /**
                 * Leaderboard Button ActionEvent on click
                 * Shows Leaderboard by reading scores.txt and outputting
                 * with label4
                 * hides Leaderboard button
                 */
                if (e.getSource() == leaderboard)
                {
                    nameSave = new Save();
                    
                    leaderboard.setVisible(false);
                    nameSave.read();
                    String leaderboard = "<html>Leaderboard:<br/>";
                    for (int boardLen = 0; boardLen < (nameSave.namesSize()); boardLen++)
                    {
                        leaderboard += (nameSave.getName(boardLen) + "'s Score is: "
                                       +nameSave.getScore(boardLen) + "<br/>");
                    }
                    leaderboard += ("<html/>");
                    label4.setText(leaderboard);
                    size = label4.getPreferredSize();
                    label4.setBounds(5, 60, size.width, size.height);
                    label4.setVisible(true);
                }
                
                /**
                 * Help Button ActionEvent on click
                 * Shows instructions with label1, label5, and play button
                 * hides help button, extra labels and entry field
                 */
                if (e.getSource() == help)
                {
                    help.setVisible(false);
                    label2.setVisible(false);
                    label3.setVisible(false);
                    label4.setVisible(false);
                    nameEntry.setVisible(false);
                    
                    label1.setText("<html>"
                            + "The Game is a Dungeon Crawler with an <br/>"
                            + "8x8 tile grid.Objective is to get to <br/>"
                            + "treasure chest at end of map by <br/>"
                            + "defeating enemies without losing too<br/>"
                            + "much health.<br/>"
                            + "<br/>"
                            + "Your player can be controlled with the <br/>"
                            + "W,A,S, and D characters of the keyboard<br/>"
                            + "in order to move North, West, South and<br/>"
                            + " East, respectively.<br/>"
                            + "<br/>"
                            + "The Enemy guards move up and down in <br/>"
                            + "a line on a time interval. When <br/>"
                            + "contact with an enemy is detected due <br/>"
                            + "to being on the same tile, a fight <br/>"
                            + "sequence will occur. Based on strength <br/>"
                            + "and a dice roll, the enemy will be <br/>"
                            + "defeated the player may or may not <br/>"
                            + "receive either damage.<br/>"
                            + "<br/>"
                            + "When Player reaches treasure chest tile <br/>"
                            + "Player's score will be calculated based <br/>"
                            + "on health, strength, treasure chest<br/>"
                            + "attainment. When Player reaches Sword<br/>"
                            + "tile, strength will be doubled.<br/>"
                            + "When Potion, interacted with Player will <br/>"
                            + "have health restored."
                            + "</html>");
                    size = label1.getPreferredSize();
                    label1.setBounds(5, 60, size.width, size.height);
                    label1.setVisible(true);
                    
                    label5.setText("Press Play to Start the Game.");
                    size = label5.getPreferredSize();
                    label5.setBounds(10, 490, size.width, size.height);
                    
                    size = play.getPreferredSize();
                    play.setBounds(100, 525, size.width, (size.height+10));
                }
                
                /**
                 * Timer ActionEvent on Time interval pass for Enemy movement
                 */
                if(e.getSource()==eTimer)
                {
                    /**
                     * Checks if Enemy Y are in upper position to move enemies down
                     * Decrement by 80 due to tiles being 80
                     * Repaints enemies in new location
                     */
                    if (enemy1Y == (SQUARE7Y-PERSONDIM) && enemy2Y == (SQUARE4Y-PERSONDIM))
                    {
                        enemy1Y -= 80;
                        enemy2Y -= 80;
                        repaint();
                    }
                    /**
                     * Moves enemies up since position is lower
                     * Increment by 80 due to tiles being 80
                     * Repaints enemies in new location
                     */
                    else
                    {
                        enemy1Y += 80;
                        enemy2Y += 80;
                        repaint();
                    }
                }
                
                /**
                 * North Button ActionEvent on click for Player movement
                 */
                if (e.getSource() == north)
                {
                    if (user.move(1))
                    {
                        playerY -= 80;
                        repaint();
                    }
                }
                
                /**
                 * East Button ActionEvent on click for Player movement
                 */
                if (e.getSource() == east)
                {
                    if (user.move(0))
                    {
                        playerX += 80;
                        repaint();
                    }
                }
                
                /**
                 * West Button ActionEvent on click for Player movement
                 */
                if (e.getSource() == west)
                {
                    if (user.move(2))
                    {
                        playerX -= 80;
                        repaint();
                    }
                }
                
                /**
                 * South Button ActionEvent on click for Player movement
                 */
                if (e.getSource() == south)
                {
                    if (user.move(3))
                    {
                        playerY += 80;
                        repaint();
                    }
                }
	}
        /*
         * keyBinding method for Player movement on keypress
         */
        public void keyBinding()
        {
            javax.swing.Action moveNorth = new AbstractAction() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    playerY -= 80;
                    repaint();
                }
            };
            
            KeyStroke northStroke = KeyStroke.getKeyStroke(KeyEvent.VK_W, 0);
            component.getActionMap().put("north", moveNorth);
            component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(northStroke, "north");

            javax.swing.Action moveEast = new AbstractAction() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    playerX += 80;
                    repaint();
                }
            };
            
            KeyStroke eastStroke = KeyStroke.getKeyStroke(KeyEvent.VK_D, 0);
            component.getActionMap().put("east", moveEast);
            component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(eastStroke, "east");

            javax.swing.Action moveSouth = new AbstractAction() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    playerY += 80;
                    repaint();
                }
            };
            
            KeyStroke southStroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, 0);
            component.getActionMap().put("south", moveSouth);
            component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(southStroke, "south");

            javax.swing.Action moveWest = new AbstractAction() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    playerX -= 80;
                    repaint();
                }
            };
            
            KeyStroke westStroke = KeyStroke.getKeyStroke(KeyEvent.VK_A, 0);
            component.getActionMap().put("west", moveWest);
            component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(westStroke, "west");

            /*InputMap inMap = component.getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap actMap = component.getActionMap();
            
            inMap.put(KeyStroke.getKeyStroke("W"),"north");
            actMap.put("north", new AbstractAction(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        playerY -= 80;
                        repaint();
                    }            
                });
            
            inMap.put(KeyStroke.getKeyStroke("D"),"east");
            actMap.put("east", new AbstractAction(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    playerX += 80;
                    repaint();
                }
            });
            
            inMap.put(KeyStroke.getKeyStroke("S"),"south");
            actMap.put("south", new AbstractAction(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    playerY += 80;
                    repaint();
                }
            });
            
            inMap.put(KeyStroke.getKeyStroke("A"),"west");
            actMap.put("west", new AbstractAction(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    playerX -= 80;
                    repaint();
                }
            });*/
        }
        
        /**
	 * Panel button to play the game when clicked
	 */
	private final JButton play;
        
        /**
	 * Panel button to help the game when clicked
	 */
        private final JButton help;
        
        /**
	 * Panel button to Leaderboard the game when clicked
	 */
        private final JButton leaderboard;
        
	/**
	 * Panel button to nameEntry the game when clicked
	 */
	private final JTextField nameEntry;
        
        /**
	 * Panel button to move player north when clicked
	 */
        private final JButton north;
        
        /**
	 * Panel button to move player east when clicked
	 */
        private final JButton east;
        
        /**
	 * Panel button to move player west when clicked
	 */
        private final JButton west;
        
        /**
	 * Panel button to move player south when clicked
	 */
        private final JButton south;
        
	/**
	 * Panel labels to display
	 */
	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;
        private final JLabel label4;
        private final JLabel label5;

	/**
	 * Image variable to hold background Image
	 */
	private Image backgroundImage;
        
	/**
	 * Image variable to hold player Image
	 */
	private Image playerImage;
        
	/**
	 * Image variable to hold enemy Image
	 */
	private Image enemy1Image;        
	
        /**
	 * Image variable to hold enemy Image
	 */
	private Image enemy2Image;
        
	/**
	 * Image variable to hold armor item Image
	 */
	private Image armorImage;
        
	/**
	 * Image variable to hold loot item Image
	 */
	private Image lootImage;
        
	/**
	 * Image variable to hold potion item Image
	 */
	private Image potionImage;
        
	/**
	 * Image variable to hold sword item Image
	 */
	private Image swordImage;
        
        /**
	 * Image variable to hold north button Image
	 */
	private Image northImage;
        
	/**
	 * Image variable to hold east button Image
	 */
	private Image eastImage;
        
        /**
	 * Image variable to hold west button Image
	 */
	private Image westImage;
        
        /**
	 * Image variable to hold south button Image
	 */
	private Image southImage;
        
        /**
         * Square Tile Constants for X and Y locations in GUI grid
         */
        private final int SQUARE0Y = 80;
        private final int SQUARE1Y = 160;
        private final int SQUARE2Y = 240;
        private final int SQUARE3Y = 320;
        private final int SQUARE4Y = 400;
        private final int SQUARE5Y = 480;
        private final int SQUARE6Y = 560;
        private final int SQUARE7Y = 640;
        private final int SQUARE0X = 380;
        private final int SQUARE1X = 460;
        private final int SQUARE2X = 540;
        private final int SQUARE3X = 620;
        private final int SQUARE4X = 700;
        private final int SQUARE5X = 780;
        private final int SQUARE6X = 860;
        private final int SQUARE7X = 940;
        private final int PERSONDIM = 75;
        private final int ITEMDIM = 60;
        private final int POTIONDIM = 30;
        
        /**
         * Initial Enemy Y variables for Enemy Tile Placement
         */
        private int enemy1Y = SQUARE6Y-PERSONDIM;
        private int enemy2Y = SQUARE3Y-PERSONDIM;
        
        /**
         * Initial Player X and Y variables for Player Tile Placement
         */
        private int playerX = SQUARE0X-PERSONDIM; 
        private int playerY = SQUARE0Y-PERSONDIM;
        
        /**
         * Player variable for Player class use and passing to Map
         */
        Player user;
        
        /**
         * Enemy variable for Enemy class use and passing to Map
         */
        Enemy guard;
        
        /**
         * Item variable for Item class use and passing to Map
         */
        Item object;
        
	/**
	 * Save variable to allow save of user names
	 */
	private Save nameSave;
        
        /**
         * JComponent for KeyBinding method
         */
        private JComponent component;
        
        /**
         * Timer variable to allow movement of Enemy on time interval
         */
        private Timer eTimer;
}
