import java.io.*;
class knapSack
{
    void printSack(int v[],int w[],int W,int numObj,int knaptable[][],char keep[][])
    {
        if(numObj==0||W==0)
        {
            return;
        }
        else if(keep[numObj][W]=='x')
        {
            System.out.println(knaptable[numObj][W]);
    
        }
        else
        {

        }
    }
    int findmax(int a,int b)
    {
        if(a>b)
        {
            return a;
        }
        else{
            return b;
        }
    }
    void KnapSack(int v[],int w[],int W,int numObj,int knaptable[][],char keep[][])
    {
        for(int i=0;i<=numObj;i++)
        {
            for(int j=0;j<=W;j++)
            {
                if(i==0||j==0)
                {
                    knaptable[i][j]=0;
                }
                else if(w[i-1]<=j)
                {
                    knaptable[i][j]=findmax(knaptable[i-1][j],v[i-1]+knaptable[i-1][j-w[i-1]]);
                    keep[i][j]='x';
                }
                else
                {
                    knaptable[i][j]=knaptable[i-1][j];
                    keep[i][j]='u';
                }
            }
        }
        for(int i=0;i<=numObj;i++)
        {
            for(int j=0;j<=W;j++)
            {
            System.out.print(" "+knaptable[i][j]); 
            }
            System.out.println();
        }
        System.out.println("The max weight is: "+knaptable[numObj][W]);
    }
    public static void main(String [] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the weight of the bag");
        int W=Integer.parseInt(br.readLine());
        System.out.println("Enter the number of objects");
        int numObj=Integer.parseInt(br.readLine());
        int v[]=new int[numObj];
        int w[]=new int[numObj];
        System.out.println("Enter the weight of objects");
        for(int i=0;i<numObj;i++)
        {
            w[i]=Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the value of objects");
        for(int i=0;i<numObj;i++)
        {
            v[i]=Integer.parseInt(br.readLine());
        }
        int knaptable[][]=new int[numObj+1][W+1];
        char keep[][]=new char[numObj+1][W+1];
        knapSack ks=new knapSack();
        ks.KnapSack(v,w,W,numObj,knaptable,keep);
        ks.printSack(v,w,W,numObj,knaptable,keep);
    }
}