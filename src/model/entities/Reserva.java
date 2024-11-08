package model.entities;

import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

    private Integer quartoNumero;
    private Date checkin;
    private Date checkout;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer quartoNumero, Date checkin, Date checkout) {
        if(!checkout.after(checkin)){
            throw new DomainException("A data de check-out deve ser posterior à data de check-in");
        }
        this.quartoNumero = quartoNumero;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getQuartoNumero() {
        return quartoNumero;
    }

    public void setQuartoNumero(Integer quartoNumero) {
        this.quartoNumero = quartoNumero;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duracao(){
        long diferenca = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    public void atualizarData(Date checkin, Date checkout) throws ParseException {

        Date agora = sdf.parse("06/06/2018");

        if(checkin.before(agora) || checkout.before(agora)){
            throw new DomainException("As datas de reserva para atualização devem ser datas futuras");
        }

        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Sala " +
                + quartoNumero
                +  ", check-in: "
                + sdf.format(checkin)
                + ", check-out: "
                + sdf.format(checkout)
                + ", "
                + duracao()
                + " noites";
    }
}
