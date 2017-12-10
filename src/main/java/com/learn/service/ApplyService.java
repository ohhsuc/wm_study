package com.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bean.Apply;
import com.learn.bean.ApplyExample;
import com.learn.bean.ApplyExample.Criteria;
import com.learn.dao.ApplyMapper;

@Service
public class ApplyService {
	
	@Autowired
	ApplyMapper applymapper;
	
	public Integer subapp(Apply apply) {
		ApplyExample example = new ApplyExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserIdEqualTo(apply.getUserId());
		createCriteria.andJobIdEqualTo(apply.getJobId());
		List<Apply> selectByExample = applymapper.selectByExample(example);
		if(selectByExample.isEmpty()) {
			int insert = applymapper.insert(apply);
			return insert;
		}else {
			return null;
		}
		
	}
	
	public List<Apply> getMyapp(Integer uid){
		return applymapper.selectByUserId(uid);
	}
	
	public List<Apply> getComapp(Integer comId){
		return applymapper.selectByCom(comId);
	}
	
	public int delAppByid(Integer jobId) {
		ApplyExample example = new ApplyExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andJobIdEqualTo(jobId);
		return applymapper.deleteByExample(example);
	}
}
