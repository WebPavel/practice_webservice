package cn.com.zv2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author lb
 * @description
 * @date 2020/5/18
 */
@Setter
@Getter
@ToString
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private String createBy;
    private String updateBy;
    private String remark;
}
