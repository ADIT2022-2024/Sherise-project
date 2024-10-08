package com.backend.demo.controller.admin;


import com.backend.demo.dto.ProductDto;
import com.backend.demo.services.admin.adminproduct.AdminProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminProductController {


    private final AdminProductService adminProductService;

    @PostMapping("/product")
    public ResponseEntity<ProductDto> addProduct(@ModelAttribute ProductDto productDto ) throws IOException {
        ProductDto productDto1 = adminProductService.addProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
    }


    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> productDtos = adminProductService.getAllProducts();
        return ResponseEntity.ok(productDtos);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto) throws IOException {
        // Call the service layer to handle the update logic
        ProductDto updatedProductDto = adminProductService.updateProduct(id, productDto);

        // Return the updated product with HTTP status 200 OK
        return ResponseEntity.ok(updatedProductDto);
    }




    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductDto>> getAllByName(@PathVariable String name){
        List<ProductDto> productDtos = adminProductService.getAllProductByName(name);
        return ResponseEntity.ok(productDtos);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
        boolean deleted = adminProductService.deleteProduct(productId);
        if(deleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(@PathVariable Long categoryId) {
        List<ProductDto> productDtos = adminProductService.getAllProductsByCategory(categoryId);
        return ResponseEntity.ok(productDtos);
    }


}
