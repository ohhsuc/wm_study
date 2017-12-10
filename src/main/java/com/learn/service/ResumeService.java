package com.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bean.Resume;
import com.learn.bean.ResumeExample;
import com.learn.bean.ResumeExample.Criteria;
import com.learn.dao.ResumeMapper;

@Service
public class ResumeService {
	
	@Autowired
	ResumeMapper resumemapper;
	
	public  List<Resume> getUserResume(Integer id) {
		ResumeExample example = new ResumeExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserIdEqualTo(id);
		return resumemapper.selectByExample(example);
	}
	
	public Integer updateResume(Resume resume,Integer uid) {
		ResumeExample example = new ResumeExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserIdEqualTo(uid);
		return resumemapper.updateByExampleSelective(resume, example);
	}
}
