import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;


public class Problem99{
	public static void main(String args[]){
		try{
			Scanner in = new Scanner(new FileReader("p099_base_exp.txt"));
			while(in.hasNextLine()){
				System.out.println(in.next());
			}
		}
		catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
	}
}
