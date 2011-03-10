package BL;
import Persistance.Etape;

//Classe permettant la consultation et l'impression duPV
public class ProcessPV 
{
	private Etape Etape_PV; // Etape pour laquelle on va rechercher le PV;
	
	
	// /////////////////////////////
	// Constructor : //
	// ////////////////////////////

	public ProcessPV(Etape et) 
	{
		this.Etape_PV = et;
	}
	
	
	// /////////////////////////////
	// Méthode : 		     //
	// ////////////////////////////
	/*
	public Vector<Struct_note> get_Note_ECUE_Etudiant(String code_Ecue String code_Etudiant)
	{
		//cherche et renvoie la note de l'étudiant code_etudiant pour l'ecue ecue
	}
	public Vector<Struct_note> get_Note_UE_Etudiant(String code_Ue, String code_Etudiant)
	{
		//cherche et renvoie la note moyenne de l'étudiant pour l'UE
	}
	public Vector<Struct_note> get_Note_Semestre_Etudiant(String code_Semestre, String code_Etudiant)
	{
		// Cherche et renvoie la note moyenne de l'étudiant pour le semestre
	}
	public Vector<Struct_note> get_All_Note_ECUE(String code_Ecue)
	{
		// Cherche et renvoie la liste de toutes les moyennes étudiant de l'ECUE "code_Ecue"
	}
	public Vector<Struct_note> get_All_Note_UE(String code_UE)
	{
		// Cherche et renvoie la liste de toutes les moyennes étudiant de l'UE "code_UE"
	}
	public Vector<Struct_note> get_All_Note_Semestre(String code_Semestre)
	{
		// Cherche et renvoie la liste de toutes les moyennes étudiant du semestre "code_Semestre"
	}
	*/
	
	
	// /////////////////////////////
	// Accesseurs : //
	// ////////////////////////////
	
	public Etape get_Etape_PV()
	{
		return this.Etape_PV;
	}
	public void set_Code_Etape_PV(Etape et)
	{
		this.Etape_PV = et;
	}		
}
