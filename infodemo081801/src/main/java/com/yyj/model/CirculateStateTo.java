package com.yyj.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;
@Entity
@Table(name = "circulatestateto")
@DataTransferObject
public class CirculateStateTo {
		public CirculateStateTo() {
		}
		
		public CirculateStateTo(String code, String borrowName, String startTime, String endTime, String statu) {
			this.code=code;
			this.borrowName =borrowName;
			this.startTime =startTime;
			this.endTime=endTime;
			this.statu=statu;
		}
		public CirculateStateTo(int id,String code, String borrowName, String startTime, String endTime, String statu) {
			
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
		private String startTime;
		private String endTime;
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
		public String getStartTime(){
			return startTime;
		}
		public void setStartTime(String startTime){
			this.startTime=startTime;
		}
		@RemoteProperty
		public String getEndTime(){
			return endTime;
		}
		public void setEndTime(String endTime){
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
