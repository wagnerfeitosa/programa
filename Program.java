package sessao_15_exececao_personalizada;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*esse programa deve está em um pacote aplicacao*/
public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Romm number: ");
		int number =sc.nextInt();
		
		System.out.print("check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		
		System.out.print("check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		//metodo after do Date testa se uma data é depois da outra
		if(!checkout.after(checkin)) {
			System.out.println("Error! data de check-out deve ser posterio que a data check-in");
			
		}else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: "+ reservation);
			
			System.out.println();
			System.out.println("Entre com as data para atualizar a reserva");
			System.out.print("check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			
			System.out.print("check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			//metodo before testa se uma data é antes da outra
			if(checkin.before(now) || checkout.before(now)) {
				System.out.println("Error na atualização as datas reservas devem ser datas futuras");
				
			}else if(!checkout.after(checkin)) {
				System.out.println("Error! data de check-out deve ser posterio que a data check-in");
			}else {
				reservation.updateDate(checkin, checkout);
				System.out.println("Resrvation: "+reservation);
			}
			
		}
		sc.close();
		
		

	}

}
