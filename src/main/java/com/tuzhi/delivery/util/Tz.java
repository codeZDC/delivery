package com.tuzhi.delivery.util;
/**
 * 统一的ajax返回格式
 * @author codeZ
 * @date 2018年3月21日 下午5:13:40
 * 
 */

import java.util.List;
import java.util.Map;

public class Tz {

	private String msg;
	
	private List<?> data;
	
	private boolean success;

	private Map<String,Object> map;
	
	public String getMsg() {
		return msg;
	}
	public Tz setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	public List<?> getData() {
		return data;
	}
	public Tz setData(List<?> data) {
		this.data = data;
		return this;
	}
	public boolean isSuccess() {
		return success;
	}
	public Tz setSuccess(boolean success) {
		this.success = success;
		return this;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public Tz setMap(Map<String, Object> map) {
		this.map = map;
		return this;
	}
	public Tz(String msg, boolean success) {
		super();
		this.msg = msg;
		this.success = success;
	}
	public Tz() {
		super();
	}
	
	
	
	public static Tz success(){
		return success(null);
	}
	public static Tz success(String msg){
		return new Tz(msg, true);
	}
	public Tz msg(String msg){
		return this.setMsg(msg);
	}
	public Tz map(Map<String, Object> map){
		return this.setMap(map);
	}
	public Tz data(List<?> data){
		return this.setData(data);
	}

	public static Tz fail(){
		return fail(null);
	}
	public static Tz fail(String msg){
		return new Tz(msg, false);
	}
	
	
}
