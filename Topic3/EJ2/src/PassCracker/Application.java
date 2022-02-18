package PassCracker;

import java.util.*;

/**
 * Class Application
 * @Description Main class that runs the application
 * @author luis.pineda
 * @date 18-02-2022
 * @version 1.0
 */

public class Application {

    /**
     * analize
     *
     * @return void
     * @Description Method that analize and evaluates the password, according to a String of possible passwords
     * @date 11-02-2022
     */
    public static void analize(String a[], String pass) {
        int ans = 0;
        Queue<String> q = new LinkedList<String>();
        int f = 0;
        for (int i = 0; i < a.length; i++) {
            if (pass == "" || pass == " " || pass.length() == 0) {
                f = 1;
                break;
            }
            if (pass.startsWith(a[i])) {
                q.add(a[i]);
                int l = a[i].length();
                pass = pass.substring(l);
                ans = ans + 1;
                i = -1;
            }
        }
        if (f == 0) {
            System.out.print("WRONG PASSWORD");
        } else {
            while (!q.isEmpty()) {
                String tem = q.remove();
                System.out.print(tem + " ");
            }
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int m = s.nextInt();
            String a[] = new String[m];
            for (int j = 0; j < m; j++) {
                a[j] = s.next();
            }
            String pass = s.next();
            analize(a, pass);
            System.out.println();
        }
    }
}