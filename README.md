
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

* Java 17 ou supérieur
* MongoDB en local (`mongodb://localhost:27017`)
* Maven

### Étapes

```bash
git clone https://github.com/TON-UTILISATEUR/projet-hotel-backend.git
cd projet-hotel-backend
mvn clean install
mvn spring-boot:run
```

L'application sera accessible sur `http://localhost:8080`

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

Il est possible d’intégrer Spring Security avec JWT pour sécuriser les endpoints sensibles (gestion des employés, réservations, commandes).

---

## 📝 Mode d'emploi

### 1. Configuration MongoDB

Assure-toi que MongoDB est installé et lancé sur ta machine.

* Pour démarrer MongoDB sous Windows, ouvre PowerShell et lance :

```powershell
"C:\Program Files\MongoDB\Server\7.0\bin\mongod.exe"
```

* Sous Linux/macOS, lance :

```bash
mongod
```

### 2. Modifier la configuration

Dans le fichier `src/main/resources/application.properties`, ajuste les paramètres si besoin :

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/hotelDB
server.port=8080
```

### 3. Démarrer le serveur backend

Dans le terminal, à la racine du projet :

```bash
mvn spring-boot:run
```

### 4. Tester l'API

* Utilise un outil comme [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/) pour envoyer des requêtes HTTP.

* Exemple : pour récupérer tous les clients

```http
GET http://localhost:8080/clients
```

* Pour créer une réservation :

```http
POST http://localhost:8080/reservations
Content-Type: application/json

{
  "idClient": "123",
  "idChambre": "ch01",
  "dateDebut": "2025-07-23",
  "dateFin": "2025-07-26",
  "statut": "Confirmée"
}
```

### 5. Intégration frontend

* Connecte ton frontend Angular aux endpoints exposés à `http://localhost:8080`.

* Pense à activer le CORS côté backend si besoin.

---

## 📌 Auteur

* **Junior Moneze**
* Projet personnel – Apprentissage Spring Boot & MongoDB

---

## 📃 Licence

Ce projet est sous licence MIT.

---

## 📎 Liens utiles

* [Documentation Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/)
* [MongoDB Documentation](https://docs.mongodb.com/)
* [Postman](https://www.postman.com/)
* [Angular](https://angular.io/)

---

