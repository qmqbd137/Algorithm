package Experience;

/**
 * @author Bd_Qmq
 * @create 2022-03-27 21:09
 */
public class P1E18 {
	public static int mystrty(int a,int b){
		if(b == 0){ return 0;}
		if ( b%2 == 0 ) { return mystrty(a+a,b/2);}
		return mystrty(a+a,b/2) + a;
	}
	public static void main(String[] args) {
		System.out.println(mystrty(2, 11));
	}
}
