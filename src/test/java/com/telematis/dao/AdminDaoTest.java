package com.telematis.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.telematis.entity.SaleArea;
import com.telematis.entity.VehiclesSale;


@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml"}) 
public class AdminDaoTest {

	@Resource
	private AdminDao adminDao;
	@Test
	public void testFindAllVehiclesSale() {
		SaleArea	saleArea = new SaleArea();
		saleArea.setData("广东");
		List<VehiclesSale> 	allData = adminDao.findAllVehiclesSale(saleArea);
	}

}
