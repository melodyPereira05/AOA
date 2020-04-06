 #include<stdio.h>
#include <math.h>
int n,x[10],j;
int place(int x[], int k,int i)
{
    for(j=0;j<k;j++)
    {
        if(((x[j]==i)) && (abs(j-k)==abs(x[j]-i)))
            return 0;
    }
    return 1;
}

void printArray(int x[], int n)
{ int i;
    for(i=0;i<n;i++)
        printf("%d\t",x[i]);
    printf("\n");
}

void nQueen(int k,int n)
{
    int i;

    for(i=0;i<n;i++)
    {
        // x[r]=i;

        if(place(x,k,i))
        {
            x[k]=i;
            if(k==n)
                {
                printArray(x,n);
                }
            else
                nQueen(k+1,n);
        }
    }
}

int main()
{int i;
    printf("Enter the number of Queens:\n");
    scanf("%d",&n);
	for(i=0;i<10;i++)
	{
		x[i]=0;
	}
    nQueen(0,n);

    return 0;
}
