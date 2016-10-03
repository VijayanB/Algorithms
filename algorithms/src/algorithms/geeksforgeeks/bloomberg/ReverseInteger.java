package algorithms.geeksforgeeks.bloomberg;

public class ReverseInteger {
public static void main(String[] args) {
	int x = -1234;
	double result = 0;
	int sign = 1;
	if (x < 0) { 
		sign = -1;
		x = -x;
	}
	while(x > 0){
		result = (result * 10) + (x %10);
		x = x/10;
	}
	System.out.println((result * sign));
}
}
