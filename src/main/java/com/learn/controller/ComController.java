package com.learn.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.bean.Apply;
import com.learn.bean.Job;
import com.learn.bean.Msg;
import com.learn.bean.Resume;
import com.learn.bean.User;
import com.learn.service.ApplyService;
import com.learn.service.JobService;
import com.learn.service.ResumeService;
import com.learn.service.UserService;

@Controller
public class ComController {
	
	@Autowired
	JobService jobservice;
	
	@Autowired
	ApplyService applyservice;
	
	@Autowired
	ResumeService resumeservice;
	
	@Autowired
	UserService userservice;
	
	//com主页
	@RequestMapping("/com/index")
	public String canindex() {
		return "/com/index";
	}
	
	//本公司已发布所有职位
	@RequestMapping("/exec/comJob")
	@ResponseBody
	public Msg comJobList() {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		List<Job> comJob = jobservice.getComJob(user.getUid());
		return Msg.success().add("comJob", comJob);
	}
	
	//修改职位
	@RequestMapping("/exec/comJobUpdate")
	@ResponseBody
	public Msg comJobUpdate(Job job) {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		Msg msg = new Msg();
		//首先根据传来的id去数据库查找
		Job jobtb = jobservice.getJobById(job.getJobId());
		//判断要修改的Job是否属于当前登录的User
		if(jobtb == null){
			msg.setMsg("修改条目不存在");
		}else if(jobtb.getUserId().equals(user.getUid())){
			int colum = jobservice.updateComJob(job);
			msg.setMsg("修改成功,影响"+colum+"条");
		}else {
			msg.setMsg("不可修改其它公司职位");
		}
		return msg;
	}
	
	@RequestMapping("/exec/addJobPage")
	public String addJobPage() {
		return "/exec/addJobPage";
	}
	
	@RequestMapping("/exec/addJob")
	@ResponseBody
	public Msg addJob(Job job) {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		job.setUserId(user.getUid());
		int addComJob = jobservice.addComJob(job);
		return Msg.success().add("addComJob", addComJob);
	}
	
	@RequestMapping("/exec/delJob")
	@ResponseBody
	public Msg delJob(Integer id) {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		Msg msg = new Msg();
		Job jobtb = jobservice.getJobById(id);
		if(jobtb == null){
			msg.setMsg("删除条目不存在");
		}else if(jobtb.getUserId().equals(user.getUid())){
			int colum = jobservice.delComJob(id);
			msg.setMsg("删除成功,影响"+colum+"条");
		}else {
			msg.setMsg("不可删除其它公司职位");
		}
		return msg;
	}
	//查看申请自己职位的所有人
	@RequestMapping("/exec/applist")
	public String appList(Model model) {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		List<Apply> comapp = applyservice.getComapp(user.getUid());
		model.addAttribute("comapp", comapp);
		return "/exec/applist";
	}
	
	//查看申请人简历
	@RequestMapping("/exec/watres/{uid}")
	public String watRes(@PathVariable("uid")Integer uid,Model model) {
		List<Resume> userResume = resumeservice.getUserResume(uid);
		for(Resume resume : userResume) {
			model.addAttribute("Resume", resume);
		}
		User user = userservice.getUserById(uid);
		model.addAttribute("User", user);
		return "/exec/watres";
	}
}
