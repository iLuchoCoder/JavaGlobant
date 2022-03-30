import Exceptions.NoFundsException;
import model.Account;

import java.util.Scanner;

public class run {

    public static Account acc;

     public static void menu(){
        System.out.println("**********************************************************************");
        System.out.println("1 - Create Account");
        System.out.println("2 - Add Money");
        System.out.println("3 - Withdraw Money");
        System.out.println("Q - Quit Application");
        System.out.println("Enter option:");
        System.out.println("**********************************************************************");
    }

    public static void main(String[] args) throws NoFundsException {
        Scanner lector=new Scanner(System.in);
        while(true){
            try {
                menu();
                String ans = lector.nextLine();
                if(ans.equalsIgnoreCase("Q")){
                    break;
                }
                if(ans.equalsIgnoreCase("1")){
                    System.out.println("Enter your name:");
                    ans = lector.nextLine();
                    acc = new Account(ans, 0.0F);
                    System.out.println("Your account has been created with the following data: " + acc.getOwner_name() + " - Balance: " + acc.getBalance());
                }
                if(ans.equalsIgnoreCase("2")){
                    System.out.println("Enter the amount to add:");
                    ans = lector.nextLine();
                    acc.addMoney(Float.parseFloat(ans));
                    System.out.println("Your new balance amount is: $" + acc.getBalance() + " for user: " +acc.getOwner_name());
                }
                if(ans.equalsIgnoreCase("3")){
                    System.out.println("Enter the amount to withdraw:");
                    ans = lector.nextLine();
                    if(Float.parseFloat(ans)>acc.getBalance()){
                        throw new NoFundsException("You do not have sufficient funds for this transaction");
                    }
                    else{
                        acc.withdrawMoney(Float.parseFloat(ans));
                        System.out.println("You withdraw successfully from your account $" + ans );
                        System.out.println("Your new balance amount is: $" + acc.getBalance() + " for user: " +acc.getOwner_name());
                    }
                }
            }
            catch(NoFundsException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
