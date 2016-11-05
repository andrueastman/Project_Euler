import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem59{
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("p059_cipher.txt"))){
			String sCurrentLine = br.readLine();//only one line in the file
			String []cards = sCurrentLine.split(",");;
			System.out.println(cards.length);//size of the number of 
			char start='a';
			char end='z';
			int []key={0,0,0};
			String [] test={"1","2","3","4","5"};
			//unlock(key,test);
			for(int i=start;i<=end;i++){
				for(int j=start;j<=end;j++){
					for(int k=start;k<=end;k++){
						key[0]=i;
						key[1]=j;
						key[2]=k;
						unlock(key,cards);
						//System.out.println(i+""+j+""+k);
					}
				}
			}	

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void unlock(int[] key,String[] cards){
		int keyLength=key.length;
		int cardsLength=cards.length;
		String words="";
		int sum=0;
		for(int i=0;i<cardsLength;){
			for (int j=0; j<keyLength && i<cardsLength;j++) {
				int res=(Integer.parseInt(cards[i]))^key[j];
				if(res<32 ){
					return;
				}
				sum=sum+res;
				words=words+((char)res);
				if(i<cardsLength){
					i++;
				}
			}
		}
		if(words.contains("the") && words.contains("and") && words.contains("this")){
			System.out.println(words);
			System.out.println(sum);
		}
		//System.out.println(words);
	}

}