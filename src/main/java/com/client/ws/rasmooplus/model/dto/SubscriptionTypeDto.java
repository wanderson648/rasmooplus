package com.client.ws.rasmooplus.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionTypeDto {
    private Long id;

    @NotBlank(message = "campo name não pode  ser nulo ou vazio")
    @Size(min = 5, max = 30)
    private String name;

    @Max(value = 12, message = "campo accessMonth não pode  ser maior que 12")
    private Long accessMonth;

    @NotNull(message = "campo price não pode nulo")
    private BigDecimal price;

    @NotBlank(message = "campo productkey não pode ser nulo ou vazio")
    @Size(min = 5, max = 15, message = "campo productkey deve ter tamanho entre 5 e 15")
    private String productKey;
}
