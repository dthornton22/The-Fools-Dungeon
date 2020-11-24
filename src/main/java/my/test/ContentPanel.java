/*
 * @author Will Osborne
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
import java.io.File;
import java.io.IOException;
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
         * updates scores.txt to sort previous entry
	 */
	public ContentPanel(Player player, Enemy enemy, Item item)
	{
                this.user = player;
                this.guard = enemy;
                this.object = item;
                
                health = user.getHealth();
                nameSave = new Save();
                potion = object.getHealthIncrease();
                
                moveTimer = new Timer(750, this);
                labelTimer = new Timer(15000,this);
		/**
		 * Panel dimensions and attributes layout null so items determine
		 * placement individually arbitrary initial dimensions on personal
		 * computer
		 */
		Dimension dim = new Dimension(WINDOWX, SQUAREDIM);
		setMinimumSize(dim);
		setPreferredSize(dim);
		setLayout(null);
		setBackground(Color.white);

		/**
		 * Try-Catch block for file read by ImageIO in case of exception throw
		 */
		try
		{
			backgroundImage = ImageIO.read(new File("src/main/resources/assets/map silhouette.png"));
                        northImage = ImageIO.read(new File("src/main/resources/assets/north.png"));
                        eastImage = ImageIO.read(new File("src/main/resources/assets/east.png"));
                        westImage = ImageIO.read(new File("src/main/resources/assets/west.png"));
                        southImage = ImageIO.read(new File("src/main/resources/assets/south.png"));
                        
		} catch (IOException e)
		{
			System.out.println("Incorrect Image");
		}

		/**
		 * Label1 placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer
		 */
		label1 = new JLabel("Dungeon Crawler");
		size = label1.getPreferredSize();
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
		 * Label6 placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer
		 */
		label6 = new JLabel("<html><font color='F42506'>"+ damage +"</font></html>");
		add(label6);
                label6.setVisible(false);
                
                /**
		 * Label7 placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer
		 */
		label7 = new JLabel("<html><font color='48F406'>+10</font></html>");
		add(label7);
                label7.setVisible(false);
                
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
		//north = new JButton(new ImageIcon(northImage));
                north =  new JButton();
                north.setVisible(false);
                
                /**
		 * East Button placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer left in for possible later
		 * use
		 */
		//east = new JButton(new ImageIcon(eastImage));
                east =  new JButton();
                east.setVisible(false);
                
                /**
		 * West Button placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer left in for possible later
		 * use
		 */
		//west = new JButton(new ImageIcon(westImage));
                west =  new JButton();
                west.setVisible(false);
                
                /**
		 * South Button placement and attributes add to panel for display arbitrary
		 * initial dimensions on personal computer left in for possible later
		 * use
		 */
		//south = new JButton(new ImageIcon(southImage));
                south =  new JButton();
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
                
		drawer.drawImage(backgroundImage, SIDEPANEL, 0, SQUAREDIM, SQUAREDIM, this);
                drawer.drawImage(armorImage, armorX, armorY, ITEMDIM, ITEMDIM, this);
                drawer.drawImage(drop1Image, drop1X, drop1Y,POTIONDIM, POTIONDIM, this);
                drawer.drawImage(drop2Image, drop2X, drop2Y,POTIONDIM, POTIONDIM, this);
                drawer.drawImage(drop3Image, drop3X, drop3Y,POTIONDIM, POTIONDIM, this);
                drawer.drawImage(enemy1Image, enemy1X, enemy1Y, PERSONDIM, PERSONDIM, this);
		drawer.drawImage(enemy2Image, enemy2X, enemy2Y, PERSONDIM, PERSONDIM, this);
                drawer.drawImage(enemy3Image, enemy3X, enemy3Y, PERSONDIM, PERSONDIM, this);
		drawer.drawImage(lootImage, lootX, lootY, ITEMDIM, ITEMDIM, this);
		drawer.drawImage(playerImage, playerX, playerY, PERSONDIM, PERSONDIM, this);
		drawer.drawImage(potionImage, potionX, potionY,POTIONDIM, POTIONDIM, this);
		drawer.drawImage(swordImage, swordX, swordY, ITEMDIM, ITEMDIM, this);
	}

	/**
	 * Method for actions to be performed based on ActionEvent
	 * overridden from ActionListener interface parameter e is input action
	 */
	@Override
	public void actionPerformed(ActionEvent action)
	{
            Dimension size;
            int[] playerLoc = user.getLocation();
		/**
                 * nameEntry entry field ActionEvent on enter
                 * Clears scores.txt if leaderboard is greater than  or equal to 6
                 * Copies user input name along with initial score to scores.txt
                 * Shows label4 with Greeting and label5 with direction
                 * Shows play and help buttons
                 * hides leaderboard button, extra labels and nameEntry text field
                 */
                if (action.getSource() == nameEntry)
		{
			user = new Player();
                        user.setScore(0);
                        String input = nameEntry.getText();
			nameEntry.selectAll();
                        
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
                if (action.getSource() == play)
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
                        
                        updateLabels(0,0);

                        label1.setVisible(true);
                        label2.setVisible(true);
                        play.setVisible(false);
                        
                        /**
                         * Try-Catch block for IMageIO read in order to load images
                         * into variables
                         */
                        try
                        {	
                                playerImage = ImageIO.read(new File("src/main/resources/assets/player silhouette.png"));	
                                enemy1Image = ImageIO.read(new File("src/main/resources/assets/enemy silhouette.png"));	
                                enemy2Image = ImageIO.read(new File("src/main/resources/assets/enemy silhouette.png"));
                                enemy3Image = ImageIO.read(new File("src/main/resources/assets/enemy silhouette.png"));
                                armorImage = ImageIO.read(new File("src/main/resources/assets/armor item silhouette.png"));
                                lootImage = ImageIO.read(new File("src/main/resources/assets/loot chest silhouette.png"));	
                                potionImage = ImageIO.read(new File("src/main/resources/assets/potion silhouette.png"));	
                                swordImage = ImageIO.read(new File("src/main/resources/assets/sword item silhouette.png"));
                        } catch (IOException io)
                        {
                                System.out.println("Incorrect Image");
                        }
                        
                        north = new JButton(new ImageIcon(northImage));
                        size = north.getPreferredSize();
                        north.setBounds(95, 440, (size.width-20), size.height);
                        north.addActionListener(this);
                        add(north);
                        
                        east = new JButton(new ImageIcon(eastImage));
                        size = east.getPreferredSize();
                        east.setBounds(185, 520, (size.width-20), size.height);
                        east.addActionListener(this);
                        add(east);
                        
                        west = new JButton(new ImageIcon(westImage));
                        size = west.getPreferredSize();
                        west.setBounds(10, 520, (size.width-20), size.height);
                        west.addActionListener(this);
                        add(west);
                        
                        south = new JButton(new ImageIcon(southImage));
                        size = south.getPreferredSize();
                        south.setBounds(95, 520, (size.width-20), size.height);
                        south.addActionListener(this);
                        add(south);
                        
                        repaint();
                        
                        moveTimer.start();
                }
                
                /**
                 * Leaderboard Button ActionEvent on click
                 * Shows Leaderboard by reading scores.txt and outputting
                 * with label4
                 * hides Leaderboard button
                 */
                if (action.getSource() == leaderboard)
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
                    leaderboard += ("</html>");
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
                if (action.getSource() == help)
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
                if(action.getSource()==moveTimer)
                {
                    /**
                     * Checks if Enemy Y are in upper position to move enemies
                     * Decrement by 80 due to tiles being 80
                     * calls playerContact to check player Location in reference to new enemy location
                     * Repaints enemies in new location
                     */
                    if (enemy1Y == (SQUARE7Y-PERSONDIM) && enemy2Y == (SQUARE4Y-PERSONDIM))
                    {
                        enemy1Y -= 80;
                        enemy2Y -= 80;
                        enemy3Y += 80;
                        playerContact();
                    }
                    /**
                     * Moves enemies since position is lower
                     * Increment by 80 due to tiles being 80
                     * calls playerContact to check player Location in reference to new enemy location
                     * Repaints enemies in new location
                     */
                    else
                    {
                        enemy1Y += 80;
                        enemy2Y += 80;
                        enemy3Y -= 80;
                        playerContact();
                    }
                }
                
                /**
                 * Timer ActionEvent on Time interval pass for label hiding
                 */
                if(action.getSource()==moveTimer)
                {
                    label6.setVisible(false);
                    label7.setVisible(false);
                }
                /**
                 * North Button ActionEvent on click for Player movement
                 */
                if (action.getSource() == north)
                {
                    if (user.move(1))
                    {
                        playerY -= 80;
                        playerContact();
                    }
                }
                
                /**
                 * East Button ActionEvent on click for Player movement
                 */
                if (action.getSource() == east)
                {
                    if (user.move(0))
                    {
                        playerX += 80;
                        playerLoc = user.getLocation();
                        playerContact();
                    }
                }
                
                /**
                 * West Button ActionEvent on click for Player movement
                 */
                if (action.getSource() == west)
                {
                    if (user.move(2))
                    {
                        playerX -= 80;
                        playerContact();
                    }
                }
                
                /**
                 * South Button ActionEvent on click for Player movement
                 */
                if (action.getSource() == south)
                {
                    if (user.move(3))
                    {
                        playerY += 80;
                        playerContact();
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
         * Checks if player Location is touching or near entities based on entity location
         * repaints when done to update GUI
         */
        private void playerContact()
        {
            if((playerX == (armorX+ITEMDIM-PERSONDIM)) && (playerY == (armorY+ITEMDIM-PERSONDIM)) && (!passedArmor))
            {
                armorImage = null;
                passedArmor = true;
                //object.createArmor();
            }
            else if((playerX == (drop1X+ITEMDIM-PERSONDIM)) && (playerY == (drop1Y+ITEMDIM-PERSONDIM)) && (!passedDrop1))
            {
                drop1Image = null;
                updateLabels(potion,0);
                size = label7.getPreferredSize();
                label7.setBounds(playerX, playerY, size.width, size.height);
                label7.setVisible(true);
                passedDrop1 = true;
            }
            else if((playerX == (drop2X+ITEMDIM-PERSONDIM)) && (playerY == (drop2Y+ITEMDIM-PERSONDIM)) && (!passedDrop2))
            {
                drop2Image = null;
                updateLabels(potion,0);
                size = label7.getPreferredSize();
                label7.setBounds(playerX, playerY, size.width, size.height);
                label7.setVisible(true);
                passedDrop2 = true;
            }
            else if((playerX == (drop3X+ITEMDIM-PERSONDIM)) && (playerY == (drop3Y+ITEMDIM-PERSONDIM))&& (!passedDrop3))
            {
                drop3Image = null;
                updateLabels(potion,0);
                size = label7.getPreferredSize();
                label7.setBounds(playerX, playerY, size.width, size.height);
                label7.setVisible(true);
                passedDrop3 = true;
            }
            else if(((playerX == (enemy1X-80)) || (playerX == enemy1X)) && (playerY == enemy1Y || (playerY == (enemy1Y-80))) && (!passedEnemy1))
            {
                enemy1Image = null;
                updateLabels(damage,0);
                size = label6.getPreferredSize();
                label6.setBounds(playerX, playerY, size.width, size.height);
                label6.setVisible(true);
                passedEnemy1 = true;
                try{
                    
                    drop1Image = ImageIO.read(new File("src/main/resources/assets/potion silhouette.png"));
                }
                catch(IOException e)
                {
                    System.out.println();
                }
                //user.fight();
            }
            else if(((playerX == (enemy2X-80)) || (playerX == enemy2X)) && (playerY == enemy2Y || (playerY == (enemy2Y-80))) && (!passedEnemy2))
            {
                enemy2Image = null;
                updateLabels(damage,0);
                size = label6.getPreferredSize();
                label6.setBounds(playerX, playerY, size.width, size.height);
                label6.setVisible(true);
                passedEnemy2 = true;
                try{
                    
                    drop2Image = ImageIO.read(new File("src/main/resources/assets/potion silhouette.png"));
                }
                catch(IOException e)
                {
                    System.out.println();
                }
                //user.fight();
            }
            else if((playerX == enemy3X || (playerX == (enemy3X-80))) && (playerY == enemy3Y || playerY == enemy3Y-80) && (!passedEnemy3))
            {
                enemy3Image = null;
                updateLabels(damage,0);
                size = label6.getPreferredSize();
                label6.setBounds(playerX, playerY, size.width, size.height);
                label6.setVisible(true);
                passedEnemy3 = true;
                try{
                    
                    drop3Image = ImageIO.read(new File("src/main/resources/assets/potion silhouette.png"));
                }
                catch(IOException e)
                {
                    System.out.println();
                }
                //user.fight();
            }
            else if((playerX == (lootX+ITEMDIM-PERSONDIM)) && (playerY == (lootY+ITEMDIM-PERSONDIM)) && (!passedLoot))
            {
                armorImage = null;
                drop1Image = null;
                drop2Image = null;
                drop3Image = null;
                enemy1Image = null;
                enemy2Image = null;
                lootImage = null;
                playerImage = null;
                potionImage = null;
                swordImage = null;
                
                updateLabels(0,1000);
                nameSave.update(user);
                passedLoot = true;
            }
            else if((playerX == (potionX+ITEMDIM-PERSONDIM)) && (playerY == (potionY+ITEMDIM-PERSONDIM)) && (!passedPotion))
            {
                potionImage = null;
                updateLabels(potion,0);
                size = label7.getPreferredSize();
                label7.setBounds(playerX, playerY, size.width, size.height);
                label7.setVisible(true);
                passedPotion = true;
            }
            else if((playerX == (swordX+ITEMDIM-PERSONDIM)) && (playerY == swordY) && (!passedSword))
            {
                swordImage = null;
                passedSword = true;
                object.createSword();
            }
            repaint();
        }
        
        /**
         * Updates Health and Score labels in GUI when values need to be changed
         * Updates Health and Score values in GUI player instance
         * @param changeHealth positive or negative value to change health by input value
         * @param changeScore used to calculate score when loot is reached 
         */
        private void updateLabels(int changeHealth, int changeScore)
        {
            health += changeHealth;
            user.setHealth(health);
            //user.usePotion(potion); Wasn't clear how this was supposed to work
            if(health > 70)
            {
                label1.setText("<html>Health: " + "<font color='48F406'>" + user.getHealth()+"</font></html>");
            }
            else if(health > 40)
            {
                label1.setText("<html>Health: " + "<font color='F4A206'>" + user.getHealth()+"</font></html>");
            }
            else
            {
                label1.setText("<html>Health: " + "<font color='F42506'>" + user.getHealth()+"</font></html>");
            }
            size = label1.getPreferredSize();
            label1.setBounds(10, 250, size.width, size.height);
               
            if (changeScore != 0)
            {
                user.setScore(changeScore + (health*10)); //Score set should calculate based on current health, strength and generic value for getting to loot
            }
            label2.setText("Score: " + user.getScore());
            size = label2.getPreferredSize();
            label2.setBounds(10, 300, size.width, size.height);
        }
        
        /**
         * Boolean values to allow singular contact with entities
         */
        private boolean passedArmor = false;
        private boolean passedDrop1 = false;
        private boolean passedDrop2 = false;
        private boolean passedDrop3 = false;
        private boolean passedEnemy1 = false;
        private boolean passedEnemy2 = false;
        private boolean passedEnemy3 = false;
        private boolean passedLoot = false;
        private boolean passedPotion = false;
        private boolean passedSword = false;
        
        /**
         * Dimension variable to get size of JPanel Components for placement
         */
        private Dimension size;
        
        /**
         * Enemy variable for Enemy class use and passing to Map
         */
        private Enemy guard;
        
	/**
	 * Image variable to hold background Image
	 */
	private Image backgroundImage;

        /**
	 * Image variable to hold armor item Image
	 */
	private Image armorImage;
        
        /**
	 * Image variable to hold first drop item Image
	 */
	private Image drop1Image;
        
	/**
	 * Image variable to hold second drop item Image
	 */
	private Image drop2Image;
        
        /**
	 * Image variable to hold second drop item Image
	 */
	private Image drop3Image;
        
	/**
	 * Image variable to hold enemy Image
	 */
	private Image enemy1Image;        
	
        /**
	 * Image variable to hold enemy Image
	 */
	private Image enemy2Image;
        
        /**
	 * Image variable to hold enemy Image
	 */
	private Image enemy3Image;
        
	/**
	 * Image variable to hold loot item Image
	 */
	private Image lootImage;
        
	/**
	 * Image variable to hold potion item Image
	 */
	private Image potionImage;
                   
	/**
	 * Image variable to hold player Image
	 */
	private Image playerImage;
        
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
         * GUI Dimensions constants
         */
        private final int WINDOWX = 940;
        private final int SQUAREDIM = 640;
        private final int SIDEPANEL = 300;
        
        /**
         * Image size dimensions for square tile size
         */
        private final int PERSONDIM = 75;
        private final int ITEMDIM = 60;
        private final int POTIONDIM = 30;
        /**
         * Square Tile Constants for X and Y locations in GUI grid
         */
        private final int SQUARE0X = 380;
        private final int SQUARE1X = 460;
        private final int SQUARE2X = 540;
        private final int SQUARE3X = 620;
        private final int SQUARE4X = 700;
        private final int SQUARE5X = 780;
        private final int SQUARE6X = 860;
        private final int SQUARE7X = 940;
        
        private final int SQUARE0Y = 80;
        private final int SQUARE1Y = 160;
        private final int SQUARE2Y = 240;
        private final int SQUARE3Y = 320;
        private final int SQUARE4Y = 400;
        private final int SQUARE5Y = 480;
        private final int SQUARE6Y = 560;
        private final int SQUARE7Y = 640;
        
        /**
         * Health variable for GUI text display
         */
        private int health;
        
        /**
         * Integer values for health changing
         */
        private int damage = -33;
        private int potion;
        
        /**
         * Initial Armor X and Y variables for Armor Tile Placement
         */
        private int armorX = SQUARE4X-ITEMDIM;
        private int armorY = SQUARE7Y-ITEMDIM;
        
        /**
         * Initial Drop Item X and Y variables for Drop Item Tile Placement
         */
        private int drop1X = SQUARE3X-ITEMDIM;
        private int drop1Y = SQUARE7Y-ITEMDIM;
        private int drop2X = SQUARE7X-ITEMDIM;
        private int drop2Y = SQUARE2Y-ITEMDIM;
        private int drop3X = SQUARE6X-ITEMDIM;
        private int drop3Y = SQUARE7Y-ITEMDIM;
        
        /**
         * Initial Enemy X and Y variables for Enemy Tile Placement
         */
        private int enemy1X = SQUARE3X-PERSONDIM;
        private int enemy1Y = SQUARE6Y-PERSONDIM;
        private int enemy2X = SQUARE7X-PERSONDIM;
        private int enemy2Y = SQUARE3Y-PERSONDIM;
        private int enemy3X = SQUARE6X-PERSONDIM;
        private int enemy3Y = SQUARE7Y-PERSONDIM;
        
        /**
         * Initial Loot X and Y variables for Loot Tile Placement
         */
        private int lootX = SQUARE7X-ITEMDIM;
        private int lootY = SQUARE7Y-ITEMDIM;
        
        /**
         * Initial Player X and Y variables for Player Tile Placement
         */
        private int playerX = SQUARE0X-PERSONDIM; 
        private int playerY = SQUARE0Y-PERSONDIM;
        
        /**
         * Initial Potion X and Y variables for Potion Tile Placement
         */
        private int potionX = SQUARE0X-ITEMDIM;
        private int potionY = SQUARE7Y-ITEMDIM;
        
        /**
         * Initial Sword X and Y variables for Sword Tile Placement
         */
        private int swordX = SQUARE6X-ITEMDIM;
        private int swordY = SQUARE0Y-PERSONDIM;
        
        /**
         * Item variable for Item class use and passing to Map
         */
        private Item object;
        
        /**
	 * Panel button to play the game when clicked
	 */
	private JButton play;
        
        /**
	 * Panel button to help the game when clicked
	 */
        private JButton help;
        
        /**
	 * Panel button to Leaderboard the game when clicked
	 */
        private JButton leaderboard;
        
        /**
	 * Panel button to move player north when clicked
	 */
        private JButton north;
        
        /**
	 * Panel button to move player east when clicked
	 */
        private JButton east;
        
        /**
	 * Panel button to move player west when clicked
	 */
        private JButton west;
        
        /**
	 * Panel button to move player south when clicked
	 */
        private JButton south;
        
         /**
         * JComponent for KeyBinding method
         */
        private JComponent component;
        
        /**
	 * Panel labels to display
	 */
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
        private JLabel label4;
        private JLabel label5;
        private JLabel label6;
        private JLabel label7;
        
	/**
	 * Panel button to nameEntry the game when clicked
	 */
	private JTextField nameEntry;
        
        /**
         * Player variable for Player class use and passing to Map
         */
        private Player user;
        
	/**
	 * Save variable to allow save of user names
	 */
	private Save nameSave;
        
        /**
         * Timer variable to allow movement of Enemy on time interval
         */
        private Timer labelTimer;
        
        /**
         * Timer variable to allow movement of Enemy on time interval
         */
        private Timer moveTimer;
}