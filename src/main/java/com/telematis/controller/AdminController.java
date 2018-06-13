package com.telematis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telematis.dto.Datagrid;
import com.telematis.dto.OperateExecution;
import com.telematis.dto.TelematisAjaxResult;
import com.telematis.entity.Admin;
import com.telematis.entity.Distributor;
import com.telematis.entity.SimplifyAdmin;
import com.telematis.enums.OperateStateEnum;
import com.telematis.service.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * 管理员个人中心的控制层
 */
@Controller
@RequestMapping("/admin") // 处理url:/模块/资源/{id}/细分
@Api(value = "/管理员中心", tags = "管理员数据操作接口")
public class AdminController {

	@Autowired
	private AdminService adminService;

	/**
	 * 管理员登录 produces: 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；
	 * 
	 * @param simplifyAdmin
	 * @return
	 */
	@RequestMapping(value = "/findAdmin", method = RequestMethod.POST)
	@ResponseBody // 返回json数据
	@ApiOperation(notes = "登陆", httpMethod = "POST", value = "管理员登陆")
	public OperateExecution findAdminByPhone(@RequestBody SimplifyAdmin simplifyAdmin) {
		OperateExecution operateExecution = adminService.findAdminByPhone(simplifyAdmin);
		return operateExecution;
	}

	/**
	 * 添加一名管理员
	 * 
	 * @param admin
	 * @return
	 */
	@RequestMapping(value = "/insertAdmin", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(notes = "添加管理员", httpMethod = "POST", value = "添加一名管理员")
	public OperateExecution insertAdmin(@RequestBody Admin admin) {
		OperateExecution operateExecution = adminService.insertAdmin(admin);
		return operateExecution;
	}

	/**
	 * 根据电话号码删除管理员
	 * 
	 * @param admin_phone
	 * @return
	 */
	@RequestMapping(value = "/deleteAdmin/{admin_phone}", method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(notes = "删除管理员", httpMethod = "DELETE", value = "根据电话号码删除管理员")
	public OperateExecution deleteAdminByPhone(
			@ApiParam(value = "管理员电话号", required = true) @PathVariable("admin_phone") String admin_phone) {
		OperateExecution operateExecution = adminService.deleteAdminByPhone(admin_phone);
		return operateExecution;
	}

	/**
	 * 查询所有的管理员
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findAllAdmin", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(notes = "查询所有的管理员", httpMethod = "GET", value = "查询所有的管理员")
	public TelematisAjaxResult<Datagrid> findAllAdmin(
			@ApiParam(value = "当前页数", required = true) @RequestParam("pageNum") int pageNum,
			@ApiParam(value = "每页显示的记录数", required = true) @RequestParam("pageSize") int pageSize) {
		try {
			Datagrid list = adminService.findAllAdmin(pageNum, pageSize);
			// 数据处理
			return new TelematisAjaxResult<Datagrid>(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			// 系统内部错误
			return new TelematisAjaxResult<Datagrid>(false, OperateStateEnum.INNER_ERROR.getStateInfo());
		}
	}

	/**
	 * 添加一名分销商
	 * 
	 * @param distributor
	 * @return
	 */
	@RequestMapping(value = "/distributor/insertDistributor", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(notes = "添加一名分销商", httpMethod = "POST", value = "添加一名分销商")
	public OperateExecution insertDistributor(@RequestBody Distributor distributor) {
		return adminService.insertDistributor(distributor);
	}

	/**
	 * 删除一名分销商
	 * 
	 * @param dist_phone
	 * @return
	 */
	@RequestMapping(value = "/distributor/{dist_phone}", method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(notes = "删除一名分销商", httpMethod = "DELETE", value = "删除一名分销商")
	public OperateExecution deleteDistributorByPhone(
			@ApiParam(value = "分销商号码", required = true) @PathVariable("dist_phone") String dist_phone) {
		return adminService.deleteDistributorByPhone(dist_phone);
	}

	/**
	 * 重置分销商的密码
	 * 
	 * @param dist_phone
	 * @return
	 */
	@RequestMapping(value = "/distributor/resetDistributor/{dist_phone}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(notes = "重置分销商的密码", httpMethod = "GET", value = "重置分销商的密码")
	public OperateExecution resetDistributorPassword(
			@ApiParam(value = "分销商号码", required = true) @PathVariable("dist_phone") String dist_phone) {
		return adminService.resetDistributorPassword(dist_phone);
	}

	/**
	 * 根据电话号查询Distributor
	 * 
	 * @param dist_phone
	 * @return
	 */
	@RequestMapping(value = "/distributor/findDistributor/{dist_phone}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(notes = "根据电话号查询分销商", httpMethod = "GET", value = "根据电话号查询分销商")
	public TelematisAjaxResult<Distributor> findDistributorByPhone(
			@ApiParam(value = "分销商号码", required = true) @PathVariable("dist_phone") String dist_phone) {
		Distributor distributor = null;
		try {
			if (dist_phone != null) {
				distributor = adminService.findDistributorByPhone(dist_phone);
				// 返回正确的数据
				return new TelematisAjaxResult<Distributor>(true, distributor);
			} else {// 提示输入号码
				return new TelematisAjaxResult<Distributor>(false, OperateStateEnum.INPUTDELETEPHONE.getStateInfo());
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 系统内部错误
			return new TelematisAjaxResult<Distributor>(false, OperateStateEnum.INNER_ERROR.getStateInfo());
		}
	}

	/**
	 * 查询所有的分销商 分页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/distributor/findAllDistributor", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(notes = "查询所有的分销商 ", httpMethod = "GET", value = "查询所有的分销商 ")
	public TelematisAjaxResult<Datagrid> findAllDistributor(
			@ApiParam(value = "当前页数", required = true) @RequestParam("pageNum") int pageNum,
			@ApiParam(value = "每页显示的记录数", required = true) @RequestParam("pageSize") int pageSize) {
		Datagrid list = null;
		try {
			list = adminService.findAllDistributor(pageNum, pageSize);
			return new TelematisAjaxResult<Datagrid>(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			// 系统内部错误
			return new TelematisAjaxResult<Datagrid>(false, OperateStateEnum.INNER_ERROR.getStateInfo());
		}
	}
}