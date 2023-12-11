package id.aldin.cimb.test.dao;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@ToString
public class ResponseService implements Serializable {
	
	Object responseCode, responseDesc, data;
	
	public ResponseService() {
	}

	public ResponseService(Object responseCode, Object responseDesc, Object data) {
		this.responseCode = responseCode;
		this.responseDesc = responseDesc;
		this.data = data;
	}

	public Object getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Object responseCode) {
		this.responseCode = responseCode;
	}

	public Object getResponseDesc() {
		return responseDesc;
	}

	public void setResponseDesc(Object responseDesc) {
		this.responseDesc = responseDesc;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
