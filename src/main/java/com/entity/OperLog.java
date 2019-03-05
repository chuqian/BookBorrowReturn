package com.entity;

import com.framework.aspectj.annotation.Excel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author chuqian
 * @Date created in 2019/1/31 20:56
 * @describe 操作日志记录表oper_log
 */
@Entity
@Table(name = "t_oper_log")
public class OperLog implements Serializable {
    private static final long serialVersionUID = -2443712479380746328L;

    /** 日志主键 */
    @Excel(name = "日志主键")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @SequenceGenerator(name = "idGenerator", sequenceName = "SEQ_T_OPER_LOG", allocationSize = 1)
    private Long oper_log_id;

    /** 操作模块 */
    @Excel(name = "操作模块")
    private String module;

    /** 操作业务类型 */
    @Excel(name = "业务类型", readConverterExp = "0=其它,1=新增,2=修改,3=删除,4=授权,5=导出,6=导入,7=强退,8=生成代码,9=清空数据")
    private Integer businessType;

    /** 请求方法 */
    @Excel(name = "请求方法")
    private String method;

    /** 操作人类别 */
    @Excel(name = "操作类别", readConverterExp = "0=其它,1=后台用户,2=手机端用户")
    private Integer operatorType;

    /** 操作人员 */
    @Excel(name = "操作人员")
    private String operName;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String deptName;

    /** 请求url */
    @Excel(name = "请求地址")
    private String operUrl;

    /** 操作地址 */
    @Excel(name = "操作地址")
    private String operIp;

    /** 操作地点 */
    @Excel(name = "操作地点")
    private String operLocation;

    /** 请求参数 */
    @Excel(name = "请求参数")
    private String operParam;

    /** 状态0正常 1异常 */
    @Excel(name = "状态", readConverterExp = "1=正常,0=异常")
    private Integer status;

    /** 错误消息 */
    @Excel(name = "错误消息")
    private String errorMsg;

    /** 操作时间 */
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date operTime;

    public Long getOper_log_id() {
        return oper_log_id;
    }

    public void setOper_log_id(Long oper_log_id) {
        this.oper_log_id = oper_log_id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOperUrl() {
        return operUrl;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }

    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getOperLocation() {
        return operLocation;
    }

    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation;
    }

    public String getOperParam() {
        return operParam;
    }

    public void setOperParam(String operParam) {
        this.operParam = operParam;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }
}
