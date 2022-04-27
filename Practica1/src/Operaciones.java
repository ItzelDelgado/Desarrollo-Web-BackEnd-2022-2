/**
 * @author Itzel Azucena Delgado Díaz
 * @date 20/02/2022
 * 
 * Clase principal, donde contiene el main y además tiene las operaciones que se pidierón en la práctica.
 *
 **/

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Operaciones {
	
	Customer customer;
	Region region;
	
	
	//Método que realiza la extracción de los datos.
	public void getDatos(){
		Conexion conexion = new Conexion();
		 Connection cn = null;
		 Statement stm = null;
		 ResultSet rs = null;
		 
		 try {
			 cn = conexion.conectar();
			 stm =  cn.createStatement();
			 rs = stm.executeQuery("SELECT a.customer_id, a.name, a.surname, a.rfc, a.mail, b.region_id, b.region FROM customer a INNER JOIN region b WHERE a.region = b.region_id");
			 while (rs.next()) {
				 region = new Region(rs.getString(6), rs.getString(7));
				 customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),region);
				 System.out.println(customer.toString());
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { //liberamos recursos
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(stm != null) {
					stm.close();
				}
				
				if(cn != null) {
					cn.close();
				}
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	//Método para agregar un customer en la base de datos.
	public void insertDato() {
		Scanner sc = new Scanner(System.in);
		Conexion conexion = new Conexion();
		 Connection cn = null;
		 Statement stm = null;
		 ResultSet rs = null;
		 
		 try {
			 cn = conexion.conectar();
			 stm =  cn.createStatement();
			 System.out.println("Ingresa los datos del empleado que deseas eliminar:");
			 System.out.println("Ingresa el name:");
			 String name = sc.nextLine();
			 System.out.println("Ingresa el surname:");
			 String surname = sc.nextLine();
			 System.out.println("Ingresa el RFC:");
			 String rfc = sc.next();
			 System.out.println("Ingresa el mail:");
			 String mail = sc.next();
			 System.out.println("Ingresa el id de la región en la que vive:");
			 String region = sc.next();
			 String query = "INSERT INTO customer(name, surname, rfc, mail, region) VALUES('"+name+"', '"+surname+"', '"+rfc+"', '"+mail+"', '"+region+"')";
			 stm.executeUpdate(query);
			 System.out.println("Un nuevo usuario fue ingresado");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {//liberamos recursos
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(stm != null) {
					stm.close();
				}
				
				if(cn != null) {
					cn.close();
				}
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	//Método para eliminar una persona de la base de dtos.
	public void deletePersona() {
		Scanner sc = new Scanner(System.in);
		Conexion conexion = new Conexion();
		 Connection cn = null;
		 Statement stm = null;
		 ResultSet rs = null;
		 
		 try {
			 cn = conexion.conectar();
			 stm =  cn.createStatement();
			 System.out.println("\n" + "Ingresa el customer_id del empleado que deseas eliminar: \n");
			 String customer_id = sc.next();
			 String query = "DELETE FROM customer WHERE customer_id = "+customer_id+"";
			 stm.executeUpdate(query);
			 System.out.println("El empleado con el id = " + customer_id + " ha sido eliminado.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {//liberamos recursos
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(stm != null) {
					stm.close();
				}
				
				if(cn != null) {
					cn.close();
				}
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	//Método principal para hacer uso de todas las operaciones. 
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		Operaciones op = new Operaciones();
		int salir = 1;
		System.out.println("Ingresando a la base de datos de empleados.");
		System.out.println("¿Qué operación deseas realizar? (Ingresa el número de la operación.)");
		int opcion;
		
		while(salir == 1) {
			System.out.println("1. Consultar lista de empleados.");
			System.out.println("2. Agregar un empleado.");
			System.out.println("3. Eliminar empleado.");
			opcion = sc.nextInt();
			switch(opcion){
            case 1:
                System.out.println("Has seleccionado la opcion 1");
                op.getDatos();
                break;
            case 2:
                System.out.println("Has seleccionado la opcion 2");
                op.insertDato();
                break;
             case 3:
                System.out.println("Has seleccionado la opcion 3");
                op.deletePersona();
                break;
             case 4:
                salir = 0;
                break;
             default:
                System.out.println("Solo números entre 1 y 3");
			}
			
			System.out.println("\n ¿Desea realizar otra operación? (Pulsa 1 si quieres realizar otra operación o un número distinto en otro caso.)");
			salir = sc.nextInt();
		}
		
		System.out.println("La ejecución ha terminado.");
	}
	

}
