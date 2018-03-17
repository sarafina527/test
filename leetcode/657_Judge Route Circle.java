class Solution {
    public boolean judgeCircle(String moves) {
        int[] steps = new int[4];
        for(int i=0;i<moves.length();i++){
        	char c = moves.charAt(i);
        	if(c=='L') steps[0]++;
        	else if(c=='R') steps[1]++;
        	else if(c=='U') steps[2]++;
        	else if(c=='D') steps[3]++;
        }
        return steps[0]==steps[1]&&steps[2]==steps[3];
    }
}