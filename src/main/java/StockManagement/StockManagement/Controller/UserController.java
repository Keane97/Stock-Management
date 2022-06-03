package StockManagement.StockManagement.Controller;

import StockManagement.StockManagement.Model.UserModel;
import StockManagement.StockManagement.Repository.UserRepo;
import StockManagement.StockManagement.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/add")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel){

        try {
            return new ResponseEntity<UserModel>(userService.addUser(userModel), HttpStatus.OK);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserModel>> getallUsers(){
        List<UserModel> userModels = (List<UserModel>) userService.getAllUsers();
        return new ResponseEntity<List<UserModel>>(userModels, HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserModel> getById(@PathVariable("userId") Long userId){

        try {
            return new ResponseEntity<UserModel>(userService.getUserByID(userId), HttpStatus.OK);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/edit/{userId}")
    public ResponseEntity<UserModel> updateUser(@PathVariable("userId") Long userId, @RequestBody UserModel userModel){

        try {
            return new ResponseEntity<UserModel>(userService.updateUser(userModel,userId), HttpStatus.OK);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);

        return new ResponseEntity<String>("User Deleted Successfully", HttpStatus.OK);
    }


}
