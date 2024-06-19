import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Buffer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 010 1234 5678
        // 010 / 1234 / 5678
        String first = st.nextToken();
        String second = st.nextToken();
        String third = st.nextToken();

        System.out.println(first + second + third);
    }
}
