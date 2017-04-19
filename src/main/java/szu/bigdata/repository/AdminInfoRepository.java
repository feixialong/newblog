package szu.bigdata.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import szu.bigdata.domain.AdminInfo;

/**
 * Created by longhao on 2017/4/7.
 */

@Repository
@Mapper
public interface AdminInfoRepository {

    @Select({
            "select username,email,github,weibo,qq,weixin,signature,resume,avatar",
            "from admin",
            "limit 1"
    })
    AdminInfo selectAdminInfo();

    @Select({
            "select count(*) as num",
            "from admin",
            "where email=#{email} and password=#{pw}"
    })
    int selectByPassword(@Param("email") String email,@Param("pw") String password);
}
