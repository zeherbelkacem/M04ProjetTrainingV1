APPLI DE FORMATION
[Pour chaque exercice ou projet, pour des raisons pédagogiques, nous ne devons pas 
utiliser un concept avant de l’avoir introduit dans le cours, par exemple : la Poo ou les 
exceptions, en revanche, vous devez impérativement utiliser les concepts ou technos 
abordées ainsi que les bonnes pratiques]
Dans cette 1ère version de l’application, il s’agit ici de proposer un ensemble de formation à 
acheter dans une application en mode console certes mais qui doit être la plus intuitive.
1/ La 1ère tâche consiste à afficher la liste des formations, prévoir par défaut 5 formations min.
Une formation est caractérisée par : id, nom, durée en jours, courte description, prix.
Tester votre application, vous devez obtenir le résultat suivant sur la console :
Après avoir transformé le répertoire courant de votre projet en dépôt git, indexer les 
fichiers(add) puis réaliser un premier commit sur la branche principale.
Votre appli est stable, dorénavant, créer une branche pour chaque nouvelle 
fonctionnalité.
2/ Proposer un menu afin que l’utilisateur puisse constituer un panier avec une ou plusieurs 
formations. Il pourra donc afficher à tout moment la liste des formations puis ajouter une 
formation à son panier et afficher le contenu de son panier. Attention ici, le programme doit 
permettre d’ajouter plusieurs fois la même formation (il faudra en tenir compte dans la 
commande).
Qui dit nouvelle fonctionnalité(feature), dit nouveau commit, puis poussez vos modifs 
en production sur github par exemple.
Vous commencez ensuite à travailler sur une nouvelle fonctionnalité consistant à 
supprimer une formation du caddy, sur une branche différente naturellement lorsque 
tout à coup, on nous indique qu’il y a plusieurs pbs en production. En effet, vous 
n’avez pas suffisamment testé votre application, voici la liste des correctifs(bugs) à 
apporter :
o Lorsque l’utilisateur saisi un caractère alors qu’on attend un nombre pour le 
menu
o En cas de saisie différente de ce qui est proposé dans le menu. Ex : 50
o En cas d’ajout d’une formation, on peut saisir n’importe quelle valeur d’id qui 
correspond à aucune formation.
o Si le panier est vide, ajouter un message pour l’indiquer
o Comment sortir du programme
NB : Vous devez donc basculer sur la branche principale, créer une branche à partir 
celle-ci, faire les modifs puis fusionner avant de revenir vers votre nouvelle 
fonctionnalité de suppression d’une formation.
Prenez bien le temps de tester et vérifier que vous êtes bien passé par tous les chemins 
cette fois-ci, que vous avez anticipé sur toutes les situations problématiques.
3/ Il pourra passer commande à tout instant, il basculera sur un écran dit secondaire avec un 
récap qui affichera uniquement le contenu de son panier et le montant total de sa commande, 
une fois validé, un message de confirmation sera affiché puis le panier sera vidé et l’appli 
reviendra sur l’écran principale.
4/ Ajouter à la suite des formations prochainement disponible
5/ Ajouter une fonctionnalité de votre choix dans l’application afin de montrer au client un 
petit +
Attention : vendredi après-midi, vous serez en binôme afin que votre binôme présente 
lundi matin votre travail à votre place et inversement.