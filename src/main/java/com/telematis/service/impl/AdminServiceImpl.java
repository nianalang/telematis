package com.telematis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.telematis.dao.AdminDao;
import com.telematis.dto.AreaDataAdmin;
import com.telematis.dto.DataAdmin;
import com.telematis.dto.Datagrid;
import com.telematis.dto.OperateExecution;
import com.telematis.dto.ResultData;
import com.telematis.entity.Admin;
import com.telematis.entity.Distributor;
import com.telematis.entity.SaleArea;
import com.telematis.entity.SimplifyAdmin;
import com.telematis.entity.VehiclesSale;
import com.telematis.enums.OperateStateEnum;
import com.telematis.service.AdminService;
import com.telematis.utils.CommonConstant;
import com.telematis.utils.TimeProcessUtil;

/**
 * 管理员的业务逻辑层
 * 
 * @author 郎媛勤
 *
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao admindao;

	/**
	 * 登录的业务逻辑
	 */
	public OperateExecution findAdminByPhone(SimplifyAdmin simplifyAdmin) {
		// 不为空，调用dao层的数据
		Admin admin;
		try {
			admin = admindao.findAdminByPhone(simplifyAdmin.getAdmin_phone());
			// 判断admin是否为空
			if (admin != null) {
				if (admin.getAdmin_password().equals(simplifyAdmin.getAdmin_password())) {
					// 说明用户名和密码正确
					return new OperateExecution(OperateStateEnum.SUCCESS);
				} else {
					// 说明密码错误或不存在
					return new OperateExecution(OperateStateEnum.PASSWORDERROR);
				}
			} else {// 如果admin为空,说明用户名错误或不存在
				return new OperateExecution(OperateStateEnum.PHONEERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 服务器内部错误
			return new OperateExecution(OperateStateEnum.INNER_ERROR);
		}
	}

	/**
	 * 添加一名管理员
	 * 
	 * @param admin管理员实例
	 * @return 返回登录的状态
	 */
	public OperateExecution insertAdmin(Admin admin) {
		try {
			// 调用数据库，返回影响的行数
			int line = admindao.insertAdmin(admin);
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
	 * 根据电话号码删除管理员
	 * 
	 * @param admin_phone
	 *            管理员电话
	 * @return 返回删除的状态
	 */
	public OperateExecution deleteAdminByPhone(String admin_phone) {
		// 判断admin_phone是否为空
		if (admin_phone != null) {
			try {
				// 调用数据库，返回影响的行数
				int line = admindao.deleteAdminByPhone(admin_phone);
				// 判断影响的行数是否大于零
				if (line > 0) {
					// 删除成功
					return new OperateExecution(OperateStateEnum.DELETESUCCESS);
				} else {
					// 删除失败
					return new OperateExecution(OperateStateEnum.DELETEFAIL);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// 系统错误
				return new OperateExecution(OperateStateEnum.INNER_ERROR);
			}
		} else {// 提示请输入要删除的号码
			return new OperateExecution(OperateStateEnum.INPUTDELETEPHONE);
		}
	}

	/**
	 * 查询所有的管理员(分页) pageNum 第几页 pageSize 每页记录数
	 * 
	 * @return 所有管理员的实例
	 * @throws Exception
	 */
	public Datagrid findAllAdmin(int pageNum, int pageSize) throws Exception {

		PageHelper.startPage(pageNum, pageSize);
		// PageHelper.orderBy("occur_time desc");
		// 查询所有数据
		List<Admin> list = admindao.findAllAdmin();
		// 使用pageInfo分页
		PageInfo<Admin> pageInfo = new PageInfo<Admin>(list);
		// 将分好的数据存入datagrid对象中
		Datagrid datagrid = new Datagrid(pageInfo.getTotal(), pageInfo.getList());
		return datagrid;
	}

	/**
	 * 添加一名分销商
	 * 
	 * @param distributor
	 *            分销商实例
	 * @return 返回插入的状态
	 */
	public OperateExecution insertDistributor(Distributor distributor) {
		try {
			// 调用数据库，返回影响的行数
			int line = admindao.insertDistributor(distributor);
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
	 * 删除一名分销商
	 * 
	 * @param dist_phone
	 *            分销商的号码
	 * @return 返回删除的状态
	 */
	public OperateExecution deleteDistributorByPhone(String dist_phone) {
		if (dist_phone != null) {// 判断输入的号码是否为空
			try {
				// 调用数据库，返回影响的行数
				int line = admindao.deleteDistributorByPhone(dist_phone);
				// 判断影响的行数是否大于零
				if (line > 0) {
					// 删除成功
					return new OperateExecution(OperateStateEnum.DELETESUCCESS);
				} else {
					// 删除失败
					return new OperateExecution(OperateStateEnum.DELETEFAIL);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// 系统错误
				return new OperateExecution(OperateStateEnum.INNER_ERROR);
			}
		} else {// 提示请输入要删除的号码
			return new OperateExecution(OperateStateEnum.INPUTDELETEPHONE);
		}
	}

	/**
	 * 重置分销商的密码
	 * 
	 * @param dist_phone
	 *            分销商的号码
	 * @return 返回重置的状态
	 */
	public OperateExecution resetDistributorPassword(String dist_phone) {
		if (dist_phone != null) {// 判断输入的号码是否为空
			try {
				// 调用数据库，返回影响的行数
				int line = admindao.resetDistributorPassword(dist_phone);
				// 判断影响的行数是否大于零
				if (line > 0) {
					// 重置成功
					return new OperateExecution(OperateStateEnum.RESETSUCCESS);
				} else {
					// 重置失败
					return new OperateExecution(OperateStateEnum.RESETFAIL);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// 系统错误
				return new OperateExecution(OperateStateEnum.INNER_ERROR);
			}
		} else {// 提示请输入要删除的号码
			return new OperateExecution(OperateStateEnum.INPUTDELETEPHONE);
		}
	}

	/**
	 * 根据电话号查询Distributor
	 * 
	 * @param dist_id
	 * @return 分销商实例
	 * @throws Exception
	 */
	public Distributor findDistributorByPhone(String dist_phone) throws Exception {
		return admindao.findDistributorByPhone(dist_phone);
	}

	/**
	 * 查询所有的分销商
	 * 
	 * @return
	 * @throws Exception
	 */
	public Datagrid findAllDistributor(int pageNum, int pageSize) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		// PageHelper.orderBy("occur_time desc");
		// 查询所有数据
		List<Distributor> list = admindao.findAllDistributor();
		// 使用pageInfo分页
		PageInfo<Distributor> pageInfo = new PageInfo<Distributor>(list);
		// 将分好的数据存入datagrid对象中
		Datagrid datagrid = new Datagrid(pageInfo.getTotal(), pageInfo.getList());
		return datagrid;
	}

	/****************************************************************
	 * 重头戏
	 ****************************************************************/

	/**
	 * 统计各种数据(条形统计图|折线图)
	 * 
	 * @param countTime
	 *            按一定的时间统计（每月/每周）默认每月
	 * @param area
	 *            车的地区
	 * @return 各个分销商+每月/每周销售的数量的集合
	 * @throws Exception
	 */
	public List<ResultData<DataAdmin>> allDataByCondition(String countTime, String area) {
		// 取出所有的数据
		List<VehiclesSale> allData = null;
		List<ResultData<DataAdmin>> dataAdmins = new ArrayList<ResultData<DataAdmin>>();
		SaleArea saleArea = null;
		// 初始化数据
		if (area == null) {
			saleArea = new SaleArea();
			saleArea.setData("大连");
			// 默认统计大连
			allData = admindao.findAllVehiclesSale(saleArea);
			if (countTime == null || CommonConstant.MONTH.equals(countTime)) {// 默认按月统计
				getData("大连", allData, dataAdmins, CommonConstant.MONTHDAY);
			} else {// area默认|countTime不默认
				getData("大连", allData, dataAdmins, CommonConstant.WEEKDAY);
			}
		} else {// 按用户需求进行统计
			saleArea = new SaleArea();
			saleArea.setData(area);
			allData = admindao.findAllVehiclesSale(saleArea);
			if (countTime == null || CommonConstant.MONTH.equals(countTime)) {// area不默认|countTime默认
				getData(area, allData, dataAdmins, CommonConstant.MONTHDAY);
			} else {// area不默认|countTime不默认
				getData(area, allData, dataAdmins, CommonConstant.WEEKDAY);
			}
		}
		return dataAdmins;
	}

	// 最终的数据封装
	private void getData(String vehicles_sale_area, List<VehiclesSale> allData, List<ResultData<DataAdmin>> dataAdmins,
			int time) {
		// area默认|countTime默认
		List<VehiclesSale> data = choiceDataByDate(allData, time);
		// 获取所有的公司
		List<String> companies = admindao.findAllCompany(vehicles_sale_area);
		List<VehiclesSale> dataCar = null;
		DataAdmin dataAdmin = null;
		for (int j = 0; j < companies.size(); j++) {
			dataCar = new ArrayList<VehiclesSale>();
			// 创建一个dataAdmin对象
			dataAdmin = new DataAdmin();
			// 遍历集合
			for (int i = 0; i < data.size(); i++) {
				// 新建对象
				VehiclesSale vehiclesSale = data.get(i);
				// 统计大连汽车制造公司的销售数据
				if (companies.get(j).equals(vehiclesSale.getDist_company())) {
					dataCar.add(vehiclesSale);
				}
			}
			getFilter(dataAdmin, dataCar, dataAdmins, companies.get(j));
		}
	}

	/**
	 * 分销商数据过滤
	 * 
	 * @param dataAdmin
	 * @param dataCar
	 * @param dataAdmins
	 * @return
	 */
	private List<ResultData<DataAdmin>> getFilter(DataAdmin dataAdmin, List<VehiclesSale> dataCar,
			List<ResultData<DataAdmin>> dataAdmins, String company) {
		ResultData<DataAdmin> resultData = new ResultData<DataAdmin>();
		for (int i = 0; i < dataCar.size(); i++) {
			VehiclesSale vehiclesSale = dataCar.get(i);
			GetDataAdmin(vehiclesSale, dataAdmin);
		}
		resultData.setData(dataAdmin);
		// 加入公司
		resultData.setResult(company);
		dataAdmins.add(resultData);
		return dataAdmins;
	}

	// 对东风日产等数据进行筛选
	private DataAdmin GetDataAdmin(VehiclesSale vehiclesSale, DataAdmin dataAdmin) {
		// 统计北京现代的数据
		if (CommonConstant.beijingHyundai.equals(vehiclesSale.getVehicles_sale_type())) {
			dataAdmin.setBeijingHyundai(dataAdmin.getBeijingHyundai() + vehiclesSale.getVehicles_sale_number());
		}
		// 统计东风日产的销售数据
		if (CommonConstant.dongfengNissan.equals(vehiclesSale.getVehicles_sale_type())) {
			dataAdmin.setDongfengNissan(dataAdmin.getDongfengNissan() + vehiclesSale.getVehicles_sale_number());
		}
		// 一汽大众的销售数据
		if (CommonConstant.fAWVolkswagen.equals(vehiclesSale.getVehicles_sale_type())) {
			dataAdmin.setfAWVolkswagen(dataAdmin.getfAWVolkswagen() + vehiclesSale.getVehicles_sale_number());
		}
		return dataAdmin;
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

	/**
	 * 按区域进行统计(柱状图|折线图)
	 */
	public List<ResultData<AreaDataAdmin>> allDataByArea(String countTime) {
		// 查询要统计的地区
		List<String> allArea = admindao.findAllArea();
		// 返回的数据
		List<ResultData<AreaDataAdmin>> data = new ArrayList<ResultData<AreaDataAdmin>>();
		// countTime==null,则按月进行统计
		if (countTime == null || CommonConstant.MONTH.equals(countTime)) {
			getData(data, allArea, CommonConstant.MONTHDAY);
		} else {// 按周进行统计
			getData(data, allArea, CommonConstant.WEEKDAY);
		}
		return data;
	}

	// 数据统计
	private void getData(List<ResultData<AreaDataAdmin>> data, List<String> allArea, int ago) {
		List<VehiclesSale> dataArea = null;
		// 遍历要统计的地区
		for (int i = 0; i < allArea.size(); i++) {
			// 返回的数据
			ResultData<AreaDataAdmin> resultData = new ResultData<AreaDataAdmin>();
			SaleArea saleArea = new SaleArea();
			saleArea.setData(allArea.get(i));
			// 按地区查询所有的数据|时间过滤
			dataArea = choiceDataByDate(admindao.findAllVehiclesSale(saleArea), ago);
			// 按照车的类型进行筛选
			AreaDataAdmin admin = new AreaDataAdmin();
			// 假设筛选所有东风日产的数据
			for (int z = 0; z < dataArea.size(); z++) {
				VehiclesSale vehiclesSale = dataArea.get(z);
				// 东风日产
				if (vehiclesSale.getVehicles_sale_type().equals(CommonConstant.dongfengNissan)) {
					admin.setDongFengNumber(admin.getDongFengNumber() + vehiclesSale.getVehicles_sale_number());
				}
				// 北京现代
				if (vehiclesSale.getVehicles_sale_type().equals(CommonConstant.beijingHyundai)) {
					admin.setBeiJingNumber(admin.getBeiJingNumber() + vehiclesSale.getVehicles_sale_number());
				}
				// 一汽大众
				if (vehiclesSale.getVehicles_sale_type().equals(CommonConstant.fAWVolkswagen)) {
					admin.setYiQiNumber(admin.getYiQiNumber() + vehiclesSale.getVehicles_sale_number());
				}
			}
			resultData.setData(admin);
			resultData.setResult(allArea.get(i));
			// 将数据进行统计
			data.add(resultData);
		}
	}

	/**
	 * 统计车的类型占领的市场
	 * 
	 * @param countTime
	 * @return
	 */
	public List<ResultData<Integer>> allDataSector(String countTime) {
		// 封装所有的数据
		List<ResultData<Integer>> list = new ArrayList<ResultData<Integer>>();
		// 查询所有的车的类型
		List<String> allType = admindao.findAllCartype();
		// 查询所有数据
		List<VehiclesSale> allData = admindao.findAllVehiclesSale(new SaleArea());
		// 过滤后的数据
		if (countTime == null || CommonConstant.MONTH.equals(countTime)) {
			getSector(allData, allType, list, CommonConstant.MONTHDAY);
		} else {// 按周进行统计
			getSector(allData, allType, list, CommonConstant.WEEKDAY);
		}
		return list;
	}

	// 数据封装
	private void getSector(List<VehiclesSale> allData, List<String> allType, List<ResultData<Integer>> list, int ago) {
		List<VehiclesSale> filterData = null;
		// 按时间筛选
		List<VehiclesSale> allDataFilter = choiceDataByDate(allData, ago);
		// 取类型
		for (int j = 0; j < allType.size(); j++) {
			String type = allType.get(j);
			filterData = new ArrayList<VehiclesSale>();
			// 取数据
			for (int i = 0; i < allDataFilter.size(); i++) {
				VehiclesSale vehiclesSale = allDataFilter.get(i);
				/*
				 * 1、北京现代 2、东风日产 3、一汽大众
				 */
				if (vehiclesSale.getVehicles_sale_type().equals(type)) {
					filterData.add(vehiclesSale);
				}
			}
			// 数据封装
			getFilterSector(filterData, list, type);
		}
	}

	// 数据封装
	private void getFilterSector(List<VehiclesSale> filterData, List<ResultData<Integer>> list, String type) {
		ResultData<Integer> resultData = new ResultData<Integer>();
		for (int i = 0; i < filterData.size(); i++) {
			VehiclesSale vehiclesSale = filterData.get(i);
			getCarNumber(i, vehiclesSale, resultData);
		}
		resultData.setResult(type);
		list.add(resultData);
	}

	/**
	 * 数据封装
	 * 
	 * @param i
	 * @param vehiclesSale
	 * @param resultData
	 */
	private void getCarNumber(int i, VehiclesSale vehiclesSale, ResultData<Integer> resultData) {
		// 北京现代
		if (CommonConstant.beijingHyundai.equals(vehiclesSale.getVehicles_sale_type())) {
			if(i==0) {
				resultData.setData(vehiclesSale.getVehicles_sale_number());
			}else {
				resultData.setData(vehiclesSale.getVehicles_sale_number() + resultData.getData());
			}
		}
		// 一汽大众
		if (CommonConstant.fAWVolkswagen.equals(vehiclesSale.getVehicles_sale_type())) {
			if(i==0) {
				resultData.setData(vehiclesSale.getVehicles_sale_number());
			}else {
				resultData.setData(vehiclesSale.getVehicles_sale_number() + resultData.getData());
			}
		}
		// 东风日产
		if (CommonConstant.dongfengNissan.equals(vehiclesSale.getVehicles_sale_type())) {
			if(i==0) {
				resultData.setData(vehiclesSale.getVehicles_sale_number());
			}else {
				resultData.setData(vehiclesSale.getVehicles_sale_number() + resultData.getData());
			}
		}
	}
}