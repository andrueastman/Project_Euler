import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;


public class Problem99{
	public static void main(String args[]){
		try{
			Scanner in = new Scanner(new FileReader("p099_base_exp.txt"));
			int lineNumber=0;
			int largestLine=0;
			double largestResult=0;
			while(in.hasNextLine()){
				String [] pair= in.next().split(",");
				//System.out.println(pair[0]+":"+pair[1]);
				double num= Double.parseDouble(pair[0]);
				double exp= Double.parseDouble(pair[1]);
				double log=Math.log(num);
				lineNumber++;

				if((log*exp)>largestResult){
					largestResult=log*exp;
					largestLine=lineNumber;
				}
			}
			System.out.println(largestLine);
		}
		catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
	}
}
