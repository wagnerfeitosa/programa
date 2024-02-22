package sessao_15_exececao_personalizada;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation3 {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation3(Integer roomNumber, Date checkin, Date checkout) throws DominioExecao {
		if(!checkout.after(checkin)) {
			throw new DominioExecao("Error! data de check-out deve ser posterio que a data check-in");
	    }
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
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
	public long duration() {
		//captando com getTime data em milisegundo e subtraindo (-)
		long diff = checkout.getTime() - checkin.getTime();
		//convertendo milisegundos em dias com a classe TimeUnit
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);	
		
	}
	public void updateDate(Date checkin, Date checkout) throws DominioExecao {
		Date now = new Date();
		//metodo before testa se uma data é antes da outra
		if(checkin.before(now) || checkout.before(now)) {
			//classe throw do java para lancar uma execao serve
			//quando os  argumento recebidos sejam invalidos
			//throw new IllegalArgumentException("Error na atualização as datas reservas devem ser datas futuras");
			//execao personalizada
			throw new DominioExecao("\"Error na atualização as datas reservas devem ser datas futuras");
		}
	    if(!checkout.after(checkin)) {
			throw new DominioExecao("Error! data de check-out deve ser posterio que a data check-in");
	    }
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
