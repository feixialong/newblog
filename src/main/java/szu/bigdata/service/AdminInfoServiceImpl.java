package szu.bigdata.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szu.bigdata.domain.AdminInfo;
import szu.bigdata.repository.AdminInfoRepository;
import szu.bigdata.service.ServiceInterface.AdminInfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by longhao on 2017/4/10.
 */
@Service
@Slf4j
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    private AdminInfoRepository adminInfoRepository;

    @Override
    public AdminInfo getAdminInfo() {
        return adminInfoRepository.selectAdminInfo();
    }

    @Override
    public boolean login(AdminInfo adminInfo) {
        int num=adminInfoRepository.selectByPassword(adminInfo.getEmail(),adminInfo.getPassword());

        if(num==1) {
            log.info("user: " + adminInfo.getEmail() + ", password: " + adminInfo.getPassword() + " logging success");
            return true;
        }
        else{
            log.info("user: " + adminInfo.getEmail() + ", password: " + adminInfo.getPassword() + " logging failed");
            return false;
        }
    }

    @Override
    public void addSession(HttpServletRequest request, AdminInfo adminInfo) {
        HttpSession session=request.getSession(true);
        session.setAttribute("current_user",adminInfo);
        session.setMaxInactiveInterval(600);
    }

    @Override
    public void destroySession(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        session.removeAttribute("current_user");
    }
}
