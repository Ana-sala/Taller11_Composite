package co.edu.uniquindio;

/*
 *
 * 1. Piezas del patrón:
 *    - Component: ElementoMenu (interfaz común para platos y combos)
 *    - Leaf:      Plato (elemento simple, no contiene a otros)
 *    - Composite: Combo (contiene una lista de ElementoMenu: platos u otros combos)
 *    - Client:    Main (arma el menú y lo trata todo como ElementoMenu)
 *
 * Reto: ¿por qué el descuento se aplica dos veces a la gaseosa y al jugo?
 *    Porque están dentro de Combo Bebidas, que a su vez está dentro de Combo Familiar.
 *    Combo Bebidas aplica el 10 % a su suma (9000 -> 8100) y luego Combo Familiar
 *    vuelve a aplicar el 10 % a todo lo que contiene, incluido ese 8100:
 *    (18000 + 7000 + 8100) * 0.9 = 29790. Cada nivel del árbol aplica su descuento.
 *
 *    ¿Tuviste que modificar Plato o el main?
 *    No. Solo se cambió una línea de Combo (return total * 0.9;). Plato y el main
 *    quedaron igual: Principio Abierto/Cerrado (OCP).
 */
// CLIENT
public class Main {
    public static void main(String[] args) {
        Combo bebidas = new Combo("Combo Bebidas");
        bebidas.agregar(new Plato("Gaseosa", 4000));
        bebidas.agregar(new Plato("Jugo", 5000));

        Combo familiar = new Combo("Combo Familiar");               // tipo Combo para poder usar agregar
        familiar.agregar(new Plato("Hamburguesa", 18000));
        familiar.agregar(new Plato("Papas", 7000));
        familiar.agregar(bebidas);                                  // un combo dentro de otro combo

        familiar.imprimir("");
        System.out.println("Total a pagar: $" + familiar.getPrecio());
    }
}
