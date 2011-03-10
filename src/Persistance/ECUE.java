package Persistance;

import java.util.Vector;

//Classe contenant les informations d'une ECUE, plus la liste d'élève et de leurs notes dans l'ECUE (liste à null si pas encore de notes).
public class ECUE extends Structure 
{ 
	// /////////////////////////////
	// Variables :                             //
	// ////////////////////////////
	
	private float coef_ECUE; // Stock le coefficient de l'ECUE
	

	// /////////////////////////////
	// Constructeur :                        //
	// ////////////////////////////

	// Constructeur de la classe, demande un code,_ECUE, un coefficient, un libelle; initialise la liste de note par étudiant à NULL;
	public ECUE(String code, String libelle, float coef) 
	{
		super(code, libelle);
		this.coef_ECUE = coef;
	}

	
	// /////////////////////////////
	// Accesseurs : //
	// ////////////////////////////

	public float getCoef_ECUE() 
	{
		return coef_ECUE;
	}

	public void setCoef_ECUE(float coef_ECUE) 
	{
		this.coef_ECUE = coef_ECUE;
	}


	// /////////////////////////////
	// Methods : //
	// ////////////////////////////

	//Ajoute une structure note (code_etudiant, note_etudiant) à la liste de note de l'ECUE
	public void add_Liste_etudiant_note(Struct_note note) 
	{
		super.add_Note(note);
	}

	//Ajoute ou modifie la note "note" de l'étudiant "code" à la liste de note de l'ECUE.
	public void set_note_Liste_etudiant_note(String code, float note)
	{
		super.set_Note_Etudiant(code, note);
	}

	//Renvoie la note de l'etudiant "code" pour l'ECUE en cours.
	public float getNoteECUE(String code)
	{
		return super.get_Note_Etudiant(code);
	}
}
