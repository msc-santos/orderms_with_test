package tech.buildrun.orderms.factory;

import tech.buildrun.orderms.entity.OrderEntity;
import tech.buildrun.orderms.entity.OrderItemEntity;

import java.math.BigDecimal;
import java.util.List;

public class OrderEntityFactory {
  public static OrderEntity build() {
    var items = new OrderItemEntity("notebook", 1, BigDecimal.valueOf(20.50));

    var entity = new OrderEntity();
    entity.setOrderId(1L);
    entity.setCustomerId(2L);
    entity.setTotal(BigDecimal.valueOf(20.50));
    entity.setItems(List.of(items));

    return entity;
  }
}
