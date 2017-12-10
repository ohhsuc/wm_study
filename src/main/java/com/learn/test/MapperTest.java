package com.learn.test;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learn.bean.Apply;
import com.learn.bean.Job;
import com.learn.bean.Resume;
import com.learn.dao.ApplyMapper;
import com.learn.dao.JobMapper;
import com.learn.dao.UserMapper;
import com.learn.service.ApplyService;
import com.learn.service.JobService;
import com.learn.service.LoginService;
import com.learn.service.ResumeService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext-mybatis.xml"})
public class MapperTest {
	@Autowired
	ApplyMapper mapply;
	
	@Test
	public void testCRUD() {
		
		
		List<Apply> comapp = mapply.selectByCom(1);
		//List<Apply> comapp = test.getComapp(1);
//		Job selectByPrimaryKey = test.selectByPrimaryKey(1);
//		Date date = new Date();
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		System.out.println(format.format(date));
//		List<String> rolelist = usermapper.selectPermissionByUser("刘容雨");
////		
		for(Apply attribute : comapp) {
			  System.out.println(attribute);
			}
	}
}
