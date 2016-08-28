import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Problem54{
	public static boolean isRoyalFlush(String hand){
		if(hand.contains("T") && hand.contains("K") && hand.contains("Q") && hand.contains("J") && hand.contains("A") && isFlush(hand.split(" ")))
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

	public static String hasThreeKind(String []hand){
		char suit=hand[0].charAt(0);
		char counter=1;
		for(int i=1;i<hand.length;i++){
			if(hand[i].contains(""+suit)){
				counter++;
			}
		}

		if(counter==3){
			return "ThreeKind: "+suit;
		}

		suit=hand[1].charAt(0);
		counter=1;
		for(int i=2;i<hand.length;i++){
			if(hand[i].contains(""+suit)){
				counter++;
			}
		}

		if(counter==3){
			return "ThreeKind: "+suit;
		}

		suit=hand[2].charAt(0);
		counter=1;
		for(int i=3;i<hand.length;i++){
			if(hand[i].contains(""+suit)){
				counter++;
			}
		}
		if(counter==3){
			return "ThreeKind: "+suit;
		}

		return "No ThreeKind";
	}

	public static String[] hasPair(String []hand){
		String[] result=new String[3];
		for(int j=0;j<hand.length-1;j++){
			char suit=hand[j].charAt(0);
			char counter=1;
			for(int i=j+1;i<hand.length;i++){
				if(hand[i].contains(""+suit)){
					counter++;
				}
			}

			if(counter==2){
				result[0]="Pair";
				result[1]=""+suit;
				return result;
			}	
		}
		result[0]="No Pair";
		return result;
	}

	public static String[] hasOtherPair(String []result,String []hand){

		for(int j=0;j<hand.length-1;j++){
			char suit=hand[j].charAt(0);
			if(hand[j].contains(result[1])){
				continue;
			}
			char counter=1;
			for(int i=j+1;i<hand.length;i++){
				if(hand[i].contains(""+suit)){
					counter++;
				}
			}

			if(counter==2){
				result[0]="Pair";
				result[2]=""+suit;
				return result;
			}	
		}
		

		
		return result;
	}
	public static String winner(String hands[]){
		String []player1=new String[5];
		String []player2=new String[5];
		System.arraycopy(hands,0,player1,0,player1.length);
		System.arraycopy(hands,player1.length,player2,0,player2.length);
		//royal flush
		/*if(isRoyalFlush(Arrays.toString(player1))){
			return "Player 1";
		}
		if(isRoyalFlush(Arrays.toString(player2))){
			return "Player 2";			
		}

		if(isFlush(player1)){
			System.out.println("Player 1 Flush: "+Arrays.toString(player1));
			return "Player 1";
		}	
		if(isFlush(player2)){
			System.out.println("Player 2 Flush: "+Arrays.toString(player2));
			return "Player 2";
		}*/
		String [] res1=hasPair(player1);
		String [] res2=hasPair(player2);
		if(res1[0].equals("Pair")){
			res1=hasOtherPair(res1,player1);
			if(res1[2]!=null){
				System.out.println("Player 1 has two Pairs of: "+res1[1]+" and "+res1[2]+" "+Arrays.toString(player1));		
			}
		}
		
		if(res2[0].equals("Pair")){
			res2=hasOtherPair(res2,player2);
			if(res1[2]!=null){
				System.out.println("Player 2 has two Pairs of: "+res2[1]+" and "+res2[2]+" "+Arrays.toString(player2));	
			}
		}
			
		return "Don't know";	

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