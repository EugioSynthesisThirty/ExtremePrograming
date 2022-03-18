# tp1-user-stories

Membres du groupe : DHIMOÏLA Gabriel, JOLY Mathias et LASTRE Sébastien

## Projet : Tetris

### User stories

| ID | En tant que... | Je veux...                                                                    | Pour...                               | Valeur métier | Durée  | Ordre | Itération |
|----|----------------|-------------------------------------------------------------------------------|---------------------------------------|---------------|--------|-------|-----------|
| 1  | Joueur         | Voir mon score                                                                | Voir si je suis le meilleur           | 60            | 25 min | 7     | 1         |
| 2  | Joueur         | Voir la prochaine pièce                                                       | Anticiper mes actions                 | 90            | 25 min | 6     | 1         |
| 3  | Joueur         | Déplacer des pièces                                                           | Organiser mon jeu                     | 100           | 25 min | 2     | 1         |
| 4  | Joueur         | Tourner des pièces                                                            | Organiser mon jeu                     | 100           | 25 min | 3     | 1         |
| 5  | Joueur         | Pouvoir déplacer une pièce avec un délai lorsqu'elle arrive en bout de course | Organiser mon jeu                     | 50            | 0 min  | 4     | 1         |
| 6  | Joueur         | Pouvoir descendre rapidement une pièce                                        | Ne pas perdre mon temps précieux      | 20            | 5 min  | 5     | 1         |
| 7  | Joueur         | Pouvoir faire des combos                                                      | Récompenser la prise de risque        | 50            | 15 min | 8     | 1         |
| 8  | Joueur         | Pouvoir écouter la musique Tetris                                             | Avoir une meilleur expérience         | 40            | 1h     | 10    | 2         |
| 9  | Joueur         | Avoir des pièces de couleurs différentes                                      | Pouvoir les distinguer facilement     | 70            | 5 min  | 1     | 1         |
| 10 | Joueur         | Avoir un gameover quand je perds                                              | Choisir si je veux refaire une partie | 45            | 1h     | 9     | 2         |
| 11 | Joueur         | Enregistrer mon score dans un classement                                      | Me comparer aux autres joueurs        | 60            | 2h     | 11    | 2         |
| 12 | Joueur         | Jouer en multijoueur                                                          | Jouer avec amis                       | 40            | 5h     | 15    | 5         |
| 13 | Joueur         | Jouer sur plusieurs plateformes                                               | Jouer sur tous mes OS                 | 20            | 1h     | 16    | 4         |
| 14 | Joueur         | Choisir des interfaces différentes                                            | Personnaliser mon jeu                 | 40            | 2h     | 13    | 3         |
| 15 | Joueur         | Choisir la taille de la grille                                                | Varier mon expérience                 | 10            | 30 min | 14    | 4         |
| 16 | Joueur         | Reconfigurer les touches                                                      | Personnaliser mon jeu                 | 50            | 1h     | 12    | 3         |

### Critères d'acceptation

| REF | Etant donné...              | Quand...                                                                         | Alors...                                         |
|-----|-----------------------------|----------------------------------------------------------------------------------|--------------------------------------------------|
| 3   | une pièce qui tombe         | j'appuie sur une touche directionnelle                                           | la pièce dans la direction demandée              |
| 4   | une pièce qui tombe         | j'appuie sur une touche rotationnelle                                            | la pièce tourne dans le sens demandé             |
| 2   | une pièce en bout de course | je ne fais rien                                                                  | la prochaine pièce annoncée est mise à jour      |
| 1   | une pièce en bout de course | elle complète une ligne                                                          | mon score augmente                               |
| 7   | une pièce en bout de course | elle complète plusieurs ligne                                                    | mon score augmente avec la taille du combo       |
| 10  | une pièce en bout de course | elle dépasse de la grille                                                        | la partie est terminée                           |
| 8   | un bouton pour le son       | j'appuie dessus                                                                  | la musique commence / s'arrête                   |
| 6   | une pièce qui tombe         | j'appuie sur la touche directionnelle du bas                                     | la pièce descend rapidement                      |
| 12  | une partie multijoueur      | l'un des joueurs perd                                                            | la partie se termine                             |
| 11  | une partie terminée         | mon score fait partie des X meilleurs                                            | le classement est mis à jour                     |
| 5   | une pièce en bout de course | j'appuie sur une touche directionnelle ou rotationnelle dans une période de 0.5s | la pièce bouge ou tourne dans la bonne direction |
| 9   | deux pièces                 | elles ont la même forme                                                          | elles ont la même couleur                        |
| 9   | deux pièces                 | elles ont des formes différentes                                                 | elles ont des couleurs différentes               |
| 3,4 | une pièce                   | la déplacer ou la tourner lui ferait faire un mouvement interdit                 | la pièce ne peut pas réaliser ce mouvement       |
| 14  | un menu de configuration    | je change l'interface de jeu                                                     | la nouvelle interface est utilisée dans le jeu   |
| 15  | un menu de configuration    | je change la taille de la grille                                                 | les nouvelles dimensions sont utilisées          |
| 16  | un menu de configuration    | lorsque j'attribue à une fonctionnalité une nouvelle touche                      | seul la nouvelle touche réalise l'action         |

### Itérations

Première itération : 1, 2, 3, 4, 6, 7, 9, 10, 11 
Deuxième itération : 5, 8, 12, 13, 14, 15, 16
