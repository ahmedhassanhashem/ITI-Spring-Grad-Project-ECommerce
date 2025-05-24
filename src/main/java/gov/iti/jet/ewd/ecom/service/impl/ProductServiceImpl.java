package gov.iti.jet.ewd.ecom.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.iti.jet.ewd.ecom.entity.Product;
import gov.iti.jet.ewd.ecom.repository.ProductRepository;
import gov.iti.jet.ewd.ecom.repository.ProductSpecification;
import gov.iti.jet.ewd.ecom.service.ProductService;

public class ProductServiceImpl implements ProductService {




    public Page<Product> filterProducts(String name, String category, Double minPrice, Double maxPrice, String sortDir, int page, int size) {
    Specification<Product> spec = Specification
            .where(ProductSpecification.hasName(name))
            .and(ProductSpecification.hasCategory(category))
            .and(ProductSpecification.hasPriceBetween(minPrice, maxPrice));

    Sort sort = sortDir.equalsIgnoreCase("desc") ?
            Sort.by("price").descending() :
            Sort.by("price").ascending();

    Pageable pageable = PageRequest.of(page, size, sort);

    return productRepository.findAll(spec, pageable);
}

}
