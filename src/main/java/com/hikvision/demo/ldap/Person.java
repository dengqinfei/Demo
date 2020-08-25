/*
 * @ProjectName: 编程学习
 * @Copyright:   2018 HangZhou Yiyuery Dev, Ltd. All Right Reserved.
 * @address:     http://xiazhaoyang.tech
 * @date:        2018/7/28 18:15
 * @email:       xiazhaoyang@live.com
 * @description: 本内容仅限于编程技术学习使用，转发请注明出处.
 */
package com.hikvision.demo.ldap;

import lombok.Data;
import lombok.ToString;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author xiachaoyang
 * @version V1.0
 * @date 2018年10月08日 17:16
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify By: {修改人} 2018年10月08日
 * @modify reason: {方法名}:{原因}
 * ...
 */
@Data
@ToString
@Entry(objectClasses = {"organizationalUnit"}, base = "ou=person,dc=coreservice")
public class Person {
    /**
     * 主键
     */
    @Attribute
    private String personId;

    /**
     * 人员姓名
     */
    @Attribute(name = "ou")
    private String ou;

    /**
     * 人员姓名
     */
    @Attribute(name = "cn")
    private String personName;
    /**
     * 组织ID
     */
    @Attribute(name = "orgId")
    private String orgId;
    /**
     * 性别
     */
    @Attribute(name = "sex")
    private Integer sex;
    /**
     * 电话
     */
    @Attribute(name = "mobile")
    private String mobile;
    /**
     * 邮箱
     */
    @Attribute(name = "email")
    private String email;
    /**
     * 工号
     */
    @Attribute(name = "jobNo")
    private String jobNo;
    /**
     * 学号
     */
    @Attribute(name = "studentId")
    private String studentId;

    /**
     * 证件类型
     */
    @Attribute(name = "certType")
    private Integer certType;
    /**
     * 证件号码
     */
    @Attribute(name = "certificateNo")
    private String certNo;

    @Attribute
    protected Date createTime;

    /**
     * 更新时间
     */
    @Attribute
    protected Date updateTime;
    /**
     * 状态
     */
    @Attribute
    protected Integer status;

    @Attribute
    protected Integer disOrder;

    /**
     * 工作单位
     */
    @Attribute
    private String company;
}

