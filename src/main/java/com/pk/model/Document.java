package com.pk.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="document")
public class Document {

	@Id
	@Column(name="fid")
	private Integer fileId;
	@Column(name="fname")
	private String fileName;
	
	@Lob       //byte[] + Lob=BLOB
	@Column(name="fdata")
	private byte[] fileData;
	
	
     public Document() {
	   System.out.println("Document::0-param constructor"); 
    }

	//setters and getters
	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	//toString
	@Override
	public String toString() {
		return "Document [fileId=" + fileId + ", fileName=" + fileName + ", fileData=" + Arrays.toString(fileData)
				+ "]";
	}
	
}
