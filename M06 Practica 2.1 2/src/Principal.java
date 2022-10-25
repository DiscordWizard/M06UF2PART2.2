import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;

public class Principal {
	public static void main(String[] args) {
			try {
				Scanner teclat = new Scanner(System.in);
				String partDelNom;
				Connection cnHospital = GetConnection();
				ArrayList<Object> llistaDoctors;
				//-------------------------------------------
				ResultSet dbDoctorsList = getAllDoctors(cnHospital);
				System.out.println("TROBATS : " + ComptarDoctors(cnHospital) + " DOCTORS EN TOTAL");
				llistaDoctors = GetLlistaDoctors(dbDoctorsList);
				ShowResults(llistaDoctors);
				//-------------------------------------------
				System.out.print("ENTRA UN UBSTRING PER A CERCAR METGES COINCIDENTS AMB EL SUBSTRING -->");
				partDelNom = teclat.nextLine();
				dbDoctorsList = GetDoctorsPerNom(cnHospital, partDelNom);
				llistaDoctors = GetLlistaDoctors(dbDoctorsList);
				ShowResults(llistaDoctors);
				//-------------------------------------------
				float inc = 33;
				int codiEmpleat = 7499;
				System.out.println(ActualitzarSalariEmpleat(cnHospital, codiEmpleat, inc));
				//-------------------------------------------
				int nouDep = 20;
				System.out.println(CanviarDepartament(cnHospital, codiEmpleat, nouDep));
				//-------------------------------------------
				UpgradeEmpleat(cnHospital, codiEmpleat, 30, 500); //OK
				UpgradeEmpleat(cnHospital, codiEmpleat, 200, 500000); //NO
				//-------------------------------------------
				//AFEGIR AQUI LA CRIDA A LA VOSTRA FUNCIO CORRESPONENT A LA DARRERA DIAPOSITIVA
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//Connexió
	private static Connection GetConnection() throws SQLException {
		Connection con = DriverManager.getConnection("dbc:mysql://localhost:3306/hospitalm02", "root", "");
		return con;
	}
	
	//Tots els doctors en ResultSet
	//Usar statement
	//Retorna cursor amb nom, especialitat i nom d'hospital
	private static ResultSet getAllDoctors(Connection cnHospital) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Retorna el total de doctors
	//Usar statement
	private static String ComptarDoctors(Connection cnHospital) {
		// TODO Auto-generated method stub
		return null;
	}

	private static ResultSet GetDoctorsPerNom(Connection cnHospital, String partDelNom) {
		// TODO Auto-generated method stub
		return null;
	}

	private static ArrayList<Object> GetLlistaDoctors(ResultSet dbDoctorsList) {
		// TODO Auto-generated method stub
		return null;
	}

	private static char[] ActualitzarSalariEmpleat(Connection cnHospital, int codiEmpleat, float inc) {
		// TODO Auto-generated method stub
		return null;
	}

	private static char[] CanviarDepartament(Connection cnHospital, int codiEmpleat, int nouDep) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void UpgradeEmpleat(Connection cnHospital, int codiEmpleat, int i, int j) {
		// TODO Auto-generated method stub
		
	}


	public static void ShowResults(ArrayList<Object> llistaObjectes) {
		for (Object objecteActual : llistaObjectes) {
			System.out.println(objecteActual + "\n");
		}
		
	}
}
