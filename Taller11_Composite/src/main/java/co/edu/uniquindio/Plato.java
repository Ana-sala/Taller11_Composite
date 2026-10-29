package co.edu.uniquindio;

// LEAF: elemento simple, no contiene a otros (copiada tal cual, NO se modifica)
public class Plato implements ElementoMenu {
    private String nombre;
    private double precio;

    public Plato(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void imprimir(String sangria) {
        System.out.println(sangria + "- " + nombre + " $" + precio);
    }
}
