package com.fy.bean;

import java.io.Serializable;

/**
 * ������Ʒ��Ϣ����
 * @author zy
 */
@SuppressWarnings("serial")
public class Product implements Serializable {
	// Fields
	private Integer id;//��ƷID
	private String productnumber;//��Ʒ���
	private String productname;//��Ʒ����
	private String categoryno;//��Ʒ������
	private String category;//��Ʒ��������
	private String imagepath;//��ƷͼƬ����
	private String isnewproduct;//�Ƿ�����Ʒ1-true,0-false
	private float price1;//�۸�
	private float price2;//��Ա�۸�
	private String stock;//ʣ����
	private String realstock;//�����
	private String cas;//ҩƷժҪ
	private String mdlint;//mdl���
	private String formula;//��ѧ����ʽ
	private String weight;//����
	private String note;//��ע
	private String delsoft;//��ɾ����־1Ϊ��ɾ����0Ϊ����
	// Constructors
	/** default constructor */
	public Product()
	{
		super();
		this.productnumber = productnumber;
		this.productname = productname;
		this.categoryno = categoryno;
		this.category = category;
		this.imagepath = imagepath;
		this.isnewproduct = isnewproduct;
		this.price1 = price1;
		this.price2 = price2;
		this.stock = stock;
		this.realstock = realstock;
		this.cas = cas;
		this.mdlint = mdlint;
		this.formula = formula;
		this.weight = weight;
		this.note = note;
		this.delsoft = delsoft;
	}
// Property accessors
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductnumber() {
		return productnumber;
	}
	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getCategoryno() {
		return categoryno;
	}
	public void setCategoryno(String categoryno) {
		this.categoryno = categoryno;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getIsnewproduct() {
		return isnewproduct;
	}
	public void setIsnewproduct(String isnewproduct) {
		this.isnewproduct = isnewproduct;
	}
	public float getPrice1() {
		return price1;
	}
	public void setPrice1(float price1) {
		this.price1 = price1;
	}
	public float getPrice2() {
		return price2;
	}
	public void setPrice2(float price2) {
		this.price2 = price2;
	}
	public String getStock() {
		return stock;
	}
	
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getRealstock() {
		return realstock;
	}
	public void setRealstock(String realstock) {
		this.realstock = realstock;
	}
	public String getCas() {
		return cas;
	}
	public void setCas(String cas) {
		this.cas = cas;
	}
	public String getMdlint() {
		return mdlint;
	}
	public void setMdlint(String mdlint) {
		this.mdlint = mdlint;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getDelsoft() {
		return delsoft;
	}
	public void setDelsoft(String delsoft) {
		this.delsoft = delsoft;
	}
}





