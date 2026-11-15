package pedidos;

public class StatusInvalidoException extends RuntimeException {
    public StatusInvalidoException(String mensagem) {
        super(mensagem);
    }
}
