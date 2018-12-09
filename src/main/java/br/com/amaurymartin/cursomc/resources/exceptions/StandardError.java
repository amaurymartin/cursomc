package br.com.amaurymartin.cursomc.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	private Long timeStamp;
	
	public StandardError() {
		
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public StandardError setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public StandardError setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	
	public Long getTimeStamp() {
		return timeStamp;
	}
	
	public StandardError setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
		return this;
	}
	
}
