

````markdown
# 🏨 Backend - Gestion des Réservations et Room Service (Spring Boot + MongoDB)

Ce projet backend est développé avec **Spring Boot** et **MongoDB** pour gérer les réservations de chambres, les commandes de room service et la gestion des clients et employés d’un hôtel.

## 📁 Structure du projet

- **Client** : Gestion des clients de l'hôtel
- **Chambre** : Informations sur les chambres disponibles
- **Réservation** : Réservation de chambres par les clients
- **Room Service** : Services proposés aux clients dans leur chambre
- **Commande Room Service** : Commandes de services faites par les clients
- **Employé** : Personnel gérant les réservations et les services

---

## 🛠️ Technologies utilisées

- [Spring Boot 3.x](https://spring.io/projects/spring-boot)
- [MongoDB](https://www.mongodb.com/)
- [Maven](https://maven.apache.org/)
- [Java 17](https://www.oracle.com/java/)
- [Spring Data MongoDB](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/)
- [Spring Web](https://spring.io/guides/gs/rest-service/)
- [Spring Security (optionnel)](https://spring.io/projects/spring-security)

---

## 🧩 Entités principales

### ✅ Client

```java
@Id
private String idClient;
private String nom;
private String prenom;
private String telephone;
private String email;
````

**Fonctions :**

* `reserverChambre()`
* `annulerReservation()`
* `commanderRoomService()`
* `modifierRoomService()`
* `annulerRoomService()`

---

### 🛏 Chambre

```java
@Id
private String idChambre;
private int numeroChambre;
private String statut; // Disponible, Occupée, Réservée...
private String type;   // Simple, Double, Suite...
private double prix;
private String description;
```

**Fonction :**

* `estDisponible()`

---

### 📆 Réservation

```java
@Id
private String idReservation;
private LocalDate dateDebut;
private LocalDate dateFin;
private String statut;
private String idClient;
private String idChambre;
```

**Fonction :**

* `calculerPrix()`

---

### 🍽 RoomService

```java
@Id
private String idService;
private String nom;
private String description;
private double prix;
private String type; // Nourriture, Boisson, Nettoyage...
```

---

### 📦 CommandeRoomService

```java
@Id
private String idCommande;
private LocalDateTime dateCommande;
private String statut;
private String idClient;
private List<String> servicesCommandés;
```

**Fonction :**

* `calculerPrix()`

---

### 👷 Employé

```java
@Id
private String idEmploye;
private String nom;
private String prenom;
private String role; // Réceptionniste, Service, Nettoyage...
```

**Fonctions :**

* `accepterCommande()`
* `refuserCommande()`
* `accepterReservation()`
* `annulerReservation()`

---

## 🚀 Lancer l'application localement

### Pré-requis

* Java 17
* MongoDB en local (`mongodb://localhost:27017`)
* Maven

### Étapes

```bash
git clone https://github.com/TON-UTILISATEUR/projet-hotel-backend.git
cd projet-hotel-backend
mvn clean install
mvn spring-boot:run
```

---

## 📦 API REST disponible

| Ressource           | Méthode | Endpoint                  | Description                   |
| ------------------- | ------- | ------------------------- | ----------------------------- |
| Client              | GET     | `/clients`                | Lister tous les clients       |
|                     | POST    | `/clients`                | Créer un client               |
| Chambre             | GET     | `/chambres/disponibles`   | Lister chambres disponibles   |
| Réservation         | POST    | `/reservations`           | Réserver une chambre          |
|                     | PUT     | `/reservations/{id}`      | Modifier une réservation      |
| RoomService         | GET     | `/roomservices`           | Lister les services           |
| CommandeRoomService | POST    | `/commandes`              | Commander un service          |
| Employé             | PUT     | `/employes/commande/{id}` | Accepter/refuser une commande |

---

## 📂 Dossiers principaux

```
src/
 └── main/
     ├── java/com/monhotel/
     │   ├── controllers/
     │   ├── models/
     │   ├── repositories/
     │   ├── services/
     │   └── HotelApplication.java
     └── resources/
         └── application.properties
```

---

## 🔐 Sécurité (optionnelle)

Tu peux intégrer Spring Security avec JWT pour protéger les endpoints réservés aux employés.

---

## 📌 Auteur

* **Junior Moneze**
* Projet personnel dans le cadre de l’apprentissage de Spring Boot + MongoDB

---

## 📃 Licence

Ce projet est open-source sous licence MIT.

---

## 📎 Liens utiles

* [Documentation Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/)
* [MongoDB Compass (GUI)](https://www.mongodb.com/products/compass)
* [Postman pour tester l’API](https://www.postman.com/)

```


