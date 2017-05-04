import java.util.Collections;
import java.util.ArrayList;

class Fraction implements Comparable<Fraction>{
	int num;
	int den;
	int simpNum;
	int simpDen;
	public Fraction(int x,int y){
		num=x;
		den=y;
		simpNum=x/gcd(x,y);
		simpDen=y/gcd(x,y);;
	}

	int gcd(int a, int b)
	{
	  if(a == 0 || b == 0) return a+b; // base case
	  return gcd(b,a%b);
	}

	public String toString(){
		return ""+num+"/"+den;
	}

	public String simplified(){
		return ""+simpNum+"/"+simpDen;
	}

	public double toDouble(){
		double x=simpNum;
		double y=simpDen;
		return x/y;
	}

	public boolean isReduced(){
		return (den==simpDen);
	}

	 // Overriding the compareTo method
	public int compareTo(Fraction d) {
	  return (((Double)this.toDouble())).compareTo(((Double)d.toDouble()));
	}

}


public class Problem71{
	public static void main(String args[]){
		int largest =1000000;
		Fraction fraction = new Fraction(3,7);
		Fraction fraction2 = new Fraction(2,7);
		ArrayList <Fraction>fractionList = new ArrayList<Fraction>();
		denominator:
		for(int i=1;i<=largest;i++){
			//System.out.println("I: "+i);
			int j=(int)(fraction2.toDouble()*i);
			//System.out.println("J: "+j);
			for(;j<i;j++){
				Fraction frac = new Fraction(j,i);
				Fraction frac2 = new Fraction(i,j);
				if(frac.toDouble()>=fraction.toDouble()){
					continue denominator;
				}//discard fractions greater than 3/7
				if(!frac.isReduced() || frac.toDouble()<fraction2.toDouble()){
					continue;
				}//dicard fractions that are not simplified and less than template base
				fraction2=frac;
				fractionList.add(frac);
			}
		}

		Collections.sort(fractionList);
		for(int i=0;i<fractionList.size();i++){
			System.out.println(fractionList.get(i).toString());
		}


	}
}
