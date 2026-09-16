package uz.uzcard.notification_service.controller;

import org.springframework.web.bind.annotation.*;
import uz.uzcard.notification_service.UserUpdateDto;
import uz.uzcard.notification_service.service.UserService;

@RestController // bu anation bilan belgilangan class Contorller, REST, JSON yoki XML, ResponseBody+Controller
//@Controller //MVC file html
//@ResponseBody -> Response da body qaytarish uchun
public class UserController {
    // Anation orqali dependency injection qilish
//    @Autowired
    private final UserService userService;

    //DI(Dependency Injection) 3 turi
    //Constructor based
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // setter based Dependency Injecction
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    /*
     * POST,GET,PUT,DELETE,PATCH -> CRUD
     * POST-> insert, modify
     * GET-> GET qiladi
     * PUT-> modify, update hamma qatorlar update
     * PATCH-> faqat biz update qilgan qatorlar update
     * */

    @PostMapping("/create-user") // url path, veriable, param, body
    public String createUser(@RequestParam String username, @RequestParam String password) {
        return "User Created Successfully";
    }

    @GetMapping("/user-byId/{id}") // path veriable
    public String getUser(@PathVariable("id") Long userId) {
        return "User retrived successfully with id: " + userId;
    }
    /*
     * form, username,password, firstname, lastName JSON
     * request={
     * "username":"coder",
     * "lastName":"Toshniyozov",
     * "firstName":"Bobur",
     * "password":"1234",
     * }
     * */

    /*
     * JSON dto object va dto object json formatga ogiradi narsa bor, Serilization ,Desirilization
     * */

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserUpdateDto request) {
        System.out.println("user updated");
    }

    @DeleteMapping("/user-delete-byId")
    public void userDelete(@RequestParam Long id) {
        System.out.println("user deleted by id: " + id);
    }
}
