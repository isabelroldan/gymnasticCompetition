package iesFranciscodelosRios.Test;

import iesFranciscodelosRios.Utils.Read;

import java.util.Arrays;

public class testPassword {
    public static void main(String[] args) {
        System.out.println("Introduce una nueva contraseña");
        char[] password=Read.readPassword();
        System.out.println(password);
        boolean end=false;
        do {
            System.out.println("Introduce la contraseña");
            char[] loadpassword=Read.readPassword();
            System.out.println(loadpassword);
            System.out.println(Arrays.equals(password,loadpassword));
            if(Arrays.equals(password,loadpassword)){
                end=true;
            }
        }while (!end);
    }
}
