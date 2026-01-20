package io.github.wallace.oms.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {
    private UUID orderId;
    private UUID customerId;
    private String customerName;
    private String orderInfo;
}
