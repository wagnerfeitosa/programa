package sessao_15_exececao_personalizada;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation2 {
	
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

	public Reservation2(Integer roomNumber, Date checkin, Date checkout) {
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
	public String updateDate(Date checkin, Date checkout) {
		Date now = new Date();
		//metodo before testa se uma data é antes da outra
		if(checkin.before(now) || checkout.before(now)) {
			return "Error na atualização as datas reservas devem ser datas futuras";
		}
	    if(!checkout.after(checkin)) {
			return "Error! data de check-out deve ser posterio que a data check-in";
	    }
		this.checkin = checkin;
		this.checkout = checkout;
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Room "+ roomNumber+
				" ,check-in "+sdf.format(checkin)+
				" ,check-out "+sdf.format(checkout)+
				" ,"+duration()+" night";
	}

}
