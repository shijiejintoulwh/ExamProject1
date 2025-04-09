package com.lwh.examproject1.Mapper;

import com.lwh.examproject1.Dao.Administrarator;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {
    //查询所有管理员
    @Select("select * from administrator ")
    List<Administrarator> selectAdminAllow();

    //根据adid查询管理员
    @Select("select * from administrator where ad_id=#{adid}")
    Administrarator selectAdminById(String adid);

    //添加管理员
    @Insert("insert into administrator(ad_id,a_name,sex,cardnumber,pwd,phone) values(#{adid},#{aname},#{sex},#{cardnumber},#{pwd},#{phone})")
    void insertAdmin(Administrarator administrator);

    @Update("update administrator set a_name=#{aname},sex=#{sex},cardnumber=#{cardnumber},pwd=#{pwd},phone=#{phone} where ad_id=#{adid}")
    void updateAdminAllow(@Param("aname") String aname,
                          @Param("sex") String sex,
                          @Param("cardnumber") String cardnumber,
                          @Param("pwd") String pwd,
                          @Param("phone") String phone,
                          @Param("adid") String adid);   //修改常用信息

    @Update("update administrator set a_name=#{aname},sex=#{sex},cardnumber=#{cardnumber},phone=#{phone} where ad_id=#{adid}")
    void updateAdmin(@Param("aname") String aname, @Param("sex") String sex, @Param("cardnumber") String cardnumber, @Param("phone") String phone, @Param("adid") String adid);

    //根据aid修改密码
    @Update("update administrator set pwd=#{pwd} where ad_id=#{adid}")
    void updateAdminBypwd(@Param("adid") String adid, @Param("pwd") String pwd);

    //根据adid删除管理员
    @Delete("delete from administrator where ad_id=#{adid}")
    void deleteAdmin(String adid);

}
