package dev.SriRaj.ProductCatalog.services;

import dev.SriRaj.ProductCatalog.dtos.GetProductResponseDto;
import dev.SriRaj.ProductCatalog.models.Product;
import dev.SriRaj.ProductCatalog.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final ProductRepository productRepository;


    @Autowired
    public SearchService(ProductRepository productRepository) {

        this.productRepository = productRepository;

    }

    public Page<GetProductResponseDto> searchProducts(String query, Pageable pageable) {


//        Sort sort=Sort.by("title").descending()
//                .and(Sort.by("price").ascending());

        //At the end sort by will be the ID

        Page<Product> productPage = productRepository.findAllByTitleContaining(query, pageable);

        List<GetProductResponseDto> dtoList = productPage.stream()
                .map(GetProductResponseDto::from) // Transform each Product to GetProductResponseDto
                .collect(Collectors.toList());

        return new PageImpl<>(dtoList, pageable, productPage.getTotalElements());
    }
}
