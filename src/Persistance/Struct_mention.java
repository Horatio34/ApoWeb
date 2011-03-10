package Persistance;



//Cette classe structure permet de créer un couple {Code_etudiant, metion_etudiant} permettant aux classe UE, semestre et étape de renvoyer l'admission, la non admission ou l'ACDJ des élèves.
public class Struct_mention 
{
	//////////////////////////////
	//Déclaration des variables :     //
	/////////////////////////////
	
	private Etudiant monEtud; //Un objet Etudiant
	private String mention; //Un objet de type mention (acquis, non acquis, ACDJ)
	
	///////////////////////////////
	//Constructeur :                        //
	//////////////////////////////
	
	public Struct_mention( Etudiant e, String m)
	{
		this.monEtud = e;
		this.mention = m;
	}
	
	///////////////////////////////
	//Accesseurs :                           //
	//////////////////////////////
	
	public Etudiant getEtudiant()
	{
		return this.monEtud;
	}
	
	public String getMention()
	{
		return this.mention;
	}
	
	public void setEtudiant(Etudiant e)
	{
		this.monEtud = e;
	}
	
	public void setMention(String m)
	{
		this.mention = m;
	}
}
