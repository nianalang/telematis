package com.telematis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telematis.dto.AdminGraph;
import com.telematis.dto.AreaDataAdmin;
import com.telematis.dto.DataAdmin;
import com.telematis.dto.ResultData;
import com.telematis.service.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 管理员数据统计
 * 
 * @author 念阿郎
 *
 */
@Controller
@RequestMapping("/adminDataStatistic")
@Api(value = "数据统计", tags = "管理员数据统计")
public class AdminDataStatisticController {

	@Autowired
	private AdminService adminService;

	/**
	 * 一、各分销商销售统计(柱形+折形)
	 */
	@RequestMapping(value = "/allDataByCondition", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(notes = "分地区分销商条形统计图+折线统计图 ", httpMethod = "POST", value = "条形统计图 ")
	public List<ResultData<DataAdmin>> allDataByCondition(@RequestBody AdminGraph adminBarGraph) {
		return adminService.allDataByCondition(adminBarGraph.getCountTime(), adminBarGraph.getArea());
	}

	// 按地区统计数据
	@RequestMapping(value = "/allDataByArea", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(notes = "所有地区分销商条形据统计图 +折线统计图 ", httpMethod = "POST", value = "地区数据统计图 ")
	public List<ResultData<AreaDataAdmin>> allDataByArea(@RequestBody AdminGraph adminBarGraph) {
		return adminService.allDataByArea(adminBarGraph.getCountTime());// 返回数据
	}

	// 扇形统计数据
	@RequestMapping(value = "/allDataBySector", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(notes = "销售车辆类型市场占领扇形图", httpMethod = "POST", value = "车辆市场占领扇形图 ")
	public List<ResultData<Integer>> allDataBySector(@RequestBody AdminGraph adminBarGraph) {
		return adminService.allDataSector(adminBarGraph.getCountTime());// 返回数据
	}
}
