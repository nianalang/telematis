package com.telematis.dto;

import java.io.Serializable;

import com.telematis.enums.OperateStateEnum;

/**
 * 封装执行后的结果
 * @author depc
 *
 */
@SuppressWarnings("serial")
public class OperateExecution implements Serializable{
	
	private int state;

    private String stateInfo;
    
    public OperateExecution(OperateStateEnum insertsuccess){
    	state=insertsuccess.getState();
    	stateInfo=insertsuccess.getStateInfo();
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
}
