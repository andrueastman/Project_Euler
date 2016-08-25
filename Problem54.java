import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem54{
	public static void main(String args[]){
		System.out.println("Problem54");
		try (BufferedReader br = new BufferedReader(new FileReader("p054_poker.txt"))){
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}