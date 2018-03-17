public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]]=='M')
        	board[click[0]][click[1]] = 'X';
        else if(board[click[0]][click[1]]=='E'){
        	char mcnt = '0';
        	for(int i=click[0]-1;i<=click[0]+1;i++){
        		for(int j=click[1]-1;j<=click[1]+1;j++){
        			if(i>=0&&i<board.length&&j>=0&&j<board[i].length&&board[i][j]=='M')
        				mcnt++;
        		}
        	}
        	if(mcnt!='0')
        		board[click[0]][click[1]] = mcnt;
        	else{
        		board[click[0]][click[1]] = 'B';
        		int[] newclick = new int[2];
        		for(int i=click[0]-1;i<=click[0]+1;i++){
	        		for(int j=click[1]-1;j<=click[1]+1;j++){
	        			newclick[0]=i;newclick[1]=j;
	        			if(i>=0&&i<board.length&&j>=0&&j<board[i].length)
	        				updateBoard(board,newclick);
	        		}
	        	}
        	}
        }
        return board;
    }
}