package com.zjut.JConsoleGroup;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zjut.pojo.User;
import com.zjut.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MybatisTest {

	private static Logger log =Logger.getLogger(MybatisTest.class);
	@Resource
	private IUserService userService;
	@Before
	public void before(){
		
	}
	public void test(){
		User user = userService.getUserById(1);
		System.out.println(user.getId()+":"+user.getUser_name()+":"+user.getPassword()+":"+user.getAge());
	}
}
