package Persistance;

//Classe permettant de stocker une note et un etudiant, la note correspondant à la note de l'étudiant pour une ECUE, une UE, un semestre ou une etape.
public class Struct_note 
{
	//////////////////////////////
	//Déclaration des variables :     //
	/////////////////////////////
	
	private Etudiant monEtud; // Un objet étudiant 
	private float maNote; // La note de l'étudiant
	
	///////////////////////////////
	//Constructeur :                        //
	//////////////////////////////
	
	public Struct_note(Etudiant e, float f)
	{
		this.monEtud = e;
		this.maNote = f;
	}
	
	///////////////////////////////
	//Accesseurs :                           //
	//////////////////////////////
	
	public float getNote()
	{
		return this.maNote;
	}
	public Etudiant getEtud()
	{
		return this.monEtud;
	}
	public void setNote(float f)
	{
		this.maNote = f;
	}
	public void setEtud(Etudiant e)
	{
		this.monEtud = e;
	}
}
	

