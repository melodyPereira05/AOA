import java.io.*;
class mergeSort
{
    void merge(String s[],int beg,int mid,int end,int len)
    {
         int i=beg;
         int j=mid+1;
         int index=beg;
         int k;
         String temp[]=new String[len];
         while(i<=mid && j<=end)
         {
             if(s[i].compareTo(s[j])>0)
             {
                 temp[index]=s[j];
                 j++;
             }
             else
             {
                 temp[index]=s[i];
                 i++;
             }
             index++;
         }
         if(j>end)
         {
            while(i<=mid)
            {
                temp[index]=s[i];
                i++;
                index++;
            }
         }
        else
        {
            while(j<=end)
            {
                temp[index]=s[j];
                j++;
                index++;
            }
        }
        
         for(k=beg;k<index;k++)
         {
             s[k]=temp[k];

         }
        }
        void merge_sort(String s[],int beg,int end,int len)
        {
            int mid;
            if(beg < end)
            {
                mid=(beg+end) / 2;
                merge_sort(s,beg,mid,len);
                merge_sort(s, mid+1, end,len);
                merge(s,beg,mid,end,len);
            }
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
System.out.println(s[i]);
}

mergeSort mg = new mergeSort();
mg.merge_sort(s, 0, n - 1,n);
System.out.println("Sorted Array is :");
for(i = 0; i < n; i++)
{
System.out.print(s[i]+" ");
}
}
}
/* Output
C:\Users\Melody vilas pereira\Desktop\AOA>javac mergeSort.java
C:\Users\Melody vilas pereira\Desktop\AOA>java mergeSort
Enter no. of elements
6
m
e
l
o
d
y
Before sorting
m
e
l
o
d
y
Sorted Array is :
d e l m o y
*/