package pedidos;

public enum StatusPedido {
    CRIADO, PROCESSADO, ENVIADO, ENTREGUE;

    /** Pedidos ENTREGUE não podem mais ser alterados. */
    public boolean podeSerAlterado() {
        return this != ENTREGUE;
    }
}
