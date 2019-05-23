package com.yuxy.myblog.domain;

import java.math.BigInteger;

/**
 * 文章类型封装类
 * 
 * @author Yuxy
 *
 */
public class Type {
	private BigInteger TypeID;
	private String TypeName;
	private Type superType;
	private String Abbr;
	
	public Type() {
		
	}

	public Type(String typeName) {
		TypeName = typeName;
		Abbr = "test";
	}
	
	public BigInteger getTypeID() {
		return TypeID;
	}

	public void setTypeID(BigInteger typeID) {
		TypeID = typeID;
	}

	public String getTypeName() {
		return TypeName;
	}

	public void setTypeName(String typeName) {
		TypeName = typeName;
	}

	public String getAbbr() {
		return Abbr;
	}

	public void setAbbr(String abbr) {
		Abbr = abbr;
	}

	public Type getSuperType() {
		return superType;
	}

	public void setSuperType(Type superType) {
		this.superType = superType;
	}

}
