package com.obr.facturation.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obr.facturation.entities.ContribuableEntity;
import com.obr.facturation.entities.UtilisateurEntity;
import com.obr.facturation.repositories.ContribuablesRepository;

@Service
public class ContribuablesService {
	
	private ContribuablesRepository contribuablesRepository;
	
	@Autowired
	public ContribuablesService(ContribuablesRepository contribuablesRepository) {
		super();
		this.contribuablesRepository = contribuablesRepository;
	}

	
	public List<ContribuableEntity> getContribuablesModels() {
		
		return contribuablesRepository.findAll();
	}

	public Long newContribuable(ContribuableEntity contribuables) {
		Optional<ContribuableEntity> contribuablesOptional = contribuablesRepository
				.findContribuablesModelByNif(contribuables.getNif());
		if (contribuablesOptional.isPresent()) 
		{
			throw new IllegalStateException("Ce NIF Existe deja, Choisis un autre");
			
		}
		
		return contribuablesRepository.save(contribuables).getId();
	}


	public void supprimerContribuable(Long idContribuable) {
		boolean exists = contribuablesRepository.existsById(idContribuable);
		if (!exists) {
			throw new IllegalStateException(
					"Le Contribuable dont l'Id est " +idContribuable+ " n'existe pas"
					);
		}
		contribuablesRepository.deleteById(idContribuable);
		
	}

	@Transactional
	public void modifierContribuable(Long idContribuable, String tp_type, String tp_name, String nif,
			String tp_trade_number, String tp_postal_number, String tp_phone_number, String tp_adress_province,
			String tp_adress_commune, String tp_adress_quartier, String tp_adress_avenue, String tp_adress_rue,
			String tp_adress_number, String vat_taxpayer, String ct_taxpayer, String tl_taxpayer,
			String tp_fiscal_center, String tp_activity_sector, String tp_legal_form) 
	{
		ContribuableEntity contribuablesModel = contribuablesRepository.findById(idContribuable)
				.orElseThrow(() -> new IllegalStateException("L'Utilisateur dont l'Id est " +idContribuable+ " n'existe pas") );
		
		if (tp_type != null && tp_type.length() > 0 &&
				!Objects.equals(contribuablesModel.getTp_type(), tp_type)
				)
		{
			contribuablesModel.setTp_type(tp_type);
		}
		
		if (tp_name != null && tp_name.length() > 0 &&
				!Objects.equals(contribuablesModel.getTp_name(), tp_name)
				)
		{
			contribuablesModel.setTp_name(tp_name);
		}
		
		if (nif != null && nif.length() > 0 &&
				!Objects.equals(contribuablesModel.getNif(), nif)
				)
		{
			contribuablesModel.setNif(nif);
		}
		
		if (tp_trade_number != null && tp_trade_number.length() > 0 &&
				!Objects.equals(contribuablesModel.getTp_trade_number(), tp_trade_number)
				)
		{
			contribuablesModel.setTp_trade_number(tp_trade_number);
		}
		
		if (tp_postal_number != null && tp_postal_number.length() > 0 &&
				!Objects.equals(contribuablesModel.getTp_postal_number(), tp_postal_number)
				)
		{
			contribuablesModel.setTp_postal_number(tp_postal_number);
		}
		
		if (tp_phone_number != null && tp_phone_number.length() > 0 &&
				!Objects.equals(contribuablesModel.getTp_phone_number(), tp_phone_number)
				)
		{
			contribuablesModel.setTp_phone_number(tp_phone_number);
		}
		
		if (tp_adress_province != null && tp_adress_province.length() > 0 &&
				!Objects.equals(contribuablesModel.getTp_adress_province(), tp_adress_province)
				)
		{
			contribuablesModel.setTp_adress_province(tp_adress_province);
		}
		
		if (tp_adress_commune != null && tp_adress_commune.length() > 0 &&
				!Objects.equals(contribuablesModel.getTp_adress_commune(), tp_adress_commune)
				)
		{
			contribuablesModel.setTp_adress_commune(tp_adress_commune);
		}
		
		if (tp_adress_quartier != null && tp_adress_quartier.length() > 0 &&
				!Objects.equals(contribuablesModel.getTp_adress_quartier(), tp_adress_quartier)
				)
		{
			contribuablesModel.setTp_adress_quartier(tp_adress_quartier);
		}
		
		if (tp_adress_avenue != null && tp_adress_avenue.length() > 0 &&
				!Objects.equals(contribuablesModel.getTp_adress_avenue(), tp_adress_avenue)
				)
		{
			contribuablesModel.setTp_adress_avenue(tp_adress_avenue);
		}
		
		if (tp_adress_rue != null && tp_adress_rue.length() > 0 &&
				!Objects.equals(contribuablesModel.getTp_adress_rue(), tp_adress_rue)
				)
		{
			contribuablesModel.setTp_adress_rue(tp_adress_rue);
		}
		
		if (tp_adress_number != null && tp_adress_number.length() > 0 &&
				!Objects.equals(contribuablesModel.getTp_adress_number(), tp_adress_number)
				)
		{
			contribuablesModel.setTp_adress_number(tp_adress_number);
		}
		
		if (vat_taxpayer != null && vat_taxpayer.length() > 0 &&
				!Objects.equals(contribuablesModel.getVat_taxpayer(), vat_taxpayer)
				)
		{
			contribuablesModel.setVat_taxpayer(vat_taxpayer);
		}
		
		if (ct_taxpayer != null && ct_taxpayer.length() > 0 &&
				!Objects.equals(contribuablesModel.getCt_taxpayer(), ct_taxpayer)
				)
		{
			contribuablesModel.setCt_taxpayer(ct_taxpayer);
		}
		
		if (tl_taxpayer != null && tl_taxpayer.length() > 0 &&
				!Objects.equals(contribuablesModel.getTl_taxpayer(), tl_taxpayer)
				)
		{
			contribuablesModel.setTl_taxpayer(tl_taxpayer);
		}
		
		if (tp_fiscal_center != null && tp_fiscal_center.length() > 0 &&
				!Objects.equals(contribuablesModel.getTp_fiscal_center(), tp_fiscal_center)
				)
		{
			contribuablesModel.setTp_fiscal_center(tp_fiscal_center);
		}
		
		if (tp_activity_sector != null && tp_activity_sector.length() > 0 &&
				!Objects.equals(contribuablesModel.getTp_activity_sector(), tp_activity_sector)
				)
		{
			contribuablesModel.setTp_activity_sector(tp_activity_sector);
		}
		
		if (tp_legal_form != null && tp_legal_form.length() > 0 &&
				!Objects.equals(contribuablesModel.getTp_legal_form(), tp_legal_form)
				)
		{
			contribuablesModel.setTp_legal_form(tp_legal_form);
		}
		
		
		
	}


}
