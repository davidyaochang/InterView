package ext.test;

public class queue8 {
	public static int max = 8;      //8皇后
	public static int []array = new int [max];   //每一行棋子所在的行數
	public static int count = 0;  //紀錄有多少種可能性
	public static void main(String[] args) {

		new queue8().Check(0);
        System.out.println(count);
	}
    public void Check(int n){    	
        if (n == max){         	
        	printPlace();
            //count++;
            return;
        }
        for (int i = 0; i < max; i++){
            array[n] = i;
            if (JudgeIsOk(n)){
                Check(n + 1);
            }
        }
    }
    
    public boolean JudgeIsOk(int n){
        //判斷是否在同一列、同一行、或者同一對角線
        for (int i = 0; i < n; i++){
            if (array[i] == array[n] || (n - i) == Math.abs(array[i] - array[n])){
                return false;
            }
        }
        return true;
    }
    
	/** * 繪製8×8棋盤，列印皇后的位置 */ 
	public static void printPlace() {		
		count++; 		
		for (int i = 0; i < max; i++) { 			 
			System.out.println(); 
			for (int k = 0; k < max; k++) { 
				if (k == array[i]) { 					
					System.out.print("Q");
				} else { 					
					System.out.print(".");
				} 
			} 		
		}		
		System.out.println(); 
	}   
}
