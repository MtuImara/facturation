package com.obr.facturation.reponse;

public class Jibu<T> {
	
	private String  Success;
	 private String messages;
	 
	 T result;
	 
	
		public Jibu() {
			super();
		
		}


	public Jibu(String success, String messages, T result) {
		super();
		Success = success;
		this.messages = messages;
		this.result = result;
	}
	public Jibu(String success, String messages) {
		super();
		Success = success;
		this.messages = messages;
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
	public String getMessages() {
		return messages;
	}
	/**
	 * @param messages the messages to set
	 */
	public void setMessages(String messages) {
		this.messages = messages;
	}
	/**
	 * @return the result
	 */
	public T getresult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setresult(T result) {
		this.result = result;
	}

}
