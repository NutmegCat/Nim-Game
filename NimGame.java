// Aaron Prince Anu

class NimGame
{
	private static final int NO_OF_PILES = 4;

	public static void main(String[] args) 
	{
		System.out.println("\nNumber of piles: " + NO_OF_PILES);
		
		//random int for piles
		int noOfSticksPerPile = getRandomNumber(4, 9); // <-- method
		int noOfSticksPerPile2 = getRandomNumber(4, 9);
		int noOfSticksPerPile3 = getRandomNumber(4, 9);
		int noOfSticksPerPile4 = getRandomNumber(4, 9);

		//display piles
		System.out.println("Number of sticks/pile: " + noOfSticksPerPile);
		int p1 = noOfSticksPerPile;
		int p2 = noOfSticksPerPile2;
		int p3 = noOfSticksPerPile3;
		int p4 = noOfSticksPerPile4;

		//total number of sticks (all piles)
		int totalNoOfSticks = p1 + p2 + p3 + p4;
		System.out.println("Total number of sticks are: " + totalNoOfSticks);

		//turn base
		boolean turn = true;

		//game starts
		System.out.println("\nBegin play");

		String player = "";

		//loop for output
		while (totalNoOfSticks > 1) {

			//present sticks
			System.out.println("Pile 1 :  " + getPileRepresentation(p1));
			System.out.println("Pile 2 :  " + getPileRepresentation(p2));
			System.out.println("Pile 3 :  " + getPileRepresentation(p3));
			System.out.println("Pile 4 :  " + getPileRepresentation(p4));

			//P1 or P2 (player)
			if (turn) 
			{
				player = "P1";
			} else 
			{
				player = "P2";
			}

			//text output + pile selection
			System.out.println("Player " + player + "'s turn");
			System.out.println("Enter the pile ");
			int currentPile = In.getInt();

			//max pile error
			if (currentPile > NO_OF_PILES) 
			{
				System.out.println("\nMax no of piles are " + NO_OF_PILES);
				continue;
			}

			int pileInPlay = -1;

			//pile selection
			if (currentPile == 1) 
			{
				pileInPlay = p1;
			} else if (currentPile == 2) 
			{
				pileInPlay = p2;
			} else if (currentPile == 3) 
			{
				pileInPlay = p3;
			} else if (currentPile == 4) 
			{
				pileInPlay = p4;
			}

			System.out.println("Enter the number of sticks");

			int pickedSticks = In.getInt();

			//if sticks chosen are above 3 (game rules)
			if (pickedSticks > 3) 
			{
				System.out.println("You can pick maximum of 3 sticks at a time. Please retry!");
				continue;
			}

			/*if sticks chosen are above the number of sticks in that pile
			 eg. if there's only 2 sticks, you cannot chose 3*/ 
			if (pickedSticks > pileInPlay) 
			{
				System.out.println("This pile has only " + pileInPlay + " sticks remaining. Please retry!");
				continue;
			} else 
			{
				if (currentPile == 1) {
					p1 = p1 - pickedSticks;
				} else if (currentPile == 2) {
					p2 = p2 - pickedSticks;
				} else if (currentPile == 3) {
					p3 = p3 - pickedSticks;
				} else if (currentPile == 4) {
					p4 = p4 - pickedSticks;
				}
				totalNoOfSticks = totalNoOfSticks - pickedSticks;
				turn = !turn;
			}
		}

		String looser = "";

		if (turn) {
			looser = "P1";
		} else {
			looser = "P2";
		}

		System.out.println("Player " + looser + " lost");
	}

	/* getPileRepresentaion method for showing sticks "|" */

	private static String getPileRepresentation(int value) 
	{
		if (value == 0) 
		{
			return "";
		}
		String stringVal = "";

		for (int index = 1; index <= value; index++) 
		{
			stringVal = stringVal + "|";
		}

		return stringVal;
	}

	/* getRandomNumber method for generating a random number */
	
	public static int getRandomNumber(int min, int max) 
	{
		return (int) ((Math.random() * (max - min)) + min);
	}
}