package com.telematis.dao;

import static org.junit.Assert.*;

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
public class DistributorDaoTest {
	@Resource
	private DistributorDao distributorDao;
	@Test
	public void testFindAllVehiclesSale() {
		SaleArea saleArea = new SaleArea();
		saleArea.setData("大连汽车制造公司1");
		// 通过公司查询所有的数据
		List<VehiclesSale> allData = distributorDao.findAllVehiclesSale(saleArea);
		System.out.println(allData);
	}

}
