# 📒 MyNotes v1.0 — Application Android

## 👤 Auteur
- **Nom :** BENCHINE Abdelilah  
- **Filière :** Génie Informatique, Système d'Information
- **Établissement :** ENSA Tanger  

---

## 📝 Description du projet

**MyNotes** est une application Android native développée en **Java** permettant à l’utilisateur de gérer ses notes personnelles de manière simple et organisée.

L’application offre les fonctionnalités suivantes :
- visualisation de la liste des notes,
- ajout d’une nouvelle note via un formulaire dédié,
- consultation du détail d’une note,
- affichage moderne des notes sous forme de **cartes colorées** selon leur priorité.

Ce projet a été réalisé dans le cadre du **TP2 de développement mobile Android**.

---

## 🏗️ Structure du projet
```bash
MyNotes/
│
├── app/
│ └── src/
│ └── main/
│ ├── java/com/example/mynotes/
│ │ ├── activities/
│ │ │ ├── NoteListActivity.java
│ │ │ ├── AddNoteActivity.java
│ │ │ └── DetailsNoteActivity.java
│ │ ├── adapters/
│ │ │ └── NoteAdapter.java
│ │ └── models/
│ │ └── Note.java
│ │
│ └── res/
│ ├── layout/
│ ├── values/
│ └── drawable/
│
├── docs/
│ ├── rapport/
│ │ └── Rapport_TP2_MyNotes.pdf
│ └── demo/
│ ├── screenshots/
│ └── demonstration_video.mp4
│
├── README.md
└── build.gradle
```

---

## 📄 Rapport

Le rapport du projet est disponible dans le dossier :

docs/rapport/

yaml
Copy code

Il contient :
- une description fonctionnelle de l’application,
- la structure des données,
- l’architecture des activités,
- une description détaillée de l’adapter personnalisé,
- les améliorations possibles.

---

## 🎥 Démonstration

La démonstration de l’application (captures d’écran et/ou vidéo) se trouve dans :

```yaml
docs/demo/
``` 

Elle illustre :
- l’écran de liste des notes,
- l’ajout d’une nouvelle note,
- l’affichage des détails d’une note,
- l’interface moderne basée sur des cartes.

---

## 🛠️ Technologies utilisées

- **Langage :** Java  
- **IDE :** Android Studio  
- **UI :** XML (Material Design, CardView, FloatingActionButton)  
- **Architecture :** Multi-Activities avec Intents explicites  

---

## 📌 Remarque

Ce projet constitue une base évolutive pouvant être enrichie par :
- la persistance des données (SQLite / Room),
- l’ajout de photos aux notes,
- l’utilisation de RecyclerView,
- une architecture MVVM.

---

📬 *Projet réalisé à des fins pédagogiques dans le cadre d’un TP universitaire.*
