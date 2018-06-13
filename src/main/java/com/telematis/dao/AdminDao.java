package com.telematis.dao;

import java.util.List;

import com.telematis.entity.Admin;
import com.telematis.entity.Distributor;
import com.telematis.entity.SaleArea;
import com.telematis.entity.VehiclesSale;

/**
 * 管理员dao层
 * @author 郎媛勤
 *
 */
public interface AdminDao{
	
	/**
	 * 登录
	 * 根据用户名查询Admin
	 * @param admin_phone 管理员号码
	 * @return 管理员的密码
	 */
	Admin findAdminByPhone(String admin_phone) throws Exception;
	
	/**
	 * 添加一名管理员
	 * @param admin 管理员实例
	 * @return 成功操作的记录的条数
	 */
	int insertAdmin(Admin admin ) throws Exception;
	
	/**
	 * 删除一名管理员
	 * @param admin_phone  管理员实例
	 * @return 成功操作的记录的条数
	 */
	int deleteAdminByPhone(String admin_phone) throws Exception;
	
	/**
	 * 查询所有的管理员
	 * @return 返回所有管理员的信息
	 */
	List<Admin> findAllAdmin() throws Exception;
	
	
	/**
	 * 添加一名分销商
	 * @param distributor 分销商实例
	 * @return 成功操作的记录的条数
	 */
	int insertDistributor(Distributor distributor) throws Exception;
	
	/**
	 * 删除一名分销商
	 * @param dist_phone 分销商的号码
	 * @return 成功操作的记录的条数
	 */
	int deleteDistributorByPhone(String dist_phone) throws Exception;
	
	/**
	 * 重置分销商的密码
	 * @param dist_phone 分销商的号码
	 * @return 成功操作的记录的条数
	 */
	
	int resetDistributorPassword(String dist_phone) throws Exception;
	
	/**
	 * 根据电话号查询Distributor
	 * @param dist_id
	 * @return 分销商实例
	 */
	Distributor findDistributorByPhone(String dist_phone) throws Exception;
	
	/**
	 * 查询所有的分销商
	 * @return
	 */
	List<Distributor> findAllDistributor() throws Exception;
	
	/**
	 * 查询所有已售出的商品
	 * @return  返回所有已售出的车辆的实例
	 */
	List<VehiclesSale> findAllVehiclesSale(SaleArea dist_area) ;
	
	
	/**
	 * 查询所有分销商的公司
	 * @return
	 */
	List<String> findAllCompany(String dist_area);
	
	
	/**
	 * 查询所有分销商所在的地区
	 * @return 
	 */
	List<String> findAllArea();
	
	/**
	 * 查询所有销售的车的类型
	 */
	List<String> findAllCartype(); 
}
