# 💌 Wedding Invitation App

The **Wedding Invitation App** is a console-based application built using **Core Java**, **JDBC**, and **PostgreSQL**, following the **Maven project structure**. It is designed to manage wedding invitation cards and guest information efficiently.

The app provides a menu-driven interface that allows users to create wedding cards, manage guests, track RSVP status, and view reports.

---

## ✨ Features

- **Create Wedding Card**: Add a new wedding invitation card with groom and bride details, wedding date, time, venue, and a special message.
- **Manage Guests**: Add, update, or delete guest records with names and email addresses.
- **Send Invitations**: Track to whom the invitation has been sent.
- **RSVP Management**: Update and view RSVP status (Yes / No / Pending) for each guest.
- **View Reports**: Fetch and display complete wedding card and guest list using Java Collections.

---

## ⚙️ Technologies Used

- **Core Java**: For implementing application logic and OOP concepts.
- **JDBC**: For database interaction with PostgreSQL.
- **PostgreSQL**: To store and manage card and guest data.
- **Maven**: For dependency management and building the project.

---

## 📦 Dependencies

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.6.0</version>
</dependency>

🗄️ Database Schema

#Wedding Card Table
CREATE TABLE wedding_cards (
    id SERIAL PRIMARY KEY,
    groom_name VARCHAR(100) NOT NULL,
    bride_name VARCHAR(100) NOT NULL,
    wedding_date DATE NOT NULL,
    wedding_time TIME NOT NULL,
    venue VARCHAR(200) NOT NULL,
    message TEXT
);

#Guest Table
CREATE TABLE guests (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    invitation_sent BOOLEAN DEFAULT FALSE,
    rsvp_status VARCHAR(20) DEFAULT 'Pending',
    wedding_card_id INT REFERENCES wedding_cards(id) ON DELETE CASCADE
);



 









