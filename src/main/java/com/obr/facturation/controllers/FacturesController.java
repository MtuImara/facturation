package com.obr.facturation.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.obr.facturation.entities.FactureEntity;
import com.obr.facturation.services.FacturesService;

@RestController
@RequestMapping(path = "/facture")
public class FacturesController {
	
	private FacturesService facturesService;
	
	@Autowired
	public FacturesController(FacturesService facturesService) 
	{
		super();
		this.facturesService = facturesService;
	}
	
	@GetMapping("/voir")
	public List<FactureEntity> getFacturesModels()
	{
		return facturesService.getFacturesModels();
		
	}
	
	@PostMapping("/new")
	public Long ajouterFacture(@RequestBody  FactureEntity facture) {
		return facturesService.newFacture(facture);
	}
	
	@DeleteMapping(path = "{idFacture}")
	public void supprimerFacture(@PathVariable("idFacture") Long idFacture) {
		facturesService.supprimerFacture(idFacture);
	}
	
	@PutMapping(path = "{idFacture}")
	public void modifierContribuable(@PathVariable("idFacture") Long idFacture,
			@RequestParam(required = false) String invoice_number,
			@RequestParam(required = false) Date invoice_date,
			@RequestParam(required = false) String payment_type,
			@RequestParam(required = false) String customer_name,
			@RequestParam(required = false) String customer_tin,
			@RequestParam(required = false) String customer_adress, 
			@RequestParam(required = false) String vat_customer_payer,
			@RequestParam(required = false) String cancelled_invoice_ref,
			@RequestParam(required = false) String invoice_signature, 
			@RequestParam(required = false) Date invoice_signature_date,
			@RequestParam(required = false) String invoice_items,
			@RequestParam(required = false) String item_designation, 
			@RequestParam(required = false) float item_quantity,
			@RequestParam(required = false) double item_price,
			@RequestParam(required = false) double item_ct, 
			@RequestParam(required = false) double item_tl,
			@RequestParam(required = false) double item_prive_nvat, 
			@RequestParam(required = false) double item_vat, 
			@RequestParam(required = false) double item_prive_wvat,
			@RequestParam(required = false) double item_total_amount,
			@RequestParam(required = false) String taxpayer)
	{
		facturesService.modifierFacture(idFacture,invoice_number,invoice_date,payment_type,customer_name,customer_tin,
				customer_adress,vat_customer_payer,cancelled_invoice_ref,invoice_signature,invoice_signature_date,invoice_items,
				item_designation,item_quantity,item_price,item_ct,item_tl,item_prive_nvat,item_vat,item_prive_wvat,item_total_amount,taxpayer);
	}
	
	

}
