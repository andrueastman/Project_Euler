import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem81{
	public static void main(String args[]){
		int [] [] matrix= new int[80][80];
		try (BufferedReader br = new BufferedReader(new FileReader("p081_matrix.txt"))){
			String sCurrentLine;
			int row = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				String []values=sCurrentLine.split(",");
				for(int i=0;i<80;i++){
					matrix[row][i]=Integer.parseInt(values[i]);
				}
				row++;
			}//array of integers populated

		} catch (IOException e) {
			e.printStackTrace();
		}

		/*for(int i=0;i<80;i++){
			for(int j=0;j<80;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}*/
		System.out.println(minCost(matrix,79,79));
	}

	private static int minCost(int cost[][], int m, int n)
    {
        int i, j;
        int tc[][]=new int[m+1][n+1];	//create array of equal size

        tc[0][0] = cost[0][0];			//copy starting point
 
        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];
 
        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];
 
        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = min(tc[i-1][j],tc[i][j-1]) + cost[i][j];
 
        return tc[m][n];
    }

	public static int min(int a,int b){
		if(a>b)
			return b;
		else return a;
	}
}