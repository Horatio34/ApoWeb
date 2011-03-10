package Persistance;

import java.util.Vector;



// Contient les informations d'une UE (code, libelle, points ECTS, liste d'ECUE, liste de moyene des étudiant, liste des étudiant, liste des mentions etudiant)
public class UE extends Structure
{
	// ////////////////////////////
	// Déclaration des variables : //
	// ///////////////////////////
	
	private int ECTS_UE; // permet de stocker le nombre de points ECTS de l'UE
	private Vector<Struct_mention> liste_etudiant_mention; // stock la liste les mention des étudiants pour l'UE
	private Vector<Struct_note> liste_pts_jury; //Stock la liste des points jury des étudiants pour l'UE
	private Vector<ECUE> liste_ECUE; //stock la liste des ECUE rattachées à l'UE
	private String obligation; // Si obligation == "Obl" alors l'UE est obligatoire, si == "Facu" alors facultative;

	
	// /////////////////////////////
	// Constructor : //
	// ////////////////////////////

	public UE(String lib, String code, int ECTS) 
	{
		super(lib, code); //Appel du constructeur de la classe hérité
		this.ECTS_UE = ECTS;
		this.liste_ECUE =  new Vector<ECUE>();
		this.liste_etudiant_mention =  new Vector<Struct_mention>();
		this.liste_pts_jury =  new Vector<Struct_note>();
		this.obligation = "Obl";
	}
	

	// /////////////////////////////
	// Méthodes : //
	// ////////////////////////////
	
	//Permet de calculer l'ensmble des moyenne UE des étudiants de l'UE
	@SuppressWarnings("null")
	public void remplir_liste_etudiant_moyenne() 
	{
		float moyenne;
		float noteECUE;
		float coefECUE;
		float som_coef;
		Vector<Struct_note> Vect_Temp = null;
		Vector<Etudiant> list_etud = super.getListeEtudiant();
		
		for (int i = 0; i < list_etud.size(); i++) // parcours des étudiants
		{
			moyenne = 0; som_coef = 0 ;
			
			for (int j = 0; j < this.getListe_ECUE().size(); j++) // parcours des ECUE de l'UE
			{								
				noteECUE = (getListe_ECUE().get(j)).getNoteECUE(list_etud.get(i).getCode());
				coefECUE = (getListe_ECUE().get(j)).getCoef_ECUE();
				
				som_coef = som_coef + coefECUE;
				moyenne = moyenne + (noteECUE * coefECUE);
			}
			moyenne = moyenne / som_coef; // la moyenne a été calculée. Exemple: ConOb*0.3 + IngOb* 0.7
			
			Struct_note Sn = new Struct_note(list_etud.get(i), moyenne);
			Vect_Temp.add(Sn); // ajout de l'étudiant
		}
		this.setListe_etudiant_moyenne(Vect_Temp);
	}
	
	
	// Permet de remplir l'ensemble des mentions des étudiants de l'UE
	public void remplir_liste_etudiant_mention() 
	{	
		Vector<Etudiant> list_etud = super.getListeEtudiant();
		float moyenne;
		float pts_jury;
		
		for (int i = 0; i < list_etud.size(); i++)
		{
			moyenne = getMoyenneEtudiantUE(this.getListe_etudiant_moyenne().get(i).getEtud().getCode());
			pts_jury = getPtsJuryEtudiantUE(this.getListe_pts_jury().get(i).getEtud().getCode());
			
			if(pts_jury == 0)
			{
				if(moyenne >= 10)
				{
					this.getListe_etudiant_mention().get(i).setEtudiant(list_etud.get(i));
					this.getListe_etudiant_mention().get(i).setMention("ACQ");
				}
				else
				{
					this.getListe_etudiant_mention().get(i).setEtudiant(list_etud.get(i));
					this.getListe_etudiant_mention().get(i).setMention("NACQ");
				}
			}
			else
			{
				this.getListe_etudiant_mention().get(i).setEtudiant(list_etud.get(i));
				this.getListe_etudiant_mention().get(i).setMention("ACDJ");
			}
		}
	}
	
	
	// /////////////////////////////
	// Accesseurs : //
	// ////////////////////////////
	
	public void setListe_etudiant_moyenne(Vector<Struct_note> liste_etudiant_moyenne)
	{
		super.setListeMoyenne(liste_etudiant_moyenne);
	}
	public void setListe_pts_jury(Vector<Struct_note> liste_pts_jury)
	{
		this.liste_pts_jury = liste_pts_jury;
	}
	public void setECTS_UE(int eCTS_UE)
	{
		ECTS_UE = eCTS_UE;
	}	
	public void setListe_etudiant_mention(Vector<Struct_mention> liste_etudiant_mention)
	{
		this.liste_etudiant_mention = liste_etudiant_mention;
	}
	public void setObligation(String obl)
	{
		this.obligation = obl;
	}
	public void setListe_ECUE(Vector<ECUE> liste_ECUE)
	{
		this.liste_ECUE = liste_ECUE;
	}
	
	
	public int getECTS_UE()
	{
		return ECTS_UE;
	}
	public Vector<Struct_note> getListe_etudiant_moyenne()
	{
		return super.getListeMoyenne();
	}
	public Vector<Struct_mention> getListe_etudiant_mention()
	{
		return liste_etudiant_mention;
	}
	public Vector<Struct_note> getListe_pts_jury()
	{
		return liste_pts_jury;
	}	
	public Vector<ECUE> getListe_ECUE()
	{
		return liste_ECUE;
	}
	public String getObligation()
	{
		return this.obligation;
	}

	// Renvoie la moyenne de l'étudiant "code"
	public float getMoyenneEtudiantUE(String code)
	{
		return super.get_Note_Etudiant(code);
	}

	// Renvoie les points jury de l'étudiant "code"
	public float getPtsJuryEtudiantUE(String code)
	{
		int i=0;
		float pts = 0;
		Vector<Struct_note> liste_pts = this.getListe_pts_jury();
		
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
