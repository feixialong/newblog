package szu.bigdata.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

/**
 * Created by longhao on 2017/4/7.
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Integer vid;
    private Date date;
    private String title;
    private String article;//正文
    private String abstracts;//摘要
    private String tags;//关键词 或标签
    private String categories;//归属的类别
    private String YearMonthDay;
}
