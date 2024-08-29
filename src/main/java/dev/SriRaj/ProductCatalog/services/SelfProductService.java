package dev.SriRaj.ProductCatalog.services;

import dev.SriRaj.ProductCatalog.dtos.*;

import java.util.List;

public interface SelfProductService {
    CreateProductResponseDto createProduct(CreateProductRequestDto product);

    GetProductResponseDto getProductById(Long Id);

    GetAllProductsResponseDto getAllProducts();

    GetProductResponseDto updateProductById(CreateProductRequestDto product, Long id);

    void deleteProductById(Long id);

    GetAllProductsResponseDto getCategoryById(String categoryType);
    List<CategoryTypeDto> getAllCategories();
}
