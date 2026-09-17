package uz.uzcard.notification_service.service;

import org.springframework.stereotype.Service;
import uz.uzcard.notification_service.dao.UserDao;
import uz.uzcard.notification_service.dto.UserCreateDto;
import uz.uzcard.notification_service.dto.UserResponse;
import uz.uzcard.notification_service.entity.Users;

@Service
// bu anation buni IoC container ichida Bean bolib yaralishiga imkon beradi,endi IoC ichida bitta UserService degan Bean yani Object
//@Component// bu anation buni IoC container ichida Bean bolib yaralishiga imkon beradi,endi IoC ichida bitta UserService degan Bean yani Object
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public void createUser(UserCreateDto dto) {
        try {
            Users entity = toEntity(dto);
            userDao.save(entity);
//            userDao.createUser(entity);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public UserResponse getUserById(Long userId) {
        Users user = userDao.findByByIdCustom(userId);
        return toResponse(user);
    }


    private UserResponse toResponse(Users user) {
        return new UserResponse(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName());
    }


    private Users toEntity(UserCreateDto dto) {
        Users user = new Users();
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setPassword(dto.password());
        user.setUsername(dto.username());
        return user;
    }
}
