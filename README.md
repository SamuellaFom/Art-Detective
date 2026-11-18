# Art Detective

Application Android ludique pour découvrir l'histoire de l'art. Le joueur incarne un détective : un tableau mystère est présenté flouté, il révèle des indices (époque, style, pays) pour deviner le peintre parmi 4 choix et gagne des points d'expérience.

Projet du module **Jetpack Compose Android** (ESGI, 2026-2027) réalisé par Samuella Fom Nenkam et Linerol Tchecounnou.

## Stack

- Kotlin, Jetpack Compose, Material 3
- Navigation Compose
- Architecture MVVM : ViewModel, use cases, repositories
- Retrofit + Gson pour l'[API Art Institute of Chicago](https://api.artic.edu/docs/)
- Coil pour le chargement des images

## Lancer le projet

1. Ouvrir le dossier dans Android Studio.
2. Attendre la fin de la synchronisation Gradle.
3. Choisir un émulateur ou un téléphone, puis cliquer sur ▶ Run.

En ligne de commande :

```sh
./gradlew assembleDebug   # compile l'application
./gradlew test            # lance les tests unitaires
```

## Organisation du code

```
fr.esgi.artdetective
├── data/          # accès aux données : API (Retrofit) et stockage local
├── domain/
│   ├── model/     # classes du métier : Artwork, Artist, Investigation…
│   └── usecase/   # règles du jeu : révéler un indice, valider une réponse…
├── navigation/    # liste des écrans et passage de l'un à l'autre
└── ui/            # écrans Compose et ViewModels, un package par écran
```

## Contribuer

- Une branche par ticket, créée depuis `Principal` : `feature/<numéro>-<sujet>`, par exemple `feature/7-navigation`.
- Pas de push direct sur `Principal` : chaque changement passe par une pull request relue par l'autre membre du binôme.
- Écrire `Closes #<numéro>` dans la description de la PR pour fermer le ticket automatiquement à la fusion.
- Messages de commit : `type(sujet): description`, par exemple `feat(gallery): ajoute les filtres par mouvement`. Types courants : `feat`, `fix`, `chore`, `test`, `docs`.
- Le suivi des tâches se fait dans le tableau GitHub Projects du dépôt.
