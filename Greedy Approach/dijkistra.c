#include<stdio.h>
#define INF 999
int G[10][10],d[10],pi[10];
int Q[10][2];
int V;

void readgraph()
{
    printf("Enter the Graph\n");
    for(int i=0;i<V;i++)
    {
        for(int j=0;j<V;j++)
        {
            scanf("%d",&G[i][j]);
        }
    }
}

void displaygraph()
{
    printf("The graph is\n");
    for(int i=0;i<V;i++)
    {
        for(int j=0;j<V;j++)
        {
            printf("%d\t",G[i][j]);
        }
        printf("\n");
    }
}

void Initialize(int s)
{
    int i,j;
    for(i=0;i<V;i++)
    {
        d[i]=INF;
        pi[i]=-1;
    }
    d[s]=0;
}

void display1Darray(int a[])
{
    for(int i=0;i<V;i++)
    {
        printf("%d\t",a[i]);
    }
}

void Min_priority_Queue()
{
    for(int i=0;i<V;i++)
    {
        Q[i][0]=i; //element
        Q[i][1]=d[i]; //priority
    }
    printf("\nThe Min priority Queue created is\n Element  Priority\n");
    for(int i=0;i<V;i++)
    {
        printf("   %d     %d",Q[i][0],Q[i][1]);
        printf("\n");
    }
}

int Extract_min()
{
    int i,j,min,pos;
    min=Q[0][1];
    pos=0;
    for(i=1;i<V;i++)
    {
        if(min>Q[i][1])
        {
            min=Q[i][1];
            pos=Q[i][0];
        }
    }
    Q[pos][1]=INF;
    return pos;
}

void Relax(int u,int v,int w)
{
        if(d[v]>d[u]+w)
        {
            d[v]=d[u]+w;
            Q[v][1]=d[v];
            pi[v]=u;
        }
}
void printPath(int s,int v)
{
    if(v==s)
        printf(" %d ",s);
    else if (pi[v]==-1)
        printf("\nNo path exist\n");
    else
    {
        printf("\n");
        printPath(s,pi[v]);
        printf("  %d  ",v);
    }

}
int main()
{
    int D_array[10],s;
    for(int i=0;i < V;i++)
    {
        D_array[i]=0;
    }
    printf("\nEnter the number of vertices\n");
    scanf("%d",&V);
    readgraph();
    displaygraph();
    printf("\nEnter the source vertex\n");
    scanf("%d",&s);
    Initialize(s);
    printf("\nThe pi array after initialization is\n");
    display1Darray(pi);
    printf("\nThe shortest distance array after initialization is\n");
    display1Darray(d);
    Min_priority_Queue();
    for(int i=0;i < V;i++)
    {
        int u=Extract_min();
        //printf("\n%d\n",u);
        D_array[i]=u;
        for(int v=0;v<V;v++)
        {
            if(G[u][v]!=0)
            {
                Relax(u,v,G[u][v]);
            }
        }

    }
    printf("\nThe pi array is\n");
    display1Darray(pi);
    printf("\nThe shortest distance array  is\n");
    display1Darray(d);
    printf("\nThe elements popped from queue into another array are : \n");
    display1Darray(D_array);
    printf("\n\nThe path printing is\n");
    for(int i=0;i<V;i++)
    {
        if (i==s)
            continue;
        printf("\nThe path from %d to %d is: ",s,i);
        printPath(s,i);

    }
}
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

/*Enter the number of vertices
5
Enter the Graph
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
The graph is
0       0       6       3       0
3       0       0       0       0
0       0       0       2       0
0       1       1       0       0
0       4       0       2       0

Enter the source vertex
4

The pi array after initialization is
-1      -1      -1      -1      -1
The shortest distance array after initialization is
999     999     999     999     0
The Min priority Queue created is
 Element  Priority
   0     999
   1     999
   2     999
   3     999
   4     0

The pi array is
1       3       3       4       -1
The shortest distance array  is
6       3       3       2       0
The elements popped from queue into another array (D_array) are :
4       3       1       2       0

The path printing is
The path from 4 to 0 is:  4   3    1    0

The path from 4 to 1 is:  4   3    1

The path from 4 to 2 is:  4   3    2

The path from 4 to 3 is:  4   3
Process returned 0 (0x0)   execution time : 5.339 s
Press any key to continue.
*/

