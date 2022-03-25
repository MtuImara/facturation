package com.obr.facturation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "contribuables", uniqueConstraints = { @UniqueConstraint(name = "nif_unique", columnNames = "nif") })
public class ContribuableEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Long id;

	@Column(name = "tp_type", length = 5)
	private String tp_type;

	@Column(name = "tp_name", length = 100)
	private String tp_name;

	@Column(name = "nif", length = 30)
	private String nif;

	@Column(name = "tp_trade_number", length = 20)
	private String tp_trade_number;

	@Column(name = "tp_postal_number", length = 20)
	private String tp_postal_number;

	@Column(name = "tp_phone_number", length = 20)
	private String tp_phone_number;

	@Column(name = "tp_adress_province", length = 50)
	private String tp_adress_province;

	@Column(name = "tp_adress_commune", length = 50)
	private String tp_adress_commune;

	@Column(name = "tp_adress_quartier", length = 50)
	private String tp_adress_quartier;

	@Column(name = "tp_adress_avenue", length = 50)
	private String tp_adress_avenue;

	@Column(name = "tp_adress_rue", length = 50)
	private String tp_adress_rue;

	@Column(name = "tp_adress_number", length = 10)
	private String tp_adress_number;

	@Column(name = "vat_taxpayer", length = 3)
	private String vat_taxpayer;

	@Column(name = "ct_taxpayer", length = 3)
	private String ct_taxpayer;

	@Column(name = "tl_taxpayer", length = 3)
	private String tl_taxpayer;

	@Column(name = "tp_fiscal_center", length = 20)
	private String tp_fiscal_center;

	@Column(name = "tp_activity_sector", length = 250)
	private String tp_activity_sector;

	@Column(name = "tp_legal_form", length = 20)
	private String tp_legal_form;

	public ContribuableEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContribuableEntity(Long id, String tp_type, String tp_name, String nif, String tp_trade_number,
			String tp_postal_number, String tp_phone_number, String tp_adress_province, String tp_adress_commune,
			String tp_adress_quartier, String tp_adress_avenue, String tp_adress_rue, String tp_adress_number,
			String vat_taxpayer, String ct_taxpayer, String tl_taxpayer, String tp_fiscal_center,
			String tp_activity_sector, String tp_legal_form) {
		super();
		this.id = id;
		this.tp_type = tp_type;
		this.tp_name = tp_name;
		this.nif = nif;
		this.tp_trade_number = tp_trade_number;
		this.tp_postal_number = tp_postal_number;
		this.tp_phone_number = tp_phone_number;
		this.tp_adress_province = tp_adress_province;
		this.tp_adress_commune = tp_adress_commune;
		this.tp_adress_quartier = tp_adress_quartier;
		this.tp_adress_avenue = tp_adress_avenue;
		this.tp_adress_rue = tp_adress_rue;
		this.tp_adress_number = tp_adress_number;
		this.vat_taxpayer = vat_taxpayer;
		this.ct_taxpayer = ct_taxpayer;
		this.tl_taxpayer = tl_taxpayer;
		this.tp_fiscal_center = tp_fiscal_center;
		this.tp_activity_sector = tp_activity_sector;
		this.tp_legal_form = tp_legal_form;
	}

	public ContribuableEntity(String tp_type, String tp_name, String nif, String tp_trade_number,
			String tp_postal_number, String tp_phone_number, String tp_adress_province, String tp_adress_commune,
			String tp_adress_quartier, String tp_adress_avenue, String tp_adress_rue, String tp_adress_number,
			String vat_taxpayer, String ct_taxpayer, String tl_taxpayer, String tp_fiscal_center,
			String tp_activity_sector, String tp_legal_form) {
		super();
		this.tp_type = tp_type;
		this.tp_name = tp_name;
		this.nif = nif;
		this.tp_trade_number = tp_trade_number;
		this.tp_postal_number = tp_postal_number;
		this.tp_phone_number = tp_phone_number;
		this.tp_adress_province = tp_adress_province;
		this.tp_adress_commune = tp_adress_commune;
		this.tp_adress_quartier = tp_adress_quartier;
		this.tp_adress_avenue = tp_adress_avenue;
		this.tp_adress_rue = tp_adress_rue;
		this.tp_adress_number = tp_adress_number;
		this.vat_taxpayer = vat_taxpayer;
		this.ct_taxpayer = ct_taxpayer;
		this.tl_taxpayer = tl_taxpayer;
		this.tp_fiscal_center = tp_fiscal_center;
		this.tp_activity_sector = tp_activity_sector;
		this.tp_legal_form = tp_legal_form;
	}

	@Override
	public String toString() {
		return "ContribuablesModel [id=" + id + ", tp_type=" + tp_type + ", tp_name=" + tp_name + ", nif=" + nif
				+ ", tp_trade_number=" + tp_trade_number + ", tp_postal_number=" + tp_postal_number
				+ ", tp_phone_number=" + tp_phone_number + ", tp_adress_province=" + tp_adress_province
				+ ", tp_adress_commune=" + tp_adress_commune + ", tp_adress_quartier=" + tp_adress_quartier
				+ ", tp_adress_avenue=" + tp_adress_avenue + ", tp_adress_rue=" + tp_adress_rue + ", tp_adress_number="
				+ tp_adress_number + ", vat_taxpayer=" + vat_taxpayer + ", ct_taxpayer=" + ct_taxpayer
				+ ", tl_taxpayer=" + tl_taxpayer + ", tp_fiscal_center=" + tp_fiscal_center + ", tp_activity_sector="
				+ tp_activity_sector + ", tp_legal_form=" + tp_legal_form + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTp_type() {
		return tp_type;
	}

	public void setTp_type(String tp_type) {
		this.tp_type = tp_type;
	}

	public String getTp_name() {
		return tp_name;
	}

	public void setTp_name(String tp_name) {
		this.tp_name = tp_name;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String tp_TIN) {
		this.nif = tp_TIN;
	}

	public String getTp_trade_number() {
		return tp_trade_number;
	}

	public void setTp_trade_number(String tp_trade_number) {
		this.tp_trade_number = tp_trade_number;
	}

	public String getTp_postal_number() {
		return tp_postal_number;
	}

	public void setTp_postal_number(String tp_postal_number) {
		this.tp_postal_number = tp_postal_number;
	}

	public String getTp_phone_number() {
		return tp_phone_number;
	}

	public void setTp_phone_number(String tp_phone_number) {
		this.tp_phone_number = tp_phone_number;
	}

	public String getTp_adress_province() {
		return tp_adress_province;
	}

	public void setTp_adress_province(String tp_adress_province) {
		this.tp_adress_province = tp_adress_province;
	}

	public String getTp_adress_commune() {
		return tp_adress_commune;
	}

	public void setTp_adress_commune(String tp_adress_commune) {
		this.tp_adress_commune = tp_adress_commune;
	}

	public String getTp_adress_quartier() {
		return tp_adress_quartier;
	}

	public void setTp_adress_quartier(String tp_adress_quartier) {
		this.tp_adress_quartier = tp_adress_quartier;
	}

	public String getTp_adress_avenue() {
		return tp_adress_avenue;
	}

	public void setTp_adress_avenue(String tp_adress_avenue) {
		this.tp_adress_avenue = tp_adress_avenue;
	}

	public String getTp_adress_rue() {
		return tp_adress_rue;
	}

	public void setTp_adress_rue(String tp_adress_rue) {
		this.tp_adress_rue = tp_adress_rue;
	}

	public String getTp_adress_number() {
		return tp_adress_number;
	}

	public void setTp_adress_number(String tp_adress_number) {
		this.tp_adress_number = tp_adress_number;
	}

	public String getVat_taxpayer() {
		return vat_taxpayer;
	}

	public void setVat_taxpayer(String vat_taxpayer) {
		this.vat_taxpayer = vat_taxpayer;
	}

	public String getCt_taxpayer() {
		return ct_taxpayer;
	}

	public void setCt_taxpayer(String ct_taxpayer) {
		this.ct_taxpayer = ct_taxpayer;
	}

	public String getTl_taxpayer() {
		return tl_taxpayer;
	}

	public void setTl_taxpayer(String tl_taxpayer) {
		this.tl_taxpayer = tl_taxpayer;
	}

	public String getTp_fiscal_center() {
		return tp_fiscal_center;
	}

	public void setTp_fiscal_center(String tp_fiscal_center) {
		this.tp_fiscal_center = tp_fiscal_center;
	}

	public String getTp_activity_sector() {
		return tp_activity_sector;
	}

	public void setTp_activity_sector(String tp_activity_sector) {
		this.tp_activity_sector = tp_activity_sector;
	}

	public String getTp_legal_form() {
		return tp_legal_form;
	}

	public void setTp_legal_form(String tp_legal_form) {
		this.tp_legal_form = tp_legal_form;
	}

}
