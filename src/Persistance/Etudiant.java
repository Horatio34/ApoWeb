package Persistance;
//Classe contenant les informations sur un étudiant.
public class Etudiant 
{
	//////////////////////////////
	//Déclaration des variables :     //
	/////////////////////////////
	
	private String code_Etudiant;
	private String nom_Etudiant;
	private String prenom_Etudiant;
	
	///////////////////////////////
	//Constructeur :                        //
	//////////////////////////////
	
	public Etudiant(String code, String nom, String prenom)
	{
		this.code_Etudiant = code;
		this.nom_Etudiant = nom;
		this.prenom_Etudiant = prenom;
	}
	
	///////////////////////////////
	//Accesseurs :                           //
	//////////////////////////////
	
	public String getCode()
	{
		return this.code_Etudiant;
	}
	public String getNom()
	{
		return this.nom_Etudiant;
	}
	public String getPrenom()
	{
		return this.prenom_Etudiant;
	}
	public void setCode(String code)
	{
		this.code_Etudiant = code;
	}
	public void setNom(String nom)
	{
		this.nom_Etudiant = nom;
	}
	public void setPrenom(String prenom)
	{
		this.prenom_Etudiant = prenom;
	}
}
