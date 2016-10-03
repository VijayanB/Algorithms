package algorithms.geeksforgeeks;

public class SubSequence {

	private int numberOfSubSequence(String s1, String s2) {
		int s1Length = s1.length();
		int s2Length = s2.length();

		int lookup[][] = new int[s1Length + 1][s2Length + 1];
		// if s1 is initial & s2 is not
		for (int i = 0; i <= s2Length; i++) {
			lookup[0][i] = 0;
		}
		// if s2 is initial and s1 is not
		for (int i = 0; i <= s1Length; i++) {
			lookup[i][0] = 1;
		}

		// rest
		for (int i = 1; i <= s1Length; i++) {
			for (int j = 1; j <= s2Length; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					lookup[i][j] = lookup[i - 1][j - 1] + lookup[i - 1][j];
				} else {
					lookup[i][j] = lookup[i - 1][j];
				}
			}
		}
		return lookup[s1Length][s2Length];

	}

	public static void main(String[] args) {
		System.out.println(new SubSequence().numberOfSubSequence("GeeksforGeeks", "Gks"));
	}

}
