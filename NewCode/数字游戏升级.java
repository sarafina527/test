import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int T = scan.nextInt();
    for (int TC = 1; TC <= T; TC++) {
      int C = scan.nextInt();
      int D = scan.nextInt();
      int V = scan.nextInt();
      Queue<Integer> Q = new ArrayDeque<>();
      for (int i = 0; i < D; i++) {
        Q.add(scan.nextInt());
      }

      long N = 0;
      int add = 0;
      while (N < V) {
        // X = The smallest value we cannot produce.
        long X = N + 1;
        if (!Q.isEmpty() && Q.peek() <= X) {
          // Use pre-existing denomination we haven't used.
          X = Q.poll();
        } else {
          // No way to produce N+1, add a new denomination.
          add++;
        }
        N += X * C;
      }
      System.out.printf("Case #%d: %d\n", TC, add);
    }
  }
}

#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>
#include <limits.h>
#include <math.h>
#include <algorithm>
using namespace std;
typedef long long ll;
 
int a[1005];
 
int main(){
    int miss=0;
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++)scanf("%d",&a[i]);
    sort(a,a+n);
    for(int i=0;i<n;i++){
        if(a[i]>miss+1) break;
        miss+=a[i];
    }
    printf("%d\n",miss+1);
    return 0;
} 