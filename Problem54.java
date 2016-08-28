import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Problem54{
	public static String []values={"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
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

	public static String[] hasThreeKind(String []hand){
		String[] result=new String[3];
		for(int j=0;j<hand.length-2;j++){
			char suit=hand[j].charAt(0);
			char counter=1;
			for(int i=j+1;i<hand.length;i++){
				if(hand[i].contains(""+suit)){
					counter++;
				}
			}

			if(counter==3){
				result[0]="ThreeKind";
				result[1]=""+suit;
				return result;
			}	
		}
		result[0]="No ThreeKind";
		return result;
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

	public static String[] cardValues(String []hands){
		String[] x=new String[2];
		String cards=Arrays.toString(hands);
		for (int i=values.length-1; i>=0; i--) {
			if(cards.contains(values[i])){
				if(x[0]==null){
					x[0]=values[i];
				}
				else{
					x[1]=values[i];
					return x;
				}
			}
		}
		return x;	
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

	public static boolean isStraight(String hands[]){
		
		String cards=Arrays.toString(hands);
		for(int i=0;i<values.length-5;i++){
			int counter=0;
			for(int j=i;j<i+5;j++){
				if(cards.contains(values[j])){
					counter++;
				}
			}
			if(counter==5){
				return true;
			}
		}
		return false;
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
		}*/

		if(isStraight(player1)){
			System.out.println("Player 1 Straight: "+Arrays.toString(player1));
			return "Player 1";
		}	
		if(isStraight(player2)){
			System.out.println("Player 2 Straight: "+Arrays.toString(player2));
			return "Player 2";
		}/*
		String [] res1=hasThreeKind(player1);
		String [] res2=hasThreeKind(player2);
		if(res1[0].equals("ThreeKind")){
			res1=hasOtherPair(res1,player1);
			if(res1[2]!=null){
				System.out.println("Player 1 has two Pairs of: "+res1[1]+" and "+res1[2]+" "+Arrays.toString(player1));		
			}else{
				System.out.println("Player 1 has ThreeKind of: "+res1[1]+Arrays.toString(player1));
			}
		}
		
		if(res2[0].equals("ThreeKind")){
			res2=hasOtherPair(res2,player2);
			if(res1[2]!=null){
				System.out.println("Player 2 has two Pairs of: "+res2[1]+" and "+res2[2]+" "+Arrays.toString(player2));	
			}else{
				System.out.println("Player 2 has ThreeKind of: "+res2[1]+Arrays.toString(player2));
			}
		}*/
		//System.out.println(hasThreeKind(player1)+" "+Arrays.toString(player1));
		System.out.println(Arrays.toString(cardValues(player1))+": "+Arrays.toString(player1));
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