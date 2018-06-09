/**
 * @ version 1.0
 * @ author dbxiao
 */

/*12. 判断随机整数是否是素数

产生100个0-999之间的随机整数，然后判断这100个随机整数哪些是素数，哪些不是?*/
public class Su {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Su();
	}
	
	public Su() {
		for (int i = 0 ; i < 100 ; i++) {
			int num = (int) (1000*Math.random());
			for (int j = 2 ; j <= num / 2 ; j++) {
				if ( num % j == 0 ) {
					System.out.println(num+"不是素数");
					break;
				} else if (j == num / 2) {
					System.out.println(num+"是素数");
				}
			}
		}
	}

}
