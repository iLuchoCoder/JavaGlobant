import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        String ans = "";
        Scanner in = new Scanner(System.in);
        do{
            System.out.println("**********************************************************************");
            System.out.println("Por favor digite un número del 1 al 3 para elegir el ejercicio");
            System.out.println("1 - Invertir cadena de texto");
            System.out.println("2 - CozaLozaWoza");
            System.out.println("3 - Imprimir tabla N");
            System.out.println("4 - Salir");
            System.out.println("**********************************************************************");

            ans = in.nextLine();

            switch (ans){
                case "1":
                    String reverse = "";
                    System.out.println("Escribe una linea de texto");
                    char[] inv = in.nextLine().toCharArray();
                    for(int i=inv.length-1;i>=0;i--)
                    {
                        reverse += inv[i];
                    }
                    System.out.println("La linea de texto invertida es: " + reverse);
                    break;

                case "2":
                    System.out.println("Coza Multiplo de 3, Loza de 5, Woza de 7 y CozaLoza de 3 y 5, entre N1 Y N2");
                    System.out.println("Digite el primer numero: ");
                    int num1 = in.nextInt();
                    System.out.println("Digite el segundo numero: ");
                    int num2 = in.nextInt();
                    String lista = "";
                    for(int i = num1;i<=num2;i++){
                        if(i%3==0)
                        {
                            lista += "Coza ";
                        }

                        if(i%5==0)
                        {
                            lista += "Loza ";
                        }

                        if(i%7==0)
                        {
                            lista += "Woza ";
                        }

                        if(i%3==0 && i%5==0)
                        {
                            lista += "CozaLoza ";
                        }

                        if(i%11==0)
                        {
                            lista += i +"\n";
                        }

                        if(i%3!=0 || i%5!=0 || i%7!=0)
                        {
                            lista += i + " ";
                        }
                    }
                   System.out.println(lista);
                   break;

                case "3":
                    System.out.println("Digita un número para conocer su tabla de multiplicar");
                    int num = in.nextInt();
                    System.out.println("***** Tabla del " + num + " *****");
                    for(int i=1;i<=10;i++){
                        System.out.println(num + " x " + i + " = " + num*i);
                    }
                    System.out.println("***********************");
                   break;

                default:
                   ans = "4";
                   break;
            }
        }
        while(ans=="4");
    }
}
