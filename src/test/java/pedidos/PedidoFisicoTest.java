package pedidos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes automatizados de PedidoFisico.
 * Ajuste construtores, métodos, exceções e valores esperados conforme o seu projeto.
 */
class PedidoFisicoTest {

    private PedidoFisico pedido;

    @BeforeEach
    void setUp() {
        // Instancia o objeto e inicializa valores antes de cada teste
        pedido = new PedidoFisico(1, "Maria", 100.0);
    }

    @AfterEach
    void tearDown() {
        // Informa que o teste foi finalizado
        System.out.println("Teste finalizado: " + pedido.getClass().getSimpleName());
    }

    // ---------- Cálculo do valor final ----------

    @Test
    @DisplayName("Deve calcular o valor final corretamente")
    void deveCalcularValorFinal() {
        assertEquals(110.0, pedido.calcularValorFinal(), 0.001);
    }

    @Test
    @DisplayName("Pedido físico soma 10% de frete")
    void deveSomarFrete() {
        assertEquals(110.0, pedido.calcularValorFinal(), 0.001);
    }

    // ---------- Exceções personalizadas ----------

    @Test
    @DisplayName("Deve lançar PedidoInvalidoException para valor zerado")
    void deveLancarPedidoInvalidoExceptionParaValorZero() {
        assertThrows(PedidoInvalidoException.class,
                () -> new PedidoFisico(1, "Maria", 0.0));
    }

    @Test
    @DisplayName("Deve lançar StatusInvalidoException ao alterar pedido ENTREGUE")
    void deveLancarStatusInvalidoExceptionAoAlterarEntregue() {
        pedido.setStatus(StatusPedido.ENTREGUE);
        assertThrows(StatusInvalidoException.class,
                () -> pedido.setStatus(StatusPedido.PROCESSADO));
    }

    // ---------- Exceções do Java ----------

    @Test
    @DisplayName("Deve lançar IllegalArgumentException para valor negativo")
    void deveLancarIllegalArgumentExceptionParaValorNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> new PedidoFisico(1, "Maria", -10.0));
    }

    @Test
    @DisplayName("Deve lançar NullPointerException para cliente nulo")
    void deveLancarNullPointerExceptionParaClienteNulo() {
        assertThrows(NullPointerException.class,
                () -> new PedidoFisico(1, null, 100.0));
    }

    // ---------- Processamento e status ----------

    @Test
    @DisplayName("Status inicial deve ser CRIADO")
    void statusInicialDeveSerCriado() {
        assertEquals(StatusPedido.CRIADO, pedido.getStatus());
    }

    @Test
    @DisplayName("Processar pedido deve alterar status para PROCESSADO")
    void processarDeveAlterarStatus() {
        pedido.processar();
        assertEquals(StatusPedido.PROCESSADO, pedido.getStatus());
    }

    // ---------- Regra do enum ----------

    @Test
    @DisplayName("Pedido ENTREGUE não pode ser alterado")
    void pedidoEntregueNaoPodeSerAlterado() {
        pedido.setStatus(StatusPedido.ENTREGUE);
        assertFalse(pedido.getStatus().podeSerAlterado());
        assertThrows(StatusInvalidoException.class, () -> pedido.processar());
        assertEquals(StatusPedido.ENTREGUE, pedido.getStatus());
    }

    @Test
    @DisplayName("Pedido CRIADO pode ser alterado")
    void pedidoCriadoPodeSerAlterado() {
        assertTrue(pedido.getStatus().podeSerAlterado());
    }
}
