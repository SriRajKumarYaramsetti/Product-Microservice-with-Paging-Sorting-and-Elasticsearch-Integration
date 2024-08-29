package dev.SriRaj.ProductCatalog.controllers;

import dev.SriRaj.ProductCatalog.dtos.GetProductResponseDto;
import dev.SriRaj.ProductCatalog.dtos.SearchRequestDto;
import dev.SriRaj.ProductCatalog.dtos.SortParameter;
import dev.SriRaj.ProductCatalog.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public Page<GetProductResponseDto> searchProducts(@RequestBody SearchRequestDto searchRequestDto) {

        List<SortParameter> sortByParameters=searchRequestDto.getSortByParameters();

        Sort sort;

        if(sortByParameters.get(0).getSortType().equals("ASC")){
            sort=Sort.by(sortByParameters.get(0).getParameterName());
        }else {
            sort=Sort.by(sortByParameters.get(0).getParameterName()).descending();
        }

        for(int i=1;i<sortByParameters.size();i++){
            if(sortByParameters.get(0).getSortType().equals("ASC")){
                sort=sort.and(Sort.by(sortByParameters.get(0).getParameterName()));
            }else {
                sort=sort.and(Sort.by(sortByParameters.get(0).getParameterName()).descending());
            }
        }

        Pageable pageable = PageRequest.of(searchRequestDto.getPageNumber(), searchRequestDto.getSizeOfEachPage(),sort);
        return searchService.searchProducts(searchRequestDto.getQuery(), pageable);
    }
}
