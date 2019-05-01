import java.io.*;

class Nuke2 {


    public static void main(String arg[]) throws Exception{
        String input;
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        input = keyboard.readLine();
        for(int i=0; i<=input.length()-1; i++) {
            if(i==1){
                continue;
            }
            System.out.print(input.charAt(i));
        }
        System.out.println();
    }

}