package Persistance;
import java.util.Vector;

public class Etape extends Structure
{
	// ////////////////////////////
	// Déclaration des variables : //
	// ///////////////////////////
	
	private Vector<Semestre> liste_Semestres;
	private int ECTS_Etape; // permet de stocker le nombre de points ECTS de l'etape
	private Vector<Struct_mention> liste_Etudiant_Mention_Etape; // stock la liste les mention des étudiants pour  l'etape

	
	// /////////////////////////////
	// Constructor : //
	// ////////////////////////////

	public Etape(String lib, String code, int ECTS)
	{
		super(lib, code); //Appel du constructeur de la classe hérité
		this.ECTS_Etape = ECTS;
		this.liste_Semestres = new Vector<Semestre>();
		this.liste_Etudiant_Mention_Etape = new Vector<Struct_mention>();
	}


	// /////////////////////////////
	// Méthodes : //
	// ////////////////////////////

	// Renvoie le nombre de semestre de l'étape
	public int get_Nb_Semestre()
	{
		return this.liste_Semestres.size();
	}

	// Renvoie le nombre d'étudiant de la liste d'étudiant
	public int get_Nb_etudiant_Etape()
	{
		return super.get_Nb_Etudiant();
	}

	
	// /////////////////////////////
	// Accesseurs : //
	// ////////////////////////////


	public void setECTS_Etape(int ECTS_Et)
	{
		this.ECTS_Etape = ECTS_Et;
	}		
	public void setListe_Etudiant_Mention_Etape(Vector<Struct_mention> liste_etudiant_mention)
	{
		this.liste_Etudiant_Mention_Etape = liste_etudiant_mention;
	}
	public void setListe_Semestres(Vector<Semestre> liste)
	{
		this.liste_Semestres = liste;
	}
	public int getECTS_Etape()
	{
		return this.ECTS_Etape;
	}
	public Vector<Struct_mention> getListe_Etudiant_Mention_Etape()
	{
		return this.liste_Etudiant_Mention_Etape;
	}
	public Vector<Semestre> getListe_Semestres()
	{
		return this.liste_Semestres;
	}
}
