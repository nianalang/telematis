package com.telematis.enums;

/**
 * 登录状态设置
 * @author depc
 *
 */
public enum OperateStateEnum {

	SUCCESS(1,"登录成功"),
	PHONEERROR(0,"用户名错误或不存在"),
	PASSWORDERROR(-1,"密码错误或不存在"),
	INNER_ERROR(-2, "系统异常"),
	NOT_LOGIN(-3, "未登陆"),
	
	INSERTSUCCESS (4,"添加成功"),
	INSERTFAIL(-4,"添加失败"),
	
	DELETESUCCESS(5,"删除成功"),
	DELETEFAIL(-5,"删除失败"),
	
	RESETSUCCESS(6,"重置成功"),
	RESETFAIL(-6,"重置失败"),
	
	UPDATESUCCESS(10,"修改成功"),
	UPDATEFAIL(-10,"修改失败"),
	
	INPUTPARAMETER(-7,"请输入数据"),
	INPUTDELETEPHONE(-8,"请输入电话号码"),
	DIFFERPASSWORD(-9,"两次输入的密码不一致");
	 OperateStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	private int state;

    private String stateInfo;
}
