import java.util.ArrayList;
import java.util.Scanner;

public class RPSApp
{
	public static void main(String args[])
  	{
	  	//declare objets
		Scanner scanner;
		RPS myRPS;
		ArrayList<String> userPicks = new ArrayList<>();
		ArrayList<String> computerPicks = new ArrayList<>();

		int amountGames;
		String computerGuess="";
		int gameNumber=1;
		int roundNumber=1;
		int userLives=3;
		String userGuess="rock";

		//create object
		scanner = new Scanner(System.in);
		myRPS = new RPS();

		System.out.println("How many games do you want to play?");
		amountGames=scanner.nextInt();
		myRPS.initArray(amountGames);
		System.out.println("********************************************");

		while(gameNumber<=amountGames)
		{
			System.out.println("(r)ock,(p)aper or (s)cissors");
			userGuess = scanner.nextLine();

			switch(userGuess)
			{
				case "r": userGuess="rock";
					break;
				case "p": userGuess="paper";
					break;
				case "s": userGuess="scissors";
					break;
			}
			/*	System.out.println(userGuess);
			System.out.println("Game number:"+gameNumber);
			System.out.println("Round number:"+roundNumber);

			*/
			if((userGuess.equals("rock"))||
			(userGuess.equals("paper"))||
			(userGuess.equals("scissors")))
			{
				myRPS.generateComputerGuess();
				computerGuess=myRPS.getComputerGuess();
				System.out.println(computerGuess);
				userLives=myRPS.decideWinner(userGuess,computerGuess,userLives);
				roundNumber++;
			 }
			//roundNumber++;
			userPicks.add(userGuess);
			computerPicks.add(computerGuess);
			System.out.println("User lives:"+userLives);
			System.out.println("*****************************************");

			if(userLives<=0)
			{
				System.out.println("Game "+gameNumber+" over");
				myRPS.gameStats(gameNumber);
				myRPS.resetVariables();

				int count = userPicks.size();
				System.out.println("User Picks: ");

				for (int i = 0; i < userPicks.size(); i++)
				{
					String value = userPicks.get(i);
					System.out.print(value);
				}
				System.out.println();
				count = computerPicks.size();
				System.out.println("Computer Picks: ");

				for (int i = 0; i < computerPicks.size(); i++)
				{
					String value = computerPicks.get(i);
					System.out.print(value);
				}

				System.out.println();
				System.out.println("*****************************************");
				myRPS.finalStats(gameNumber);
				gameNumber++;
				userLives=3;
				roundNumber=1;
				userPicks.clear();
				computerPicks.clear();
			}
			else
			{
				userPicks.add(",");
				computerPicks.add(",");
			}
		}
	}
}