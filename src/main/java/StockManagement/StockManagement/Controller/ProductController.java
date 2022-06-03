package StockManagement.StockManagement.Controller;

import StockManagement.StockManagement.Model.ProductModel;
import StockManagement.StockManagement.Model.UserModel;
import StockManagement.StockManagement.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private IProductService productService;

    @Autowired
    public ProductController(IProductService productService){
        this.productService = productService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ProductModel> addproduct(@RequestBody ProductModel productModel){

        try {
            return new ResponseEntity<ProductModel>(productService.addProduct(productModel), HttpStatus.OK);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductModel>> getallProducts(){
        List<ProductModel> userModels = (List<ProductModel>) productService.getAllProducts();
        return new ResponseEntity<List<ProductModel>>(userModels, HttpStatus.OK);
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<ProductModel> getById(@PathVariable("userId") Long productId){

        try {
            return new ResponseEntity<ProductModel>(productService.getProductById(productId), HttpStatus.OK);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/edit/{productId}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable("userId") Long productId, @RequestBody ProductModel productModel){

        try {
            return new ResponseEntity<ProductModel>(productService.UpdateProduct(productModel,productId), HttpStatus.OK);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
        productService.deleteProduct(id);

        return new ResponseEntity<String>("Product Deleted Successfully", HttpStatus.OK);
    }

}
