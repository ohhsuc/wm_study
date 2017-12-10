package com.learn.controller;

import java.util.Date;
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
import com.learn.bean.Msg;
import com.learn.bean.Resume;
import com.learn.bean.User;
import com.learn.service.ApplyService;
import com.learn.service.ResumeService;

@Controller
public class CanController {

	@Autowired
	ResumeService resumeservice;
	@Autowired
	ApplyService applyservice;
	

	
	//can主页
	@RequestMapping("/can/index")
	public String canindex() {
		return "/can/index";
	}
	//查看简历
	@RequestMapping("/exec/resmore")
	public String resmore(Model model) {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		//查询当前用户简历内容
		List<Resume> userResume = resumeservice.getUserResume(user.getUid());
		for(Resume resume : userResume) {
			model.addAttribute("Resume", resume);
		}
		return "/exec/resmore";
	}
	
	//修改简历 没有做数据验证
	@RequestMapping("/exec/resupdate")
	@ResponseBody
	public Msg resupdate(Resume resume) {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		Msg msg = new Msg();
		Integer upres = resumeservice.updateResume(resume,user.getUid());
		msg.setMsg("修改成功，影响"+upres+"条");
		return msg;
	}
	
	//提交简历
	@RequestMapping("/exec/subapp/{jobId}")
	@ResponseBody
	public Msg subapp(@PathVariable("jobId")Integer jobId) {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		Apply apply = new Apply();
		Date date = new Date();
		apply.setUserId(user.getUid());
		apply.setJobId(jobId);
		apply.setAppDate(date);
		Integer subapp = applyservice.subapp(apply);
		Msg msg = new Msg();
		if(subapp != null) {
			msg.setMsg("申请成功");
			return msg.add("insertId", subapp);
			}
		else {
			msg.setMsg("请不要重复申请");
			return msg;
			}
	}
	//当前用户申请列表
	@RequestMapping("/exec/apprec")
	public String apprec(Model model) {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		List<Apply> myapp = applyservice.getMyapp(user.getUid());
		model.addAttribute("myapp", myapp);
		return "/exec/apprec";
	}
}
