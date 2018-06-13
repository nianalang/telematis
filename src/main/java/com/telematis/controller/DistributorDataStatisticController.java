package com.telematis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telematis.dto.DataDistributor;
import com.telematis.dto.DistributorGraph;
import com.telematis.dto.ResultData;
import com.telematis.service.DistributorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 分销商数据统计
 * 
 * @author 念阿郎
 *
 */
@Controller
@RequestMapping("/distributorDataStatistic")
@Api(value = "/数据统计", tags = "分销商数据统计")
public class DistributorDataStatisticController {

	@Autowired
	private DistributorService distributorService;

	// 条形统计图
	@RequestMapping(value = "/allDataByVehiclesType/{countTime}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(notes = "条形统计图", httpMethod = "GET", value = "条形统计图")
	public List<ResultData<DataDistributor>> allDataByVehiclesType(
			@ApiParam(value = "month|week", required = true) @PathVariable("countTime") String countTime) {
		List<ResultData<DataDistributor>> dataDistributors = distributorService.allDataByVehiclesType(countTime);
		// 返回正确的数据
		return dataDistributors;
	}

	// 地区分布图
	@RequestMapping(value = "/allDataByVehiclesArea", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(notes = "销售地区分布图", httpMethod = "POST", value = "地区分布图")
	public List<ResultData<DataDistributor>> allDataByVehiclesArea(@RequestBody DistributorGraph distributorGraph) {
		List<ResultData<DataDistributor>> dataDistributors = distributorService
				.allDataByVehiclesArea(distributorGraph.getCountTime(), distributorGraph.getArea());
		return dataDistributors;
	}
}
