package com.lwh.examproject1.Controller;

import com.lwh.examproject1.Dao.Administrarator;
import com.lwh.examproject1.Dao.Student;
import com.lwh.examproject1.Dao.Teacher;
import com.lwh.examproject1.Service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
public class LoginController1 {
    @Autowired
    private LoginService loginService;

   /* @PostMapping("/login") // 明确指定POST方法
    @ResponseBody
    @CrossOrigin(origins = "*") // 添加跨域支持
    public Student login(@RequestBody Map<String,String> loginData) { // 接收JSON参数

        return loginService.Stulogin(loginData.get("username"), loginData.get("password"));
    }*/

    /**
     * 处理用户登录请求并根据用户类型分发处理逻辑
     *
     * @param loginData 包含登录凭证的请求体，需包含username（用户名）和password（密码）字段
     * @param userType  用户类型参数，接受student/teacher/admin三种有效值
     * @return ResponseEntity包装的响应实体：
     * - 成功时返回对应类型的用户对象（Student/Teacher/Administrator）
     * - 无效用户类型时返回400状态码和错误消息
     */
   /* @PostMapping("/login")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> login(@RequestBody Map<String,String> loginData, @RequestParam("userType") String userType) {
        // 根据用户类型分发登录处理逻辑
        switch(userType) {
            case "student":
                // 处理学生登录
                Student student = loginService.Stulogin(loginData.get("username"), loginData.get("password"));
                return ResponseEntity.ok(student);

            case "teacher":
                // 处理教师登录
                Teacher teacher = loginService.selteacher(loginData.get("username"), loginData.get("password"));
                return ResponseEntity.ok(teacher);

            case "admin":
                // 处理管理员登录
                Administrarator admin = loginService.selectAdministrarator(loginData.get("username"), loginData.get("password"));
                return ResponseEntity.ok(admin);

            default:
                // 处理无效用户类型请求
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Map.of("message", "无效的用户类型"));
        }
    }*/
    @PostMapping("/login")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData,
                                   @RequestParam("userType") String userType,
                                   HttpSession session) { // 添加session参数
        switch (userType) {
            case "student":
                Student student = loginService.Stulogin(loginData.get("username"), loginData.get("password"));
                if (student != null) {
                    session.setAttribute("student", student); // 添加session存储
                    return ResponseEntity.ok(student);
                }
                return ResponseEntity.status(401).body("登录失败");
            case "teacher":
                // 处理教师登录
                Teacher teacher = loginService.selteacher(loginData.get("username"), loginData.get("password"));
                return ResponseEntity.ok(teacher);

            case "admin":
                // 处理管理员登录
                Administrarator admin = loginService.selectAdministrarator(loginData.get("username"), loginData.get("password"));
                return ResponseEntity.ok(admin);

            default:
                // 处理无效用户类型请求
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Map.of("message", "无效的用户类型"));
        }
    }
}



