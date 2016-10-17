import java.util.Scanner;


public class EnemyShipTesting {
	public static void main(String[] args) {
		/*
		 * 
		// ����һ����������Ҫͨ��������ʵ�־������͵��б����˵
		// �� dynamic-type��	
		EnemyShip theEnemy = null;
		
		EnemyShip ufoShip = new UFOEnemyShip();
		
		Scanner userInput = new Scanner(System.in);
		
		String enemyShipOption = "";
		
		System.out.println("What type of ship? (U / R)");		
		
		if (userInput.hasNextLine()) {
			enemyShipOption = userInput.nextLine();
		}
		
		// ��δ�������˵�naive
		if (enemyShipOption.equals("U")) {
			theEnemy = new UFOEnemyShip();
		}else if (enemyShipOption.equals("R")) {
			theEnemy = new RocketEnemyShip();
		}
		userInput.close();
		doStuffEnemy(theEnemy);
		
		*/
		
		/*
		 * ����Ĵ������������ġ������������
		 * �ǽ���һ���ǳ����õ�����
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
