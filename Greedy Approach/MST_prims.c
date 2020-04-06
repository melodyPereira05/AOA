#include <stdio.h>
#include <stdlib.h>
#define INF 999
int V;
int queue[10],G[10][10],pi[10],key[10],priority[10];
int r;
int front = 0,rear = 0,tc=0;

void ReadGraph()
{
    int i,j;
  printf("Enter graph elements\n");
  for(i = 0; i < V; i++)
  {
    for(j = 0; j < V; j++)
    {
      scanf("%d",&G[i][j]);
    }
  }
}

void Displaygraph()
{
  printf("Graph is \n");
  for(int i = 0; i < V; i++)
  {
    for(int j = 0; j < V; j++)
    {
      printf("%d\t",G[i][j]);
    }
    printf("\n");
  }
}

void Initialize()
{
  for(int i = 0;i <V; i++)
  {

    key[i] = INF;
    pi[i] = -1;
  }
  key[r] = 0; //root veretex to zero
}

int Member_q(int elem)
{
    for(int i = front; i<=rear; i++)
    {
        if(elem==queue[i])
            return 1;
    }
    return 0;
}

void printArray(int arr[])
{

  for(int i = 0;i < V; i++)
  {
    printf("%d\t",arr[i]);
  }
  printf("\n");
}

void priority_Queue()
{

  printf("Queue\n");
  for(int i = front;i <= rear; i++)
  {
    printf("%d\t",queue[i]);
  }
  printf("\nPriority queue\n");
  for(int i = front;i <=rear; i++)
  {
    printf("%d\t",priority[i]);
  }
}

void MinPriorityQueue() //inserting in priority queue
{
    for (int i=0; i<V;i++)
    {
        queue[rear] = i;
        priority[rear] = key[i];
        rear++;
    }
    rear--;
    printf("\n");
    printf("Priority queue after creation is :\n");
    priority_Queue();
    printf("\n");
}

int Extract_Min()
{
    int min = priority[front];
    int pos = front;

    for(int i=front+1;i<=rear;i++)
    {
        if(min>priority[i])
        {
            min = priority[i];
            pos = i;
        }
    }

    for (int i=pos;i<rear;i++)
    {
        priority[i] = priority[i+1];
        queue[i] = queue[i+1];
    }
    rear--;
    return pos;
}


int CostOfMST()
{
  for(int i = 0; i<=V-1;i++)
  {
      if (i==r)
        continue;
      tc=tc+G[i][pi[i]];

  }
  return tc;

}

int main()
{
    int u;
  printf("Enter number of vertices");
  scanf("%d",&V);
  ReadGraph();
  Displaygraph();
  printf("Enter starting Vertex  ");
  scanf("%d",&r);
  Initialize(); // key to inf and pi to nil except r
printf("The key array is : \n");
printArray(key);
printf("\n");
printf("The pi array is: \n");
printArray(pi);
MinPriorityQueue();
  while(rear >= 0)
  {
      u = Extract_Min();
      printf("\n min selected is :%d\n",u);
      for(int i = 0; i < V; i++)
      {
          if(G[u][i]!=0)
          {
            if(Member_q(i) && G[u][i] < key[i])
            {
                pi[i] = u;
                key[i] = G[u][i];
                priority[i] = G[u][i];

            }
          }
          printf("\n");
          //priority_Queue();
          //printf("\n");
      }
  }
  printf("\nThe key array is :\n");
  printArray(key);
  printf("\nThe pi array is :\n");
  printArray(pi);
  printf("\n\nTotal Cost is : %d", CostOfMST());
 return 0;
}
/*
0
4
0
0
0
0
0
8
0
4
0
8
0
0
0
0
11
0
0
8
0
7
0
4
0
0
2
0
0
7
0
9
14
0
0
0
0
0
0
9
0
10
0
0
0
0
0
4
14
10
0
2
0
0
0
0
0
0
0
2
0
1
6
8
11
0
0
0
0
1
0
7
0
0
2
0
0
0
6
7
0
*/

