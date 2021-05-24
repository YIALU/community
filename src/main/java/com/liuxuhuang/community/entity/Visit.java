package com.liuxuhuang.community.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.io.Serializable;

/**
 * (Visit)实体类
 *
 * @author liuxuhuang
 * @since 2021-05-19 20:17:31
 */
@ApiModel
@Component
public class Visit implements Serializable {
    private static final long serialVersionUID = 328655631982382462L;

    @ApiModelProperty(value = "访客编号")
    private int id;
    /**
     * 访客姓名
     */
    @ApiModelProperty(value = "访客姓名")
    private String visitorName;
    /**
     * 访客电话
     */
    @ApiModelProperty(value = "访客电话")
    private String visitorTel;
    /**
     * 到访原因
     */
    @ApiModelProperty(value = "到访原因")
    private String visitReason;
    /**
     * 进入时间
     */
    @ApiModelProperty(value = "进入时间")
    private Date enterTime;
    /**
     * 离开时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "离开时间")
    private Date leaveTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorTel() {
        return visitorTel;
    }

    public void setVisitorTel(String visitorTel) {
        this.visitorTel = visitorTel;
    }

    public String getVisitReason() {
        return visitReason;
    }

    public void setVisitReason(String visitReason) {
        this.visitReason = visitReason;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Visit() {
    }

    public Visit(int id, String visitorName, String visitorTel, String visitReason, Date enterTime, Date leaveTime) {
        this.id = id;
        this.visitorName = visitorName;
        this.visitorTel = visitorTel;
        this.visitReason = visitReason;
        this.enterTime = enterTime;
        this.leaveTime = leaveTime;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", visitorName='" + visitorName + '\'' +
                ", visitorTel='" + visitorTel + '\'' +
                ", visitReason='" + visitReason + '\'' +
                ", enterTime=" + enterTime +
                ", leaveTime=" + leaveTime +
                '}';
    }
}
