package StockManagement.StockManagement.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
//@NoArgsConstructor
@Table(name = "users")
public class UserModel {

    @Id
    private Long userId;

    private String FirstName;
    private String LastName;
    private String Address;
    private String Mobile;
    private String Email;
    private Date LastLogin;
    private Date LastUpdated;
}
