package com.example.test1.service.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.test1.mapper.UserMapper;
import com.example.test1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.test1.entity.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public String loginService(String number, String password) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("number",number)
                .eq("password",password);
        User user=userMapper.selectOne(queryWrapper);
        if(user!=null){
            return "SUCCESS";
        }else{
            return "用户账号或密码错误";
        }
    }

    /*
    @Override
    public String registerService(User user) {
        User userE = userMapper.selectById(user.getNumber());
        if (userE == null) {
            if ("".equals(user.getPassword())) {
                return "请输入密码";
            } else {
                userMapper.insert(user);
                return "SUCCESS";
            }
        }
        return "用户已存在";
    }
    */

}
