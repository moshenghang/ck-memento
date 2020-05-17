package com.shenhangyu.icard.icardweb.bean;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 用户卡号信息表
 * 
 * @author moshenghang
 * @email com.moshenghang@gmail.com
 * @date 2020-05-11 19:58:50
 */
@ApiModel(description="用户卡号信息封装类")
public class CardInfoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="card_info表id")
	private Integer id;
	@ApiModelProperty(value="卡号")
	private String cardNo;
	@ApiModelProperty(value="卡类型")
	private String cardType;
	@ApiModelProperty(value="证件号")
	private String idNo;
	@ApiModelProperty(value="证件类型")
	private String idType;
	@ApiModelProperty(value="持卡人中文")
	private String userZhName;
	@ApiModelProperty(value="持卡人英文名")
	private String userEnName;
	@ApiModelProperty(value="手机号码")
	private String mobilePhone;
	@ApiModelProperty(value="固话号码")
	private String telephone;
	@ApiModelProperty(value="家庭地址")
	private String homeAddress;
	@ApiModelProperty(value="公司地址")
	private String companyAddress;
	@ApiModelProperty(value="有效期")
	private Date validityDate;
	@ApiModelProperty(value="开卡日期")
	private Date openTime;
	@ApiModelProperty(value="激活日期")
	private Date actTime;
	@ApiModelProperty(value="卡状态")
	private String cardStatus;
	@ApiModelProperty(value="创建时间")
	private Date createTime;
	@ApiModelProperty(value="创建人")
	private String createOper;
	@ApiModelProperty(value="修改时间")
	private Date modifyTime;
	@ApiModelProperty(value="修改人")
	private String modifyOper;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：卡号
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * 获取：卡号
	 */
	public String getCardNo() {
		return cardNo;
	}
	/**
	 * 设置：卡类型
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	/**
	 * 获取：卡类型
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * 设置：证件号
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * 获取：证件号
	 */
	public String getIdNo() {
		return idNo;
	}
	/**
	 * 设置：证件类型
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}
	/**
	 * 获取：证件类型
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * 设置：持卡人中文名
	 */
	public void setUserZhName(String userZhName) {
		this.userZhName = userZhName;
	}
	/**
	 * 获取：持卡人中文名
	 */
	public String getUserZhName() {
		return userZhName;
	}
	/**
	 * 设置：持卡人英文名
	 */
	public void setUserEnName(String userEnName) {
		this.userEnName = userEnName;
	}
	/**
	 * 获取：持卡人英文名
	 */
	public String getUserEnName() {
		return userEnName;
	}
	/**
	 * 设置：手机号码
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	/**
	 * 获取：手机号码
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	/**
	 * 设置：
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * 获取：
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * 设置：家庭地址
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	/**
	 * 获取：家庭地址
	 */
	public String getHomeAddress() {
		return homeAddress;
	}
	/**
	 * 设置：公司地址
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	/**
	 * 获取：公司地址
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}
	/**
	 * 设置：有效期
	 */
	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}
	/**
	 * 获取：有效期
	 */
	public Date getValidityDate() {
		return validityDate;
	}
	/**
	 * 设置：开卡日期
	 */
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	/**
	 * 获取：开卡日期
	 */
	public Date getOpenTime() {
		return openTime;
	}
	/**
	 * 设置：激活日期
	 */
	public void setActTime(Date actTime) {
		this.actTime = actTime;
	}
	/**
	 * 获取：激活日期
	 */
	public Date getActTime() {
		return actTime;
	}
	/**
	 * 设置：卡状态
	 */
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}
	/**
	 * 获取：卡状态
	 */
	public String getCardStatus() {
		return cardStatus;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateOper(String createOper) {
		this.createOper = createOper;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateOper() {
		return createOper;
	}
	/**
	 * 设置：修改时间
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setModifyOper(String modifyOper) {
		this.modifyOper = modifyOper;
	}
	/**
	 * 获取：修改人
	 */
	public String getModifyOper() {
		return modifyOper;
	}
}
