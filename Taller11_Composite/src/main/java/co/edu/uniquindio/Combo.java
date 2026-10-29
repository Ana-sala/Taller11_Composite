package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.List;

// COMPOSITE: agrupa elementos del menú (platos u otros combos)
public class Combo implements ElementoMenu {                         // (1) implements ElementoMenu
    private String nombre;
    private List<ElementoMenu> elementos = new ArrayList<>();        // (2) lista del tipo de la interfaz

    public Combo(String nombre) {
        this.nombre = nombre;
    }

    // Recibe un plato o un combo: los dos son ElementoMenu
    public void agregar(ElementoMenu elemento) {
        elementos.add(elemento);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {                                      // (3) recorre y pregunta lo mismo a cada uno
        double total = 0;
        for (ElementoMenu e : elementos) {
            total += e.getPrecio();                                  // si e es un combo, esto es recursivo
        }
        return total;
        // RETO (10 % de descuento): cambiar la línea anterior por
        // return total * 0.9;
    }

    @Override
    public void imprimir(String sangria) {
        System.out.println(sangria + "+ " + nombre + " $" + getPrecio());
        for (ElementoMenu e : elementos) {
            e.imprimir(sangria + "   ");                             // tres espacios más de sangría
        }
    }
}
