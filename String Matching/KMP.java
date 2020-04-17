import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class KMP
{
    
    public static int[] Compute_prefix_func(String pat)
    {
        int m=pat.length();
        int[] pi=new int[m];
        pi[0]=0;int k=0;
        for(int q=1;q<=(m-1);q++)
        {
            while(k>0 && pat.charAt(k)!=pat.charAt(q))
            {
                k=pi[k-1];
            }
            if (pat.charAt(k)==pat.charAt(q))
            { 
                k=k+1;
            }
            pi[q]=k;

        }
        // for(int i=0;i<m;i++)
        // {
        //     System.out.println(pi[i]);
        // }
        return pi;

    }
  
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the TEXT");
        String txt=br.readLine();
        System.out.println("Enter the PATTERN");
        String pat=br.readLine();
        int M = pat.length(); 
        int N = txt.length();
        int pi[];
        pi=Compute_prefix_func(pat);
        // for(int i=0;i<M;i++)
        // {
        //     System.out.println(pi[i]);
        // }
        int i,q=0;
        for(i=0; i<N ; i++)
        {
            while(q>0 && pat.charAt(q)!=txt.charAt(i))
            {
                q=pi[q-1];
            }
            if(pat.charAt(q)==txt.charAt(i))
            {
                q=q+1;
            }
            if (q==M)
            {
               System.out.println("pattern found at index  "+(i-M+1));
                q=pi[q-1];
            }
        }
    }
}

output:


Enter the TEXT
abbbbaaabbbaaabaaabbab
Enter the PATTERN
ab
pattern found at index  0
pattern found at index  7
pattern found at index  13
pattern found at index  17
pattern found at index  20

C:\Users\Melody vilas pereira\Desktop\AOA>

