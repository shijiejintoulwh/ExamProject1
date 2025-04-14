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
// 声明为RESTful风格控制器，自动将返回对象序列化为JSON
@RestController
// 定义控制器根路径为/admin，所有接口访问路径前都会加上此路径
@RequestMapping("/admin")
public class AdminController1 {
    // 日志记录器，用于输出日志信息
    private static final Logger logger = LoggerFactory.getLogger(AdminController1.class);
    // 自动注入数据访问层组件（MyBatis Mapper接口）
    @Autowired
    private AdminMapper adminMapper;
    // 自动注入业务逻辑层组件
    @Autowired
    private AdminService adminService;

    // 处理GET请求，访问路径为/admin/list
    @GetMapping("/list")
    // 返回包含管理员列表的响应实体，List<Administrarator>是响应体类型
    public ResponseEntity<List<Administrarator>> getAllAdmins() {
        // 200 OK响应 + 数据库查询结果
        return ResponseEntity.ok(adminMapper.selectAdminAllow());
    }
    // 处理POST请求，访问路径为/admin/add
    @PostMapping("/add")
    // <?>表示响应体类型不确定（可能成功或返回错误信息），将请求体JSON自动反序列化为Administrarator对象
    public ResponseEntity<?> addAdmin(@RequestBody Administrarator admin) {
        // 记录请求日志（INFO级别）
        logger.info("Received addAdmin request with data: {}", admin);
        try {
            // 存在性校验：根据ID查询是否已存在管理员
            if (adminMapper.selectAdminById(admin.getAdid()) != null) {
                // 返回400 Bad Request + 错误信息
                return ResponseEntity.badRequest().body("管理员已存在");
            }
            // 调用业务层方法执行添加操作
            adminService.addAdmin(admin);  // 使用Service层方法
            // 记录成功日志
            logger.info("Admin added successfully: {}", admin);
            // 返回200 OK空响应体
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // 记录错误日志（ERROR级别，带堆栈跟踪）
            logger.error("Failed to add admin", e);
            // 返回500服务器错误 + 错误信息
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add admin");
        }
    }


    @PutMapping("/{id}")  // 映射HTTP PUT请求到updateAdmin方法
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
