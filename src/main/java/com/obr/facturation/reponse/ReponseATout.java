package com.obr.facturation.reponse;

public class ReponseATout {
	private String  Success;
	 private String msg;
	 
	 
	
		public  ReponseATout() {
			
		}


	public ReponseATout(String success, String messages) {
		super();
		Success = success;
		this.msg = messages;
	}


	/**
	 * @return the success
	 */
	public String getSuccess() {
		return Success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(String success) {
		Success = success;
	}
	/**
	 * @return the messages
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param messages the messages to set
	 */
	public void setMsg(String messages) {
		this.msg = messages;
	}

}
