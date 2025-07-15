Here’s the **corrected and polished version** of your README for the **Wedding Invitation App** project:

---

# 💌 Wedding Invitation App

A console-based Java application to manage wedding invitations and guest information efficiently. Built using **Core Java**, **JDBC**, and **PostgreSQL**, this project follows the **Maven** structure and offers an interactive menu-driven interface for creating wedding cards, managing guest lists, and tracking RSVP statuses.

---

## ✨ Features

* **Create Wedding Card**: Add groom and bride details, wedding date, time, venue, and a personalized message.
* **Manage Guests**: Add, update, or delete guest records with name and email.
* **Send Invitations**: Track which guests have been sent invitations.
* **RSVP Management**: Update and view RSVP status (`Yes`, `No`, `Pending`) for each guest.
* **View Reports**: Display full wedding card details and guest list using Java Collections.

---

## ⚙️ Technologies Used

* **Core Java** – Application logic and OOP concepts
* **JDBC** – Interaction with the database
* **PostgreSQL** – Persistent storage of cards and guest data
* **Maven** – Project and dependency management

---

## 📦 Dependencies

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.6.0</version>
</dependency>
```

---

## 🗄️ Database Schema

### 🎴 Wedding Card Table

```sql
CREATE TABLE wedding_cards (
    id SERIAL PRIMARY KEY,
    groom_name VARCHAR(100) NOT NULL,
    bride_name VARCHAR(100) NOT NULL,
    wedding_date DATE NOT NULL,
    wedding_time TIME NOT NULL,
    venue VARCHAR(200) NOT NULL,
    message TEXT
);
```

### 👤 Guest Table

```sql
CREATE TABLE guests (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    invitation_sent BOOLEAN DEFAULT FALSE,
    rsvp_status VARCHAR(20) DEFAULT 'Pending',
    wedding_card_id INT REFERENCES wedding_cards(id) ON DELETE CASCADE
);
```

---

## ✅ Prerequisites

Ensure the following are installed:

* Java Development Kit (**JDK 17** or higher)
* **Apache Maven** 3.8.6 or higher
* **PostgreSQL** 15 or higher

---

## 🖥️ Console Menu

The app uses a console-based menu system that allows you to:

1. Create Wedding Card
2. Add / View / Update / Delete Guests
3. Send Invitations
4. Manage RSVP Status
5. View Reports
6. Exit

---

## 🗂️ Project Directory Structure

![IMG-20250714-WA0002](https://github.com/user-attachments/assets/4eb8e150-d23e-49f8-ae1f-ea7d9c1a6914)

### Output Structure

![IMG-20250714-WA0001](https://github.com/user-attachments/assets/652a596f-1e06-4629-b274-1d183ab583b9)


---

## 👥 Group Members

* **Shreya Shankar Tonape**
* **Sakshi Shivaji Khandagale**
* **Sayali Sadanand More**

---

## 📬 Contact

* **Name**: Shreya Shankar Tonape
* **Email**: [shreyatonape65@gmail.com](mailto:shreyatonape65@gmail.com)
* **GitHub**: [Shreyatonape](https://github.com/Shreyatonape)

---

🎉 **Enjoy using the Wedding Invitation App!**
Feel free to fork, contribute, or give feedback!

---













 









