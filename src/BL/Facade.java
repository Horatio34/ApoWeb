package BL;

import Persistance.Etape;

public class Facade 
{
	// //////////////////////////////
	// Variables :    			  //
	// ////////////////////////////
	
	private ProcessPV PV;
	private Load chargeur;
	private String code_Etape;
	private String chargement;
	private Etape etape_Facade;
	
	
	// //////////////////////////////
	// Constructeur : 			  //
	// ////////////////////////////
	
	public Facade(String code, String chargement)
	{
		this.code_Etape = code;
		this.setChargement(chargement);
		
		creer_Environnement();
	}
	
	
	// //////////////////////////////
	// Méthodes :    			  //
	// ////////////////////////////

	public void creer_Environnement()
	{
		this.chargeur = new Load("", this.chargement, this.code_Etape);
		this.etape_Facade = this.chargeur.getEtapeLoad();
		this.PV = new ProcessPV(this.etape_Facade);
	}
	
	
	// //////////////////////////////
	// Accesseurs : 			  //
	// ////////////////////////////
	
	public void setCode_Etape(String code_Etape) 
	{
		this.code_Etape = code_Etape;
	}

	public String getCode_Etape() 
	{
		return code_Etape;
	}

	public void setChargeur(Load chargeur) 
	{
		this.chargeur = chargeur;
	}

	public Load getChargeur() 
	{
		return this.chargeur;
	}

	public void setPV(ProcessPV pV)
	{
		this.PV = pV;
	}

	public ProcessPV getPV() 
	{
		return this.PV;
	}


	public void setChargement(String chargement) 
	{
		this.chargement = chargement;
	}


	public String getChargement()
	{
		return chargement;
	}


	public void setEtape_Facade(Etape etape_Facade) 
	{
		this.etape_Facade = etape_Facade;
	}


	public Etape getEtape_Facade() 
	{
		return this.etape_Facade;
	}

}
