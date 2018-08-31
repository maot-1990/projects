package com.pers.util.enums;

public class CommonType {

	public enum responseType{
		success("200","成功"),system_error("500","系统异常"),param_error("300","入参异常"),unknown_error("400","未知异常"),
		network_error("502","网络异常");
		
		private String code;
		private String value;
		
		private responseType(String code, String value){
			this.code = code;
			this.value = value;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
	}
}
