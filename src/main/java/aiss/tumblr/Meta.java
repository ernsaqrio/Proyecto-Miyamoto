/* Generated by JavaFromJSON */
/*http://javafromjson.dashingrocket.com*/

package aiss.tumblr;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meta {
	private java.lang.String msg;

 	public void setMsg(java.lang.String msg) {
		this.msg = msg;
	}

	public java.lang.String getMsg() {
		return msg;
	}

	private java.lang.Integer status;

 	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Integer getStatus() {
		return status;
	}

}