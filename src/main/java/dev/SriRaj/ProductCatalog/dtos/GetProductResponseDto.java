package dev.SriRaj.ProductCatalog.dtos;


import dev.SriRaj.ProductCatalog.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductResponseDto {
    private Long id;
    private String title;
    private String category;
    private String description;
    private String image;
    private double price;

    // Method to map Product to GetProductResponseDto
    public static GetProductResponseDto from(Product product) {
        GetProductResponseDto dto = new GetProductResponseDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        return dto;
    }
}
