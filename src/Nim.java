import java.util.*;
public class Nim{
    private String player1,player2,Eleccion;
    private String cantidad="";
    protected ArrayList<String> listA=new ArrayList<>();
    private ArrayList<String> listB=new ArrayList<>();
    private ArrayList<String> listC=new ArrayList<>();
    private boolean valido =true,validez2=true;
    private int cantidad_Int=0,cambia_jugador=0,can_a,can_b,can_c;
    public Nim(){
        player1="user1";
        player2="user2";
        listB.add("*"); listB.add("*"); listB.add("*"); listB.add("*");
        listC.add("*"); listC.add("*"); listC.add("*"); listC.add("*"); listC.add("*");
        listA.add("*"); listA.add("*"); listA.add("*");
        can_a=listA.size();can_b=listB.size();can_c=listC.size();
    }
    //------------------------------------METODOS----------------------------
    public void setPlayer1(String nombre){
        player1=nombre;
    }
    public void setPlayer2(String nombre){
        player2=nombre;
    }
    public void turno_player1(){

        Scanner sc=new Scanner(System.in);
        do {
            valido=true;
            validez2=true;
            pintarPantalla();
            System.out.println("\nA: "+can_a+"\t"+ "B: "+can_b+"\t"+ "C: "+can_c+"\n");
            if(cambia_jugador==0){
                System.out.print(player1+", Elija una pila: ");
            }else{ System.out.print(player2+", Elija una pila: ");}

            Eleccion= sc.nextLine();
            Eleccion=Eleccion.toUpperCase();
            switch (Eleccion){
                case "A":
                    cantidad_Int=0;
                    if(listA.size()==0){
                        System.out.print("Seleccion no valida,la pila en cuestion no cuenta con nada en su interior");
                        valido=true;
                        break;
                    }else {
                        do {
                            boolean bandera=true;
                            do {
                                System.out.println("Cuantos quitara de la pila " + Eleccion);
                                cantidad = sc.nextLine();
                                if(validacion(cantidad)){
                                    bandera=false;
                                    cantidad_Int=Integer.parseInt(cantidad);
                                }else {
                                    System.out.println("Debes ingresar un numero.");
                                }

                            }while(bandera);

                            if (cantidad_Int > listA.size()) {
                                System.out.println("ingrese una cantidad valida para dicha pila. ");
                            } else if (cantidad_Int <= 0) {
                                System.out.println("Debes ingresar un valor mayor a 0");
                            } else {
                                int catidad_pila = listA.size() - 1;                        // creo una variable con la cantidad que hay en la lista
                                for (int i = catidad_pila; i > catidad_pila - cantidad_Int; i--) {  // porque sino en el ciclo for me cambia la variable ya que la variable i estaba ligada a la lista
                                    listA.set(i," ");                                   // (int i=listA.size()-1) cuando realizaba el ciclo for, la i cambiaba porque listA se hacia mas chico.
                                }
                                can_a-=cantidad_Int;
                                validez2 = false;
                                valido = false;
                            }
                        } while (validez2);
                    }break;
                case "B":
                    cantidad_Int=0;
                    if(listB.size()==0){
                        System.out.print("Seleccion no valida,la pila en cuestion no cuenta con nada en su interior");
                        valido=true;
                        break;
                    }else {
                        do {
                                boolean bandera=true;
                                do {
                                    System.out.println("Cuantos quitara de la pila " + Eleccion);
                                    cantidad = sc.nextLine();
                                    if(validacion(cantidad)){
                                        bandera=false;
                                        cantidad_Int=Integer.parseInt(cantidad);
                                    }else {
                                        System.out.println("Debes ingresar un numero.");
                                    }

                                }while(bandera);
                            if (cantidad_Int > listB.size()) {
                                System.out.println("ingrese una cantidad valida para dicha pila. ");
                            } else if (cantidad_Int <= 0) {
                                System.out.println("Debes ingresar un valor mayor a 0");
                            } else {

                                int catidad_pila = listB.size() - 1;
                                for (int i = catidad_pila; i > catidad_pila - cantidad_Int; i--) {
                                    listB.set(i," ");
                                }
                                can_b-=cantidad_Int;
                                validez2 = false;
                                valido = false;
                            }
                        } while (validez2);
                    }break;
                case "C":
                    cantidad_Int=0;
                    if(listC.size()==0){
                        System.out.print("Seleccion no valida,la pila en cuestion no cuenta con nada en su interior");
                        valido=true;
                        break;
                    }else {
                        do {
                                boolean bandera=true;
                                do {
                                    System.out.println("Cuantos quitara de la pila " + Eleccion);
                                    cantidad = sc.nextLine();
                                    if(validacion(cantidad)){
                                        bandera=false;
                                        cantidad_Int=Integer.parseInt(cantidad);
                                    }else {
                                        System.out.println("Debes ingresar un numero.");
                                    }

                                }while(bandera);
                            if (cantidad_Int > listC.size()) {
                                System.out.println("ingrese una cantidad valida para dicha pila. ");
                            } else if (cantidad_Int <= 0) {
                                System.out.println("Debes ingresar un valor mayor a 0");
                            } else {

                                int catidad_pila = listC.size() - 1;
                                for (int i = catidad_pila; i > catidad_pila - cantidad_Int; i--) {
                                    listC.set(i," ");
                                }
                                can_c-=cantidad_Int;
                                validez2 = false;
                                valido = false;
                            }
                        } while (validez2);
                    }break;
                default:
                    System.out.println("Haz ingresado mal.");
                    valido=true;
            }
        }while(valido);
        if(cambia_jugador==0){cambia_jugador=1;}else {cambia_jugador=0;}
    }
    public void pintarPantalla(){
        System.out.print(" "+" "+ listC.get(4));
        System.out.println("");
        System.out.print(" "+listB.get(3)+listC.get(3));
        System.out.println("");
        System.out.print(listA.get(2)+listB.get(2)+listC.get(2));
        System.out.println("");
        System.out.print(listA.get(1)+listB.get(1)+listC.get(1));
        System.out.println("");
        System.out.print(listA.get(0)+listB.get(0)+listC.get(0));
        System.out.println("");

    }
    public static void main(String[] c){
        Nim jugar= new Nim();
        Scanner sc=new Scanner(System.in);
        System.out.print("\t\tBienvenido al juego NIM\n");
        System.out.println("Es un juego para 2 jugadores");
        System.out.println("Ingrese el nombre del primer jugador.");
        jugar.setPlayer1(sc.nextLine());
        System.out.println("Ingrese el nombre del segundo jugador.");
        jugar.setPlayer2(sc.nextLine());
        System.out.println(jugar.can_a);
        do {
            if(jugar.can_a!=0 || jugar.can_b!=0 || jugar.can_c!=0) {
                System.out.println("uwu");
                jugar.turno_player1();

            }else {
                if(jugar.cambia_jugador==0){
                    System.out.println("Gano "+jugar.player1);
                }else System.out.println("Gano "+jugar.player2);
                break;
            }
        }while (true);
        jugar.listB.get(0);
    }
    static boolean validacion(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
