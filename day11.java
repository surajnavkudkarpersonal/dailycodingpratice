/**
**/
import java.lang.Math;  
import java.util.Arrays;

class Day11 {

	int MAX_COL=4; 
	int MAX_ROW=4;
	int[][] gold={ {1, 3, 1, 5},
                   {2, 2, 4, 1},
                   {5, 0, 2, 3},
                   {0, 6, 1, 2}};

	private int maxGoldRecur(int r,int c){

		if(c>=MAX_COL)
			return 0;

		if(r<0 || r>=MAX_ROW)
			return 0;

		int rightTop = maxGoldRecur(r-1,c+1);
		int right = maxGoldRecur(r,c+1);
		int rightBottom = maxGoldRecur(r+1,c+1);

		return gold[r][c]+Math.max(rightTop, Math.max(right,rightBottom));

	}	

	public int maxGoldRecur(){
		int maxGold=0;

		for(int i=0;i<MAX_ROW;i++){
			int gold=maxGoldRecur(i,0);
			if(gold> maxGold)
				maxGold=gold;
		}

		return maxGold;
	}


	public int maxGoldRecurDp(){

		int goldTable[][] = new int[MAX_ROW][MAX_COL]; 
          
        for(int[] rows:goldTable) 
            Arrays.fill(rows, 0); 

		for(int i=MAX_COL-1;i>=0;i--){

			for(int j=0;j<MAX_ROW;j++){

				int rightTop = (j==0||i==MAX_COL-1)?0:gold[j-1][i+1]; 
				int right = (i==MAX_COL-1)?0:gold[j][i+1]; 
				int rightBottom = (j==MAX_ROW-1||i==MAX_COL-1)?0:gold[j+1][i+1]; 
				goldTable[j][i]=gold[j][i]+Math.max(rightTop, Math.max(right,rightBottom));
			}
		}
		int res = goldTable[0][0]; 
          
        for (int i = 1; i < MAX_ROW; i++) 
            res = Math.max(res, goldTable[i][0]); 
              
        return res; 
	}


}