// // 투포인터
// import java.io.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         String s = br.readLine();
//         String t = br.readLine();

//         System.out.println(isSecret(s, t) ? "YES" : "NO");

        

//     }

//     static boolean isSecret(String s, String t) {
//         int i = 0;

//         for (int j = 0; j < s.length(); j++) {
//             if (i < t.length() && s.charAt(j) == t.charAt(i))
//                 i++;
//         }

//         return i == t.length();
//     }
// }