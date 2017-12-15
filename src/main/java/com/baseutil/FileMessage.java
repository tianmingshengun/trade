package com.baseutil;
/**
 * 文件描述信息
 * @author admin
 *
 */
public class FileMessage {
	private String code;
	private String msg;
	private Data data;
	
	public class Data{
		private String fileFullName;

		public String getFileFullName() {
			return fileFullName;
		}

		public void setFileFullName(String fileFullName) {
			this.fileFullName = fileFullName;
		}
		
		
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
}

