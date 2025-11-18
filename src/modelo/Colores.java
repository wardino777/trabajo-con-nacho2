
package modelo;

public class Colores 
{
    private String codigo, color;
    private int cantidad;

    public Colores(String codigo, String color, int cantidad) {
        this.codigo = codigo;
        this.color = color;
        this.cantidad = cantidad;
    }

    public Colores() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
