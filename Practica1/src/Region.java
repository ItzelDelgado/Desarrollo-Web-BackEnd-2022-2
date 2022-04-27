/**
 * @author Itzel Azucena Delgado Díaz
 * @date 20/02/2022
 * Clase que representa una Region con region_id y region. 
 **/
public class Region {

	private String region_id;
	private String region;
	
	//Constructor
	public Region(String region_id,
				  String region) {
		this.region_id = region_id;
		this.region    = region;
	}

	//Nos devuelve el id de una región
	public String getRegion_id() {
		return region_id;
	}

	//Nos ayuda a modificar el id de una región.
	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	//Nos devuelve la el nonbre de la región
	public String getRegion() {
		return region;
	}

	//Nos ayuda a modificar el nombre de una región.
	public void setRegion(String region) {
		this.region = region;
	}

	//Sobreescribimos el método toString para poder imprimir los datos de una región. 
	@Override
	public String toString() {
		return "region_id=" + region_id + ", region=" + region;
	}
	
	
}
