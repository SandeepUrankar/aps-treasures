// https://codeforces.com/contest/1811/problem/A
import java.util.Scanner;
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T --> 0){
            in.nextInt();
            int d = in.nextInt();
            Boolean done = false;
            String input = in.next();
            StringBuffer num = new StringBuffer(input);
            for (int i = 0; i < num.length(); i++) {
                if(Integer.parseInt(num.charAt(i)+"") < d){
                    num.insert(i, d);
                    System.out.println(num);
                    done = true;
                    break;
                }else if(Integer.parseInt(num.charAt(i)+"") < d){
                    num.insert(i -1, d);
                    System.out.println(num);
                    done = true;
                    break;
                }
            }
            if(!done){
                num.append(d);
                System.out.println(num);
            }
        }
        in.close();
    }
}

