package Persistance;


import java.sql.*;
import java.util.Vector;

public class SaveBD{

	Etape etape;
	public Etape getEtape() {
		return etape;
	}

	public void setEtape(Etape etape) {
		this.etape = etape;
	}

	Semestre semestre;
	UE ue;
	ECUE ecue;
	
    String sQuery;
	
	
    /**
	 * Constructeur de la classe SaveBD
	 */
    public SaveBD(String requete, String type){
    	ResultSet rs = creationRequete(requete);
    	
    	if (rs != null)
	    	if (type == "Chargement")
	    	{
	    		chargementEtape(rs);
	    	}
    	
    }
    
    public ResultSet creationRequete(String requete)
    {
	   	 this.sQuery=requete;
	     Statement sStat=null;
	     Connection cCon=null;
	     
	     ResultSet rs = null;
	     
	     try{
	         Class cDriverOracle=Class.forName("oracle.jdbc.driver.OracleDriver");
	         Driver dDriverOracle=(java.sql.Driver)cDriverOracle.newInstance();
	         DriverManager.registerDriver(dDriverOracle);
	         cCon=DriverManager.getConnection("jdbc:oracle:thin:@v240.ig.polytech.univ-montp2.fr:1521:ORA10","quentin.dejean","oracle");
	     }
	     catch(Exception e)
	     {
	         System.out.println("--Pbm en chargeant le driver JDBC oracle--");
	         e.printStackTrace();
	     }	
	     
         try
         {
             sStat=cCon.createStatement();
             rs=sStat.executeQuery(sQuery);
             
             //sStat.close();
         }
         catch(Exception sqlE)
         {
             System.out.println("La Requ�te n'a pas abouti");
             sqlE.printStackTrace();
         }
         
         return rs;
    }
    
    public void chargementEtape(ResultSet rs)
    {
    	
    	// Chargement de l'Žtape :
    	try {
			while(rs.next()){
				etape = new Etape(rs.getObject(2).toString(),rs.getObject(1).toString(), Integer.parseInt(rs.getObject(3).toString()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Toujours dans l'Žtape, chargement des listes d'Žtudiants qui font partie de la structure
 		String requete = "select e.code_etudiant, e.nom, e.prenom, ed.moyenne_etape " +
		"from etudiant e, est_dans ed " +
		"where ed.code_etape = '" + etape.getCode() + "' and ed.code_etudiant = e.code_etudiant";
		
		rs = creationRequete(requete);
		
		if (rs != null)
			chargementEtudiants(rs, etape.getListeEtudiant(), etape.getListeMoyenne());
		
		// Dernier chargement de l'Žtape : la liste des mentions
 		requete = "select e.code_etudiant, e.nom, e.prenom, ed.decision_jury_etape " +
		"from etudiant e, est_dans ed " +
		"where ed.code_etape = '" + etape.getCode() + "' and ed.code_etudiant = e.code_etudiant";
		
 		rs = creationRequete(requete);
 		
 		if (rs != null)
 		{
 			chargementMentionsEtudiant(rs, etape.getListe_Etudiant_Mention_Etape());
 		} 		
 		// Chargement des semestres :
 		requete = "select s.code_semestre, s.libelle_semestre, s.ects_semestre " +
				"from semestre s " +
				"where s.code_etape = '" + etape.getCode() + "'";
		
 		rs = creationRequete(requete);

 		chargementSemestre(rs);		
    }
    
    public void chargementSemestre(ResultSet rs)
    {
    	try {
			//rs.next();
			while(rs.next()){
				semestre = new Semestre (rs.getObject(2).toString(),rs.getObject(1).toString(), Integer.parseInt(rs.getObject(3).toString()));
				etape.getListe_Semestres().add(semestre);
				
				// Chargement des listes d'Žtudiants qui font partie de la structure
		 		String requete = "select e.code_etudiant, e.nom, e.prenom, ed.moyenne_semestre " +
				"from etudiant e, passe_un ed " +
				"where ed.code_semestre =  '" + semestre.getCode() + "' and ed.code_etudiant = e.code_etudiant";
				
		 		ResultSet new_rs = creationRequete(requete);
				
				if (new_rs != null)
					chargementEtudiants(new_rs, semestre.getListeEtudiant(), semestre.getListeMoyenne());
				
				// Dernier chargement de l'Žtape : la liste des mentions et des points jurys
		 		requete = "select e.code_etudiant, e.nom, e.prenom, ed.point_jury_semestre, ed.decision_jury_semestre " +
				"from etudiant e, passe_un ed " +
				"where ed.code_semestre = '" + semestre.getCode() + "' and ed.code_etudiant = e.code_etudiant";
		 		
		 		new_rs = creationRequete(requete);
		 		if (new_rs != null)
		 			chargementMentionsMatieres(new_rs, semestre.getListe_pts_jury_sem(), semestre.getListe_etudiant_mention_sem());
		 		
		 		
		 		// Chargement des UE :
		 		String new_requete = "select s.code_UE, s.libelle_UE, s.ects_UE, s.obligatoire " +
						"from UE s " +
						"where s.code_semestre = '" + semestre.getCode()+ "'";
		 		
		 		new_rs = creationRequete(new_requete);

		 		chargementUE(new_rs, semestre);
		 			
		 		
			}
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void chargementUE(ResultSet rs, Semestre semestre)
    {
    	try {
			//rs.next();
			while(rs.next()){
				ue = new UE (rs.getObject(2).toString(),rs.getObject(1).toString(), Integer.parseInt(rs.getObject(3).toString()));
				semestre.getListe_UE().add(ue);
				
				// Chargement des listes d'Žtudiants qui font partie de la structure
		 		String requete = "select e.code_etudiant, e.nom, e.prenom, ed.moyenne_ue, ed.point_jury_ue " +
				"from etudiant e, est_inscrit_dans ed " +
				"where ed.code_ue = '" + ue.getCode() + "' and ed.code_etudiant = e.code_etudiant";
				
		 		ResultSet new_rs = creationRequete(requete);
				
				if (new_rs != null)
					chargementEtudiants(new_rs, ue.getListeEtudiant(), ue.getListeMoyenne());
				
				// Dernier chargement de l'Žtape : la liste des mentions et des points jurys
		 		requete = "select e.code_etudiant, e.nom, e.prenom, ed.point_jury_ue, ed.decision_jury_ue " +
				"from etudiant e, est_inscrit_dans ed " +
				"where ed.code_ue = '" + ue.getCode() + "' and ed.code_etudiant = e.code_etudiant";
		 		
		 		new_rs = creationRequete(requete);
		 		if (new_rs != null)
		 			chargementMentionsMatieres(new_rs, ue.getListe_pts_jury(), ue.getListe_etudiant_mention());
		 		
		 		
		 		// Chargement des UE :
		 		String new_requete = "select s.code_ECUE, s.libelle_ECUE, s.ects_ECUE " +
						"from ECUE s " +
						"where s.code_ue = '" + ue.getCode()+ "'";
		 		
		 		new_rs = creationRequete(new_requete);

		 		chargementECUE(new_rs, ue);
			}
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void chargementECUE(ResultSet rs, UE ue)
    {
    	try {
			//rs.next();
			while(rs.next()){
				ecue = new ECUE (rs.getObject(1).toString(),rs.getObject(2).toString(), rs.getFloat(3));
				ue.getListe_ECUE().add(ecue);					
				
				// Chargement des listes d'Žtudiants qui font partie de la structure
		 		String requete = "select e.code_etudiant, e.nom, e.prenom, ed.note_ecue, ed.note_rattrapage_ecue " +
				"from etudiant e, est_note_dans ed " +
				"where ed.code_ecue = '" + ecue.getCode() + "' and ed.code_etudiant = e.code_etudiant";
				
		 		ResultSet new_rs = creationRequete(requete);
				
				if (new_rs != null)
					chargementEtudiants(new_rs, ecue.getListeEtudiant(), ecue.getListeMoyenne());
			}
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public void chargementEtudiants(ResultSet rs, Vector<Etudiant> liste_Etudiants, Vector<Struct_note> liste_Moyennes)
    {
    	try {
			//rs.next();
			Etudiant etudiant;
			float moyenne_etudiant;
			while(rs.next())
			{
				etudiant = new Etudiant(rs.getObject(1).toString(),rs.getObject(2).toString(), rs.getObject(3).toString());
				moyenne_etudiant = rs.getFloat(4);

				Struct_note struct = new Struct_note(etudiant, moyenne_etudiant);
				liste_Etudiants.add(etudiant);
				liste_Moyennes.add(struct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void chargementMentionsEtudiant(ResultSet rs, Vector<Struct_mention> liste_Mentions)
    {
    	try {
			//rs.next();
			Etudiant etudiant;
			String mention_etudiant;
			while(rs.next())
			{
				etudiant = new Etudiant(rs.getObject(2).toString(),rs.getObject(1).toString(), rs.getObject(3).toString());
				mention_etudiant = rs.getObject(4).toString();
				
				Struct_mention struct = new Struct_mention(etudiant, mention_etudiant);
				liste_Mentions.add(struct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void chargementMentionsMatieres(ResultSet rs, Vector<Struct_note> liste_pts_jury_sem, Vector<Struct_mention> liste_Mentions)
    {
    	try {
			//rs.next();
			Etudiant etudiant;
			String mention_etudiant;
			float points_jurys;
			
			while(rs.next())
			{
				etudiant = new Etudiant(rs.getObject(2).toString(),rs.getObject(1).toString(), rs.getObject(3).toString());
				
				points_jurys = rs.getFloat(4);
				mention_etudiant = rs.getObject(5).toString();

				Struct_note struct_note = new Struct_note(etudiant, points_jurys);
				Struct_mention struct = new Struct_mention(etudiant, mention_etudiant);
				liste_Mentions.add(struct);
				liste_pts_jury_sem.add(struct_note);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}