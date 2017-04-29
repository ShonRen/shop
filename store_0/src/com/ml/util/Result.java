package com.ml.util;

import java.io.Serializable;

//NoteResult<T>对象变成json字符串{"status":xx,"msg":xxx,"data":xxx}
public class Result<T> implements Serializable{
	private int status;
	private String msg;
	private T data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
