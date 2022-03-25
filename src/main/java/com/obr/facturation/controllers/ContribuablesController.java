package com.obr.facturation.controllers;

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

import com.obr.facturation.entities.ContribuableEntity;
import com.obr.facturation.entities.UtilisateurEntity;
import com.obr.facturation.services.ContribuablesService;

@RestController
@RequestMapping(path = "/contribuables")
public class ContribuablesController {
	
	private ContribuablesService contribuablesService;
	
	@Autowired
	public ContribuablesController(ContribuablesService contribuablesService) {
		super();
		this.contribuablesService = contribuablesService;
	}


	@GetMapping("/voir")
	public List<ContribuableEntity> getContribuablesModels()
	{
		return contribuablesService.getContribuablesModels();
		
	}
	
	@PostMapping("/new")
	public Long ajouterContribuabled(@RequestBody ContribuableEntity contribuables) {
		return contribuablesService.newContribuable(contribuables);
	}
	
	@DeleteMapping(path = "{idContribuable}")
	public void supprimerContribuable(@PathVariable("idContribuable") Long idContribuable) {
		contribuablesService.supprimerContribuable(idContribuable);
	}
	
	@PutMapping(path = "{idContribuable}")
	public void modifierContribuable(@PathVariable("idContribuable") Long idContribuable,
			@RequestParam(required = false) String tp_type,
			@RequestParam(required = false) String tp_name,
			@RequestParam(required = false) String nif,
			@RequestParam(required = false) String tp_trade_number,
			@RequestParam(required = false) String tp_postal_number,
			@RequestParam(required = false) String tp_phone_number, 
			@RequestParam(required = false) String tp_adress_province,
			@RequestParam(required = false) String tp_adress_commune,
			@RequestParam(required = false) String tp_adress_quartier, 
			@RequestParam(required = false) String tp_adress_avenue,
			@RequestParam(required = false) String tp_adress_rue,
			@RequestParam(required = false) String tp_adress_number, 
			@RequestParam(required = false) String vat_taxpayer,
			@RequestParam(required = false) String ct_taxpayer,
			@RequestParam(required = false) String tl_taxpayer, 
			@RequestParam(required = false) String tp_fiscal_center,
			@RequestParam(required = false) String tp_activity_sector, 
			@RequestParam(required = false) String tp_legal_form)
	{
		contribuablesService.modifierContribuable(idContribuable,tp_type,tp_name,nif,tp_trade_number,tp_postal_number,
				tp_phone_number,tp_adress_province,tp_adress_commune,tp_adress_quartier,tp_adress_avenue,tp_adress_rue,
				tp_adress_number,vat_taxpayer,ct_taxpayer,tl_taxpayer,tp_fiscal_center,tp_activity_sector,tp_legal_form);
	}

}
