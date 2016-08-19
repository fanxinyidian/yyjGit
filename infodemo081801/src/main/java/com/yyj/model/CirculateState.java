package com.yyj.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;
@Entity
@Table(name = "circulatestate")
@DataTransferObject
public class CirculateState {
		public CirculateState() {
		}
		
		public CirculateState(String code, String borrowName, Date startTime, Date endTime, String statu) {
			this.code=code;
			this.borrowName =borrowName;
			this.startTime =startTime;
			this.endTime=endTime;
			this.statu=statu;
		}
		public CirculateState(int id,String code, String borrowName, Date startTime, Date endTime, String statu) {
			
			this.id = id;
			this.code=code;
			this.borrowName =borrowName;
			this.startTime =startTime;
			this.endTime=endTime;
			this.statu=statu;
		}

		@Id
		private int id;
		private String code;
		private String borrowName;
		private Date startTime;
		private Date endTime;
		private String statu;
		@RemoteProperty
		public int getId(){
			return id;
		}
		public void setId(int id){
			this.id=id;
		}
		@RemoteProperty
		public String getCode(){
			return code;
		}
		public void setCode(String code){
			this.code=code;
		}
		@RemoteProperty
		public String getBorrowName(){
			return borrowName;
		}
		public void setBorrowName(String borrowName){
			this.borrowName=borrowName;
		}
		@RemoteProperty
		public Date getStartTime(){
			return startTime;
		}
		public void setStartTime(Date startTime){
			this.startTime=startTime;
		}
		@RemoteProperty
		public Date getEndTime(){
			return endTime;
		}
		public void setEndTime(Date endTime){
			this.endTime=endTime;
		}
		@RemoteProperty
		public String getStatu(){
			return statu;
		}
		public void setStatu(String statu){
			this.statu=statu;
		}
		
}
