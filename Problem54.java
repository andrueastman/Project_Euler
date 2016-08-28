import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
		//start from the top
		//flush wins!!
		if(isFlush(player1) && !isFlush(player2)){
			return "Player 1";
		}
		else if(isFlush(player2) && !isFlush(player1)){
			return "Player 2";
		}
		//straight wins!!
		else if(isStraight(player2) && !isStraight(player1)){
			return "Player 2";
		}
		else if(isStraight(player1) && !isStraight(player2)){
			return "Player 1";
		}
		//three of a kind wins!!
		String [] res1=hasThreeKind(player1);
		String [] res2=hasThreeKind(player2);
		if(res1[0].equals("ThreeKind") && !res2[0].equals("ThreeKind")){
			return "Player 1";
		}
		else if(res2[0].equals("ThreeKind") && !res1[0].equals("ThreeKind")){
			return "Player 2";
		}

		//pairs wins!!
		res1=hasPair(player1);
		res2=hasPair(player2);
		if(res1[0].equals("Pair") && !res2[0].equals("Pair")){
			return "Player 1";
		}
		else if(res2[0].equals("Pair") && !res1[0].equals("Pair")){
			return "Player 2";
		}
		else if(res2[0].equals("Pair") && res1[0].equals("Pair")){
			res1=hasOtherPair(res1,player1);
			res2=hasOtherPair(res2,player2);
			if(res1[2]==null && !(res2[2]==null)){
				return "Player 2";
			}
			else if(!(res1[2]==null) && res2[2]==null){
				return "Player 1";
			}
			else if(res1[2]==null && res2[2]==null){
				if(res1[1].equals(res2[1])){
					List vals=Arrays.asList(values);
					String[] vals1=cardValues(player1);
					String[] vals2=cardValues(player2);
					if(vals.indexOf(vals1[0])>vals.indexOf(vals2[0])){
						return "Player 1";
					}

					else if(vals.indexOf(vals2[0])>vals.indexOf(vals1[0])){
						return "Player 2";
					}
				}
				else{
					List vals=Arrays.asList(values);
					if(vals.indexOf(res1[1])>vals.indexOf(res2[1])){
						return "Player 1";
					}
					else{
						return "Player 2";
					}
				}
								
			}
			else if(!(res1[2]==null) && !(res2[2]==null)){
				System.out.println("Both have TWO PAirs!!");

			}
		}


		//highest value card wins!!
		List vals=Arrays.asList(values);
		String[] vals1=cardValues(player1);
		String[] vals2=cardValues(player2);
		if(vals.indexOf(vals1[0])>vals.indexOf(vals2[0])){
			return "Player 1";
		}

		else if(vals.indexOf(vals2[0])>vals.indexOf(vals1[0])){
			return "Player 2";
		}
		//System.out.println(hasThreeKind(player1)+" "+Arrays.toString(player1));
		//System.out.println(Arrays.toString(cardValues(player1))+": "+Arrays.toString(player1));
		return "Don't know";	

	}

	public static void main(String args[]){
		System.out.println("Problem54");
		int player1=0;
		int player2=0;
		int unknown =0;
		try (BufferedReader br = new BufferedReader(new FileReader("p054_poker.txt"))){
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				String []cards=sCurrentLine.split(" ");
				String winner= winner(cards);
				if(winner.equals("Player 1")){
					player1++;
				}
				else if(winner.equals("Player 2")){
					player2++;
				}
				else
					unknown++;

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Player 1: "+player1);
		System.out.println("Player 2: "+player2);
		System.out.println("unknown: "+unknown);
		System.out.println("Total Games: "+(player1+player2));
	}



}