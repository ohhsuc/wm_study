package com.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bean.Job;
import com.learn.bean.JobExample;
import com.learn.bean.JobExample.Criteria;
import com.learn.dao.ApplyMapper;
import com.learn.dao.JobMapper;

@Service
public class JobService {
	
	@Autowired
	JobMapper jobmapper;
	@Autowired
	ApplyService applyservice;
	
	public List<Job> getAllJob(){
		return jobmapper.selectByExample(null);
	}
	
	public Job getJobById(Integer id){
		return jobmapper.selectByPrimaryKey(id);
	}
	
	public List<Job> getComJob(Integer comId){
		JobExample example = new JobExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserIdEqualTo(comId);
		return jobmapper.selectByExample(example);
	}
	
	public int updateComJob(Job job) {
		return jobmapper.updateByPrimaryKeySelective(job);
	}
	
	public int addComJob(Job job) {
		return jobmapper.insert(job);
	}
	
	public int delComJob(Integer id) {
		int delAppByid = applyservice.delAppByid(id);
		return jobmapper.deleteByPrimaryKey(id)+delAppByid;
	}
	
}
