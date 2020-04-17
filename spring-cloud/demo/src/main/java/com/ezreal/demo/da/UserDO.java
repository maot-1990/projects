package com.ezreal.demo.da;

import java.util.Date;

/**
 * The table USER
 */
public class UserDO {

    /**
     * oid OID.
     */
    private String oid;
    /**
     * email EMAIL.
     */
    private String email;
    /**
     * phone PHONE.
     */
    private String phone;
    /**
     * regIp REG_IP.
     */
    private String regIp;
    /**
     * lastIp LAST_IP.
     */
    private String lastIp;
    /**
     * suspend SUSPEND.
     */
    private Boolean suspend;
    /**
     * apiLimit API_LIMIT.
     */
    private Integer apiLimit;
    /**
     * currency CURRENCY.
     */
    private String currency;
    /**
     * language LANGUAGE.
     */
    private String language;
    /**
     * nickname NICKNAME.
     */
    private String nickname;
    /**
     * password PASSWORD.
     */
    private String password;
    /**
     * createdAt CREATED_AT.
     */
    private Date createdAt;
    /**
     * deletedAt DELETED_AT.
     */
    private Date deletedAt;
    /**
     * updatedAt UPDATED_AT.
     */
    private Date updatedAt;
    /**
     * baseFeeRate BASE_FEE_RATE.
     */
    private Float baseFeeRate;
    /**
     * googleTwoFa GOOGLE_TWO_FA.
     */
    private String googleTwoFa;
    /**
     * lastLoginAt LAST_LOGIN_AT.
     */
    private Date lastLoginAt;
    /**
     * sendGasDate SEND_GAS_DATE.
     */
    private String sendGasDate;
    /**
     * referrerCode REFERRER_CODE.
     */
    private String referrerCode;
    /**
     * baseBonusRate BASE_BONUS_RATE.
     */
    private Float baseBonusRate;
    /**
     * emailValidate EMAIL_VALIDATE.
     */
    private Boolean emailValidate;
    /**
     * phoneValidate PHONE_VALIDATE.
     */
    private Boolean phoneValidate;
    /**
     * tradePassword TRADE_PASSWORD.
     */
    private String tradePassword;
    /**
     * rateStableDate 在日期之前费率保持稳定(不受鼓励金比例影响改变).
     */
    private Date rateStableDate;
    /**
     * sendSharesDate SEND_SHARES_DATE.
     */
    private String sendSharesDate;
    /**
     * referrerUserOid REFERRER_USER_OID.
     */
    private String referrerUserOid;
    /**
     * googleTwoFaBinding GOOGLE_TWO_FA_BINDING.
     */
    private Boolean googleTwoFaBinding;
    /**
     * emailValidationCode EMAIL_VALIDATION_CODE.
     */
    private String emailValidationCode;

    /**
     * Set oid OID.
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * Get oid OID.
     *
     * @return the string
     */
    public String getOid() {
        return oid;
    }

    /**
     * Set email EMAIL.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get email EMAIL.
     *
     * @return the string
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set phone PHONE.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get phone PHONE.
     *
     * @return the string
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set regIp REG_IP.
     */
    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    /**
     * Get regIp REG_IP.
     *
     * @return the string
     */
    public String getRegIp() {
        return regIp;
    }

    /**
     * Set lastIp LAST_IP.
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    /**
     * Get lastIp LAST_IP.
     *
     * @return the string
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * Set suspend SUSPEND.
     */
    public void setSuspend(Boolean suspend) {
        this.suspend = suspend;
    }

    /**
     * Get suspend SUSPEND.
     *
     * @return the string
     */
    public Boolean getSuspend() {
        return suspend;
    }

    /**
     * Set apiLimit API_LIMIT.
     */
    public void setApiLimit(Integer apiLimit) {
        this.apiLimit = apiLimit;
    }

    /**
     * Get apiLimit API_LIMIT.
     *
     * @return the string
     */
    public Integer getApiLimit() {
        return apiLimit;
    }

    /**
     * Set currency CURRENCY.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Get currency CURRENCY.
     *
     * @return the string
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Set language LANGUAGE.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Get language LANGUAGE.
     *
     * @return the string
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Set nickname NICKNAME.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Get nickname NICKNAME.
     *
     * @return the string
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Set password PASSWORD.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get password PASSWORD.
     *
     * @return the string
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set createdAt CREATED_AT.
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Get createdAt CREATED_AT.
     *
     * @return the string
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Set deletedAt DELETED_AT.
     */
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * Get deletedAt DELETED_AT.
     *
     * @return the string
     */
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**
     * Set updatedAt UPDATED_AT.
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Get updatedAt UPDATED_AT.
     *
     * @return the string
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Set baseFeeRate BASE_FEE_RATE.
     */
    public void setBaseFeeRate(Float baseFeeRate) {
        this.baseFeeRate = baseFeeRate;
    }

    /**
     * Get baseFeeRate BASE_FEE_RATE.
     *
     * @return the string
     */
    public Float getBaseFeeRate() {
        return baseFeeRate;
    }

    /**
     * Set googleTwoFa GOOGLE_TWO_FA.
     */
    public void setGoogleTwoFa(String googleTwoFa) {
        this.googleTwoFa = googleTwoFa;
    }

    /**
     * Get googleTwoFa GOOGLE_TWO_FA.
     *
     * @return the string
     */
    public String getGoogleTwoFa() {
        return googleTwoFa;
    }

    /**
     * Set lastLoginAt LAST_LOGIN_AT.
     */
    public void setLastLoginAt(Date lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    /**
     * Get lastLoginAt LAST_LOGIN_AT.
     *
     * @return the string
     */
    public Date getLastLoginAt() {
        return lastLoginAt;
    }

    /**
     * Set sendGasDate SEND_GAS_DATE.
     */
    public void setSendGasDate(String sendGasDate) {
        this.sendGasDate = sendGasDate;
    }

    /**
     * Get sendGasDate SEND_GAS_DATE.
     *
     * @return the string
     */
    public String getSendGasDate() {
        return sendGasDate;
    }

    /**
     * Set referrerCode REFERRER_CODE.
     */
    public void setReferrerCode(String referrerCode) {
        this.referrerCode = referrerCode;
    }

    /**
     * Get referrerCode REFERRER_CODE.
     *
     * @return the string
     */
    public String getReferrerCode() {
        return referrerCode;
    }

    /**
     * Set baseBonusRate BASE_BONUS_RATE.
     */
    public void setBaseBonusRate(Float baseBonusRate) {
        this.baseBonusRate = baseBonusRate;
    }

    /**
     * Get baseBonusRate BASE_BONUS_RATE.
     *
     * @return the string
     */
    public Float getBaseBonusRate() {
        return baseBonusRate;
    }

    /**
     * Set emailValidate EMAIL_VALIDATE.
     */
    public void setEmailValidate(Boolean emailValidate) {
        this.emailValidate = emailValidate;
    }

    /**
     * Get emailValidate EMAIL_VALIDATE.
     *
     * @return the string
     */
    public Boolean getEmailValidate() {
        return emailValidate;
    }

    /**
     * Set phoneValidate PHONE_VALIDATE.
     */
    public void setPhoneValidate(Boolean phoneValidate) {
        this.phoneValidate = phoneValidate;
    }

    /**
     * Get phoneValidate PHONE_VALIDATE.
     *
     * @return the string
     */
    public Boolean getPhoneValidate() {
        return phoneValidate;
    }

    /**
     * Set tradePassword TRADE_PASSWORD.
     */
    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
    }

    /**
     * Get tradePassword TRADE_PASSWORD.
     *
     * @return the string
     */
    public String getTradePassword() {
        return tradePassword;
    }

    /**
     * Set rateStableDate 在日期之前费率保持稳定(不受鼓励金比例影响改变).
     */
    public void setRateStableDate(Date rateStableDate) {
        this.rateStableDate = rateStableDate;
    }

    /**
     * Get rateStableDate 在日期之前费率保持稳定(不受鼓励金比例影响改变).
     *
     * @return the string
     */
    public Date getRateStableDate() {
        return rateStableDate;
    }

    /**
     * Set sendSharesDate SEND_SHARES_DATE.
     */
    public void setSendSharesDate(String sendSharesDate) {
        this.sendSharesDate = sendSharesDate;
    }

    /**
     * Get sendSharesDate SEND_SHARES_DATE.
     *
     * @return the string
     */
    public String getSendSharesDate() {
        return sendSharesDate;
    }

    /**
     * Set referrerUserOid REFERRER_USER_OID.
     */
    public void setReferrerUserOid(String referrerUserOid) {
        this.referrerUserOid = referrerUserOid;
    }

    /**
     * Get referrerUserOid REFERRER_USER_OID.
     *
     * @return the string
     */
    public String getReferrerUserOid() {
        return referrerUserOid;
    }

    /**
     * Set googleTwoFaBinding GOOGLE_TWO_FA_BINDING.
     */
    public void setGoogleTwoFaBinding(Boolean googleTwoFaBinding) {
        this.googleTwoFaBinding = googleTwoFaBinding;
    }

    /**
     * Get googleTwoFaBinding GOOGLE_TWO_FA_BINDING.
     *
     * @return the string
     */
    public Boolean getGoogleTwoFaBinding() {
        return googleTwoFaBinding;
    }

    /**
     * Set emailValidationCode EMAIL_VALIDATION_CODE.
     */
    public void setEmailValidationCode(String emailValidationCode) {
        this.emailValidationCode = emailValidationCode;
    }

    /**
     * Get emailValidationCode EMAIL_VALIDATION_CODE.
     *
     * @return the string
     */
    public String getEmailValidationCode() {
        return emailValidationCode;
    }

}
