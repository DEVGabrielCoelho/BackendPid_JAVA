package br.com.api.atividade.pid.ResponseModel;

import java.util.Date;

public class GeneralResponseModel {

	private Integer httpStatus;
	private String messageStatus;
	private Date dateRequest;
	private Integer listSize;
	private Object object;

	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	public Date getDateRequest() {
		return dateRequest;
	}

	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}

	public Integer getListSize() {
		return listSize;
	}

	public void setListSize(Integer listSize) {
		this.listSize = listSize;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "GeneralResponseModel [httpStatus=" + httpStatus + ", messageStatus=" + messageStatus + ", dateRequest="
				+ dateRequest + ", listSize=" + listSize + ", object=" + object + "]";
	}

	public GeneralResponseModel(Integer httpStatus, String messageStatus, Date dateRequest, Integer listSize,
			Object object) {
		super();
		this.httpStatus = httpStatus;
		this.messageStatus = messageStatus;
		this.dateRequest = dateRequest;
		this.listSize = listSize;
		this.object = object;
	}

	public GeneralResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
