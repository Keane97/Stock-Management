package StockManagement.StockManagement.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
public class ProductModel {

    @Id
    @GeneratedValue
    @Column(name = "product_Id", nullable = false)
    private long product_Id;

    @Column(name = "product_name", nullable = false)
    private String product_name;

    @Column(name = "category", nullable = false)
    private String Category;

    @Column(name = "supplier", nullable = false)
    private String Supplier;

    @Column(name = "quantity", nullable = false)
    private String Quantity;

    @Column(name = "date_added", nullable = false)
    private String date_added;
}
