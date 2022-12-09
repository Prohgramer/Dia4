import java.util.*;
public class prueba {
    public static void main(String[] c){
        Scanner sc=new Scanner(System.in);
        boolean bandera=true;
        String num;
        int numero=0;
        do {
            System.out.println("ingrese numero");
            num=sc.nextLine();
            if(validacion(num)){
                bandera=false;
            }else {
                System.out.println("Debes ingresar un numero.");
            }

        }while(bandera);
    }
    static boolean validacion(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
