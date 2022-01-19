package git.alexeydf.pizzaria.modelo;

public class TesteClasses {

    public static void main(String[] args) {

        Pizza pizza = new Pizza("Calabresa","tradicional", 38.99);
        Cliente cliente = new Cliente("alexey", "qi 06 cj z", "61-983122366", "alexeydf@gmail.com", 0, 45.60);

        System.out.println(cliente);
    }
}
