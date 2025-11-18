package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Colores;


public class ColoresDAO
{
    // CUIDADO: Asegúrate de que tu clase 'modelo.Colores' tiene el método getCantidad()
    
    public boolean ingresarColores(Colores col)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            // CORRECCIÓN 1: Se usa 'cant' en lugar de 'cantidad'
            String query="insert into tbColores (codigo,color,cant) values(?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            
            ps.setString(1, col.getCodigo());
            ps.setString(2, col.getColor());
            ps.setInt(3, col.getCantidad());
            
            resultado=ps.executeUpdate()==1;
            ps.close();
            
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ColoresDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return resultado;
    }

    public boolean modificarColores(Colores col)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            // CORRECCIÓN 2: Se usa 'cant' en lugar de 'Cantidad' y minúsculas para consistencia
            String query="update tbColores set color=?,cant=? where codigo=?";
            PreparedStatement ps=con.prepareStatement(query);

            ps.setString(1, col.getColor());
            ps.setInt(2, col.getCantidad());
            ps.setString(3, col.getCodigo());

            resultado=ps.executeUpdate()==1;
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ColoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ColoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  resultado;
    }

    public boolean eliminarColor(String codigo)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            // CORRECCIÓN 3: Uso de PreparedStatement con '?' para seguridad (anti-inyección SQL)
            String query="delete from tbColores where codigo=?";
            PreparedStatement ps=con.prepareStatement(query);
            
            ps.setString(1, codigo); // Asignación del código

            resultado=ps.executeUpdate()==1;
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ColoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ColoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public ArrayList <Colores> obtenerTodos()
    {
        ArrayList <Colores> col=new ArrayList<>();
        try {
            Connection con=Conexion.getConexion();
            String query="Select * from tbColores";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            Colores cc;
            while(rs.next())
            {
                // NOTA: rs.getString(1), rs.getString(2), rs.getInt(3) asumen orden de: codigo, color, cant
                cc=new Colores(rs.getString(1),rs.getString(2),rs.getInt(3));
                col.add(cc);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ColoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ColoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return col;
    }

    public Colores buscarColor(String cod)
    {
        Colores col=null;
        try {
            Connection con=Conexion.getConexion();
            // CORRECCIÓN 4: Uso de PreparedStatement con '?' para seguridad (anti-inyección SQL)
            String query="select * from tbColores where codigo=?";
            PreparedStatement ps=con.prepareStatement(query);
            
            ps.setString(1, cod); // Asignación del código

            ResultSet rs=ps.executeQuery();
            while(rs.next())
                col=new Colores(rs.getString(1),rs.getString(2),rs.getInt(3));
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ColoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ColoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return col;
    }
}