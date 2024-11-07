package application;

import model.entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int numero = in.nextInt();

        System.out.print("Data de check-in: (dd/MM/yyyy): ");
        Date checkin = sdf.parse(in.next());

        System.out.print("Data de check-out: (dd/MM/yyyy): ");
        Date checkout = sdf.parse(in.next());

        if(!checkout.after(checkin)){
            System.out.println("Erro na reserva: A data de check-out deve ser posterior à data de check-in");
        }
        else {
            Reserva reserva = new Reserva(numero, checkin, checkout);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Insira os dados para atualizar a reserva:");
            System.out.print("Data de check-in: (dd/MM/yyyy): ");
            checkin = sdf.parse(in.next());
            System.out.print("Data de check-out: (dd/MM/yyyy): ");
            checkout = sdf.parse(in.next());

            String erro = reserva.atualizarData(checkin, checkout);
            if(erro != null){
                System.out.println("Erro na reserva: " + erro);
            } else {
                System.out.println("Reserva: " + reserva);
            }
        }
    }
}
