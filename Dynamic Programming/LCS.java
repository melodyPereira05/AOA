import java.io.*;
public class LCS{
     void lcs(int c[][],char b[][], char str1[], char str2[], int m, int n) {
        int i, j;
        for (i = 0; i <= m; i++) {
            c[i][0] = 0;b[i][0] = 0;}
        for (i = 0; i <= n; i++) {
            c[0][i] = 0;b[0][i] = 0;}
        for (i = 1; i <= m; i++) {
            for (j =1; j <= n; j++) {
                if (str1[i - 1] == str2[j - 1]){
                    c[i][j]=c[i-1][j-1]+1;  b[i][j]='d';}
                else if(c[i-1][j]>c[i][j-1]){
                    c[i][j]=c[i-1][j];b[i][j]='u';}else{
                    c[i][j]=c[i][j-1];b[i][j]='l';}}}}
    void  printPath(int c[][],char b[][],char str1[],char str2[],int m,int n){
        if(m==0 || n==0)return;
        else if(b[m][n]=='d'){
            printPath(c,b,str1,str2,m-1,n-1);
            System.out.print(str1[m-1]);}
        else if(b[m][n]=='l'){
            printPath(c, b, str1, str2, m, n-1);}
        else if(b[m][n]=='u'){
            printPath(c, b, str1, str2, m-1, n);}}
    void printtable(int c[][],char b[][],char str1[],char str2[],int m,int n){
        int i,j;
        System.out.print("   ");
        for(i=0;i<n;i++){
            System.out.print(" "+str2[i]);}
        System.out.println();
        for(i=0;i<=m;i++){
            if(i==0){
                System.out.print(" ");}
            else{
                System.out.print(str1[i-1]);}
            for(j=0;j<=n;j++){
                System.out.print(" "+c[i][j]);}
            System.out.println();}
        System.out.println();}
    public static void main(String [] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter string");
        String st1=br.readLine();
        System.out.println("Enter subString");
        String st2=br.readLine();
        char str1[]=st1.toCharArray();char str2[]=st2.toCharArray();
        int m=str1.length;int n=str2.length;
        int c[][]=new int[m+1][n+1]; char b[][] =new char[m+1][n+1];
        LCS ls=new LCS();
        ls.lcs(c,b,str1,str2,m,n);
        ls.printPath(c,b,str1,str2,m,n);
        System.out.println();
        ls.printtable(c, b, str1, str2, m, n); }}
/*
o/p:
Enter string
ABCBDAB
Enter subString
ABCXYZ
ABC
    A B C X Y Z
  0 0 0 0 0 0 0
A 0 1 1 1 1 1 1
B 0 1 2 2 2 2 2
C 0 1 2 3 3 3 3
B 0 1 2 3 3 3 3
D 0 1 2 3 3 3 3
A 0 1 2 3 3 3 3
B 0 1 2 3 3 3 3
 */