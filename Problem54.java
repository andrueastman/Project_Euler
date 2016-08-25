import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem54{
	public static String winner(String hands[]){
		return "Player 2";
	}

	public static void main(String args[]){
		System.out.println("Problem54");
		int player1=0;
		int player2=0;
		try (BufferedReader br = new BufferedReader(new FileReader("p054_poker.txt"))){
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				String []cards=sCurrentLine.split(" ");
				String winner= winner(cards);
				if(winner.equals("Player 1")){
					player1++;
				}
				else{
					player2++;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Player 1 wins: "+player1);
		System.out.println("Player 2 wins: "+player2);
	}



}