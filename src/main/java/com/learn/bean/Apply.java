package com.learn.bean;

import java.util.Date;

public class Apply {
    private Integer appId;

    private Integer userId;

    private Integer jobId;

    private Date appDate;
    
    private Job job;

    private User user;
    
    

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

	@Override
	public String toString() {
		return "Apply [appId=" + appId + ", userId=" + userId + ", jobId=" + jobId + ", appDate=" + appDate + ", job="
				+ job + ", user=" + user + "]";
	}

	
    
    
}