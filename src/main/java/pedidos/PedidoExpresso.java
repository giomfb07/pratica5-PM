package pedidos;

public class PedidoExpresso extends Pedido {
    public PedidoExpresso(int id, String cliente, double valorBase) {
        super(id, cliente, valorBase);
    }

    @Override
    public double calcularValorFinal() {
        return getValorBase() * 1.20;
    }
}
