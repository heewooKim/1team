import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
        
        String input = bf.readLine();
        
        StringTokenizer token = new StringTokenizer(input, " ");

        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());

        System.out.println((a+b)%c);
        System.out.println((a%c) + (b%c)%c);
        System.out.println((a*b)%c);
        System.out.println((a%c) * (b%c)%c);
        
    }
}