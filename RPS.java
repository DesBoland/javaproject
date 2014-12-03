import java.util.Scanner;
import java.util.Random;

public class RPS
{
	private String computerGuess;
	int userWon=0,userLost=0,computerWon=0,computerLost=0;
	int gamesUserWon=0, gamesComputerWon=0;
	int[][] arrayGameStats;

	public void initArray(int gameAmount)
	{
		arrayGameStats = new int[gameAmount][4];
	}

	//int counter=0;
	public void resetVariables()
	{
		userWon=0;
		userLost=0;
		computerWon=0;
		computerLost=0;
	}

	public void generateComputerGuess()
	{
		Random rand = new Random();
		int n = rand.nextInt(3) + 1;

		switch(n)
		{
			case 1:
				computerGuess="rock";
				break;
			case 2:
				computerGuess="paper";
				break;
			case 3:
				computerGuess="scissors";
				break;
			default:
				System.out.println("Invalid selection");
				break;
		}
	}


	public String getComputerGuess()
	{
		return computerGuess;
	}

	public int decideWinner(String user,String computer,int userLives)
	{
		if(user.equals("rock"))
		{
			if(computer.equals("rock"))
			{
				System.out.println("draw");
			}
			else if(computer.equals("paper"))
			{
				System.out.println("You Lose");
				userLost++;
				computerWon++;
				userLives--;
			}
			else if(computer.equals("scissors"))
			{
				System.out.println("win");
				userWon++;
				computerLost++;
			}
		}
		else if(user.equals("paper"))
		{
			System.out.println("user paper");

			if(computer.equals("rock"))
			{
				System.out.println("win");
				userWon++;
				computerLost++;
			}
			else if(computer.equals("paper"))
			{
				System.out.println("draw");
			}
			else if(computer.equals("scissors"))
			{
				System.out.println("lose");
				userLost++;
				computerWon++;
				userLives--;
			}
		}
		else if(user.equals("scissors"))
		{
			System.out.println("user scissors");

			if(computer.equals("rock"))
			{
				System.out.println("lose");
				userLost++;
				computerWon++;
				userLives--;
			}
			else if(computer.equals("paper"))
			{
				System.out.println("Win");
				userWon++;
				computerLost++;
			}
			else if(computer.equals("scissors"))
			{
				System.out.println("draw");
			}
		}
		System.out.println("User wins:" +userWon);
		System.out.println("User loses:"+userLost);
		System.out.println("Computer wins:"+computerWon);
		System.out.println("Computer loses:"+computerLost);

		return userLives;
	}

	public void gameStats(int gameNumber)
	{
		if(userWon==computerWon)
		{
			System.out.println("Draw Game");
		}
		else if(userWon>computerWon)
		{
			System.out.println("You Win");
			gamesUserWon++;
		}
		else if(userWon<computerWon)
		{
			System.out.println("You Lose");
			gamesComputerWon++;
		}

		arrayGameStats[gameNumber-1][0]=userWon;
		arrayGameStats[gameNumber-1][1]=userLost;
		arrayGameStats[gameNumber-1][2]=computerWon;
		arrayGameStats[gameNumber-1][3]=computerLost;
	}

	public void finalStats(int gameNumber)
	{
		for(int i=0;i<gameNumber;i++)
		{
			System.out.println("*********************************");
			System.out.println("* Game Number: "+(i+1)+"\t\t*");
			System.out.println("*\tUser Wins: "+arrayGameStats[i][0]+"\t\t*");
			System.out.println("*\tUser Loses: "+arrayGameStats[i][1]+"\t\t*");
			System.out.println("*\tComputer Wins: "+arrayGameStats[i][2]+"\t*");
			System.out.println("*\tComputer Loses: "+arrayGameStats[i][3]+"\t*");

			if(arrayGameStats[i][0]>arrayGameStats[i][2])
			{
				System.out.println("* You won!\t\t\t*");
			}
			else
			{
				System.out.println("* You did not win!\t\t*");
			}
			System.out.println("*********************************");
		}
	}
}