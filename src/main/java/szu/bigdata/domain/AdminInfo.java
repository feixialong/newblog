package szu.bigdata.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by longhao on 2017/4/7.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class AdminInfo {
    private String username;
    private String password;//md5加密后的密码
    private String email;
    private String github;
    private String weibo;
    private String qq;
    private String weixin;
    private String signature;//个性签名
    private String resume;//个人简历
    private String avatar;//个人头像
}
