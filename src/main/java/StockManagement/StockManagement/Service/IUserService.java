package StockManagement.StockManagement.Service;

import StockManagement.StockManagement.Model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    UserModel addUser(UserModel userModel);
    List<UserModel> getAllUsers();
    UserModel getUserByID(Long Id);
    UserModel updateUser(UserModel userModel, Long Id);
    void deleteUser(Long Id);

}
