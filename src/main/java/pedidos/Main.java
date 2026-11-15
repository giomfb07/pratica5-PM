package pedidos;

/** Apenas demonstração: nenhuma regra de negócio nem teste fica aqui. */
public class Main {
    public static void main(String[] args) {
        Pedido p = new PedidoEletronico(1, "Maria", 100.0);
        p.processar();
        System.out.println("Valor final: " + p.calcularValorFinal() + " | Status: " + p.getStatus());
    }
}
