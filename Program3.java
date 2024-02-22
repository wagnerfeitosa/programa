package sessao_15_exececao_personalizada;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program3 {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Romm number: ");
			int number =sc.nextInt();
			System.out.print("check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
			
			Reservation3 reservation = new Reservation3(number, checkin, checkout);
			System.out.println("Reservation: "+ reservation);
			
			System.out.println();
			System.out.println("Entre com as data para atualizar a reserva");
			System.out.print("check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			reservation.updateDate(checkin, checkout);
			
			System.out.println("Reservation: "+reservation);
		}
		catch (ParseException e) {
			System.out.println("Data invalida!" +e.getMessage());
		}
		catch (DominioExecao e) {
			System.out.println("Error reservation:" +e.getMessage());
		}
		//Exception trata qualquer execao inesperada
		catch(Exception e) {
			System.out.println("Error ");
		}
	
			
		
		sc.close();

	}

}
