package com.invitation;

import com.invitation.dao.GuestDAO;
import com.invitation.dao.WeddingCardDAO;
import com.invitation.entity.Guest;
import com.invitation.entity.WeddingCard;
import com.invitation.util.JPAUtil;

import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EntityManager em = JPAUtil.getEntityManager();

        WeddingCardDAO cardDAO = new WeddingCardDAO(em);
        GuestDAO guestDAO = new GuestDAO(em);

        while (true) {
            System.out.println("\n1. Create Wedding Card");
            System.out.println("2. Add Guest");
            System.out.println("3. Update RSVP");
            System.out.println("4. View Wedding Card");
            System.out.println("5. View Guest List with RSVP");
            System.out.println("6. View RSVP Reports (Yes/No/Pending)");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Groom Name: ");
                    String groom = sc.nextLine();
                    System.out.print("Bride Name: ");
                    String bride = sc.nextLine();
                    System.out.print("Date (dd-mm-yyyy): ");
                    String date = sc.nextLine();
                    System.out.print("Time: ");
                    String time = sc.nextLine();
                    System.out.print("Venue: ");
                    String venue = sc.nextLine();
                    System.out.print("Message: ");
                    String message = sc.nextLine();

                    WeddingCard card = new WeddingCard(groom, bride, date, time, venue, message);
                    cardDAO.createWeddingCard(card);

                    System.out.println("✅ Wedding Card Created!");
                    break;

                case 2:
                    System.out.print("Guest Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Invitation Sent (Yes/No): ");
                    String invite = sc.nextLine();

                    Guest guest = new Guest(name, email, invite, "Pending");
                    guestDAO.addGuest(guest);
                    System.out.println("✅ Guest Added!");
                    break;

                case 3:
                    System.out.print("Enter Guest ID to update RSVP: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("New RSVP Status (Yes/No/Pending): ");
                    String status = sc.nextLine();

                    guestDAO.updateRSVP(id, status);
                    System.out.println("✅ RSVP Updated!");
                    break;

                case 4:
                    List<WeddingCard> cards = cardDAO.getAllWeddingCards();
                    if (cards.isEmpty()) {
                        System.out.println("❌ No Wedding Cards Found.");
                    } else {
                        for (WeddingCard cardItem : cards) {
                            System.out.println(cardItem);
                        }
                    }
                    break;

                case 5:
                    List<Guest> guests = guestDAO.getAllGuests();
                    if (guests.isEmpty()) {
                        System.out.println("❌ No Guests Found.");
                    } else {
                        for (Guest g : guests) {
                            System.out.println("ID: " + g.getId() + ", Name: " + g.getName() +
                                    ", Email: " + g.getEmail() + ", Invitation Sent: " + g.getInvitationSent() +
                                    ", RSVP: " + g.getRsvpStatus());
                        }
                    }
                    break;

                case 6:
                    System.out.print("Enter RSVP status to filter (Yes/No/Pending): ");
                    String rsvp = sc.nextLine();
                    List<Guest> filtered = guestDAO.getGuestsByRSVP(rsvp);
                    if (filtered.isEmpty()) {
                        System.out.println("❌ No guests with RSVP: " + rsvp);
                    } else {
                        System.out.println("Guests with RSVP '" + rsvp + "':");
                        for (Guest g : filtered) {
                            System.out.println(g.getName() + " (" + g.getEmail() + ")");
                        }
                    }
                    break;

                case 7:
                    System.out.println("👋 Exiting...");
                    em.close();
                    JPAUtil.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please enter valid choice (1 to 7).");
            }
        }
    }
}
