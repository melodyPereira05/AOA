import java.io.*;

class insertionSort
{
    void sortElements(int arr[],int n)
    {
        int j,i,temp;
        for(j=1;j<n;j++)
        {
            i=j-1;
            temp=arr[j];
            while(i>=0&&temp<arr[i])
            {
                arr[i+1]=arr[i];
                i--;
            }
            arr[i+1]=temp;
        }
        for(i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the numbers of element");
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++)
        {
            arr[i]=Integer.parseInt(br.readLine());
        }
        System.out.println("Before sorting");
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        insertionSort is=new insertionSort();
        System.out.println("\nAfter sorting");
        is.sortElements(arr,n);


    }
}

/*
   output
c:\Users\Melody vilas pereira\Desktop\AOA>javac insertionSort.java
c:\Users\Melody vilas pereira\Desktop\AOA>java insertionSort
Enter the numbers of element
10
Enter the elements
8
7
6
5
0
1
2
3
5
67
Before sorting
8 7 6 5 0 1 2 3 5 67
After sorting
0 1 2 3 5 5 6 7 8 67 
*/ 