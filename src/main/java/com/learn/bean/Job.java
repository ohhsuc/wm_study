package com.learn.bean;

public class Job {
    private Integer jobId;

    private String jobName;

    private String jobBewrite;

    private Integer userId;
    
    private User user;
    

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobBewrite() {
        return jobBewrite;
    }

    public void setJobBewrite(String jobBewrite) {
        this.jobBewrite = jobBewrite == null ? null : jobBewrite.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobName=" + jobName + ", jobBewrite=" + jobBewrite + ", userId=" + userId
				+ ", user=" + user + "]";
	}

    
    
}