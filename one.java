package Notepad;

import javax.swing.*;
import javax.sound.sampled.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/// i made this from Feb 21 to March 14 ,2026 i built everything expect the file jmenubar. i used the logic for snake,flippy bird is orignally from youtube. 
// i also added some notes for myself to understand when i read this again.
// this is an anime themed notepad with background and music
public class one {
	static JFrame Window = new JFrame();
	static JTextArea textplace;
	static JMenuBar content;
	static JMenu File,Format,Colour,Album,Font,Games;
	static JMenuItem Newfile,Savefile,Openfile; //file menu
	static JMenuItem White,Black,Red,Green,Pink; //color menu
	static JMenuItem s1,s2,s3; //album menu 
	static JMenuItem f1,f2,f3; //font color menu
	static JMenuItem g1,g2,g3,g4,g5,g6; // games menu
	static JMenuItem toUpper,toLower; //format menu
	
	
	static JLabel background;
	static Clip clip;
	
	public static void playMusic(String location) {
	    try {
	        if(clip != null) {
	            clip.stop(); // stop previous music (this stop last music gahhh)
	        }

	        File file = new File(location);
	        AudioInputStream audio = AudioSystem.getAudioInputStream(file);

	        clip = AudioSystem.getClip();
	        clip.open(audio);
	        clip.start();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public static void changeBackground(String imagePath)
	{
	    ImageIcon bg = new ImageIcon(imagePath);
	    Image scaled = bg.getImage().getScaledInstance(
	        Window.getWidth(), Window.getHeight(), Image.SCALE_SMOOTH
	    );
	    background.setIcon(new ImageIcon(scaled));
	    background.setBounds(0,0,Window.getWidth(), Window.getHeight());
	    textplace.setBounds(0,0,Window.getWidth(), Window.getHeight());
	}
	

	public static void main(String[] args) {
	
	
		Window.setVisible(true);
		Window.setTitle("Aung Khant Thar Personal Notepad");
		ImageIcon logo = new ImageIcon("logo.png");
		Window.setIconImage(logo.getImage());
		Window.setSize(1000,800);
		Window.setResizable(false);
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setJMenuBar(content);
		
		
		//menubar stuffs
		content = new JMenuBar();
		 File = new JMenu("File");
		 Format = new JMenu("Format");
		 Colour = new JMenu("Color");
		 Album = new JMenu("Music Album");
		 Font = new JMenu("Font Color");
		 Games = new JMenu("Arcade");
		 
		 
		
		content.add(File);
		content.add(Format);
		content.add(Colour);
		content.add(Album);
		content.add(Font);
		content.add(Games);
		Window.setJMenuBar(content);
		
		//menu item stuffs
		//file
		Newfile = new JMenuItem("New File");
		Savefile = new JMenuItem("Save File");
		Openfile = new JMenuItem("Open File");
		File.add(Newfile);
		File.add(Savefile);
		File.add(Openfile);
		
		//color
		White = new JMenuItem("White");
		Black = new JMenuItem("Black");
		Red = new JMenuItem("Red");
		Green = new JMenuItem("Green");
		Pink = new JMenuItem("Pink");
		Colour.add(White);
		Colour.add(Black);
		Colour.add(Red);
		Colour.add(Green);
		Colour.add(Pink);
		
		//music album
		s1 = new JMenuItem("Overdose");
		s2 = new JMenuItem("Help");
		s3 = new JMenuItem("Clover Club");
		Album.add(s1);
		Album.add(s2);
		Album.add(s3);
		
		//font color
		f1 = new JMenuItem("White");
		f2 = new JMenuItem("Black");
		f3 = new JMenuItem("Blue");
		Font.add(f1);
		Font.add(f2);
		Font.add(f3);
		
		//games
		g1 = new JMenuItem("Guess the number");
		g2 = new JMenuItem("Dice Roll");
		g3 = new JMenuItem("Snake Game");
		g4 = new JMenuItem("Flappy Bird");
		g5 = new JMenuItem("Tower Defense ");
		g6 = new JMenuItem("Fortune Cookie");
		Games.add(g1);
		Games.add(g2);
		Games.add(g3);
		Games.add(g4);
		Games.add(g5);
		Games.add(g6);
		
		//format
		JMenuItem toUpper = new JMenuItem("UPPERCASE");
		JMenuItem toLower = new JMenuItem("lowercase");

		Format.add(toUpper);
		Format.add(toLower);
	
				
		//typing stuffs
		textplace = new JTextArea();
		textplace.setLineWrap(false); 
		textplace.setWrapStyleWord(true); 
		textplace.setBounds(0,0,1000,800);   // IMPORTANT(don't forget if i am watching this again this is for setting bounds if you don't have this the image behind the notepad don't appear)
		textplace.setOpaque(false); 
	
		// scroll stuffs
		JScrollPane scroll = new JScrollPane(textplace);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0,0,Window.getWidth(), Window.getHeight());  // same size as text area
		scroll.setOpaque(false);                                       // transparent scroll pane
		scroll.getViewport().setOpaque(false); 
		
		// image stuff
		ImageIcon bgImage = new ImageIcon("images.png");
		Image scaled = bgImage.getImage().getScaledInstance(
		    Window.getWidth(), Window.getHeight(), Image.SCALE_SMOOTH
		);
		background = new JLabel(new ImageIcon(scaled));
		background.setBounds(0,0,Window.getWidth(), Window.getHeight());

		// layered pane
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0,1000,800);

		layeredPane.add(background, Integer.valueOf(0)); // background
		layeredPane.add(scroll, Integer.valueOf(1));  // text on top

		Window.add(layeredPane);
		
		Window.setVisible(true);
		
		//clicking stuffs
	
		//color click
		White.addActionListener(e -> {
			changeBackground("white.png"); 
		});
		
		Black.addActionListener(e -> {
			changeBackground("black.png"); 
		});
		
		Red.addActionListener(e -> {
			changeBackground("red.png"); 
		});
		
		Green.addActionListener(e -> {
			changeBackground("green.png"); 
		});
		Pink.addActionListener(e -> {
			changeBackground("pink.png"); 
		});
		
		//music click
		s1.addActionListener(e -> {
		    playMusic("overdose.wav");
		    changeBackground("kobo three.png");
		});

		s2.addActionListener(e -> {
		    playMusic("help.wav");
		    changeBackground("kobo two.png");
		});

		s3.addActionListener(e -> {
		    playMusic("clover club.wav");
		    changeBackground("kobo one.png");
		});
		//font click
		f1.addActionListener(e -> {
			textplace.setForeground(java.awt.Color.white);
		});

		f2.addActionListener(e -> {
			textplace.setForeground(java.awt.Color.black);
		});

		f3.addActionListener(e -> {
			textplace.setForeground(java.awt.Color.blue);
		});
		
		Window.addComponentListener(new java.awt.event.ComponentAdapter() {
		    public void componentResized(java.awt.event.ComponentEvent evt) {
		        if(background.getIcon() != null) {
		            ImageIcon bg = (ImageIcon) background.getIcon();
		            Image scaled = bg.getImage().getScaledInstance(
		                Window.getWidth(), Window.getHeight(), Image.SCALE_SMOOTH
		            );
		            background.setIcon(new ImageIcon(scaled));
		            background.setBounds(0,0,Window.getWidth(), Window.getHeight());
		            textplace.setBounds(0,0,Window.getWidth(), Window.getHeight());
		        }
		    }
		});
		// File menu functionality
		Newfile.addActionListener(e -> {
		    textplace.setText("");            // clear all text
		    changeBackground("images.png");   // reset background
		});

		Savefile.addActionListener(e -> {
		    JFileChooser fileChooser = new JFileChooser();
		    int option = fileChooser.showSaveDialog(Window);
		    if(option == JFileChooser.APPROVE_OPTION) {
		        try {
		            File file = fileChooser.getSelectedFile();
		            java.io.FileWriter writer = new java.io.FileWriter(file);
		            writer.write(textplace.getText());
		            writer.close();
		        } catch(Exception ex) {
		            JOptionPane.showMessageDialog(Window, "Error saving file: " + ex.getMessage());
		        }
		    }
		});

		Openfile.addActionListener(e -> {
		    JFileChooser fileChooser = new JFileChooser();
		    int option = fileChooser.showOpenDialog(Window);
		    if(option == JFileChooser.APPROVE_OPTION) {
		        try {
		            File file = fileChooser.getSelectedFile();
		            java.util.Scanner scanner = new java.util.Scanner(file);
		            StringBuilder content = new StringBuilder();
		            while(scanner.hasNextLine()) {
		                content.append(scanner.nextLine()).append("\n");
		            }
		            scanner.close();
		            textplace.setText(content.toString());
		        } catch(Exception ex) {
		            JOptionPane.showMessageDialog(Window, "Error opening file: " + ex.getMessage());
		        }
		    }
		});
		// Convert all text to uppercase
		toUpper.addActionListener(e -> {
		    textplace.setText(textplace.getText().toUpperCase());
		});

		// Convert all text to lowercase
		toLower.addActionListener(e -> {
		    textplace.setText(textplace.getText().toLowerCase());
		});

		//this shit is for number guessing game
		g1.addActionListener(e -> {
		    int min = 1, max = 100;
		    int target = (int)(Math.random() * (max - min + 1) + min);
		    boolean guessed = false;

		    while(!guessed) {
		        String input = JOptionPane.showInputDialog(Window, 
		            "Guess a number between " + min + " and " + max + ":");
		        if(input == null) break; 
		        try {
		            int guess = Integer.parseInt(input);
		            if(guess < target) {
		                JOptionPane.showMessageDialog(Window, "Higher!");
		            } else if(guess > target) {
		                JOptionPane.showMessageDialog(Window, "Lower!");
		            } else {
		                JOptionPane.showMessageDialog(Window, "Correct! The number was " + target);
		                guessed = true;
		            }
		        } catch(NumberFormatException ex) {
		            JOptionPane.showMessageDialog(Window, "Please enter a valid number!");
		        }
		    }
		});
		
		//and this is for rolling dice
		g2.addActionListener(e -> {
		    JFrame diceFrame = new JFrame("Dice Roll");
		    diceFrame.setSize(400, 400);
		    diceFrame.setResizable(false);
		    diceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    diceFrame.setLayout(new BorderLayout());

		    JLabel diceLabel = new JLabel();
		    diceLabel.setHorizontalAlignment(JLabel.CENTER);
		    diceLabel.setVerticalAlignment(JLabel.CENTER);

		    JButton rollButton = new JButton("Roll Dice");
		    rollButton.addActionListener(ev -> {
		        int roll = (int)(Math.random() * 6) + 1;
		        String fileName = "";
		        switch(roll) {
		            case 1: fileName = "face one.png"; break;
		            case 2: fileName = "face two.png"; break;
		            case 3: fileName = "face three.png"; break;
		            case 4: fileName = "face four.png"; break;
		            case 5: fileName = "face five.png"; break;
		            case 6: fileName = "face six.png"; break;
		        }
		        ImageIcon diceIcon = new ImageIcon(fileName);
		        Image saled = diceIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		        diceLabel.setIcon(new ImageIcon(saled));
		    });

		    diceFrame.add(diceLabel, BorderLayout.CENTER);
		    diceFrame.add(rollButton, BorderLayout.SOUTH);
		    diceFrame.setVisible(true);
		});
		g3.addActionListener(e -> {
		    new SnakeGame();
		});
		g4.addActionListener(e -> {
		    new FlappyBirdGame();  
		});
		g5.addActionListener(e -> {
		    new TowerDefense();  
		});
		g6.addActionListener(e -> {
		    new FortuneCookie();
		});
		
	}
	
	static class SnakeGame extends JFrame {
	    private int width = 300, height = 300, unit = 15;
	    private int[] snakeX = new int[100];
	    private int[] snakeY = new int[100];
	    private int snakeLength = 3;
	    private int foodX, foodY;
	    private char direction = 'R'; // U,D,L,R
	    private boolean running = true;
	    private javax.swing.Timer timer;

	    public SnakeGame() {
	        this.setTitle("Snake Game");
	        this.setSize(width, height);
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        this.setResizable(true);
	        this.setLocationRelativeTo(null);

	        // Key listener for movement
	        this.addKeyListener(new java.awt.event.KeyAdapter() {
	            public void keyPressed(java.awt.event.KeyEvent e) {
	                switch(e.getKeyCode()) {
	                    case java.awt.event.KeyEvent.VK_UP:
	                        if(direction!='D') direction='U';
	                        break;

	                    case java.awt.event.KeyEvent.VK_DOWN:
	                        if(direction!='U') direction='D';
	                        break;

	                    case java.awt.event.KeyEvent.VK_LEFT:
	                        if(direction!='R') direction='L';
	                        break;

	                    case java.awt.event.KeyEvent.VK_RIGHT:
	                        if(direction!='L') direction='R';
	                        break;
	                }
	            }
	        });
	        snakeX[0] = width / 2;
	        snakeY[0] = height / 2;
	        spawnFood();
	        timer = new javax.swing.Timer(100, e -> { move(); repaint(); });
	        timer.start();
	        this.setVisible(true);
	    }

	    private void spawnFood() {
	        foodX = (int)(Math.random() * (width / unit)) * unit;
	        foodY = (int)(Math.random() * (height / unit)) * unit;
	    }

	    private void move() {
	        if(!running) return;
	        for(int i=snakeLength; i>0; i--) {
	            snakeX[i] = snakeX[i-1];
	            snakeY[i] = snakeY[i-1];
	        }
	        switch(direction) {
	        case 'U': snakeY[0] -= unit; break;
	        case 'D': snakeY[0] += unit; break;
	        case 'L': snakeX[0] -= unit; break;
	        case 'R': snakeX[0] += unit; break;
	    }
	        checkCollision();
	        checkFood();
	    }

	    private void checkFood() {
	        if(snakeX[0] == foodX && snakeY[0] == foodY) {
	            snakeLength++;
	            spawnFood();
	        }
	    }

	    private void checkCollision() {
	        // wall collision
	        if(snakeX[0] < 0 || snakeX[0] >= width || snakeY[0] < 0 || snakeY[0] >= height) {
	            running = false;
	            timer.stop();
	            JOptionPane.showMessageDialog(this, "Game Over! Score: " + (snakeLength-3));
	        }
	        // self collision
	        for(int i=1; i<snakeLength; i++) {
	            if(snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
	                running = false;
	                timer.stop();
	                JOptionPane.showMessageDialog(this, "Game Over! Score: " + (snakeLength-3));
	            }
	        }
	    }

	    public void paint(Graphics g) {
	        super.paint(g);
	        if(running) {
	            g.setColor(Color.pink);
	            g.fillRect(foodX, foodY, unit, unit);
	            g.setColor(Color.black);
	            for(int i=0; i<snakeLength; i++) {
	                g.fillRect(snakeX[i], snakeY[i], unit, unit);
	            }
	        }
	    }
	}
	static class FlappyBirdGame extends JFrame {
	    private int birdY = 200;
	    private int birdVelocity = 0;
	    private int gravity = 1;
	    private int jumpStrength = -12;
	    private Timer timer;
	    private int score = 0;

	    private int pipeX = 400;
	    private int pipeGap = 150;
	    private int pipeHeight = 200;

	    private Image backgroundImg;
	    private Image birdImg;
	    private Image pipeImg;

	    public FlappyBirdGame() {
	        this.setTitle("Flappy Bird");
	        this.setSize(400, 600);
	        this.setResizable(false);
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	        // Load images 
	        backgroundImg = new ImageIcon("bg.png").getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH);
	        birdImg = new ImageIcon("bird.png").getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
	        pipeImg = new ImageIcon("pipe.png").getImage().getScaledInstance(50, 600, Image.SCALE_SMOOTH);

	        JPanel panel = new JPanel() {
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                g.drawImage(backgroundImg, 0, 0, null); // background

	                g.drawImage(birdImg, 50, birdY, null); // bird

	                // top pipe
	                g.drawImage(pipeImg, pipeX, 0, null);
	                g.setColor(new Color(0,0,0,0)); // invisible top part (mask)
	                g.fillRect(pipeX, pipeHeight, 50, pipeGap);

	                // bottom pipe
	                g.drawImage(pipeImg, pipeX, pipeHeight + pipeGap, null);

	                g.setColor(Color.white);
	                g.setFont(new Font("Arial", Font.ABORT, 18));
	                g.drawString("Score: " + score, 10, 20);
	            }
	        };

	        this.add(panel);
	        this.addKeyListener(new java.awt.event.KeyAdapter() {
	            public void keyPressed(java.awt.event.KeyEvent e) {
	                if(e.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE) {
	                    birdVelocity = jumpStrength;
	                }
	            }
	        });

	        timer = new Timer(20, e -> {
	            birdVelocity += gravity;
	            birdY += birdVelocity;

	            pipeX -= 5;
	            if(pipeX + 50 < 0) { // reset pipe
	                pipeX = 400;
	                pipeHeight = (int)(Math.random() * 250) + 50;
	                score++;
	            }

	            // collision
	            if(birdY > 570 || birdY < 0 ||
	               (50 + 40 > pipeX && 50 < pipeX + 50 &&
	               (birdY < pipeHeight || birdY + 30 > pipeHeight + pipeGap))) {
	                timer.stop();
	                JOptionPane.showMessageDialog(null, "Game Over! Score: " + score);
	                dispose();
	            }

	            panel.repaint();
	        });
	        timer.start();
	        this.setVisible(true);
	    }
	}
	static class TowerDefense extends JFrame {
	    private final int WIDTH = 600, HEIGHT = 400;
	    private int hp = 10;
	    private int score = 0;

	    private ArrayList<Enemy> enemies = new ArrayList<>();
	    private ArrayList<Tower> towers = new ArrayList<>();
	    private Timer timer;

	    private Image background, enemyImg, towerImg, projectileImg;

	    public TowerDefense() {
	        this.setTitle("Tower Defense Lite");
	        this.setSize(WIDTH, HEIGHT);
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        this.setResizable(false);

	        // Load images
	        background = new ImageIcon("green.png").getImage();
	        enemyImg = new ImageIcon("tdenemy.png").getImage();
	        towerImg = new ImageIcon("tower.png").getImage();
	        projectileImg = new ImageIcon("black.png").getImage();

	        GamePanel panel = new GamePanel();
	        this.add(panel);

	        // Timer: game loop
	        timer = new Timer(50, e -> {
	            moveEnemies();
	            attackEnemies();
	            spawnEnemies();
	            panel.repaint();
	        });
	        timer.start();

	        // this is mouse listener to add towers
	        panel.addMouseListener(new MouseAdapter() {
	            public void mousePressed(MouseEvent e) {
	                towers.add(new Tower(e.getX(), e.getY()));
	            }
	        });

	        this.setVisible(true);
	    }

	    private void spawnEnemies() {
	        if (Math.random() < 0.02) enemies.add(new Enemy(0, 200));
	    }

	    private void moveEnemies() {
	        Iterator<Enemy> it = enemies.iterator();
	        while(it.hasNext()) {
	            Enemy en = it.next();
	            en.move();
	            if (!en.isAlive()) {
	                it.remove();
	                score += 10;
	            } else if (en.x > WIDTH) {
	                it.remove();
	                hp--;
	                if(hp <= 0){
	                    timer.stop();
	                    JOptionPane.showMessageDialog(this,"Game Over! Score: "+score);
	                    this.dispose();
	                }
	            }
	        }
	    }

	    private void attackEnemies() {
	        for (Tower t : towers) t.attack(enemies);
	    }

	    class GamePanel extends JPanel {
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background,0,0,WIDTH,HEIGHT,this);

	            // Draw towers
	            for (Tower t : towers)
	                g.drawImage(towerImg, t.x-15, t.y-15, 30,30,this);

	            // Draw enemies
	            for (Enemy en : enemies)
	                g.drawImage(enemyImg, en.x-10, en.y-10, 20,20,this);

	            // Draw HP & Score
	            g.setColor(Color.WHITE);
	            g.setFont(new Font("Arial",Font.ABORT,16));
	            g.drawString("HP: "+hp, 10, 20);
	            g.drawString("Score: "+score, 80, 20);
	        }
	    }

	    class Enemy {
	        int x, y;
	        int health = 3;
	        boolean alive = true;

	        Enemy(int x, int y) { this.x=x; this.y=y; }

	        void move() { x += 2; }

	        boolean isAlive() { return health > 0; }

	        void damage() { health--; if(health<=0) alive=false; }
	    }

	    class Tower {
	        int x, y;

	        Tower(int x, int y) { this.x=x; this.y=y; }

	        void attack(ArrayList<Enemy> enemies) {
	            for (Enemy en : enemies) {
	                double distance = Math.hypot(x-en.x, y-en.y);
	                if (distance < 50) {
	                    en.damage();
	                }
	            }
	        }
	    }
	}
	
	static class FortuneCookie extends JFrame {

	    JLabel cookieLabel;
	    JLabel messageLabel;
	    String[] fortunes = {
	        "Great luck is coming your way.",
	        "You will meet someone interesting.",
	        "Success will find you soon.",
	        "Adventure is waiting for you.",
	        "A new opportunity will appear.",
	        "Today is your lucky day.",
	        "Happiness is closer than you think.",
	        "Something exciting will happen soon.",
	        "Good news will come to you soon.",
	        "A new friendship will bring happiness.",
	        "You will discover something valuable.",
	        "A great opportunity is near.",
	        "Your hard work will pay off.",
	        "Someone is thinking about you.",
	        "Luck will find you when you least expect it.",
	        "A pleasant surprise is waiting for you.",
	        "You will learn something important today.",
	        "Your future looks bright.",
	        "A small step today leads to big success.",
	        "Trust your instincts.",
	        "New adventures are ahead.",
	        "Patience will bring great rewards.",
	        "Your creativity will shine.",
	        "Something lost will soon be found.",
	        "A dream you have will come true.",
	        "You will make someone smile today.",
	        "An exciting change is coming.",
	        "Believe in yourself.",
	        "Good fortune will follow you.",
	        "A fresh start will bring happiness.",
	        "You will overcome a challenge.",
	        "A new idea will inspire you.",
	        "Your kindness will be returned.",
	        "A mystery will soon be solved.",
	        "A lucky break is coming.",
	        "You will achieve something great.",
	        "A joyful moment is coming soon.",
	        "You will meet someone interesting.",
	        "Your future holds many surprises.",
	        "A secret wish will come true.",
	        "Something wonderful is about to happen.",
	        "A new door will open for you.",
	        "Your courage will bring success.",
	        "You will gain new knowledge.",
	        "A bright opportunity awaits.",
	        "Your effort will not go unnoticed.",
	        "You will make a wise decision.",
	        "Your journey will lead to success.",
	        "Someone will help you unexpectedly.",
	        "A calm mind will solve your problem.",
	        "Today is a perfect day to start something new.",
	        "Your talents will bring you recognition.",
	        "A small act of kindness will return to you.",
	        "You will discover hidden potential.",
	        "Great things take time.",
	        "Your confidence will lead the way.",
	        "An exciting message will reach you soon.",
	        "A positive change is coming."
	    };

	    public FortuneCookie() {

	        this.setTitle("Fortune Cookie");
	        this.setSize(400,400);
	        this.setLayout(new BorderLayout());
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	        // Cookie Image
	        cookieLabel = new JLabel();
	        cookieLabel.setHorizontalAlignment(JLabel.CENTER);

	        ImageIcon cookie = new ImageIcon("cookie.png");
	        Image scaled = cookie.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
	        cookieLabel.setIcon(new ImageIcon(scaled));

	        // Fortune text
	        messageLabel = new JLabel("Click the cookie!", JLabel.CENTER);
	        messageLabel.setFont(new Font("Arial",Font.ABORT,16));

	        this.add(cookieLabel,BorderLayout.CENTER);
	        this.add(messageLabel,BorderLayout.SOUTH);

	        // Click event
	        cookieLabel.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent e) {

	                int random = (int)(Math.random()*fortunes.length);
	                messageLabel.setText( fortunes[random]);

	                // change cookie image to broken cookie
	                ImageIcon broken = new ImageIcon("cookie_broken.png");
	                Image scaled2 = broken.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
	                cookieLabel.setIcon(new ImageIcon(scaled2));
	            }
	        });

	        this.setVisible(true);
	    }
	}
	}
