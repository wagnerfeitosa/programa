package sessao_15_exececao_personalizada;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
//essa classe deve ficar em um pacote model
public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public long duration() {
		//captando com getTime data em milisegundo e subtraindo (-)
		long diff = checkout.getTime() - checkin.getTime();
		//convertendo milisegundos em dias com a classe TimeUnit
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);	
		
	}
	public void updateDate(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Room "+ roomNumber+
				" ,check-in "+sdf.format(checkin)+
				" ,check-out "+sdf.format(checkout)+
				" ,"+duration()+" night";
	}
	

}
