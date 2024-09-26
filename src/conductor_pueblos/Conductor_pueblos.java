package conductor_pueblos;

import java.util.Scanner;

/**
 *
 * @author martin cantillo
 */
public class Conductor_pueblos {

    Scanner entrada = new Scanner(System.in);

    public class nodo {

        String dato;
        nodo sig;

    }
    nodo cab,cab2,  p,q, ultimo;

    public Conductor_pueblos() {
        this.cab = null;
        this.ultimo = null;
        this.cab2=null;
        this.q=null;
        this.p=cab;
    }

    public boolean listavacia() {
        if (cab == null) {
            return true;
        } else {
            return false;
        }
    }

    public nodo insertar(String info) {
        nodo n = new nodo();
        n.dato = info;
        if (listavacia()) {
            cab = n;
            p = cab;
        } else {
            p.sig = n;
            p = n;
        }
        return p;
    }
     public nodo mostrarlista_venida(){
          if(listavacia()|| cab.sig==null){
               System.out.println("no hay  pueblos recorridos ");
            }
          else{

              cab2=null;
              ultimo=null;
              while(cab.sig!=ultimo){
                  p=cab;
                  q=null;
                  while(p.sig!=ultimo){
                      q=p;
                      p=p.sig;
                  }
                  if(ultimo==null){
                      cab2=p;
                  }
                  p.sig=q;
                  ultimo=p;
              }
              cab.sig=null;
              cab=cab2;
          }
         return cab;
     }

    public void mostrarlista() {
        if (listavacia()) {
            System.out.print("No tiene pueblos anteriores  ");
        } else {
            nodo r = cab;
            while (r != null) {
                System.out.print(r.dato + " -> ");
                r = r.sig;
            }
            System.out.println("");

        }
    }

    
       

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("LISTAS ENLAZADAS , COLAS ");
        Conductor_pueblos listas = new Conductor_pueblos();
        int opc, num, dato, i = 1;
        String p;
        do {
            System.out.println("\nMENÚ COLA  DINAMICA");
            System.out.println("1. Insertar pueblo");
            System.out.println("2. Muestre el recorrido de ida  ");
            System.out.println("3.Muestre el recorrido de venida ");
            System.out.println("10. Salir");
            opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("ingrese el nombre del pueblo (" + i + ")");
                    p = entrada.next();
                    listas.insertar(p);
                    i++;
                    break;
                case 2:
                    System.out.println("recorrido ida ");
                    listas.mostrarlista();
                    break;
                case 3:
                    listas.mostrarlista_venida();
                    System.out.println("recorrido venida ");
                     listas.mostrarlista();
                    break;
            }
        } while (opc != 10);

    }

}
