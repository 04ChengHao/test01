package tes;

import com.ruanda.pojo.User;
import com.ruanda.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //启动spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_mapper.xml","classpath:applicationContext_service.xml"})
public class MyTest {

    @Autowired
    UserService userService;

    @Test
    public void testSelectUserPage(){
        List<User> list = userService.selectUserPage(null,null,0);
        list.forEach(user -> System.out.println(user));
    }
    @Test
    public void  testdeleteUserById(){
        int num = userService.deleteUserById("15968162087363060");
        System.out.println(num);
    }
    @Test
    public void testGetRowCount(){
        int num = userService.getRowCount(null,"男");
        System.out.println(num);
    }
    @Test
    public void testcreateUser(){
        int num = userService.createUser(new User("1234561231545","身份证","4354231265","天湖","男","23","工人"));
        System.out.println(num);
    }

    @Test
    public void textQueryUserPage(){
        List<User> list = userService.queryUserPage(5);
    }

    @Test
    public void textUpdateUserById(){
        int num = userService.updateUserById(new User("1234561231545","身份证","4354231265","天湖","女","23","工人"));
    }

    @Test
    public void textDeleteUserByIdList(){
        int num = userService.deleteUserByIdList(Collections.singletonList("1234561231545"));
    }
}
