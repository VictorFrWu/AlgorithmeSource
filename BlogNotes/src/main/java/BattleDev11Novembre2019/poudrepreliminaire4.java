package BattleDev11Novembre2019;

/**
 * @author mac
 * 
 *         You accidentally glide with your slippers on your flying carpet and
 *         fall through quicksand into a magical cavern where there is a
 *         fabulous treasure. The treasure is composed of different powders and
 *         whose price is given to you per kilogram as well as the total
 *         quantity of each of the powders contained in the cave. The treasure
 *         also contains precious stones, each with an indivisible weight and
 *         value. You only have with you an old oil lamp (you believed what?
 *         it's not magic eh!) and you have to indicate which powders and gems
 *         you must select in order to maximize the value of the treasure you
 *         will bring to the surface ( greedy that you are)! Hint: if you have
 *         recognized here the "Knapsack problem";
 *         https://en.wikipedia.org/wiki/Knapsack_problem,you are on the right
 *         track, but the very large number of objects changes will require
 *         additional code !
 * 
 * 
 *         Data format
 * 
 *         Input Row 1: 3 integers separated by spaces: N the number of
 *         gemstones, M, the number of types of powders, C number (in gram) of
 *         stones or powder that the lamp can hold,
 * 
 *         each between 1 and 100. Rows 2 to N + 1: 2 integers separated by
 *         spaces, respectively the value (in gold coins) and the weight (in
 *         grams) of each gemstone, between 1 and 1000 and 1 and C respectively.
 *         Rows N + 2 to N + M + 2: 2 integers separated by spaces, respectively
 *         the price by weight (in gold coins per gram) and the amount available
 *         (in grams) of each type of powder, between 1 and 100 and 1 and C
 *         respectively. Output The maximum value that the lamp can hold in
 *         precious stones and powders!
 * 
 *         Example Input 2 2 100 600 40 1000 50 20 40 15 80 Output 1950 Comment
 *         In this example the optimal is to take the object of value 1000, then
 *         40 grams of powder whose value is 20 gold coins per gram, then 10
 *         grams of powder whose value is 15 gold coins per gram. It leads to a
 *         value of 1000 - 800 - 150 = 1950
 * 
 * 
 * 
 *         Vous glissez malencontreusement avec vos babouches sur votre tapis
 *         volant et tombez à travers des sables mouvants dans une caverne
 *         magique où se trouve un fabuleux trésor.
 * 
 *         Le trésor est composé de différentes épices et poudres plus
 *         précieuses les unes que les autres dont on vous donne le prix au
 *         kilogramme ainsi que la quantité totale de chacune des poudres
 *         contenues dans la caverne. Le trésor comporte également des pierres
 *         précieuses, chacune a un poids et une valeur indivisible. Vous n'avez
 *         avec vous qu'une vielle lampe à huile de contenance finie (vous avez
 *         cru quoi ? ce n'est pas magique hein !) et vous devez indiquer
 *         quelles poudres et pierres précieuses emporter dedans pour maximiser
 *         la valeur du trésor que vous allez rapporter à la surface (avide que
 *         vous êtes) !
 * 
 * 
 *         Indice : si vous avez reconnu ici le "problème du sac à dos"
 *         (https://fr.wikipedia.org/wiki/Problème_du_sac_à_dos), vous êtes sur
 *         la bonne piste, mais le très grand nombre d'objets change un peu la
 *         donne !
 * 
 *         Données
 * 
 *         Entrée
 * 
 *         Ligne 1 : 3 entiers séparés par des espaces : N le nombre de pierres
 *         précieuses, M le nombre de types de poudres, C la quantité (en
 *         gramme) de pierres ou poudre que peux contenir la lampe, chacun
 *         compris entre 1 et 100. Lignes 2 à N + 1 : 2 entiers séparés par des
 *         espaces, respectivement la valeur (en pièces d'or) et le poids (en
 *         grammes) de chaque pierre précieuse, compris respectivement entre 1
 *         et 1000 et 1 et C Lignes N + 2 à N + M + 2 : 2 entiers séparés par
 *         des espaces, respectivement le prix au poids (en pièces d'or par
 *         gramme) et la quantité disponible (en grammes) de chaque type de
 *         poudre, compris respectivement entre 1 et 100 et 1 et C.
 * 
 *         Sortie
 * 
 *         La valeur maximale que peux contenir la lampe en pierres précieuses
 *         et poudres !
 * 
 *         Exemple
 * 
 *         Entrée
 * 
 *         2 2 100 600 40 1000 50 20 40 15 80
 * 
 *         Sortie
 * 
 *         1950
 * 
 *         Commentaire
 * 
 *         Dans cet exemple l'optimal est de prendre l'objet de valeur 1000,
 *         puis 40 grammes de poudre à 20 pièces d'or par gramme, puis 10
 *         grammes de poudre à 15 pièces d'or par gramme. On arrive alors à une
 *         valeur de 1000 + 800 + 150 = 1950
 * 
 * 
 */
public class poudrepreliminaire4 {

}
