package pedidos;

import java.util.Objects;

public abstract class Pedido {

    private final int id;
    private final String cliente;
    private final double valorBase;
    private StatusPedido status = StatusPedido.CRIADO;

    protected Pedido(int id, String cliente, double valorBase) {
        Objects.requireNonNull(cliente, "Cliente não pode ser nulo");
        if (valorBase < 0) {
            throw new IllegalArgumentException("Valor base não pode ser negativo");
        }
        if (valorBase == 0) {
            throw new PedidoInvalidoException("Valor base não pode ser zero");
        }
        this.id = id;
        this.cliente = cliente;
        this.valorBase = valorBase;
    }

    public abstract double calcularValorFinal();

    public void processar() {
        validarAlteracao();
        this.status = StatusPedido.PROCESSADO;
    }

    public void setStatus(StatusPedido novoStatus) {
        Objects.requireNonNull(novoStatus, "Status não pode ser nulo");
        validarAlteracao();
        this.status = novoStatus;
    }

    private void validarAlteracao() {
        if (!status.podeSerAlterado()) {
            throw new StatusInvalidoException("Pedido " + id + " já foi entregue e não pode ser alterado");
        }
    }

    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public double getValorBase() { return valorBase; }
    public StatusPedido getStatus() { return status; }
}
