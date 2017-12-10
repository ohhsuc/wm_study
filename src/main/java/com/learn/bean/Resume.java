package com.learn.bean;

public class Resume {
    private Integer resId;

    private String resGender;

    private String resPhone;

    private Integer userId;

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getResGender() {
        return resGender;
    }

    public void setResGender(String resGender) {
        this.resGender = resGender == null ? null : resGender.trim();
    }

    public String getResPhone() {
        return resPhone;
    }

    public void setResPhone(String resPhone) {
        this.resPhone = resPhone == null ? null : resPhone.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	@Override
	public String toString() {
		return "Resume [resId=" + resId + ", resGender=" + resGender + ", resPhone=" + resPhone + ", userId=" + userId
				+ "]";
	}
    
}