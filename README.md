# Projet Mobile Esiea 3A

<p align="middle">
  <img width="200" src="https://github.com/srikanthsc/srikanthsc/blob/master/download.png"></p>
  
> Nom de l'application : Stop Covid

Sommaire
=================

<!--ts-->
   * [Sommaire](#Sommaire)
   * [Description de l'application](#Description-de-l'application)
   * [Caractéristiques du projet](#caractéristiques-du-projet)
   * [Screenshots](#Screenshots)
   * [API](#API)
   * [AVD utilisées](#AVD-utilisées)
   * [Probleme rencontrée](#Probleme-rencontrée)
   * [Conclusion](#Conclusion)
 <!--te-->
  
     

Description de l'application
=================================
C'est une application qui permet de consuleter une liste de pays infecter par le covid, elle permet d'avoir des informations sur chaque pays.
Pour cela j'ai utiliser une API Corona mais modifier c'est a dire j'ai garder les pays europeens et fais quelque mofication sur l'API d'origine. Dans cette apllication j'ai creer ma propre API , pour afficher une liste avec les gestes barriere. On peut aussi aussi consulter une liste de vaccins.  

Caractéristiques du projet 
============================

- [x] Projet langage: Codée en Java
- [x] Glide: Bibliothèque de chargement d'images
- [x] ImageView
- [x] Affichage d'une liste 
- [x] Ecran de detail sur les Items
- [x] RecyclerView
- [x] ListView
- [x] API rest 
- [ ] Retrofit: Destinée pour afficher la deuxiemme API en utilisant cette fois retrofit , mais j'ai eu quelque probleme sur le retrofit. 
- [x] Sqllite : Utilisées pour le stockage des données en cache
- [x] Volley : Librairie HTTP
- [x] Firebase : Le firebase dans ce projet fonctionne partiellement (pour les notifiation push)
- [x] Admod : Pour afficher une pub
- [x] Webview : Dans ce projet j'utilise une autre fonctionnalite; la webview pour affiche le site suivant: https://covid19.who.int/ 
- [x] Bouton
- [x] Okhttp
- [x] Json pour les API
- [X] Screenplash : L'ecran de demmarage de l'application
- [X] Architecture : Utilisation de la segregation des interfaces
- [X] Vector asset
- [X] CardView
- [X] Test Unitaires
- [X] JavaDoc
- [X] Commentaire dans le code
- [X] Gitflow: Tres peu utilisées
- [x] http://www.json-generator.com/ : Site utilisées pour heberger les API et pour les modifications
- [x] Troisiemme liste sans utilisation D'API (liste les vaccins)
- [x] Layout
- [X] Map: Pour afficher une carte 


Screenshots
=============


<p align="middle">
  <img width="200" src="https://github.com/srikanthsc/srikanthsc/blob/master/Screenshot/screenshot%201.PNG">
  <img width="200" src="https://github.com/srikanthsc/srikanthsc/blob/master/Screenshot/screenshot%203.PNG">
  <img width="200" src="https://github.com/srikanthsc/srikanthsc/blob/master/Screenshot/screenshot%204.PNG">
  <img width="200" src="https://github.com/srikanthsc/srikanthsc/blob/master/Screenshot/screenshot%205.PNG">
  <img width="200" src="https://github.com/srikanthsc/srikanthsc/blob/master/Screenshot/screenshot%206.PNG">
  <img width="200" src="https://github.com/srikanthsc/srikanthsc/blob/master/Screenshot/screenshot%207.PNG">
  <img width="200" src="https://github.com/srikanthsc/srikanthsc/blob/master/Screenshot/screenshot%208.PNG">
  <img width="200" src="https://github.com/srikanthsc/srikanthsc/blob/master/Screenshot/screenshot%209.PNG">
  <img width="200" src="https://github.com/srikanthsc/srikanthsc/blob/master/Screenshot/screenshot%2010.PNG">
  <img width="200" src="https://github.com/srikanthsc/srikanthsc/blob/master/Screenshot/screenshot%2011.PNG">
  <img width="200" src="https://github.com/srikanthsc/srikanthsc/blob/master/Screenshot/webview.PNG">
</p>


API
=============

La creation et la modification pour les API et l'herbergement sont faites sur le site http://www.json-generator.com/
Voici le lien des API utilisées pour le projet:
- http://www.json-generator.com/api/json/get/bTzfdlcXSa?indent=2  (liste pays)
- http://www.json-generator.com/api/json/get/bPifBFnKwi?indent=2  (liste gestes barriere) 



AVD utilisées
===============
  <p align="middle">
  <img width="600" src="https://github.com/srikanthsc/srikanthsc/blob/master/Screenshot/screenshot%202.PNG">
  </p>

