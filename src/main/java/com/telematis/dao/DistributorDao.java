package com.telematis.dao;

import java.util.List;

import com.telematis.entity.Distributor;
import com.telematis.entity.SaleArea;
import com.telematis.entity.SimplifyDistributor;
import com.telematis.entity.VehiclesSale;

public interface DistributorDao {

	/**
	 * 登录
	 * 根据用户名查询分销商
	 * @param dist_phone 分销商的号码
	 */
	Distributor  findDistributorByPhone(String dist_phone) throws Exception;;
	
	/**
	 * 根据电话号码修改密码
	 * @param dist_phone
	 * @return
	 */
	int updatePassword(SimplifyDistributor simplifyDistributor);
	
	// TODO  回答车主的问题
	
	
	/**
	 * 记录销售车辆的数据
	 * @param vehiclesSale 销售车的数据
	 * @return
	 */
	int insertVehiclesSale(VehiclesSale vehiclesSale) throws Exception;
	
	/**
	 * 查询所有已售出的商品
	 * @return  返回所有已售出的车辆的实例
	 */
	List<VehiclesSale> findAllVehiclesSale(SaleArea data) ;
	
	/**
	 * 查询所有车辆的类型
	 * @return 返回所有的类型
	 */
	List<String> findAllVehiclesSaleType();
	
	
	List<String> findAllArea();
}
