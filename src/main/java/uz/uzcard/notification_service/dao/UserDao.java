package uz.uzcard.notification_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.uzcard.notification_service.entity.Users;

@Repository
public interface UserDao extends JpaRepository<Users, Long> {

    Users findByFirstNameEndingWith(String bek);


    // Jpa query lang

//    @Query("insert into")
//     void createUser(Users entity);

    // CRUD -> save, get,delete,update
    // JPA method name ozi compile time create qiladi

    // method by name: JPA generate qiladi select * from t_user;

//    Optional<Users> findById(Long id);

    @Query("select u from Users u where u.id=:id")
    Users findByByIdCustom(@Param("id") Long userId);
}
