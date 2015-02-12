package Games;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicTacToe implements ActionListener
{
	public static final char playerO = 'O'; // --> 79
	public static final char playerX = 'X'; // --> 88
	
    private	boolean player1turn;
	private boolean player2turn;
	private int size;
	
	private String[][] grid;
	private JButton[][] gameGrid;
	private int count = 0;
	
	public TicTacToe()
	{
		initialize();
	}
	
	/**
	 * Returns a boolean value of true or false of player 1's turn state.
	 */
	public boolean getPlayer1Turn()
	{
		return player1turn;
	}
	
	/**  
	 * Sets player 1's turn to the specified turn boolean. 
	 */
	public void setPlayer1turn(boolean turn)
	{
		player1turn = turn;
	}
	   
	/**
	 * Returns a boolean value of true or false of player 2's turn state.
	 */
	public boolean getPlayer2turn()
	{
		return player2turn;
	}
	
	/**
	 * Returns the current size of the board.
	 */
	public int getBoardSize()
	{
		return size;
	}
	
	/**
	 * @param size The size of the board to be set when the user starts the game.
	 */
	public void setBoardSize(int size)
	{
		this.size = size;
	}
	   
	/**
	 * Sets player 2's turn to the specified turn boolean
	 */
	public void setPLayer2turn(boolean turn)
	{
		player2turn = turn;
	}
	 
	/**
	 * Checks the board size that the user has submitted, and verifies that it is between 3 and 25, inclusive.
	 */
	public boolean checkBoardSize(int size)
	{
		//checks that the size is between 3 and 25
		if(size < 3 || size > 25)
		{
			return false;
		}
		
		return true;
	}
	
	/**
	 * Declares the winner.
	 */
	public boolean checkWin(char player)
	{
        if (checkHorizontalWin(player))
        {
            return true;
        }

        if (checkVerticalWin(player))
        {
            return true;
        }

        if (checkLeftDiagonal(player))
        {
            return true;
        }
        
        if(checkRightDiagonal(player))
        {
        	return true;
        }
        
        return false;
    }

	/**
	 * Checks for a win in all of the rows.
	 */
	 public boolean checkHorizontalWin(char player)
	 {
		 for (int row = 0; row < size; row++)
		 {
			 int xTotal = 0;
			 int oTotal = 0;
			 
			 for (int column = 0; column < size; column++)
			 {
				 if(!grid[row][column].equals("-"))
				 {
					 if(grid[row][column].equals("X"))
					 {
						 xTotal++;
					 }
					 
					 if(grid[row][column].equals("O"))
					 {
						oTotal++;
					 }
				 }
			 }
		     
			 if(player == 'X')
			 {
				 if(xTotal == size)
				 {
					 return true;
				 }
			 }
			 
			 if(player == 'O')
			 {
				 if(oTotal == size)
				 {
					 System.out.println("Came here");
					 return true;
				 }
			 }
		 }

		 return false;
	 }
	 
	 /**
	  * Checks for a win in all of the columns.
	  */
	 public boolean checkVerticalWin(char player)
	 {
		 for (int column = 0; column < getBoardSize(); column++)
		 {
			 int xTotal = 0;
			 int oTotal = 0;
			 
			 for (int row = 0; row < getBoardSize(); row++)
			 {
				 if(!grid[row][column].equals("-"))
				 {
					 if(grid[row][column].equals("X"))
					 {
						 xTotal++;
					 }
					 
					 if(grid[row][column].equals("O"))
					 {
						oTotal++;
					 }
				 }
			 }

			 if(player == 'X')
			 {
				 if(xTotal == size)
				 {
					 return true;
				 }
			 }
			 
			 if(player == 'O')
			 {
				 if(oTotal == size)
				 {
					 System.out.println("Came here");
					 return true;
				 }
			 }
		 }
		 
		 return false;
	 }
	 
	 /**
	  * Checks for a win in all of the diagonals.
	  */
	 public boolean checkLeftDiagonal(char player)
	 {
		 int xTotal = 0;
		 int oTotal = 0;
		 
		 for (int leftDiagonal = 0; leftDiagonal < getBoardSize(); leftDiagonal++) 
		 {
			 if(!grid[leftDiagonal][leftDiagonal].equals("-"))
			 {
				 if(grid[leftDiagonal][leftDiagonal].equals("X"))
				 {
					 xTotal++;
				 }
				 
				 if(grid[leftDiagonal][leftDiagonal].equals("O"))
				 {
					oTotal++;
				 }
			 }
		 }

		 if(player == 'X')
		 {
			 if(xTotal == size)
			 {
				 return true;
			 }
		 }
		 
		 if(player == 'O')
		 {
			 if(oTotal == size)
			 {
				 System.out.println("Came here");
				 return true;
			 }
		 }
		 
		 return false;
	 }
	 
	 public boolean checkRightDiagonal(char player)
	 {
		 int xTotal = 0;
		 int oTotal = 0;
		 
		 for (int rightDiagonal = 0; rightDiagonal < getBoardSize(); rightDiagonal++)
		 {
			 if(!grid[rightDiagonal][size - rightDiagonal - 1].equals("-"))
			 {
				 if(grid[rightDiagonal][size - rightDiagonal - 1].equals("X"))
				 {
					 xTotal++;
				 }
				 
				 if(grid[rightDiagonal][size - rightDiagonal - 1].equals("O"))
				 {
					 oTotal++;
				 }
			 }
		 }

		 if(player == 'X')
		 {
			 if(xTotal == size)
			 {
				 return true;
			 }
		 }
		 
		 if(player == 'O')
		 {
			 if(oTotal == size)
			 {
				 System.out.println("Came here");
				 return true;
			 }
		 }
		 
		 return false;
	 }

	/**
	 * Displays game introduction to the user.
	 */
	public void initialize()
	{
		final JFrame introFrame = new JFrame();
		JPanel introPanel = new JPanel();
		
		JLabel blank = new JLabel();
		JLabel blank2 = new JLabel();
		JLabel blank3 = new JLabel();
		JLabel blank4 = new JLabel();
		final JLabel blank5 = new JLabel();
		
		JButton playGame = new JButton("Play!");
		JLabel welcomeLabel = new JLabel("Tic Tac Toe");
		JLabel boardSize = new JLabel("Board Size");
		final JTextField boardInput = new JTextField();
		
		introPanel.add(blank);
		introPanel.add(welcomeLabel);
		introPanel.add(blank2);
		introPanel.add(boardSize);
		introPanel.add(boardInput);
		introPanel.add(blank3);
		introPanel.add(blank4);
		introPanel.add(playGame);
		introPanel.add(blank5);
		
		introPanel.setLayout(new GridLayout(3,3));
		introFrame.setTitle("Welcome to Tic Tac Toe!");
		introFrame.add(introPanel);
		introFrame.setVisible(true);
		introFrame.setSize(725,300);
		
		playGame.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String input = boardInput.getText();
				
				if(input.length() == 0)
				{
					blank5.setText("Input cannot be empty");
					return;
				}
				
				else
				{
					try
					{
						if((Integer) Integer.parseInt(input) instanceof Integer)
						{
							if(checkBoardSize(Integer.parseInt(boardInput.getText())))
							{
								setBoardSize(Integer.parseInt(boardInput.getText()));
								introFrame.setVisible(false);
								playGame();
							}
							
							else
							{
								blank5.setText("Size must be between 3 and 25");
								return;
							}
						}
					}
					
					catch(NumberFormatException e)
					{
						blank5.setText("Input must be a number");
						return;
					}
				}
			}
		});

		introFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void playGame()
	{
		JFrame gameframe = new JFrame();
		JPanel gamePanel = new JPanel();
		gameGrid = new JButton[size][size];
		grid = new String[size][size];
		
		//game panel variables
		final int rows = getBoardSize();
		final int columns = getBoardSize();
		
		setPlayer1turn(true);
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				gameGrid[i][j] = new JButton();
				gamePanel.add(gameGrid[i][j]);
				gameGrid[i][j].setBackground(Color.black);
				
				gameGrid[i][j].addActionListener(this);
				grid[i][j] = "-";
			}
		}
		
		gamePanel.setLayout(new GridLayout(size, size));
		gameframe.add(gamePanel);
		gameframe.setVisible(true);
		gameframe.setSize(500, 500);
		  
		gameframe.setLayout(new GridLayout());
		gameframe.setTitle("Tic Tac Toe");
		gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
   @Override
   public void actionPerformed(ActionEvent e) 
   {
	   final int rows = getBoardSize();
	   final int columns = getBoardSize();
	   JButton b = (JButton) e.getSource();
	   
	   for(int i = 0; i < rows; i++)
	   {
		   for(int j = 0; j < columns; j++)
		   {
			   if(b == gameGrid[i][j])
			   {
				   //put x
				   if(getPlayer1Turn())
				   {
					   ((JButton) e.getSource()).setText("X");
					   ((JButton) e.getSource()).setBackground(Color.red);
					   setPlayer1turn(false);
					
					   setPLayer2turn(true);
					   ((JButton) e.getSource()).setEnabled(false);
					   grid[i][j] = "X";
					   count++;
					   
					   if(checkWin(playerX))
					   {
						   JOptionPane.showMessageDialog(null, "Player 1 wins!");
						   count = 0;
						   System.exit(0);
					   }
					   
					   if(checkWin(playerO))
					   {
						   JOptionPane.showMessageDialog(null, "Player 2 wins!");
						   count = 0;
						   System.exit(0);
					   }
					   
					   //declares tie
					   if(count == size * size)
					   {
						   JOptionPane.showMessageDialog(null, "Game is a tie!");
						   System.exit(0);
					   }
				   }
			   
			      //otherwise put o
			      else
			      {
			    	  ((JButton) e.getSource()).setText("O");
			    	  ((JButton) e.getSource()).setBackground(Color.blue);
			    	  setPlayer1turn(true);
					
			    	  setPLayer2turn(false);
			    	  ((JButton) e.getSource()).setEnabled(false);
			    	  grid[i][j] =  "O";
			    	  count++;
			    	  
			    	  if(checkWin(playerX))
					   {
						   JOptionPane.showMessageDialog(null, "Player 1 wins!");
						   System.exit(0);
					   }
					   
					   if(checkWin(playerO))
					   {
						   JOptionPane.showMessageDialog(null, "Player 2 wins!");
						   System.exit(0);
					   }
					   
					   //declares tie
					   if(count == size * size)
					   {
						   JOptionPane.showMessageDialog(null, "Game is a tie!");
						   System.exit(0);
					   }
			       }
			   }
		   }
	   }
   }
	
   public static void main(String[] args)
   {
	   TicTacToe tictactoe = new TicTacToe();
   }
}