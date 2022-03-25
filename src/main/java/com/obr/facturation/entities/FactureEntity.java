package com.obr.facturation.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "factures")
public class FactureEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Long id;

	@Column(name = "invoice_number", length = 30)
	private String invoice_number;

	@Column(name = "invoice_date")
	private Date invoice_date;

	@Column(name = "payment_type", length = 4)
	private String payment_type;

	@Column(name = "customer_name", length = 100)
	private String customer_name;

	@Column(name = "customer_tin", length = 50)
	private String customer_tin;

	@Column(name = "customer_adress", length = 100)
	private String customer_adress;

	@Column(name = "vat_customer_payer", length = 3)
	private String vat_customer_payer;

	@Column(name = "cancelled_invoice_ref", length = 4)
	private String cancelled_invoice_ref;

	@Column(name = "invoice_signature", length = 30)
	private String invoice_signature;

	@Column(name = "invoice_signature_date")
	private Date invoice_signature_date;

	@Column(name = "invoice_items")
	private String invoice_items;

	@Column(name = "item_designation", length = 250)
	private String item_designation;

	@Column(name = "item_quantity")
	private Float item_quantity;

	@Column(name = "item_price")
	private double item_price;

	@Column(name = "item_ct")
	private double item_ct;

	@Column(name = "item_tl")
	private double item_tl;

	@Column(name = "item_prive_nvat")
	private double item_prive_nvat;

	@Column(name = "item_vat")
	private double item_vat;

	@Column(name = "item_prive_wvat")
	private double item_prive_wvat;

	@Column(name = "item_total_amount")
	private double item_total_amount;

	@Column(name = "taxpayer")
	private String taxpayer;

	public FactureEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FactureEntity(Long id, String invoice_number, Date invoice_date, String payment_type, String customer_name,
			String customer_tin, String customer_adress, String vat_customer_payer, String cancelled_invoice_ref,
			String invoice_signature, Date invoice_signature_date, String invoice_items, String item_designation,
			Float item_quantity, double item_price, double item_ct, double item_tl, double item_prive_nvat,
			double item_vat, double item_prive_wvat, double item_total_amount, String taxpayer) {
		super();
		this.id = id;
		this.invoice_number = invoice_number;
		this.invoice_date = invoice_date;
		this.payment_type = payment_type;
		this.customer_name = customer_name;
		this.customer_tin = customer_tin;
		this.customer_adress = customer_adress;
		this.vat_customer_payer = vat_customer_payer;
		this.cancelled_invoice_ref = cancelled_invoice_ref;
		this.invoice_signature = invoice_signature;
		this.invoice_signature_date = invoice_signature_date;
		this.invoice_items = invoice_items;
		this.item_designation = item_designation;
		this.item_quantity = item_quantity;
		this.item_price = item_price;
		this.item_ct = item_ct;
		this.item_tl = item_tl;
		this.item_prive_nvat = item_prive_nvat;
		this.item_vat = item_vat;
		this.item_prive_wvat = item_prive_wvat;
		this.item_total_amount = item_total_amount;
		this.taxpayer = taxpayer;
	}

	public FactureEntity(String invoice_number, Date invoice_date, String payment_type, String customer_name,
			String customer_tin, String customer_adress, String vat_customer_payer, String cancelled_invoice_ref,
			String invoice_signature, Date invoice_signature_date, String invoice_items, String item_designation,
			Float item_quantity, double item_price, double item_ct, double item_tl, double item_prive_nvat,
			double item_vat, double item_prive_wvat, double item_total_amount, String taxpayer) {
		super();
		this.invoice_number = invoice_number;
		this.invoice_date = invoice_date;
		this.payment_type = payment_type;
		this.customer_name = customer_name;
		this.customer_tin = customer_tin;
		this.customer_adress = customer_adress;
		this.vat_customer_payer = vat_customer_payer;
		this.cancelled_invoice_ref = cancelled_invoice_ref;
		this.invoice_signature = invoice_signature;
		this.invoice_signature_date = invoice_signature_date;
		this.invoice_items = invoice_items;
		this.item_designation = item_designation;
		this.item_quantity = item_quantity;
		this.item_price = item_price;
		this.item_ct = item_ct;
		this.item_tl = item_tl;
		this.item_prive_nvat = item_prive_nvat;
		this.item_vat = item_vat;
		this.item_prive_wvat = item_prive_wvat;
		this.item_total_amount = item_total_amount;
		this.taxpayer = taxpayer;
	}

	@Override
	public String toString() {
		return "FacturesModel [id=" + id + ", invoice_number=" + invoice_number + ", invoice_date=" + invoice_date
				+ ", payment_type=" + payment_type + ", customer_name=" + customer_name + ", customer_tin="
				+ customer_tin + ", customer_adress=" + customer_adress + ", vat_customer_payer=" + vat_customer_payer
				+ ", cancelled_invoice_ref=" + cancelled_invoice_ref + ", invoice_signature=" + invoice_signature
				+ ", invoice_signature_date=" + invoice_signature_date + ", invoice_items=" + invoice_items
				+ ", item_designation=" + item_designation + ", item_quantity=" + item_quantity + ", item_price="
				+ item_price + ", item_ct=" + item_ct + ", item_tl=" + item_tl + ", item_prive_nvat=" + item_prive_nvat
				+ ", item_vat=" + item_vat + ", item_prive_wvat=" + item_prive_wvat + ", item_total_amount="
				+ item_total_amount + ", taxpayer=" + taxpayer + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoice_number() {
		return invoice_number;
	}

	public void setInvoice_number(String invoice_number) {
		this.invoice_number = invoice_number;
	}

	public Date getInvoice_date() {
		return invoice_date;
	}

	public void setInvoice_date(Date invoice_date) {
		this.invoice_date = invoice_date;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_tin() {
		return customer_tin;
	}

	public void setCustomer_tin(String customer_tin) {
		this.customer_tin = customer_tin;
	}

	public String getCustomer_adress() {
		return customer_adress;
	}

	public void setCustomer_adress(String customer_adress) {
		this.customer_adress = customer_adress;
	}

	public String getVat_customer_payer() {
		return vat_customer_payer;
	}

	public void setVat_customer_payer(String vat_customer_payer) {
		this.vat_customer_payer = vat_customer_payer;
	}

	public String getCancelled_invoice_ref() {
		return cancelled_invoice_ref;
	}

	public void setCancelled_invoice_ref(String cancelled_invoice_ref) {
		this.cancelled_invoice_ref = cancelled_invoice_ref;
	}

	public String getInvoice_signature() {
		return invoice_signature;
	}

	public void setInvoice_signature(String invoice_signature) {
		this.invoice_signature = invoice_signature;
	}

	public Date getInvoice_signature_date() {
		return invoice_signature_date;
	}

	public void setInvoice_signature_date(Date invoice_signature_date) {
		this.invoice_signature_date = invoice_signature_date;
	}

	public String getInvoice_items() {
		return invoice_items;
	}

	public void setInvoice_items(String invoice_items) {
		this.invoice_items = invoice_items;
	}

	public String getItem_designation() {
		return item_designation;
	}

	public void setItem_designation(String item_designation) {
		this.item_designation = item_designation;
	}

	public Float getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(Float item_quantity) {
		this.item_quantity = item_quantity;
	}

	public double getItem_price() {
		return item_price;
	}

	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}

	public double getItem_ct() {
		return item_ct;
	}

	public void setItem_ct(double item_ct) {
		this.item_ct = item_ct;
	}

	public double getItem_tl() {
		return item_tl;
	}

	public void setItem_tl(double item_tl) {
		this.item_tl = item_tl;
	}

	public double getItem_prive_nvat() {
		return item_prive_nvat;
	}

	public void setItem_prive_nvat(double item_prive_nvat) {
		this.item_prive_nvat = item_prive_nvat;
	}

	public double getItem_vat() {
		return item_vat;
	}

	public void setItem_vat(double item_vat) {
		this.item_vat = item_vat;
	}

	public double getItem_prive_wvat() {
		return item_prive_wvat;
	}

	public void setItem_prive_wvat(double item_prive_wvat) {
		this.item_prive_wvat = item_prive_wvat;
	}

	public double getItem_total_amount() {
		return item_total_amount;
	}

	public void setItem_total_amount(double item_total_amount) {
		this.item_total_amount = item_total_amount;
	}

	public String getTaxpayer() {
		return taxpayer;
	}

	public void setTaxpayer(String taxpayer) {
		this.taxpayer = taxpayer;
	}

}
