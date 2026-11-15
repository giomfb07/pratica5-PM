package pedidos;

public class PedidoEletronico extends Pedido {
    public PedidoEletronico(int id, String cliente, double valorBase) {
        super(id, cliente, valorBase);
    }

    @Override
    public double calcularValorFinal() {
        return getValorBase() * 0.90;
    }
}
