package Persistance;
import java.util.Vector;

import javax.swing.Spring;

//classe stockant les informations d'un semestre
public class Semestre extends Structure
{
	// ////////////////////////////
	// Déclaration des variables : //
	// ///////////////////////////

	private Vector<UE> liste_UE;
	private int ECTS_Semestre; // permet de stocker le nombre de points ECTS du semestre
	private Vector<Struct_mention> liste_etudiant_mention_sem; // stock la liste les mention des étudiants pour  le semestre
	private Vector<Struct_note> liste_pts_jury_sem; //Stock la liste des points jury des étudiants pour lle semestre


	// /////////////////////////////
	// Constructor : //
	// ////////////////////////////

	public Semestre(String lib, String code, int ECTS) 
	{
		super(lib, code); //Appel du constructeur de la classe hérité
		this.ECTS_Semestre = ECTS;
		this.liste_UE =  new Vector<UE>();
		this.liste_etudiant_mention_sem =  new Vector<Struct_mention>();
		this.liste_pts_jury_sem =  new Vector<Struct_note>();
	}


	// /////////////////////////////
	// Méthodes : //
	// ////////////////////////////

	// Renvoie le nombre d'UE du semestre
	public int get_Nb_Semestre()
	{
		return this.liste_UE.size();
	}

	// Renvoie le nombre d'étudiant de la liste d'étudiant du semestre
	public int get_Nb_etudiant_Etape()
	{
		return super.get_Nb_Etudiant();
	}




	public String getMoyenneEtud(String code)
	{
		String moy = "";
		float temp = 0;

		for (int i = 0 ; i < this.getListe_etudiant_moyenne_semestre().size(); i++){

			if (this.getListe_etudiant_moyenne_semestre().get(i).getEtud().getCode()== code){

				temp = this.getListe_etudiant_moyenne_semestre().get(i).getNote();
			}


		}
		moy = Float.toString(temp);

		return moy;
	}



	//Permet de calculer l'ensmble des moyenne UE des étudiants de l'UE
	public void remplir_liste_etudiant_moyenne_sem () 
	{
		float moyenne;
		float noteUE;
		float coefUE;
		float som_coef;
		Vector<Struct_note> Vect_Temp = new Vector<Struct_note>();
		Vector<Etudiant> list_etud = super.getListeEtudiant();

		for (int i = 0; i < list_etud.size(); i++) // parcours des étudiants
		{
			moyenne = 0; som_coef = 0 ;

			for (int j = 0; j < this.getListe_UE().size(); j++) // parcours des ECUE de l'UE
			{								
				noteUE = (this.getListe_UE().get(j)).getMoyenneEtudiantUE(list_etud.get(i).getCode());
				coefUE = (this.getListe_UE().get(j)).getECTS_UE();

				som_coef = som_coef + coefUE;
				moyenne = moyenne + (noteUE * coefUE);
			}
			moyenne = moyenne / som_coef; // la moyenne a été calculée. Exemple: ConOb*0.3 + IngOb* 0.7

			Struct_note Sn = new Struct_note(list_etud.get(i), moyenne);
			Vect_Temp.add(Sn); // ajout de l'étudiant
		}
		super.setListeMoyenne(Vect_Temp);
	}

	//TODO
	// Permet de remplir l'ensemble des mentions des étudiants du semestre
	public void remplir_liste_etudiant_mention() 
	{	
		Vector<Etudiant> list_etud = super.getListeEtudiant();

		float moyenne = 0;
		float pts_jury = 0;

		for (int i = 0; i < list_etud.size(); i++)
		{
			moyenne = super.get_Note_Etudiant(list_etud.get(i).getCode());
			pts_jury = this.get_Pts_Jury_Etudiant_Sem(list_etud.get(i).getCode());

			if(pts_jury == 0)
			{
				if(moyenne >= 10)
				{
					this.getListe_etudiant_mention_sem().get(i).setEtudiant(list_etud.get(i));
					this.getListe_etudiant_mention_sem().get(i).setMention("ACQ");
				}
				else
				{
					this.getListe_etudiant_mention_sem().get(i).setEtudiant(list_etud.get(i));
					this.getListe_etudiant_mention_sem().get(i).setMention("NACQ");
				}
			}
			else
			{
				this.getListe_etudiant_mention_sem().get(i).setEtudiant(list_etud.get(i));
				this.getListe_etudiant_mention_sem().get(i).setMention("ACDJ");
			}
		}
	}


	// /////////////////////////////
	// Accesseurs : //
	// ////////////////////////////

	public void setECTS_Sem(int ECTS_Sem)
	{
		this.ECTS_Semestre = ECTS_Sem;
	}	
	public void setListe_pts_jury_sem(Vector<Struct_note> liste_pts_jury)
	{
		this.liste_pts_jury_sem = liste_pts_jury;
	}	
	public void setListe_etudiant_mention_sem(Vector<Struct_mention> liste_etudiant_mention)
	{
		this.liste_etudiant_mention_sem = liste_etudiant_mention;
	}
	public void setListe_UE(Vector<UE> liste)
	{
		this.liste_UE = liste;
	}
	public void setListe_etudiant_moyenne_semestre(Vector<Struct_note> liste)
	{
		super.setListeMoyenne(liste);
	}


	public int getECTS_Sem()
	{
		return this.ECTS_Semestre;
	}	
	public Vector<Struct_note> getListe_pts_jury_sem()
	{
		return this.liste_pts_jury_sem;
	}	
	public Vector<Struct_mention> getListe_etudiant_mention_sem()
	{
		return this.liste_etudiant_mention_sem;
	}
	public Vector<UE> getListe_UE()
	{
		return this.liste_UE;
	}
	public Vector<Struct_note> getListe_etudiant_moyenne_semestre()
	{
		return super.getListeMoyenne();
	}
	// Renvoie les points jury de l'étudiant "code"
	public float get_Pts_Jury_Etudiant_Sem(String code)
	{
		int i=0;
		float pts = 0;
		Vector<Struct_note> liste_pts = this.getListe_pts_jury_sem();
		
		while (i < liste_pts.size() && pts == 0)
		{
			if (liste_pts.get(i).getEtud().getCode() == code)
			{
				pts =  liste_pts.get(i).getNote();
			}
			i++;
		}
		return pts;
	}
}
