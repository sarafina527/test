class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] up = new int[N][N];
        int[][] down = new int[N][N];
        int[][] left = new int[N][N];
        int[][] right = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                up[i][j]=1;down[i][j]=1;left[i][j]=1;right[i][j]=1;
            }
        }
        for(int i=0;i<mines.length;i++){
            up[mines[i][0]][mines[i][1]]=0;
            down[mines[i][0]][mines[i][1]]=0;
            left[mines[i][0]][mines[i][1]]=0;
            right[mines[i][0]][mines[i][1]]=0;
        }
        for(int i=1;i<N;i++){
            for(int j=0;j<N;j++){
                if(up[i][j]>0)
                    up[i][j] = up[i-1][j]+1;
            }
        }
        for(int i=N-2;i>=0;i--){
            for(int j=0;j<N;j++){
                if(down[i][j]>0)
                    down[i][j] = down[i+1][j]+1;
            }
        }
        for(int j=1;j<N;j++){
            for(int i=0;i<N;i++){
                if(left[i][j]>0)
                    left[i][j] = left[i][j-1]+1;
            }
        }
        for(int j=N-2;j>=0;j--){
            for(int i=0;i<N;i++){
                if(right[i][j]>0)
                    right[i][j] = right[i][j+1]+1;
            }
        }
        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int k = Math.min(up[i][j],down[i][j]);
                if(left[i][j]<k) k=left[i][j];
                if(right[i][j]<k) k=right[i][j];
                if(ans<k) ans = k;
            }
        }
        return ans;
    }
}
