package com.syf.rbac;

import com.syf.rbac.service.impl.UserDetailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(JUnit4.class)
@SpringBootTest(classes = {RcbaApplicationTests.class})
public class RcbaApplicationTests {

//    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl=new UserDetailServiceImpl();
//    private UserServiceImpl userService;

    @Test
    public void contextLoads() {
        System.out.println(userDetailServiceImpl);
    }
}
