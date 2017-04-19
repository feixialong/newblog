package szu.bigdata.service.ServiceInterface;

import szu.bigdata.domain.AdminInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by longhao on 2017/4/7.
 */
public interface AdminInfoService {

    //获取 username,email,github,webo,avatar信息
    AdminInfo getAdminInfo();

    //登陆验证
    boolean login(AdminInfo adminInfo);

    //登录成功后添加session
    void addSession(HttpServletRequest request, AdminInfo adminInfo);

    //登录退出或者超时之后销毁session
    void destroySession(HttpServletRequest request);
}
