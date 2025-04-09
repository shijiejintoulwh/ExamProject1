package com.lwh.examproject1.test;

import com.lwh.examproject1.Dao.Administrarator;
import com.lwh.examproject1.Mapper.AdminMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAdminMapper {
    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void test1() {
        System.out.println(adminMapper.selectAdminAllow());
    }

    @Test
    public void test2() {

        Administrarator administrator = new Administrarator();
        administrator.setAdid("admin");
        administrator.setAname("admin");
        administrator.setSex("男");
        administrator.setCardnumber("123456789");
        administrator.setPwd("123456");
        administrator.setPhone("123456789");
        adminMapper.insertAdmin(administrator);
    }

    @Test
    public void updateByPwdTest() {
        Administrarator adminbyid = adminMapper.selectAdminById("admin");
        System.out.println(adminbyid);
        adminMapper.updateAdminBypwd("admin", "56694659");
        Administrarator adminbyid1 = adminMapper.selectAdminById("admin");
        System.out.println(adminbyid1);
    }

    @Test
    public void deleteTest() {
        adminMapper.deleteAdmin("admin");
        test1();
    }

    @Test
    public void updateTest() {
        adminMapper.updateAdmin("管理员1", "女", "110113152605022541", "15725413652", "admin");
        test1();
    }

    @Test
    public void updateAll() {
        test1();
        adminMapper.updateAdminAllow("李四", "男",
                "123456789456123", "159264837",
                "12345678901", "admin22");
        test1();
    }
}
