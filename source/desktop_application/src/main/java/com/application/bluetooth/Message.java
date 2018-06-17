package com.application.bluetooth;

public class Message {

	private String type;
	private String opCode;
	private String dataLength;
	private String Data;
	
	public Message(String type, String opCode, String datalength, String Data)
	{
		this.type=type;
		this.opCode=opCode;
		this.dataLength=datalength;
		this.Data=Data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOpCode() {
		return opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	public String getDataLength() {
		return dataLength;
	}
	public void setDataLength(String dataLength) {
		this.dataLength = dataLength;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	@Override
	public String toString() {
		return "Message [type=" + type + ", opCode=" + opCode + ", dataLength=" + dataLength + ", Data=" + Data + ", lngth=" + Data.length()/2 + "]";
	}
	
}
