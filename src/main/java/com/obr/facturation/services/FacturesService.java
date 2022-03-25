package com.obr.facturation.services;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obr.facturation.entities.FactureEntity;
import com.obr.facturation.repositories.FacturesRepository;


@Service
public class FacturesService {
	
	
	private FacturesRepository facturesRepository;
	
	@Autowired
	public FacturesService(FacturesRepository facturesRepository) {
		super();
		this.facturesRepository = facturesRepository;
	}



	public List<FactureEntity> getFacturesModels() 
	{
		return facturesRepository.findAll();
	}
	
	private FactureEntity facturesModel = new FactureEntity();
	
	public FacturesService(FactureEntity facturesModel) {
		super();
		this.facturesModel = facturesModel;
	}



	public double calculTVA(Float quantite, Double price) {
		//Double total = facturesModel.getItem_quantity()*facturesModel.getItem_price();
		
		Double total = quantite * price;
		Double tva = (total * 18)/100;
		facturesModel.setItem_vat(tva);
		return facturesModel.getItem_vat();
	}


	public Long newFacture(FactureEntity facture) 
	{	
		double tva = calculTVA(facture.getItem_quantity(), facture.getItem_price());
		facture.setItem_vat(tva);
		return facturesRepository.save(facture).getId();
	}



	public void supprimerFacture(Long idFacture) 
	{
		boolean exists = facturesRepository.existsById(idFacture);
		if (!exists) {
			throw new IllegalStateException(
					"La Facture dont l'Id est " +idFacture+ " n'existe pas"
					);
		}
		facturesRepository.deleteById(idFacture);
		
	}


	@Transactional
	public void modifierFacture(Long idFacture, String invoice_number, Date invoice_date, String payment_type,
			String customer_name, String customer_tin, String customer_adress, String vat_customer_payer,
			String cancelled_invoice_ref, String invoice_signature, Date invoice_signature_date, String invoice_items,
			String item_designation, float item_quantity, double item_price, double item_ct, double item_tl,
			double item_prive_nvat, double item_vat, double item_prive_wvat, double item_total_amount,
			String taxpayer) 
	{
		FactureEntity facturesModel = facturesRepository.findById(idFacture)
				.orElseThrow(() -> new IllegalStateException("La Facture dont l'Id est " +idFacture+ " n'existe pas") );
		

		if (invoice_number != null && invoice_number.length() > 0 &&
				!Objects.equals(facturesModel.getInvoice_number(), invoice_number)
				)
		{
			facturesModel.setInvoice_number(invoice_number);
		}
		
		if (invoice_date != null &&	!Objects.equals(facturesModel.getInvoice_date(), invoice_date)
				)
		{
			facturesModel.setInvoice_date(invoice_date);
		}
		
		if (payment_type != null && payment_type.length() > 0 &&
				!Objects.equals(facturesModel.getPayment_type(), payment_type)
				)
		{
			facturesModel.setPayment_type(payment_type);
		}
		
		if (customer_name != null && customer_name.length() > 0 &&
				!Objects.equals(facturesModel.getCustomer_name(), customer_name)
				)
		{
			facturesModel.setCustomer_name(customer_name);
		}
		
		if (customer_tin != null && customer_tin.length() > 0 &&
				!Objects.equals(facturesModel.getCustomer_tin(), customer_tin)
				)
		{
			facturesModel.setCustomer_tin(customer_tin);
		}
		
		if (customer_adress != null && customer_adress.length() > 0 &&
				!Objects.equals(facturesModel.getCustomer_adress(), customer_adress)
				)
		{
			facturesModel.setCustomer_adress(customer_adress);
		}
		
		if (vat_customer_payer != null && vat_customer_payer.length() > 0 &&
				!Objects.equals(facturesModel.getVat_customer_payer(), vat_customer_payer)
				)
		{
			facturesModel.setVat_customer_payer(vat_customer_payer);
		}
		
		if (cancelled_invoice_ref != null && cancelled_invoice_ref.length() > 0 &&
				!Objects.equals(facturesModel.getCancelled_invoice_ref(), cancelled_invoice_ref)
				)
		{
			facturesModel.setCancelled_invoice_ref(cancelled_invoice_ref);
		}
		
		if (invoice_signature != null && invoice_signature.length() > 0 &&
				!Objects.equals(facturesModel.getInvoice_signature(), invoice_signature)
				)
		{
			facturesModel.setInvoice_signature(invoice_signature);
		}
		
		if (invoice_signature_date != null  &&	!Objects.equals(facturesModel.getInvoice_signature_date(), invoice_signature_date)
				)
		{
			facturesModel.setInvoice_signature_date(invoice_signature_date);
		}
		
		if (invoice_items != null && invoice_items.length() > 0 &&
				!Objects.equals(facturesModel.getInvoice_items(), invoice_items)
				)
		{
			facturesModel.setInvoice_items(invoice_items);
		}
		
		if (item_designation != null && item_designation.length() > 0 &&
				!Objects.equals(facturesModel.getItem_designation(), item_designation)
				)
		{
			facturesModel.setItem_designation(item_designation);
		}
		
		if (!Objects.equals(facturesModel.getItem_quantity(), item_quantity))
		{
			facturesModel.setItem_quantity(item_quantity);
		}
		
		if (!Objects.equals(facturesModel.getItem_price(), item_price))
		{
			facturesModel.setItem_price(item_price);
		}
		
		if (!Objects.equals(facturesModel.getItem_ct(), item_ct))
		{
			facturesModel.setItem_ct(item_ct);
		}
		
		if (!Objects.equals(facturesModel.getItem_tl(), item_tl))
		{
			facturesModel.setItem_tl(item_tl);
		}
		
		if (!Objects.equals(facturesModel.getItem_prive_nvat(), item_prive_nvat))
		{
			facturesModel.setItem_prive_nvat(item_prive_nvat);
		}
		
		if (!Objects.equals(facturesModel.getItem_vat(), item_vat))
		{
			facturesModel.setItem_vat(item_vat);
		}
		
		if (!Objects.equals(facturesModel.getItem_prive_wvat(), item_prive_wvat))
		{
			facturesModel.setItem_prive_wvat(item_prive_wvat);
		}
		
		if (!Objects.equals(facturesModel.getItem_total_amount(), item_total_amount))
		{
			facturesModel.setItem_total_amount(item_total_amount);
		}
		
		if (taxpayer != null && taxpayer.length() > 0 &&
				!Objects.equals(facturesModel.getTaxpayer(), taxpayer)
				)
		{
			facturesModel.setTaxpayer(taxpayer);
		}
	}

}
