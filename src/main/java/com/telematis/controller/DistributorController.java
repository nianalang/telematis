package com.telematis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telematis.dto.OperateExecution;
import com.telematis.entity.SimplifyDistributor;
import com.telematis.entity.VehiclesSale;
import com.telematis.service.DistributorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 分销商的控制层
 * 
 * @author depc 郎媛勤
 *
 */
@Controller
@RequestMapping("/distributor")
@Api(value = "/分销商中心", tags = "分销商接口")
public class DistributorController {

	@Autowired
	private DistributorService distributorService;

	// 分销商的状态
	@RequestMapping(value = "/findDistributor", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(notes = "分销商的状态", httpMethod = "POST", value = "分销商登陆")
	public OperateExecution findDistributorByPhone(@RequestBody SimplifyDistributor simplifyDistributor) {
		OperateExecution operateExecution = distributorService.findDistributorByPhone(simplifyDistributor);
		return operateExecution;
	}

	// 记录销售车辆的数据
	@RequestMapping(value = "/insertVehiclesSale", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(notes = "记录销售车辆的数据", httpMethod = "POST", value = "记录销售车辆的数据")
	public OperateExecution insertVehiclesSale(@RequestBody VehiclesSale vehiclesSale) {
		OperateExecution operateExecution = distributorService.insertVehiclesSale(vehiclesSale);
		return operateExecution;
	}

	// 修改密码
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(notes = " 修改密码", httpMethod = "POST", value = " 修改分销商登陆密码")
	public OperateExecution updatePassword(@RequestBody SimplifyDistributor simplifyDistributor) {
		OperateExecution operateExecution = distributorService.updatePassword(simplifyDistributor);
		return operateExecution;
	}

}
