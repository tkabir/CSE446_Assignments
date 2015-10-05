//Calculating Z-values in a given string using the Z-algorithm in linear time

import java.util.Scanner;


public class A1_ZAlgLinear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("\nPlease enter a string: ");
		String str = in.nextLine();
		
		int n = str.length();		
		int [] z = new int[n];		
		char[] s = str.toCharArray();
		int L = 0, R = 0; 									//init L and R of Z-boxes
		z[0] = 0; 											//set 1st z-value to 0 or undefined
		
		System.out.print(z[0]+" ");
															//start loop for prefix matching in string s
		for(int i=1; i<n; i++) {
			if(i>R) {
				L = R = i;
															//initially R-L = 0; checking starts between s[0] and s[1] and so on...
				while(R < n && s[R-L] == s[R]) {
					R++; 									//inc R for each match found
				}
				z[i] = R-L; 								//once match window found, set z-value to current length of z-box
				R--; 										//dec R for next iteration
			}
			else {
				int k = i-L; 								//when R>i, set value k to the index at start of string
				if(z[k] < R-i+1) { 							//when match found, set z-value to corresponding L of z-box
					z[i] = z[k];
				}
				else {
					L = i; 									//else check for match separately as before
					while(R<n && s[R-L] == s[R]) {
						R++;
					}
					z[i] = R-L;
					R--;
				}
			}
			
			System.out.print(z[i] + " "); 					//print out z-values
		}
		in.close();

	}

}
