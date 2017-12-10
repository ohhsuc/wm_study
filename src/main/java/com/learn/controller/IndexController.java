package com.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.bean.Job;
import com.learn.bean.Msg;
import com.learn.service.JobService;

@Controller
public class IndexController {

	@Autowired
	JobService jobservice;
	
	//全部工作列表
	@RequestMapping("/AllJob")
	@ResponseBody
	public Msg AllJob() {
		List<Job> allJob = jobservice.getAllJob();
		return Msg.success().add("allJob", allJob);
	}
	
	@RequestMapping("/JobDetail/{id}")
	public String JobDetail(@PathVariable("id")Integer id,Model model) {
		Job job = jobservice.getJobById(id);
		model.addAttribute("jobdetail", job);
		return "jobDetail";
	}
	
	
	
	
	/*@RequestMapping("/index")
	public String index(Model model) {
		// 从shiro的session中取出activeUser
		Subject subject = SecurityUtils.getSubject();
		// 取出身份信息
		User user = (User) subject.getPrincipal();
		// 通过model传到页面
		model.addAttribute("uinfo", user);
		return "index";
	}
	
	@RequestMapping("/addUser")
	public String addUser() {
		System.out.println("有添加权限");
		return "addUser";
	}

	@RequestMapping("/updateUser")
	public String updateUser() {
		System.out.println("有修改权限");
		return "updateUser";
	}
	
	@RequestMapping("/queryUser")
	public String queryUser() {
		System.out.println("有查询权限");
		return "queryUser";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser() {
		System.out.println("有删除权限");
		return "deleteUser";
	}*/
}
