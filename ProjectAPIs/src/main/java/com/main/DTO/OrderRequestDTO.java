package com.main.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDTO {
    private String shippingAddress;
    private String recipientName;
    private String phone;
}
