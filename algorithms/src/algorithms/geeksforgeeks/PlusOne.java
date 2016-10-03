package algorithms.geeksforgeeks;

public class PlusOne {
public static void main(String[] args) {
	int [] num = { 9,9,9,9};
	int carry = 1;
	int sum = 0;
	for(int i = num.length-1 ; i >= 0; i--){
		sum = carry + num[i];
		num[i] = sum %10;
		carry = sum / 10;
		if(carry == 0){
			for(int n : num){
			System.out.print(n);
			}
			break;
		}
	}
	if(carry == 1){
		int [] res = new int [num.length+1];
		System.arraycopy(num, 0, res, 1, num.length);
		res[0]=1;
		for(int n : res){
			System.out.print(n);
			}
	}
}
}
