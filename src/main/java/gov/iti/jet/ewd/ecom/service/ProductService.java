package gov.iti.jet.ewd.ecom.service;

import gov.iti.jet.ewd.ecom.entity.Product;



import org.springframework.data.domain.Page;
public interface ProductService {

   
 

     public Page<Product> filterProducts(String name, String category, Double minPrice, Double maxPrice, String sortDir, int page, int size);



}
