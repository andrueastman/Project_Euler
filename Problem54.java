import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Problem54{
	public static boolean isRoyalFlush(String hand){
		if(hand.contains("T") && hand.contains("K") && hand.contains("Q") && hand.contains("J") && hand.contains("A"))
			return true;
		else 
			return false;
	}

	public static boolean isFlush(String []hand){
		char suit=hand[0].charAt(1);
		for(int i=1;i<hand.length;i++){
			if(!hand[i].contains(""+suit)){
				return false;
			}
		}

		return true;
	}

	public static boolean hasThreeKind(String []hand){
		char suit=hand[0].charAt(0);
		char counter=1;
		for(int i=1;i<hand.length;i++){
			if(hand[i].contains(""+suit)){
				counter++;
			}
		}

		if(counter==3)
			return true;

		suit=hand[1].charAt(0);
		counter=1;
		for(int i=2;i<hand.length;i++){
			if(hand[i].contains(""+suit)){
				counter++;
			}
		}
		if(counter==3)
			return true;

		suit=hand[2].charAt(0);
		counter=1;
		for(int i=3;i<hand.length;i++){
			if(hand[i].contains(""+suit)){
				counter++;
			}
		}
		if(counter==3)
			return true;

		return false;
	}

	public static boolean hasPair(String []hand){
		char suit=hand[0].charAt(0);
		char counter=1;
		for(int i=1;i<hand.length;i++){
			if(hand[i].contains(""+suit)){
				counter++;
			}
		}

		if(counter==2)
			return true;

		suit=hand[1].charAt(0);
		counter=1;
		for(int i=2;i<hand.length;i++){
			if(hand[i].contains(""+suit)){
				counter++;
			}
		}
		if(counter==2)
			return true;

		suit=hand[2].charAt(0);
		counter=1;
		for(int i=3;i<hand.length;i++){
			if(hand[i].contains(""+suit)){
				counter++;
			}
		}
		if(counter==2)
			return true;

		return false;
	}
	public static String winner(String hands[]){
		String []player1=new String[5];
		String []player2=new String[5];
		System.arraycopy(hands,0,player1,0,player1.length);
		System.arraycopy(hands,player1.length,player2,0,player2.length);
		//royal flush
		if(isRoyalFlush(Arrays.toString(player1))){
			return "Player 1";
		}
		if(isRoyalFlush(Arrays.toString(player1))){
			return "Player 2";			
		}

		if(isFlush(player1)){
			System.out.println("Player 1 Flush: "+Arrays.toString(player1));
			return "Player 1";
		}	
		if(isFlush(player2)){
			System.out.println("Player 2 Flush: "+Arrays.toString(player2));
			return "Player 2";
		}

		if(hasThreeKind(player1)){
			System.out.println("Player 1 Three kind: "+Arrays.toString(player1));
			return "Player 1";
		}

		if(hasThreeKind(player2)){
			System.out.println("Player 2 Three Kind: "+Arrays.toString(player2));
			return "Player 2";
		}	

		if(hasPair(player1)){
			System.out.println("Player 1 Pair: "+Arrays.toString(player1));
			return "Player 1";
		}

		if(hasPair(player2)){
			System.out.println("Player 2 Pair: "+Arrays.toString(player2));
			return "Player 2";
		}
	else return "Don't know";	

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
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}