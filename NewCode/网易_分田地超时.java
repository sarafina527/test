import java.util.*;
public class Main {  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] board = new char[80][80];   
        short[][] sum = new short[80+1][80+1];//preprocess  
        int[] x = new int[5];
        int[] y = new int[5];   
        while(input.hasNext()){
            int m = input.nextInt();
            int n = input.nextInt();
            for(int i=0;i<m;i++){
                board[i] = input.next().toCharArray();
            }
            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    sum[i][j] = (short)(board[i-1][j-1]-'0');
                }
            }
            for(int j=2;j<=n;j++) sum[1][j]+=sum[1][j-1];
            for(int i=2;i<=m;i++) sum[i][1]+=sum[i-1][1];
            for(int i=2;i<=m;i++){
                for(int j=2;j<=n;j++){
                    sum[i][j] += sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
                }
            }
            int ans = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
            x[4] = m;y[4] = n;
            for(x[1]=1;x[1]<m-2;x[1]++){
                for(x[2]=x[1]+1;x[2]<m-1;x[2]++){
                    for(x[3]=x[2]+1;x[3]<m;x[3]++){
                        for(y[1]=1;y[1]<n-2;y[1]++){
                            for(y[2]=y[1]+1;y[2]<n-1;y[2]++){
                                for(y[3]=y[2]+1;y[3]<n;y[3]++){
                                    min = Integer.MAX_VALUE;
                                    for(int i=0;i<4;i++){
                                        for(int j=0;j<4;j++){
                                            int valsum = sum[x[i+1]][y[j+1]]-sum[x[i]][y[j+1]]-sum[x[i+1]][y[j]]+sum[x[i]][y[j]];
                                            if(min>valsum) min = valsum;
                                        }
                                    }
                                    if(ans<min) ans=min;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}