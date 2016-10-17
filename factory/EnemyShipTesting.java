import java.util.Scanner;


public class EnemyShipTesting {
	public static void main(String[] args) {
		/*
		 * 
		// 这是一个反例，需要通过代码来实现具体类型的判别或者说
		// 是 dynamic-type。	
		EnemyShip theEnemy = null;
		
		EnemyShip ufoShip = new UFOEnemyShip();
		
		Scanner userInput = new Scanner(System.in);
		
		String enemyShipOption = "";
		
		System.out.println("What type of ship? (U / R)");		
		
		if (userInput.hasNextLine()) {
			enemyShipOption = userInput.nextLine();
		}
		
		// 这段代码是如此的naive
		if (enemyShipOption.equals("U")) {
			theEnemy = new UFOEnemyShip();
		}else if (enemyShipOption.equals("R")) {
			theEnemy = new RocketEnemyShip();
		}
		userInput.close();
		doStuffEnemy(theEnemy);
		
		*/
		
		/*
		 * 上面的代码如果用下面的“工厂”来替代
		 * 那将是一件非常美好的事情
		 */
		EnemyShipFactory shipFactory = new EnemyShipFactory();
		EnemyShip theEnemy = null;
		
		Scanner userInput = new Scanner(System.in);
		
		
		System.out.println("What type ship? (U/R/B)");
		
		if(userInput.hasNextLine()) {
			String typeOfShip = userInput.nextLine();
			theEnemy = shipFactory.makeEnemyShip(typeOfShip);
		}
		
		if (theEnemy != null) {
			doStuffEnemy(theEnemy);
		}else System.out.println("Enter a U, R, or B next time");
	}


	public static void doStuffEnemy(EnemyShip anEnemyShip) {
		anEnemyShip.displayEnemyShip();
		anEnemyShip.followHeroShip();
		anEnemyShip.enemyShipShoots();
	}
}
