# ExtremePrograming

## Git

* Clone the project : `git clone <target-url>`
* Create your own project on Github
* Change the remote branch : `git remote set-url origin <new-url>`

## Installation

Normalement, **Eclipse** est déjà installé sur vos machines avec un **JDK 1.8** (Java 8).


### Téléchargement

Vous pouvez télécharger de votre choix :
* [Eclipse Oxygen (September 2017)](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/oxygenrc3) (Portable)
* [IntelliJ Community](https://www.jetbrains.com/idea/download/) (_Il est possible que vous n'ayez pas les droits pour l'installer_ )

### Extraction

Vous pouvez lancer l'extraction via l'explorateur ou bien à l'aide de l'un des commandes suivantes :
```
tar -zxf <tar.gz-file>
unzip <zip-file>
```

### Eclipse

Vous avez téléchargé la version portable d'Eclipse, vous pouvez donc le lancer en allant directement dans le dossier extrait.

Pour importer le projet :
```
File > Open Projects from File System... > Directory...
```

### IntelliJ

Après l'extraction, une fois dans le répertoire, vous devez lancer le script `./bin/idea.sh`.

* `Import Project > Import project from external model > Eclipse`
* Sélectionnez le SDK installé sur votre machine
* `File > Project Structure... > Modules`
* Dans l'onglet _Sources_, sélectionnez _java_ comme source (bleu) et _test_ comme tests (vert)
* Dans l'onglet _Dependencies_, cochez _junit-4.12.jar_ avec un scope de _Test_

## Pratique (POKER)

### Scénarii (_User Stories_)

Id | En tant que... | Je veux... | Afin de... | Valeur
--- | --- | --- | --- | ---
1 | Joueur | initialiser une partie | commencer à jouer | 100
2 | Joueur | choisir le nombre de joueurs | initialiser la partie | 100
3 | Joueur | choisir le nom des joueurs | initialiser la partie | 50
4 | Joueur | choisir l'ordre des joueurs | initialiser la partie | 20
5 | Joueur | recevoir 2 cartes en début de tour | constiuer ma main | 100
6 | Joueur | terminer ma partie au bout d'un certain nombre de tours | limiter le temps de jeux | 50
7 | Joueur | découvrir les cartes sur la table | connaître ma combinaison | 70
8 | Spectateur | découvrir les cartes sur la table | suivre le déroulement de la partie | 20
9 | Joueur / Spectateur | savoir quel joueur a gagné le tour | savoir la répartition des gains | 100
10 | Joueur | voir seulement mes cartes | décider de mon annonce | 100
11 | Spectateur | voir les cartes de tous les joueurs | suivre le déroulement de la partie | 20
12 | Joueur | voir la somme qui me reste | décider des mises | 100
13 | Spectateur | voir l'argent de tous les joueurs | suivre le déroulement de la partie | 20
14 | Joueur | terminer la partie lorsque je n'ai plus d'argent | terminer la partie | 100
15 | Joueur | miser | augmenter les gains du tour | 100
16 | Joueur | suivre (miser le minimum pour continuer) | augmenter la somme en jeu | 100
17 | Joueur | faire tapis (miser tout mon argent) | augmenter la somme en jeu | 100
18 | Joueur | relancer (surenchérir) | augmenter la somme en jeu | 100
19 | Joueur | voir ma mise actuelle | décider de mon annonce | 80
20 | Joueur / Spectateur | voir la somme en jeu | connaître l'objectif | 100
21 | Joueur | jouer après le jouer à ma droite | effectuer une action | 80
22 | Croupier | le joueur à ma gauche mise la petite blind | initialiser le tour | 80
23 | Croupier | le deuxième joueur à ma gauche mise la grande blind | initialiser le tour | 80
24 | Croupier | le troisième joueur à ma gauche commence le tour | initialiser le tour | 80
25 | Croupier | le joueur à ma gauche soit le prochain croupier | initialiser le prochain tour | 80

### Sprint 1

Scénario | Temps
--- | ---


### Sprint 2

Scénario | Temps
--- | ---


## Help

### Cheat sheets

* [Java](https://introcs.cs.princeton.edu/java/11cheatsheet/ "Java Programing Cheatsheet")
* [Git](https://www.git-tower.com/blog/posts/git-cheat-sheet "Git Tower")
* [Markdown](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet "Markdown Cheat Sheet by Adam Pritchard")

### Docs

* [Debian](https://www.debian.org/doc/manuals/refcard/refcard "Debian Doc")
* [Git](https://git-scm.com/documentation "Git SCM doc")
* [Javadoc](https://docs.oracle.com/javase/8/docs/api/ "Java 8 Doc")
* [JUnit](http://junit.org/junit4/javadoc/latest/ "JUnit Doc")
