import java.io.*;
class quickSort
{
    void quick(String s[],int beg,int end)
    {
        int p;
        if(beg<end)
        {
            p=quicksort(s,beg,end);
            quick(s,beg,p-1);
            quick(s,p+1,end);
        }
    }
    int quicksort(String s[],int beg,int end)
    {
        int j,i;
        String temp,pivot;
        pivot=s[end];
        i=beg-1;
        for(j=beg;j<=end-1;j++)
        {
            if(s[j].compareTo(pivot) <= 0)
            {
                i++;
                temp=s[j];
                s[j]=s[i];
                s[i]=temp;
            }
        }
        temp=s[i+1];
        s[i+1]=pivot;
        s[end]=temp;
    
    return (i+1);
    }
public static void main(String args[])throws IOException
{
BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter no. of elements");
int n = Integer.parseInt(obj.readLine());
String s[] = new String[n];
int i;
for(i = 0; i < n; i++)
{
s[i] = obj.readLine();
}
System.out.println("Before sorting");
for(i = 0; i < n; i++)
{
System.out.print(s[i]+" ");
}

quickSort qui = new quickSort();
qui.quick(s, 0, n - 1);
System.out.println();
System.out.println("Sorted Array is :");
for(i = 0; i < n; i++)
{
System.out.print(s[i]+" ");
}
}
}
/*
C:\Users\Melody vilas pereira\Desktop\AOA>javac quickSort.java
C:\Users\Melody vilas pereira\Desktop\AOA>java quickSort
Enter no. of elements
6
m
e
l
o
d
y
Before sorting
m e l o d y
Sorted Array is :
d e l m o y
C:\Users\Melody vilas pereira\Desktop\AOA> 
*/




