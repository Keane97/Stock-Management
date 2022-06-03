package StockManagement.StockManagement.Service;

import StockManagement.StockManagement.Model.ProductModel;
import StockManagement.StockManagement.Repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo = productRepo;
    }


    @Override
    public ProductModel addProduct(ProductModel productModel) {
        return productRepo.save(productModel);
    }

    @Override
    public List<ProductModel> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public ProductModel getProductById(Long Id) {
        return productRepo.findById(Id).
                orElseThrow(
                        () -> new IllegalArgumentException("Cannot Find product with the ID of: " + Id));
    }

    @Override
    public ProductModel UpdateProduct(ProductModel productModel, Long Id) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        ProductModel existingProduct = productRepo.findById(Id).orElseThrow(
                () -> new IllegalArgumentException("Cannot Find product with the ID of: " + Id));

        existingProduct.setProduct_name(productModel.getProduct_name());
        existingProduct.setCategory(productModel.getCategory());
        existingProduct.setSupplier(productModel.getSupplier());
        existingProduct.setQuantity(productModel.getQuantity());
        existingProduct.setDate_added(formatter.format(date));

        productRepo.save(existingProduct);
        return existingProduct;
    }

    @Override
    public void deleteProduct(long productId) {
        productRepo.deleteById(productId);
    }
}
