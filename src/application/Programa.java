package application;

import model.entities.Reserva;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Número do quarto: ");
            int numero = in.nextInt();

            System.out.print("Data de check-in: (dd/MM/yyyy): ");
            Date checkin = sdf.parse(in.next());

            System.out.print("Data de check-out: (dd/MM/yyyy): ");
            Date checkout = sdf.parse(in.next());

            Reserva reserva = new Reserva(numero, checkin, checkout);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Insira os dados para atualizar a reserva:");
            System.out.print("Data de check-in: (dd/MM/yyyy): ");
            checkin = sdf.parse(in.next());
            System.out.print("Data de check-out: (dd/MM/yyyy): ");
            checkout = sdf.parse(in.next());

            reserva.atualizarData(checkin, checkout);
            System.out.println("Reserva: " + reserva);
        }
        catch (ParseException e){
            System.out.println("Formato de data inválido!");
        }
        catch (DomainException e){
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Erro inesperado!");
        }
    }
}
