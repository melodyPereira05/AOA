import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

class selectionSort
{
    void sSort(int arr[],int n)
    {
        int i,j,min,temp;
        for(i=0;i<n-1;i++)
        {
            min=i;
            for(j=i+1;j<n;j++)
            {
                if(arr[j]<arr[min])
                {
                    min=j;
                }
            }
            temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
        for(i=0;i<n;i++)
        {
            System.out.print(" "+arr[i]);
        }

    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the numbers of term");
        int n=Integer.parseInt(br.readLine());
        System.out.println("Enter the elements");
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=Integer.parseInt(br.readLine());
        }
        System.out.println("Before sorting");
        for(int i=0;i<n;i++)
        {
            System.out.print(" "+arr[i]);
        }
        selectionSort ss=new selectionSort();
        System.out.println("\nAfter sorting");
        ss.sSort(arr,n); 
    }
}

/*
    output
c:\Users\Melody vilas pereira\Desktop\AOA>javac selectionSort.java
c:\Users\Melody vilas pereira\Desktop\AOA>java selectionSort
Enter the numbers of term
10
Enter the elements
56
45
100
98
2
1
76
30
29
19
Before sorting
 56 45 100 98 2 1 76 30 29 19
After sorting
 1 2 19 29 30 45 56 76 98 100
*/