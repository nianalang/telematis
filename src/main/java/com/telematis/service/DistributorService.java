package com.telematis.service;

import java.util.List;

import com.telematis.dto.DataDistributor;
import com.telematis.dto.OperateExecution;
import com.telematis.dto.ResultData;
import com.telematis.entity.SimplifyDistributor;
import com.telematis.entity.VehiclesSale;

/**
 * 分销商的业务逻辑接口
 * 
 * @author 郎媛勤
 *
 */
public interface DistributorService {

	/**
	 * 分销商的状态
	 * 
	 * @param dist_phone
	 *            分销商的号码
	 * @return 返回登录的状态
	 */
	OperateExecution findDistributorByPhone(SimplifyDistributor simplifyDistributor);
	
	/**
	 * 修改密码
	 * @param simplifyDistributor
	 * @return
	 */
	OperateExecution updatePassword(SimplifyDistributor simplifyDistributor);
	/**
	 * 记录销售车辆的数据
	 * 
	 * @param vehiclesSale
	 *            销售车的实例
	 * @return 返回添加的状态
	 */
	OperateExecution insertVehiclesSale(VehiclesSale vehiclesSale);

	/**
	 * 条形统计图
	 * 
	 * @param countTime
	 *            按每周|每月统计数据
	 * @return 总的销售数据+各个车的类型
	 * @throws Exception
	 */
	List<ResultData<DataDistributor>> allDataByVehiclesType(String countTime);

	/**
	 * 地区分布图
	 * 
	 * @param countTime
	 *            按每周|每月统计数据
	 * @param area
	 *            按地区统计
	 * @return 总的销售数据+各个车的类型
	 * @throws Exception
	 */
	List<ResultData<DataDistributor>> allDataByVehiclesArea(String countTime, String area);

}
