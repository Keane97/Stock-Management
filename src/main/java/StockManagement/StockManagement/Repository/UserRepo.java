package StockManagement.StockManagement.Repository;

import StockManagement.StockManagement.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {

//    @Override
//    @Query("SELECT um FROM users WHERE um")
//    List<UserModel> findAll();

}
