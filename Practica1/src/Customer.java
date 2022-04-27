/**
 * @author Itzel Azucena Delgado Díaz
 * @date 20/02/2022
 * Clase para representar clientes. Un cliente tiene customer_id, name, surmane, rfc, mail y Region. 
 * */
public class Customer {

	
	private String customer_id;
	private String name;
	private String surname;
	private String rfc;
	private String mail;
	private Region region;
	
	//Constructor de un custumer.
	public Customer(String customer_id,
					String name,
					String surname,
					String rfc,
					String mail,
					Region region) {
		
		this.customer_id = customer_id;
		this.name        = name;
		this.surname     = surname;
		this.rfc         = rfc;
		this.mail        = mail;
		this.region      = region;
	}

	
	//Nos devuelve el id de un customer.
	public String getCustomer_id() {
		return customer_id;
	}

	//Nos ayuda a modificar el id de un customer.
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	//Nos devuelve el nombre de un customer.
	public String getName() {
		return name;
	}

	//Nos ayuda a modificar el name de un customer.
	public void setName(String name) {
		this.name = name;
	}

	//Nos devuelve el surname de un customer.
	public String getSurname() {
		return surname;
	}
	
	//Nos ayuda a modificar el surname de un customer.
	public void setSurname(String surname) {
		this.surname = surname;
	}

	//Nos devuelve el rfc de un customer.
	public String getRfc() {
		return rfc;
	}

	//Nos ayuda a modificar el rfc de un customer.
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	//Nos devuelve el mail de un customer.
	public String getMail() {
		return mail;
	}

	//Nos ayuda a modificar el mail de un customer.
	public void setMail(String mail) {
		this.mail = mail;
	}

	//Nos devuelve la región de un customer (objeto).
	public Region getRegion() {
		return region;
	}

	//Nos ayuda a modificar el id de una región.
	public void setRegion(Region region) {
		this.region = region;
	}

	//Sobreescribimos el método toString para imprimir el empleado de forma bonita.
	@Override
	public String toString() {
		return "customer_id=" + customer_id + ", name=" + name + ", surname=" + surname + ", rfc=" + rfc
				+ ", mail=" + mail + "," + region.toString();
	}
	
	
}
