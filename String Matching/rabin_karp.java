import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class rabin_karp
{
    public static void main(String [] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the TEXT");
        String txt=br.readLine();
        System.out.println("Enter the PATTERN");
        String pat=br.readLine();
        int d=256;
        int q=13;
        int M = pat.length(); 
        int N = txt.length(); 
        int i, j; 
        int p = 0; 
        int t = 0; 
        int h = 1; 
      
        for (i = 0; i < M-1; i++) 
            h = (h*d)%q; 
        for (i = 0; i < M; i++) 
        { 
            p = (d*p + pat.charAt(i))%q; 
            t = (d*t + txt.charAt(i))%q; 
        }  
        System.out.println("Hash of pattern is "+p);
        for (i = 0; i <= N - M; i++) 
        { 
            if ( p == t ) 
            { 
                for (j = 0; j < M; j++) 
                { 
                    if (txt.charAt(i+j) != pat.charAt(j)) 
                        break; 
                } 
                if (j == M) 
                    System.out.println("Pattern found at index " + i+" with hash value "+p); 
            }  
            if ( i < N-M ) 
            { 
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q; 
                if (t < 0) 
                t = (t + q); 
            } 
        } 
    }

}

output:

Enter the TEXT
abbbbaaabbbaaabaaabbab
Enter the PATTERN
ab
Hash of pattern is 9
Pattern found at index 0 with hash value 9
Pattern found at index 7 with hash value 9
Pattern found at index 13 with hash value 9
Pattern found at index 17 with hash value 9
Pattern found at index 20 with hash value 9
    
      
