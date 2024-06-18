package com.invoice.brands;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BrandDTO ( Long id,
                         String name,
                         String description){
}
