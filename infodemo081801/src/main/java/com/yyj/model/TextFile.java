package com.yyj.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;

@Entity
@Table(name="file")
@DataTransferObject
public class TextFile {
		@Id
		private int id;
		private String filename;
		private String filepath;
		public TextFile(){
			
		}
		public TextFile(String filename,String filepath){
			this.filename=filename;
			this.filepath=filepath;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFilename() {
			return filename;
		}
		public void setFilename(String filename) {
			this.filename = filename;
		}
		public String getFilepath() {
			return filepath;
		}
		public void setFilepath(String filepath) {
			this.filepath = filepath;
		}
		@Override
		public String toString() {
			return "TextFile [id=" + id + ", filename=" + filename
					+ ", filepath=" + filepath + "]";
		}
		
		
}
