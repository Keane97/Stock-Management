package StockManagement.StockManagement.Service;

import StockManagement.StockManagement.Model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {

    ProductModel addProduct(ProductModel productModel);
    List<ProductModel> getAllProducts();
    ProductModel getProductById(Long Id);
    ProductModel UpdateProduct(ProductModel productModel, Long Id);
    void deleteProduct(long productId);
}
