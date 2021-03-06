package StockManagement.StockManagement.Repository;

import StockManagement.StockManagement.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {

}
