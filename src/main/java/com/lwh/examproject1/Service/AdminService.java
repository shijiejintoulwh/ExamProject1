package com.lwh.examproject1.Service;

import com.lwh.examproject1.Dao.Administrarator;
import com.lwh.examproject1.Mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public List<Administrarator> getAllAdmins() {
        return adminMapper.selectAdminAllow();
    }

    public void updateAdminAll(Administrarator admin) {
        // 先检查用户是否存在
        Administrarator existAdmin = adminMapper.selectAdminById(admin.getAdid());
        if (existAdmin == null) {
            throw new RuntimeException("用户不存在");
        }
        // 执行更新
        adminMapper.updateAdminAllow(
                admin.getAname(),
                admin.getSex(),
                admin.getCardnumber(),
                admin.getPwd(),
                admin.getPhone(),
                admin.getAdid()
        );
    }


    // AdminService.java 添加校验逻辑
    public void addAdmin(Administrarator admin) {
        if (adminMapper.selectAdminById(admin.getAdid()) != null) {
            throw new RuntimeException("管理员已存在");
        }
        adminMapper.insertAdmin(admin);
    }


    public void updateAdmin(Administrarator admin) {
        adminMapper.updateAdmin(admin.getAname(), admin.getSex(),
                admin.getCardnumber(), admin.getPhone(), admin.getAdid());
    }

    public void deleteAdmin(String adid) {
        adminMapper.deleteAdmin(adid);
    }
}
