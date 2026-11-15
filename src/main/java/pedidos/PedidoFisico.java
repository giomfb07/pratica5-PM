package pedidos;

public class PedidoFisico extends Pedido {
    public PedidoFisico(int id, String cliente, double valorBase) {
        super(id, cliente, valorBase);
    }

    @Override
    public double calcularValorFinal() {
        return getValorBase() * 1.10;
    }
}
