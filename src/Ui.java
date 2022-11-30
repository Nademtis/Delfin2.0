import java.util.Scanner;

public class Ui {

    Scanner in = new Scanner(System.in);

    public void println(String msg){
        System.out.println(msg);
    }

    public void print(String msg){
        System.out.print(msg);
    }

    public String readString(){
        return in.nextLine();
    }

    public String readString(String msg){
        print(msg);
        return readString();
    }

    public int readInt(){
        boolean validChoice = false;
        int number =-1;
        while(!validChoice){
            if(in.hasNextInt()){
                number = in.nextInt();
                validChoice = true;
            }else{
                in.nextLine();
            }
        }
        in.nextLine();//scanner bug
        return number;
    }
    public int readInt(String msg){
        boolean validChoice = false;
        int number =-1;
        while(!validChoice){
            println(msg);
            if(in.hasNextInt()){
                number = in.nextInt();
                validChoice = true;
            }else{
                in.nextLine();
            }
        }
        in.nextLine();//scanner bug
        return number;
    }


}