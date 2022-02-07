import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap iniHash(){
        HashMap ch = new HashMap ();
        ch.put("1", "Luis");
        ch.put("2", "Andrea");
        ch.put("3", "Mauricio");
        ch.put("4", "Maria");
        return ch;
    }

    public static ArrayList iniArray(){
        ArrayList<String> data = new ArrayList<String>();
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        return data;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws InterruptedException {
        HashMap cache = iniHash();
        ArrayList bd = iniArray();

        Scanner lector=new Scanner(System.in);
        while (true) {
            System.out.println("Consulte el ID");
            String ans = lector.nextLine();
            if(ans.equals("salir")){
                break;
            }
            else{
                if(cache.containsKey(ans)){
                    System.out.println("Usuario existente");
                    System.out.println(cache.get(ans));
                    Thread.sleep(5000);
                }
                else{
                    System.out.println("Usuario inexiste, se creara usuario");
                    bd.add(ans);
                    String id = ans;
                    System.out.println("Ingrese el nombre del usuario");
                    ans = lector.nextLine();
                    cache.put(id,ans);
                    System.out.println("Usuario creado satisfactoriamente con el ID: " + id);
                    Thread.sleep(5000);
                }
            }
        }
    }
}
