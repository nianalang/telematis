package com.telematis.service;

import java.util.List;

import com.telematis.dto.AreaDataAdmin;
import com.telematis.dto.DataAdmin;
import com.telematis.dto.Datagrid;
import com.telematis.dto.OperateExecution;
import com.telematis.dto.ResultData;
import com.telematis.entity.Admin;
import com.telematis.entity.Distributor;
import com.telematis.entity.SimplifyAdmin;

/**
 * 1、业务接口：站在"使用者"的角度去设计接口 1)方法定义粒度-->明确 2)参数-->越简单越好 3)返回类型-->return的类型要友好
 * 2、exception包：存放service的一些异常 3、dto包：数据传输层，关注web和service之间的数据传递
 * 
 * @author 郎媛勤
 *
 */

public interface AdminService {

	/**
	 * 管理员登录
	 * 
	 * @param admin_phone
	 *            管理员号码
	 * @return 返回登录的状态
	 */
	OperateExecution findAdminByPhone(SimplifyAdmin simplifyAdmin);

	/**
	 * 添加一名管理员
	 * 
	 * @param admin管理员实例
	 * @return 返回添加的状态
	 */
	OperateExecution insertAdmin(Admin admin);

	/**
	 * 根据电话号码删除管理员
	 * 
	 * @param admin_phone
	 *            管理员电话
	 * @return 返回删除的状态
	 */
	OperateExecution deleteAdminByPhone(String admin_phone);

	/**
	 * 查询所有的管理员
	 * 
	 * pageNum 第几页 pageSize 每页记录数
	 * 
	 * @return 所有管理员的实例
	 * @throws Exception
	 */
	Datagrid findAllAdmin(int pageNum, int pageSize) throws Exception;

	/**
	 * 添加一名分销商
	 * 
	 * @param distributor
	 *            分销商实例
	 * @return 返回插入的状态
	 */
	OperateExecution insertDistributor(Distributor distributor);

	/**
	 * 删除一名分销商
	 * 
	 * @param dist_phone
	 *            分销商的号码
	 * @return 返回删除的状态
	 */
	OperateExecution deleteDistributorByPhone(String dist_phone);

	/**
	 * 重置分销商的密码
	 * 
	 * @param dist_phone
	 *            分销商的号码
	 * @return 返回重置的状态
	 */
	OperateExecution resetDistributorPassword(String dist_phone);

	/**
	 * 根据电话号查询Distributor
	 * 
	 * @param dist_id
	 * @return 分销商实例
	 */
	Distributor findDistributorByPhone(String dist_phone) throws Exception;

	/**
	 * 查询所有的分销商 pageNum 第几页 pageSize 每页记录数
	 * 
	 * @return
	 */
	Datagrid findAllDistributor(int pageNum, int pageSize) throws Exception;

	/**
	 * 统计各种数据(条形统计图)
	 * 
	 * @param countTime
	 *            按一定的时间统计（每月/每周）默认每月
	 * @param vehiclesType
	 *            车的类型
	 * @return 各个分销商+每月/每周销售的数量的集合
	 */
	List<ResultData<DataAdmin>> allDataByCondition(String countTime, String vehiclesType);

	/**
	 * 按地区统计数据
	 * 
	 * @param area
	 *            地区
	 * @param countTime
	 *            按一定的时间统计（每月/每周）默认每月
	 * @param vehiclesType车的类型
	 * @return 各个分销商+每月/每周销售的数量的集合
	 */
	List<ResultData<AreaDataAdmin>> allDataByArea(String countTime);

	/**
	 * 统计车的类型占领的市场
	 * 
	 * @param countTime
	 * @return
	 */
	List<ResultData<Integer>> allDataSector(String countTime);
}
