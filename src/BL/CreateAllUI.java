package BL;
import Interface.*;
import Persistance.*;

public class CreateAllUI
{
	private Facade_PV FPV;
	private UI_PV ui_Pv;
	private String type_interface;
	private Etape etape_UI;
	
	
	
	public CreateAllUI(String t_interface, Etape et)
	{
		this.type_interface = t_interface;
		this.etape_UI = et;
		
		load_interface();
	}
	
	
	public void load_interface()
	{
		if(this.type_interface.equals("Graphique"))
		{
			this.ui_Pv = new UI_PV(this.etape_UI);
		}
	}
	
	public Facade_PV getFPV()
	{
		return this.FPV;
	}
	public UI_PV get_ui_Pv()
	{
		return this.ui_Pv;
	}
	public String get_Type_Interface()
	{
		return this.type_interface;
	}
	public void setFPV(Facade_PV fpv)
	{
		this.FPV = fpv;
	}
	public void setFPV(UI_PV ui_pv)
	{
		this.ui_Pv = ui_pv;
	}
	public void set_Type_Interface(String inter)
	{
		this.type_interface = inter;;
	}
}
