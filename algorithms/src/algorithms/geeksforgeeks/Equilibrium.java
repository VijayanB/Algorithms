package algorithms.geeksforgeeks;

public class Equilibrium {
	public int solution(int[] A) {
		if(A == null || A.length < 1){
			return -1;
		}
		long aux[] = new long[A.length];
		long prevSum = 0;
		for (int i = 0; i < A.length; i++) {
			aux[i] = prevSum;
			prevSum += A[i];
		}

		prevSum = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			aux[i] -= prevSum;
			if (aux[i] == 0)
				return i;
			prevSum += A[i];
		}
		return -1;
	}
	    
	    public static void main(String[] args) {
			System.out.println(new Equilibrium().solution(new int[] {0}));
		}
	}

