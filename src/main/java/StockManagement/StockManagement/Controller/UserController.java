package StockManagement.StockManagement.Controller;

import StockManagement.StockManagement.Model.UserModel;
import StockManagement.StockManagement.Repository.UserRepo;
import StockManagement.StockManagement.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Users")
public class UserController {

    private IUserService userService;

    @Autowired
    public UserController(IUserService iUserService) {
//        super();
        this.userService = iUserService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserModel>> getallUsers(){
        List<UserModel> userModels = (List<UserModel>) userService.getAllUsers();
        return new ResponseEntity<List<UserModel>>(userModels, HttpStatus.OK);
    }
}
