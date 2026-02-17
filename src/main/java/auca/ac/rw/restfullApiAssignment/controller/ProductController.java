package auca.ac.rw.restfullApiAssignment.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.restfullApiAssignment.modal.ecommerce.Product;
import auca.ac.rw.restfullApiAssignment.service.ProductService;

@RestController
@RequestMapping("/api/products")    
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewProduct(@RequestBody Product product) {
        String saveProduct = productService.addNewProduct(product);

        if(saveProduct.equals("Product added successfully")){
            return new ResponseEntity<>(saveProduct, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(saveProduct, HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        if(product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        String result = productService.updateProduct(id, product);
        if(result.equals("Product updated successfully")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        String result = productService.deleteProduct(id);
        if(result.equals("Product deleted successfully")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchByCategory(@RequestParam String category) {
        List<Product> getproducts = productService.searchByCategory(category);
        
        if(getproducts != null) {
            return new ResponseEntity<>(getproducts, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Products with that category are not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> searchByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(productService.searchByBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/price/less-than/{price}")
    public ResponseEntity<List<Product>> searchByPriceLessThan(@PathVariable Double price) {
        return new ResponseEntity<>(productService.searchByPriceLessThan(price), HttpStatus.OK);
    }

    @GetMapping("/price/between/{minPrice}/{maxPrice}")
    public ResponseEntity<List<Product>> searchByPriceBetween(@PathVariable Double minPrice, @PathVariable Double maxPrice) {
        return new ResponseEntity<>(productService.searchByPriceBetween(minPrice, maxPrice), HttpStatus.OK);
    }
}
