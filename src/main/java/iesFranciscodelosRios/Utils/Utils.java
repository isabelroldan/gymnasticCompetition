package iesFranciscodelosRios.Utils;

public class Utils {
    public static String b = "\u001B[0m";
    public static String negro = "\033[30m";
    public static String rojo = "\033[31m";
    public static String verde = "\033[32m";
    public static String amarillo = "\033[33m";
    public static String azul = "\033[34m";
    public static String magenta = "\033[35m";
    public static String celeste = "\033[36m";

    /**
     * Metodo que realiza una consulta al jugador si desea realmente realizar una accion de manera definitiva
     * @param msn mensaje de imprimir
     * @return retorna true si el usuario acepta y false de lo contrario
     */
    public static boolean confirm(String msn) {
        boolean confirm = false;
        String respuesta;
        int i = 0;
        try {
            do {
                respuesta = Read.readString(Utils.rojo + msn + Utils.rojo + "\nAre you sure?" + "\n1. Y: you accept" + "\n2. N: you decline" + Utils.b);
                respuesta = respuesta.toUpperCase();
                if (respuesta.equals("Y")) {
                    confirm = true;
                    i++;
                } else if (respuesta.equals("N")) {
                    confirm = false;
                    i++;
                } else {
                    System.out.println(Utils.rojo);
                    System.out.println("Enter a valid option");
                    System.out.println(Utils.b);
                }
            } while (i == 0);
        } catch (ExceptionInInitializerError e) {
            System.out.println(Utils.rojo + "Enter a valid option" + Utils.b);
        }
        return confirm;
    }
}
