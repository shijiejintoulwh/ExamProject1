package com.lwh.examproject1.Controller;

import com.lwh.examproject1.Dao.Administrarator;
import com.lwh.examproject1.Mapper.AdminMapper;
import com.lwh.examproject1.Service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController1 {
    private static final Logger logger = LoggerFactory.getLogger(AdminController1.class);

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminService adminService;

    @GetMapping("/list")
    public ResponseEntity<List<Administrarator>> getAllAdmins() {
        return ResponseEntity.ok(adminMapper.selectAdminAllow());
    }

    // 修改3：增强添加接口校验（约第28行）
    @PostMapping("/add")
    public ResponseEntity<?> addAdmin(@RequestBody Administrarator admin) {
        logger.info("Received addAdmin request with data: {}", admin);
        try {
            // 新增存在性校验
            if (adminMapper.selectAdminById(admin.getAdid()) != null) {
                return ResponseEntity.badRequest().body("管理员已存在");
            }
            adminService.addAdmin(admin);  // 使用Service层方法
            logger.info("Admin added successfully: {}", admin);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Failed to add admin", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add admin");
        }
    }


    @PutMapping("/{id}")  // 原@PutMapping("/update")
    public ResponseEntity<?> updateAdmin(
            @PathVariable String id,  // 新增路径参数
            @RequestBody Administrarator admin) {

        adminService.updateAdminAll(admin); // 使用Service层方法
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable String id) {
        adminMapper.deleteAdmin(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrarator> getAdminById(@PathVariable String id) {
        return ResponseEntity.ok(adminMapper.selectAdminById(id));
    }
}
