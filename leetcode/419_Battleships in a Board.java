class Solution {
    public int countBattleships(char[][] board) {
    	if(board.length==0) return 0;
    	int ans=0;
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		if(board[i][j]=='X'&&isStart(board,i,j))
        			ans++;
        	}
        }
        return ans;
    }
    public boolean isStart(char[][] board,int i,int j){
    	if((i-1<0||board[i-1][j]=='.')&&(j-1<0||board[i][j-1]=='.'))
    		return true;
    	else
    		return false;
    }
}