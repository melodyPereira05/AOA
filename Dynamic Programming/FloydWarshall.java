import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class FloydWarshall{
  public static void pathprint(int s,int v,int p[][]){
    if(s==v){System.out.print(" "+s+" ");}
    else if(p[s][v]==-1) { System.out.println("Path does not exists");}
    else{pathprint(s,p[s][v],p);
    System.out.print(" "+v+" ");}
    System.out.println();}
  public static void floydWarshall(int[][] G,int d[][],int p[][],int V)
  {int i,j,k;
    for(k=0;k<V;k++){
      for(i=0;i<V;i++){
        for(j=0;j<V;j++){
          if(d[i][j]<=d[i][k]+d[k][j])
          continue;
          else{
            d[i][j]=d[i][k]+d[k][j];p[i][j]=p[k][j];}}}}}
  public static void Initilaize(int G[][],int d[][],int p[][],int V){
    int i,j;
    for(i=0;i<V;i++){
      for(j=0;j<V;j++){
        if(i==j){
          d[i][j]=0;p[i][j]=-1;}
        else if(G[i][j]==0){
          d[i][j]=999;p[i][j]=-1;}
        else{
          d[i][j]=G[i][j];p[i][j]=i; }  } }}
  public static void Display(int G[][],int V){
    for(int i=0;i<V;i++){
      for(int j=0;j<V;j++){
        System.out.print("  "+G[i][j]+"  ");}
      System.out.println();}}
    public static void main(String[] args)throws IOException{
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  System.out.println("Enter the no. of vertices");
  int V=Integer.parseInt(br.readLine());
  int G[][]=new int[V][V]; 
  System.out.println("Enter the graph elements");
  for(int i=0;i<V;i++){
    for(int j=0;j<V;j++){
      G[i][j]=Integer.parseInt(br.readLine());}}
  System.out.println("The entered graph is:");
  Display(G,V);
  int d[][]=new int [V][V];int p[][]=new int[V][V];
  Initilaize(G,d,p,V);
  System.out.println("The initialize d matrix is:");
  Display(d,V);
  System.out.println("The initialize p matrix is:");
  Display(p,V);floydWarshall(G,d,p,V);
System.out.println("The floydwarshall d matrix is:");
Display(d,V);
System.out.println("The floydwarshall p matrix is:");
Display(p,V);
System.out.println("The path printing");
for(int i=0;i<V;i++){
  for(int j=0;j<V;j++){
    if(i==j)continue;
    System.out.println("The path from "+i+" to "+j);
    pathprint(i,j,p);}}}}
    /*
o/p:
Enter the no. of vertices
5
Enter the graph elements
0 0 6 3 0 3 0 0 0 0 0 0 0 2 0 0 1 1 0 0 0 4 0 2 0
The entered graph is:
  0    0    6    3    0  
  3    0    0    0    0
  0    0    0    2    0
  0    1    1    0    0
  0    4    0    2    0
The initialize d matrix is:
  0    999    6    3    999  
  3    0    999    999    999
  999    999    0    2    999
  999    1    1    0    999  
  999    4    999    2    0
The initialize p matrix is:
  -1    -1    0    0    -1
  1    -1    -1    -1    -1
  -1    -1    -1    2    -1
  -1    3    3    -1    -1
  -1    4    -1    4    -1  
The floydwarshall d matrix is:
  0    4    4    3    999
  3    0    7    6    999
  6    3    0    2    999
  4    1    1    0    999
  6    3    3    2    0
The floydwarshall p matrix is:
  -1    3    3    0    -1  
  1    -1    3    0    -1
  1    3    -1    2    -1
  1    3    3    -1    -1
  1    3    3    4    -1
The path printing
The path from 0 to 1
 0 3 1 
The path from 0 to 2
 0 3  2
The path from 0 to 3
 0 3
The path from 0 to 4
Path does not exists

The path from 1 to 0
 1 0
The path from 1 to 2
 1 0 3  2 
The path from 1 to 3
 1 0 3 
The path from 1 to 4
Path does not exists

The path from 2 to 0
 2 3 1 0
The path from 2 to 1
 2 3 1 
The path from 2 to 3
 2 3 
The path from 2 to 4
Path does not exists

The path from 3 to 0
 3 1 0
The path from 3 to 1
 3 1
The path from 3 to 2
 3  2
The path from 3 to 4
Path does not exists

The path from 4 to 0
 4 3 1 0
The path from 4 to 1
 4 3 1
The path from 4 to 2
 4 3 2
The path from 4 to 3
 4 3
/*

0
0
6
3
0
3
0
0
0
0
0
0
0
2
0
0
1
1
0
0
0
4
0
2
0

 */
