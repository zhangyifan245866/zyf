package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

public class Devicetype implements Serializable {
    @Id
    private Integer devicetypeid;

    private String typename;

    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creatime;

    private static final long serialVersionUID = 1L;

    /**
     * @return devicetypeid
     */
    public Integer getDevicetypeid() {
        return devicetypeid;
    }

    /**
     * @param devicetypeid
     */
    public void setDevicetypeid(Integer devicetypeid) {
        this.devicetypeid = devicetypeid;
    }

    /**
     * @return typename
     */
    public String getTypename() {
        return typename;
    }

    /**
     * @param typename
     */
    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return creatime
     */
    public Date getCreatime() {
        return creatime;
    }

    /**
     * @param creatime
     */
    public void setCreatime(Date creatime) {
        this.creatime = creatime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", devicetypeid=").append(devicetypeid);
        sb.append(", typename=").append(typename);
        sb.append(", status=").append(status);
        sb.append(", creatime=").append(creatime);
        sb.append("]");
        return sb.toString();
    }
}