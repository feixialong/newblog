package szu.bigdata.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by longhao on 2017/4/7.
 * 个人介绍
 */
@Getter
@Setter
@NoArgsConstructor
public class Resume {
    private String username;//用户名
    private String resume;//简历的markdown文本
    private String resume_html;//简历的html文本，由markdown转换而来
}
