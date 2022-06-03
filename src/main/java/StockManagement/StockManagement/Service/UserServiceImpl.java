package StockManagement.StockManagement.Service;

import StockManagement.StockManagement.Model.UserModel;
import StockManagement.StockManagement.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
//        super();
        this.userRepo = userRepo;
    }

    @Override
    public UserModel addUser(UserModel userModel) {
        return userRepo.save(userModel);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserModel getUserByID(Long userId) {
        return userRepo.findById(userId).orElseThrow(() ->
            new IllegalArgumentException("Cannot find User with the ID of : " + userId));
    }

    @Override
    public UserModel updateUser(UserModel userModel,Long userId) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());


        UserModel existingUser = userRepo.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("Cannot find User with the ID of : " + userId));

        existingUser.setFirstName(userModel.getFirstName());
        existingUser.setLastName(userModel.getLastName());
        existingUser.setAddress(userModel.getAddress());
        existingUser.setMobile(userModel.getMobile());
        existingUser.setEmail(userModel.getEmail());
        existingUser.setLastUpdated(formatter.format(date)); //potential issue (comment left at service creation stage), This is saved as a string, not a date. column datatype on DB must be a string

        userRepo.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }
}
