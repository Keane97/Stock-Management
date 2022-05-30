package StockManagement.StockManagement.Service;

import StockManagement.StockManagement.Model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    UserModel addUser(UserModel userModel);
    Iterable<UserModel> getAllUsers();
    UserModel getUserByID(Long Id);
    UserModel updateUser(UserModel userModel, Long Id);
    void deleteUser(Long Id);

}
