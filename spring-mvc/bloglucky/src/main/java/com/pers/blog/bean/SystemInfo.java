package com.pers.blog.bean;

import java.util.Date;

public class SystemInfo {
    private String id;

    private Date createTime;

    private Date systemCreateTime;

    private Integer ipCount;

    private Integer totalVisits;

    private String siteEnglishName;

    private String siteName;

    private String siteUrl;

    private String recordNumber;

    private String siteOwner;

    private String ownerQq;

    private String ownerWeixin;

    private String ownerMail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSystemCreateTime() {
        return systemCreateTime;
    }

    public void setSystemCreateTime(Date systemCreateTime) {
        this.systemCreateTime = systemCreateTime;
    }

    public Integer getIpCount() {
        return ipCount;
    }

    public void setIpCount(Integer ipCount) {
        this.ipCount = ipCount;
    }

    public Integer getTotalVisits() {
        return totalVisits;
    }

    public void setTotalVisits(Integer totalVisits) {
        this.totalVisits = totalVisits;
    }

    public String getSiteEnglishName() {
        return siteEnglishName;
    }

    public void setSiteEnglishName(String siteEnglishName) {
        this.siteEnglishName = siteEnglishName == null ? null : siteEnglishName.trim();
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl == null ? null : siteUrl.trim();
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber == null ? null : recordNumber.trim();
    }

    public String getSiteOwner() {
        return siteOwner;
    }

    public void setSiteOwner(String siteOwner) {
        this.siteOwner = siteOwner == null ? null : siteOwner.trim();
    }

    public String getOwnerQq() {
        return ownerQq;
    }

    public void setOwnerQq(String ownerQq) {
        this.ownerQq = ownerQq == null ? null : ownerQq.trim();
    }

    public String getOwnerWeixin() {
        return ownerWeixin;
    }

    public void setOwnerWeixin(String ownerWeixin) {
        this.ownerWeixin = ownerWeixin == null ? null : ownerWeixin.trim();
    }

    public String getOwnerMail() {
        return ownerMail;
    }

    public void setOwnerMail(String ownerMail) {
        this.ownerMail = ownerMail == null ? null : ownerMail.trim();
    }
}