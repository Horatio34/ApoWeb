/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJDialog.java
 *
 * Created on 8 mars 2011, 20:58:37
 */

package Interface;

import java.util.Vector;


import Persistance.Etape;
import Persistance.Etudiant;

/**
 * 
 * @author Ralph
 */
public class Facade_PV extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates new form NewJDialog */
	public Facade_PV(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	public Facade_PV(Etape E, java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		this.Etape_for_PV = E;
		initComponents();

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		// Static fields
		jTextField1 = new javax.swing.JTextField();
		jTextField1.setText("Promo choisie");
		jTextField2 = new javax.swing.JTextField();
		jTextField2.setText(this.getEtape_facade().getLibelle());

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		// Static Panel 1
		jPanel1 = new javax.swing.JPanel();
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);

		jTextField3 = new javax.swing.JTextField();
		jTextField3.setText("Nom");
		jTextField5 = new javax.swing.JTextField();
		jTextField5.setText("Pr�nom");
		jTextField6 = new javax.swing.JTextField();
		jTextField6.setText("Moyenne Semestre");

		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jTextField3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												61,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTextField5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												71,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTextField6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												78,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(16, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(19, 19, 19)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField5,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField6,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		// Static Panel 2

		jPanel3 = new javax.swing.JPanel();
		jTextField7 = new javax.swing.JTextField();
		jTextField7.setText("ECTS");
		jTextField8 = new javax.swing.JTextField();
		jTextField8.setText("Coefficient");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(
																jTextField8,
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jTextField7,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																222,
																Short.MAX_VALUE))
										.addContainerGap(16, Short.MAX_VALUE)));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addComponent(
												jTextField7,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTextField8,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		// Dynamic Panel STRUCTURE initializing
		/*
		 * Etape Etape_Temp = getEtape_facade(); int compteur_for_item = 100;
		 */

		for (int i = 0; i < getEtape_facade().getListe_Semestres().size(); i++) {
			// on cr�e autant de panel que de semestre � afficher
			jPanel5 = new javax.swing.JPanel();
			jTextField10 = new javax.swing.JTextField();
			jTextField10.setText("Sesmestre " + i + 1);

			for (int j = 0; j < getEtape_facade().getListe_Semestres().get(i)
					.getListe_UE().size(); j++) {
				// Pour chacun des panels semestres, on les remplit avec leurs
				// UE
				jPanel2 = new javax.swing.JPanel();
				jTextField4 = new javax.swing.JTextField();
				jTextField4.setText("UE");
				jTextField11 = new javax.swing.JTextField();
				jTextField11.setText("ECTS_UE");
				jTextField13 = new javax.swing.JTextField();
				jTextField13.setText("Coeff_UE");

				for (int k = 0; k < getEtape_facade().getListe_Semestres()
						.get(i).getListe_UE().get(j).getListe_ECUE().size(); k++) {
					// On remplit chacune des UE avec leurs ECUE.

					jPanel4 = new javax.swing.JPanel();
					jTextField9 = new javax.swing.JTextField();
					jTextField9.setText("ECUE");
					jTextField12 = new javax.swing.JTextField();
					jTextField12.setText("Coeff ECUE");

					javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
							jPanel4);
					jPanel4.setLayout(jPanel4Layout);
					jPanel4Layout
							.setHorizontalGroup(jPanel4Layout
									.createParallelGroup(
											javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(
											jPanel4Layout
													.createSequentialGroup()
													.addGroup(
															jPanel4Layout
																	.createParallelGroup(
																			javax.swing.GroupLayout.Alignment.TRAILING,
																			false)
																	.addComponent(
																			jTextField9,
																			javax.swing.GroupLayout.Alignment.LEADING)
																	.addComponent(
																			jTextField12,
																			javax.swing.GroupLayout.Alignment.LEADING,
																			javax.swing.GroupLayout.DEFAULT_SIZE,
																			76,
																			Short.MAX_VALUE))
													.addContainerGap(74,
															Short.MAX_VALUE)));
					jPanel4Layout
							.setVerticalGroup(jPanel4Layout
									.createParallelGroup(
											javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(
											javax.swing.GroupLayout.Alignment.TRAILING,
											jPanel4Layout
													.createSequentialGroup()
													.addComponent(
															jTextField9,
															javax.swing.GroupLayout.PREFERRED_SIZE,
															20,
															javax.swing.GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															javax.swing.LayoutStyle.ComponentPlacement.RELATED,
															29, Short.MAX_VALUE)
													.addComponent(
															jTextField12,
															javax.swing.GroupLayout.PREFERRED_SIZE,
															javax.swing.GroupLayout.DEFAULT_SIZE,
															javax.swing.GroupLayout.PREFERRED_SIZE)
													.addContainerGap()));

				}

				javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
						jPanel2);
				jPanel2.setLayout(jPanel2Layout);
				jPanel2Layout
						.setHorizontalGroup(jPanel2Layout
								.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(
										javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel2Layout
												.createSequentialGroup()
												.addGroup(
														jPanel2Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING)
																.addGroup(
																		jPanel2Layout
																				.createSequentialGroup()
																				.addContainerGap()
																				.addGroup(
																						jPanel2Layout
																								.createParallelGroup(
																										javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(
																										jTextField13,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										68,
																										Short.MAX_VALUE)
																								.addComponent(
																										jTextField11,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										68,
																										Short.MAX_VALUE))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																				.addComponent(
																						jPanel4,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGap(29,
																						29,
																						29))
																.addComponent(
																		jTextField4,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		267,
																		Short.MAX_VALUE))
												.addGap(20, 20, 20)));
				jPanel2Layout
						.setVerticalGroup(jPanel2Layout
								.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(
										jPanel2Layout
												.createSequentialGroup()
												.addComponent(
														jTextField4,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														jPanel2Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING)
																.addGroup(
																		jPanel2Layout
																				.createSequentialGroup()
																				.addGap(30,
																						30,
																						30)
																				.addComponent(
																						jTextField11,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGap(5,
																						5,
																						5)
																				.addComponent(
																						jTextField13,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addContainerGap())
																.addGroup(
																		jPanel2Layout
																				.createSequentialGroup()
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(
																						jPanel4,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)))));

			}

			javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
					jPanel5);
			jPanel5.setLayout(jPanel5Layout);
			jPanel5Layout
					.setHorizontalGroup(jPanel5Layout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									jPanel5Layout
											.createSequentialGroup()
											.addGroup(
													jPanel5Layout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING)
															.addComponent(
																	jTextField10,
																	javax.swing.GroupLayout.PREFERRED_SIZE,
																	javax.swing.GroupLayout.DEFAULT_SIZE,
																	javax.swing.GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	jPanel2,
																	javax.swing.GroupLayout.PREFERRED_SIZE,
																	javax.swing.GroupLayout.DEFAULT_SIZE,
																	javax.swing.GroupLayout.PREFERRED_SIZE))
											.addContainerGap(646,
													Short.MAX_VALUE)));
			jPanel5Layout
					.setVerticalGroup(jPanel5Layout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									jPanel5Layout
											.createSequentialGroup()
											.addComponent(
													jTextField10,
													javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(
													javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(
													jPanel2,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)));

		}

		// Dynamic Panel ELEVE initializing

		Vector<Etudiant> Vect_Temp = this.getEtape_facade().getListeEtudiant();


		for (int j = 0; j < this.getEtape_facade().getListe_Semestres().size(); j++) {
			for (int i = 0; i < Vect_Temp.size(); i++) {
				// On cr�e le panel �tudiant i dans lequel on va mettre toutes
				// ses donn�es pour le pv
				jPanel6 = new javax.swing.JPanel();
				jTextField14 = new javax.swing.JTextField();
				jTextField14.setText(Vect_Temp.get(i).getNom());
				jTextField15 = new javax.swing.JTextField();
				jTextField15.setText(Vect_Temp.get(i).getPrenom());
				jTextField16 = new javax.swing.JTextField();

				jTextField16.setText(this.getEtape_facade()
						.getListe_Semestres().get(j)
						.getMoyenneEtud(Vect_Temp.get(i).getCode()));// Moyenne
																		// du
																		// Semestre

				// Moyenne UE i

				for (int k = 0; k < this.getEtape_facade().getListe_Semestres()
						.get(j).getListe_UE().size(); k++) {
					jTextField17 = new javax.swing.JTextField();
					jTextField17.setText(Float.toString(this.getEtape_facade()
							.getListe_Semestres().get(j).getListe_UE().get(k)
							.getMoyenneEtudiantUE(Vect_Temp.get(i).getCode())));

					// Note ECUE k de l'ue i

					for (int l = 0; l < this.getEtape_facade()
							.getListe_Semestres().get(j).getListe_UE().get(k)
							.getListe_ECUE().size(); l++) {

						jTextField18 = new javax.swing.JTextField();
						jTextField18.setText(Float.toString(this
								.getEtape_facade().getListe_Semestres().get(j)
								.getListe_UE().get(k).getListe_ECUE().get(l)
								.getNoteECUE(Vect_Temp.get(i).getCode())));

					}

				}

			}

		}

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(
				jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout
				.setHorizontalGroup(jPanel6Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel6Layout
										.createSequentialGroup()
										.addComponent(
												jTextField14,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												52,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTextField15,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												58,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTextField16,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												99,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(
												jTextField17,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTextField18,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(414, Short.MAX_VALUE)));
		jPanel6Layout
				.setVerticalGroup(jPanel6Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel6Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel6Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField14,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField15,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField16,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField17,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField18,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(10, 10,
																		10)
																.addComponent(
																		jPanel6,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addContainerGap())
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(
																		layout.createSequentialGroup()
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																								.addGroup(
																										layout.createSequentialGroup()
																												.addComponent(
																														jTextField1,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														98,
																														javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addGap(18,
																														18,
																														18)
																												.addComponent(
																														jTextField2,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														132,
																														javax.swing.GroupLayout.PREFERRED_SIZE))
																								.addComponent(
																										jPanel3,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(
																						jPanel5,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGap(110,
																						110,
																						110))
																.addGroup(
																		layout.createSequentialGroup()
																				.addComponent(
																						jPanel1,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addGap(1049,
																						1049,
																						1049))))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jTextField1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						20,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		jPanel3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		52,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(
														jPanel5,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(0, 0, 0)
								.addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel6,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(324, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	/**
	 * @param args
	 *            the command line arguments
	 */
	
	 /* public static void main(String args[]) {
	  java.awt.EventQueue.invokeLater(new Runnable() { public void run() {
	  Facade_PV dialog = new Facade_PV(new javax.swing.JFrame(), true);
	  dialog.addWindowListener(new java.awt.event.WindowAdapter() { public void
	  windowClosing(java.awt.event.WindowEvent e) { System.exit(0); } });
	  dialog.setVisible(true); } }); }*/
	 
	// Variables declaration - do not modify

	private Etape Etape_for_PV;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField10;
	private javax.swing.JTextField jTextField11;
	private javax.swing.JTextField jTextField12;
	private javax.swing.JTextField jTextField13;
	private javax.swing.JTextField jTextField14;
	private javax.swing.JTextField jTextField15;
	private javax.swing.JTextField jTextField16;
	private javax.swing.JTextField jTextField17;
	private javax.swing.JTextField jTextField18;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField8;
	private javax.swing.JTextField jTextField9;

	// End of variables declaration

	public Etape getEtape_facade() {
		return this.Etape_for_PV;
	}

}
