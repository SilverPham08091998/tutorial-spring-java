package com.example.springjava.service.Impl;

import com.example.springjava.entity.CategoryProductEntity;
import com.example.springjava.entity.ProductEntity;
import com.example.springjava.model.ProductDTO;
import com.example.springjava.payload.request.ProductPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.respository.CategoryProductRepository;
import com.example.springjava.respository.ProductRepository;
import com.example.springjava.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryProductRepository categoryProductRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ApiResponse<String> createProduct(ProductPayload.CreateProductPayload payload) {
        CategoryProductEntity categoryProduct = categoryProductRepository.findCategoryProductEntityByCategoryProductId(payload.getCategoryProductId());
        ProductEntity product = new ProductEntity();
        product.setProductName(payload.getProductName());
        product.setProductStatus(payload.getProductStatus());
        product.setProductType(payload.getProductType());
        product.setAmount(payload.getAmount());
        product.setQuantity(payload.getQuantity());
        product.setCategoryProductEntity(categoryProduct);
        productRepository.save(product);
        return new ApiResponse<>(true, 200, "success", "Product is created");
    }

    @Override
    public ApiResponse<List<ProductDTO>> getListProduct(String search, String filter, String categoryProductId) {
        List<ProductEntity> entityList = productRepository.findProductEntitiesByCategoryProductEntity_CategoryProductId(categoryProductId);
        List<ProductDTO> dtoList = new ArrayList<>();
        for (ProductEntity entity : entityList) {
            ProductDTO productDTO = modelMapper.map(entity, ProductDTO.class);
            dtoList.add(productDTO);
        }
        return new ApiResponse<>(true, 200, "success", dtoList);
    }

    @Override
    public ApiResponse<String> updateProduct(ProductPayload.UpdateProductPayload payload) {
        return null;
    }

    @Override
    public ApiResponse<String> deleteProduct(ProductPayload.DeleteProductPayload payload) {
        return null;
    }
}
