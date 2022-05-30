package StockManagement.StockManagement.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
//@NoArgsConstructor
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue
    private Long ID;
    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "FirstName", nullable = false)
    private String FirstName;
    @Column(name = "LastName", nullable = false)
    private String LastName;
    @Column(name = "Address", nullable = false)
    private String Address;
    @Column(name = "Mobile", nullable = false)
    private String Mobile;
    @Column(name = "Email", nullable = false)
    private String Email;
    @Column(name = "LastLogin", nullable = false)
    private Date LastLogin;
    @Column(name = "LastUpdated", nullable = false)
    private Date LastUpdated;
}
