
package vista;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class ProyectoCOloresMVC_BaseDatos {

   
    public static void main(String[] args) 
    {
       //hola
       VentanaPrincipal ventPrin=new VentanaPrincipal();
       ventPrin.setLocationRelativeTo(null);
       ventPrin.setTitle("MENU PRINCIPAL");
       ventPrin.setResizable(false);
       ventPrin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
       ventPrin.setVisible(true);
    }
    
}
