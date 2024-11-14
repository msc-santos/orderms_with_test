package integration;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import tech.buildrun.orderms.OrdermsApplication;
import tech.buildrun.orderms.entity.OrderEntity;
import tech.buildrun.orderms.repository.OrderRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OrdermsApplication.class)
class OrderServiceIntegrationTest {
  @Autowired
  OrderRepository orderRepository;

  @Captor
  ArgumentCaptor<PageRequest> pageRequestCaptor;

  @Nested
  class getOrderById {

    @Test
    public void findAllByCustomerId() {
      // Executa a consulta no banco de dados
      Page<OrderEntity> order = orderRepository.findAllByCustomerId(1L, pageRequestCaptor.capture());

      // Verifica se a consulta não trouxe uma página vazia
      assertNotNull(order, "A consulta deveria retornar um objeto Page não nulo.");
      assertFalse(order.isEmpty(), "A consulta deveria retornar ao menos um pedido.");

      // Se desejar, você também pode verificar o conteúdo do primeiro pedido retornado
      order.getContent().forEach(orderResponse -> {
        assertNotNull(orderResponse.getOrderId(), "O ID do pedido não deveria ser nulo.");
        assertEquals(1L, orderResponse.getCustomerId(), "O ID do cliente deve ser o especificado na consulta.");
      });
    }
  }
}