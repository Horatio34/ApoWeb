import BL.*;
import java.util.Scanner;

public class Apoweb 
{


	
	public static void main(String[] args) 
	{
		//args[0] == code_etape;
		//args[1] == chargement;
		//args[2] == UI;
		String code_Etape;
		String chargement;
		String UI;
		
		
		if(args.length == 0)
		{

			Scanner sc = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);

			System.out.println("Saisir le code etape");
			code_Etape = sc.nextLine();
			System.out.println("Saisir le mode de chargement");
			chargement = sc2.nextLine();
			
			UI = "Graphique";
			
		}
		else
		{
			code_Etape = args[0];
			chargement = args[1];
			UI = args[2];
		}
		
		Facade facade = new Facade(code_Etape, chargement);
		CreateAllUI all_Ui = new CreateAllUI(UI, facade.getEtape_Facade());
		
		// plus une fonction pour créer toutes les interfaces...
	}

}
