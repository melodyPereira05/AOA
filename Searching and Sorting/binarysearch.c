#include<stdio.h>
#define max 10

 int binary_search(int a[],int beg,int end,int x)
 {
     int mid;
     if(end>=beg)
     {
          mid=(beg+end)/2;
         if(x==a[mid])
         {
             return a[mid];
         }
         else if(x>a[mid]){
            return binary_search(a,mid+1,end,x);
         }

         return  binary_search(a,beg,mid-1,x);

     }
     return -1;
 }

 int main()
 {
     int a[max],n,i,result,x;
     printf("Enter the length and value to find\n");
     scanf("%d %d",&n,&x);
     for(i=0;i<n;i++)
     {
         scanf("%d",&a[i]);
     }
     result=binary_search(a,0,n-1,x);
     if(result==-1)
     {
         printf("Element not found");
     }
     else
     {
         printf("element found");
     }
 }
