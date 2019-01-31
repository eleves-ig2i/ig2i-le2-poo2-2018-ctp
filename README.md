# ig2i-le2-poo2-2018-ctp

Ce repository contient les fichiers textes et le sujet du CTP donnés ainsi qu'un code source répondant à toutes les questions du CTP (hors bonus). Quelques remarques :
* Pour la question 12, lors de la copie d'une collection, il n'y a pas de copie en profondeur (ou "parfaite") pour plusieurs raisons :
    + On n'utilise qu'une fois l'instance dans le programme pendant tout le CTP.
    + Il aurait fallu définir le constructeur par copie d'un EmplacementLivraison ainsi que d'un Commerçant.
    + Réadapter le getter pour qu'il utilise le constructeur par copie pour chaque ajout.
    + Perte de temps (:
* Pour la question 13, le code source donné ne permet pas de résoudre l'instance donné dans le fichier texte. Néanmoins, il fonctionne lorsqu'on l'adapte à l'instance implicitement évoqué à la question suivante.
* Comme pour tous les autres CTP de POO, je vous conseille de le faire avant de regarder le code source ;)
* IMPORTANT : on aurait pu utiliser les HashSet au lieu des LinkedList, pour les classes dont on a redéfini la méthode HashCode()
