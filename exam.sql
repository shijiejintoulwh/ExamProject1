/*
 Navicat Premium Dump SQL

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80037 (8.0.37)
 Source Host           : localhost:3306
 Source Schema         : exam

 Target Server Type    : MySQL
 Target Server Version : 80037 (8.0.37)
 File Encoding         : 65001

 Date: 10/04/2025 00:09:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `ad_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键、管理员登录id',
  `a_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员姓名',
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '管理员性别',
  `cardnumber` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `pwd` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员用户密码',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`ad_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('admin1', 'admin', '1', '0', '123456', '123456');
INSERT INTO `administrator` VALUES ('root', '测试', '女', '351223200302025698', '456452', '13026532659');

-- ----------------------------
-- Table structure for choicequestion
-- ----------------------------
DROP TABLE IF EXISTS `choicequestion`;
CREATE TABLE `choicequestion`  (
  `c_id` int NOT NULL AUTO_INCREMENT COMMENT '题目编号、主键、自增',
  `c_question` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '题目、唯一',
  `c_choiceA` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '选项A',
  `c_choiceB` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '选项B',
  `c_choiceC` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '选项C',
  `c_choiceD` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '选项D',
  `c_answer` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '答案',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of choicequestion
-- ----------------------------
INSERT INTO `choicequestion` VALUES (1, '1.单片机的英文缩写是	 (		 )', 'A. CPU', 'B. MCU', 'C. RAM', 'D. ATM', 'B');
INSERT INTO `choicequestion` VALUES (2, '2.下面哪个不是单片机的组成部分 (		)', 'A. 输入/输出接口', 'B.中央处理器', 'C.显示器', 'D.定时/计数器', 'C');
INSERT INTO `choicequestion` VALUES (3, '3.PC的值是	 (		)', 'A. 当前正在执行的指令的地址', 'B. 控制器中指令寄存器的地址', 'C. 当前正在执行指令的前一条指令的地址', 'D. 当前正在执行指令的下一条指令的地址', 'D');
INSERT INTO `choicequestion` VALUES (4, '4.	在中断服务程序中，至少应该有一条	(		)', 'A. 中断返回指令', 'B. 加法指令', 'C. 位传送指令', 'D. 查表指令', 'A');
INSERT INTO `choicequestion` VALUES (5, '5.	要使单片机能够响应T0中断和外部中断0，中断允许寄存器IE的值应该为(		)', 'A. 98H', 'B.85H', 'C.53H', 'D.83H', 'D');
INSERT INTO `choicequestion` VALUES (6, '6.	定时/计数器控制寄存器TCON中，IT0=1，表示外部中INT0的触发方式为(		)', 'A. 无条件触发', 'B.下降沿触发', 'C.低电平触发', 'D.定时触发', 'B');
INSERT INTO `choicequestion` VALUES (7, '7.	MCS-51指令系统中访问片外RAM时使用的指令是(		)', 'A. MOVX		', 'B.MOV	', 'C.MOVC	', 'D.SJMP', 'A');
INSERT INTO `choicequestion` VALUES (8, '8.	89C51单片机的地址总线中，需要外加地址锁存器的是 (		)', 'A. P0口	', 'B.P1口	', 'C.P2口	', 'D.P3口', 'A');
INSERT INTO `choicequestion` VALUES (12, 'erarfd', 'A. 输入/输出接口', 'B.中央处理器', 'C.显示器', 'D.定时/计数器', 'q');

-- ----------------------------
-- Table structure for exam_history
-- ----------------------------
DROP TABLE IF EXISTS `exam_history`;
CREATE TABLE `exam_history`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `score` int NOT NULL,
  `exam_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `student_id`(`student_id` ASC) USING BTREE,
  CONSTRAINT `exam_history_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`s_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_history
-- ----------------------------
INSERT INTO `exam_history` VALUES (1, '001', 80, '2025-04-09 22:07:36');
INSERT INTO `exam_history` VALUES (2, '001', 0, '2025-04-09 23:11:52');
INSERT INTO `exam_history` VALUES (3, '001', 0, '2025-04-09 23:12:03');
INSERT INTO `exam_history` VALUES (4, '001', 0, '2025-04-09 23:12:50');
INSERT INTO `exam_history` VALUES (5, '001', 30, '2025-04-09 23:14:41');
INSERT INTO `exam_history` VALUES (6, '001', 30, '2025-04-09 23:16:17');
INSERT INTO `exam_history` VALUES (7, '001', 20, '2025-04-09 23:16:49');
INSERT INTO `exam_history` VALUES (8, '001', 0, '2025-04-09 23:17:41');

-- ----------------------------
-- Table structure for fillquestion
-- ----------------------------
DROP TABLE IF EXISTS `fillquestion`;
CREATE TABLE `fillquestion`  (
  `f_id` int NOT NULL AUTO_INCREMENT COMMENT '题目编号、主键、自增',
  `f_question` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '题目、唯一',
  `f_answer` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '答案',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fillquestion
-- ----------------------------
INSERT INTO `fillquestion` VALUES (1, '1.	89C51单片机1个机器周期包含           个状态周期。', 'f');
INSERT INTO `fillquestion` VALUES (2, '2.	在系统进行外部扩展时，由            口输出高8位地址。', 'P2');
INSERT INTO `fillquestion` VALUES (3, '3.	程序状态字寄存器PSW中，RS1、RS0为10时，选择的工作寄存器组号为          。', '2');
INSERT INTO `fillquestion` VALUES (4, '4.	累加器A 是            位的寄存器。', '8');
INSERT INTO `fillquestion` VALUES (5, '5.	指令MOV A, #0F6H源操作数的寻址方式为                。', '立即数');
INSERT INTO `fillquestion` VALUES (6, '6.	51单片机使用定时/计数器                作为波特率发生器。', 'T1');
INSERT INTO `fillquestion` VALUES (7, '7.	89C51单片机外接晶体振荡器的振荡频率为12MHz，则一个机器周期为           。', '1us    ');
INSERT INTO `fillquestion` VALUES (8, '8.	计算机中最常用的字符信息编码为               码。', 'ASCII ');
INSERT INTO `fillquestion` VALUES (9, '9.	51单片机使用定时/计数器T1作为波特率发生器时，通常选用工作方式           。', '2');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `s_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键、考生登录id',
  `s_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '考生姓名',
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `cardnumber` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '考生密码',
  `department` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '系别',
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '考生电话',
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('001', '李四', '男', '123456789', '123', '计算机科学与技术', '123456789');
INSERT INTO `student` VALUES ('0010', 'cd', '女', '351223200302025698', '', '计算机科学与技术', '13026532659');
INSERT INTO `student` VALUES ('002', '张三cx', '女', '351223200302025698', '123', '计算机科学与技术', '13026532659');
INSERT INTO `student` VALUES ('003', '王五', '女', '351223200302025698', '123', '计算机科学与技术', '13026532659');
INSERT INTO `student` VALUES ('006', '五五', '女', '351223200302025698', 'zxcv', '机械工程', '13026532659');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `t_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键、教师登录id',
  `t_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教师姓名',
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '教师性别',
  `cardnumber` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `pwd` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `title` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '职称',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1001', '12', '女', '12345678901', '123456', '教授', '12345678901');
INSERT INTO `teacher` VALUES ('1002', '测试修改', '女', '351223200302025698', 'asdf', '高级', '13026532659');
INSERT INTO `teacher` VALUES ('20180004', '测试修改', '女', '351223200302025698', 'asd', '高级', '13026532659');

SET FOREIGN_KEY_CHECKS = 1;
