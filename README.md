# Sistema de Pedidos - Testes com JUnit

Projeto Java com testes automatizados (JUnit 5), feito com Maven.

## Requisitos
- Java 17 ou superior
- Maven (ou uma IDE que já traga Maven: NetBeans, IntelliJ, Eclipse)

## Como rodar os testes

**Pelo terminal** (dentro da pasta do projeto):

    mvn test

**Pela IDE:**
1. Abra a pasta `sistema-pedidos` como projeto Maven.
2. Clique com o botão direito no projeto (ou na pasta `src/test/java`) e escolha **Test** / **Run Tests**.

Se tudo estiver certo, a saída termina com `BUILD SUCCESS`.

## Como rodar o programa
Execute a classe `pedidos.Main` pela IDE, ou:

    mvn compile exec:java -Dexec.mainClass=pedidos.Main

## Estrutura

    src/main/java/pedidos   -> código do sistema
    src/test/java/pedidos   -> testes
    pom.xml                 -> configuração do Maven e do JUnit

## Regras de negócio
| Tipo de pedido     | Valor final        |
|--------------------|--------------------|
| PedidoEletronico   | valor base - 10%   |
| PedidoFisico       | valor base + 10% (frete) |
| PedidoExpresso     | valor base + 20% (urgência) |

- Pedido com status `ENTREGUE` não pode ser alterado (`StatusInvalidoException`).
- Valor zero lança `PedidoInvalidoException`.
- Valor negativo lança `IllegalArgumentException`; cliente nulo lança `NullPointerException`.

## O que é testado (em cada tipo de pedido)
- Cálculo do valor final
- Exceções personalizadas e exceções do Java
- Mudança de status ao processar o pedido
- Regra do enum: `ENTREGUE` não pode ser alterado
- `@BeforeEach` cria o pedido antes de cada teste; `@AfterEach` avisa que o teste terminou

## Sem Maven?
Adicione os JARs **JUnit Jupiter API** e **JUnit Jupiter Engine** (baixe em https://junit.org/) às bibliotecas do projeto na sua IDE.
