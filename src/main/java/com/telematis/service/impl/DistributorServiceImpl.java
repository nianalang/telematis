package com.telematis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.telematis.dao.DistributorDao;
import com.telematis.dto.DataDistributor;
import com.telematis.dto.OperateExecution;
import com.telematis.dto.ResultData;
import com.telematis.entity.Distributor;
import com.telematis.entity.SaleArea;
import com.telematis.entity.SimplifyDistributor;
import com.telematis.entity.VehiclesSale;
import com.telematis.enums.OperateStateEnum;
import com.telematis.service.DistributorService;
import com.telematis.utils.CommonConstant;
import com.telematis.utils.TimeProcessUtil;

/**
 * 分销商的业务逻辑
 */
@Service
public class DistributorServiceImpl implements DistributorService {

	@Autowired
	private DistributorDao distributorDao;

	public static HttpSession getSession() {
		HttpSession session = null;
		try {
			session = getRequest().getSession();
		} catch (Exception e) {
		}
		return session;
	}

	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest();
	}

	/**
	 * 登录 分销商的状态
	 * 
	 * @param dist_phone
	 *            分销商的号码
	 * @return 返回登录的状态
	 */
	public OperateExecution findDistributorByPhone(SimplifyDistributor simplifyDistributor) {
		try {
			// 调用Dao层的函数
			Distributor distributor = distributorDao.findDistributorByPhone(simplifyDistributor.getDist_phone());
			// 判断distributor是否为空，为空说明该电话号码为被注册
			if (distributor != null) {
				// 判断密码是否正确
				if (distributor.getDist_password().equals(simplifyDistributor.getDist_password())) {
					// 将值存入session中
					HttpSession session = getSession();
					session.setAttribute("dist_phone", distributor.getDist_phone());
					session.setAttribute("dist_company", distributor.getDist_company());
					// 登录成功
					return new OperateExecution(OperateStateEnum.SUCCESS);
				} else {// 密码错误或不存在
					return new OperateExecution(OperateStateEnum.PASSWORDERROR);
				}
			} else {// 该电话号码为被注册
				return new OperateExecution(OperateStateEnum.PHONEERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 系统内部错误
			return new OperateExecution(OperateStateEnum.INNER_ERROR);
		}
	}

	/**
	 * 修改密码
	 */
	public OperateExecution updatePassword(SimplifyDistributor simplifyDistributor) {
		// 判断输入密码和确认密码是否相同
		if (simplifyDistributor.getDist_password().equals(simplifyDistributor.getConfirm_password())) {// 相等
			// 调用数据库，返回影响的行数
			int line = distributorDao.updatePassword(simplifyDistributor);
			// 判断影响的行数是否大于零
			if (line > 0) {
				// 修改成功
				return new OperateExecution(OperateStateEnum.UPDATESUCCESS);
			} else {
				// 修改失败
				return new OperateExecution(OperateStateEnum.UPDATEFAIL);
			}
		} else {// 提示两次输入密码不一致
			return new OperateExecution(OperateStateEnum.DIFFERPASSWORD);
		}
	}

	/**
	 * 记录销售车辆的数据
	 * 
	 * @param vehiclesSale
	 *            销售车的实例
	 * @return 返回添加的状态
	 */
	public OperateExecution insertVehiclesSale(VehiclesSale vehiclesSale) {
		try {
			// 调用数据库，返回影响的行数
			int line = distributorDao.insertVehiclesSale(vehiclesSale);
			// 判断影响的行数是否大于零
			if (line > 0) {
				// 添加成功
				return new OperateExecution(OperateStateEnum.INSERTSUCCESS);
			} else {
				// 添加失败
				return new OperateExecution(OperateStateEnum.INSERTFAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 系统错误
			return new OperateExecution(OperateStateEnum.INNER_ERROR);
		}
	}

	/**
	 * 条形统计图
	 * 
	 * @param countTime
	 *            按每周|每月统计数据
	 * @return 总的销售数据+各个车的类型
	 * @throws Exception
	 */
	public List<ResultData<DataDistributor>> allDataByVehiclesType(String countTime) {
		List<ResultData<DataDistributor>> result = new ArrayList<ResultData<DataDistributor>>();
		// 取出session里分销商所处的公司
		String dist_company = (String) getSession().getAttribute("dist_company");
		SaleArea saleArea = new SaleArea();
		saleArea.setData(dist_company);
		// 通过公司查询所有的数据
		List<VehiclesSale> allData = distributorDao.findAllVehiclesSale(saleArea);
		// 查询所有销售车辆的类型
		List<String> allType = distributorDao.findAllVehiclesSaleType();
		// 按月统计
		if (countTime == null || CommonConstant.MONTH.equals(countTime)) {
			getDataByType(allType, allData, result, CommonConstant.MONTHDAY);
		} else {// 按周统计
			getDataByType(allType, allData, result, CommonConstant.WEEKDAY);
		}
		return result;
	}

	private void getDataByType(List<String> allType, List<VehiclesSale> allData,
			List<ResultData<DataDistributor>> result, int ago) {
		// 筛选出按时间的数据
		List<VehiclesSale> data = choiceDataByDate(allData, ago);
		for (int i = 0; i < allType.size(); i++) {
			String type = allType.get(i);
			ResultData<DataDistributor> resultData = new ResultData<DataDistributor>();
			DataDistributor dataDistributor = new DataDistributor();
			for (int j = 0; j < data.size(); j++) {
				VehiclesSale vehiclesSale = data.get(j);
				if (type.equals(vehiclesSale.getVehicles_sale_type())) {
					if (j == 0) {
						dataDistributor.setAll_vehicles_sale_number(vehiclesSale.getVehicles_sale_number());
					} else {
						dataDistributor.setAll_vehicles_sale_number(
								vehiclesSale.getVehicles_sale_number() + dataDistributor.getAll_vehicles_sale_number());
					}
				}
			}
			resultData.setResult(type);
			resultData.setData(dataDistributor);
			result.add(resultData);
		}

	}

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
	public List<ResultData<DataDistributor>> allDataByVehiclesArea(String countTime, String area) {
		List<ResultData<DataDistributor>> result = new ArrayList<ResultData<DataDistributor>>();
		// 取出session里分销商所处的公司
		String dist_company = (String) getSession().getAttribute("dist_company");
		SaleArea saleArea = new SaleArea();
		saleArea.setData(dist_company);
		// 通过公司查询所有的数据
		List<VehiclesSale> allData = distributorDao.findAllVehiclesSale(saleArea);
		// 初始化数据
		if (area == null) {
			if (countTime == null || CommonConstant.MONTH.equals(countTime)) {// 默认按月统计
				getData(allData, result, "北京现代", CommonConstant.MONTHDAY);
			} else {// area默认|countTime不默认
				getData(allData, result, "北京现代", CommonConstant.WEEKDAY);
			}
		} else {// 按用户需求进行统计
			if (countTime == null || CommonConstant.MONTH.equals(countTime)) {// area不默认|countTime默认
				getData(allData, result, area, CommonConstant.MONTHDAY);
			} else {// area不默认|countTime不默认
				getData(allData, result, area, CommonConstant.WEEKDAY);
			}
		}
		return result;
	}

	// 数据封装
	private void getData(List<VehiclesSale> allData, List<ResultData<DataDistributor>> result, String area, int ago) {
		// 1、先根据销售的车的类型进行筛选
		List<VehiclesSale> allDataByType = new ArrayList<VehiclesSale>();
		// 遍历allData集合
		for (int i = 0; i < allData.size(); i++) {
			VehiclesSale vehiclesSale = allData.get(i);
			if (area.equals(vehiclesSale.getVehicles_sale_type())) {
				allDataByType.add(vehiclesSale);
			}
		}

		// 2.在根据时间进行筛选
		List<VehiclesSale> data = choiceDataByDate(allDataByType, ago);
		// 3、进行数据统计
		// 查询分销商所在的区域
		List<String> allArea = distributorDao.findAllArea();
		// 遍历所有的区域
		for (int i = 0; i < allArea.size(); i++) {

			String distArea = allArea.get(i);
			ResultData<DataDistributor> resultData = new ResultData<DataDistributor>();
			DataDistributor dataDistributor = new DataDistributor();
			// 遍历数据
			for (int j = 0; j < data.size(); j++) {
				VehiclesSale vehiclesSale = data.get(j);
				// 判断销售的地区是否正确
				if (distArea.equals(vehiclesSale.getVehicles_sale_area())) {
					if (j == 0) {
						dataDistributor.setAll_vehicles_sale_number(vehiclesSale.getVehicles_sale_number());
					} else {
						dataDistributor.setAll_vehicles_sale_number(
								vehiclesSale.getVehicles_sale_number() + dataDistributor.getAll_vehicles_sale_number());
					}

				}
			}

			resultData.setResult(distArea);
			resultData.setData(dataDistributor);
			result.add(resultData);
		}

	}

	// 对日期经行筛选
	private List<VehiclesSale> choiceDataByDate(List<VehiclesSale> allData, int monthDay) {
		List<VehiclesSale> data = new ArrayList<VehiclesSale>();
		// 遍历数组
		for (int i = 0; i < allData.size(); i++) {

			VehiclesSale vehiclesSale = allData.get(i);
			// 获得销售日期
			String saleDate = vehiclesSale.getVehicles_sale_time();
			// 筛选出符合日期的数据
			if (TimeProcessUtil.belongCalendar(TimeProcessUtil.stringToDate(saleDate),
					TimeProcessUtil.beforeObjectTimes(monthDay), TimeProcessUtil.getNowTimes())) {
				data.add(vehiclesSale);
			}
		}
		return data;
	}
}
