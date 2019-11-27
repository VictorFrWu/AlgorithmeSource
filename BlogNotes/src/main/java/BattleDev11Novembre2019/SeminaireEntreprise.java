package BattleDev11Novembre2019;

import java.util.Iterator;
import java.util.Scanner;

/**
 * @author he.wu During a seminar with your company in an exotic country, you
 *         have the opportunity to participate in several activities. The
 *         excursion to an island looks nice but you prefer to take part in the
 *         2-day hike. The scenery on the paths is beautiful and you've never
 *         slept under the stars before. You've been gone for more than 10 hours
 *         and unfortunately not everything is going according to plan. It rains
 *         a lot, the landscapes are not that nice and you are exhausted. You
 *         thought resting in the tents was going to make you feel better, but
 *         you realize there's one missing. The sun is almost down and you have
 *         to find a solution quickly. It's decided, a person has to sacrifice
 *         himself and it's going to be a short straw. You collect as much piece
 *         of wood as there are people and each your turn you will draw one.
 *         Whoever pulls the smallest piece of wood will sleep without a tent.
 *         You need to determine the first name of the person who is going to
 *         sleep without a tent. You are assured that there is no equality
 *         possible. Data format Input Row 1: an integer N between 10 and 100
 *         corresponding to the number of people participating in the hike. Rows
 *         2 to N+1: a string comprising between 5 and 10 lower case characters
 *         and a integer between 1 and 1000 separated by a space representing
 *         respectively the first name of a participant and the length of his
 *         piece of wood in centimeters. Output The first name of the person who
 *         will sleep without a tent
 * 
 * 
 * 
 * 
 *         En séminaire avec votre entreprise dans un pays exotique, vous avez
 *         la possibilité de participer à plusieurs activités. L’excursion sur
 *         une île a l’air sympa mais vous préférez participer à la randonnée
 *         sur 2 jours. Les paysages sur les chemins sont magnifiques et vous
 *         n’avez encore jamais dormi à la belle étoile.
 * 
 *         Vous êtes partis depuis plus de 10h et malheureusement tout ne se
 *         passe pas comme prévu. Il pleut beaucoup, les paysages ne sont pas au
 *         rendez-vous et vous êtes épuisés. Vous pensiez que sortir les tentes
 *         allait vous soulager mais vous vous rendez compte qu’il en manque
 *         une.
 * 
 *         Le soleil est presque couché donc il faut vite trouver une solution.
 *         C'est décidé, une personne doit se sacrifier et ça va se jouer à la
 *         courte paille. Vous ramassez autant de bout de bois qu’il y a de
 *         personnes et chacun votre tour vous allez en tirer un. Celui qui tire
 *         le plus petit bout de bois dormira sans tente.
 * 
 *         Vous devez déterminer le prénom de la personne qui va dormir sans
 *         tente.
 * 
 *         On vous garantit qu’il n’y a pas d’égalité possible.
 * 
 * 
 *         Format des données
 * 
 *         Entrée
 * 
 *         Ligne 1 : un entier N compris entre 10 et 100 correspondant au nombre
 *         de personnes participant à la randonnée. Lignes 2 à N+1 : une chaîne
 *         de caractères comprenant entre 5 et 10 caractères en minuscules et un
 *         entier compris entre 1 et 1000 séparés par un espace représentant
 *         respectivement le prénom d'un participant et la longueur de son bout
 *         de bois en centimètres.
 * 
 *         Sortie
 * 
 *         Le prénom de la personne qui dormira sans tente.
 */
public class SeminaireEntreprise {

	public static void main(String[] argv) throws Exception {
		String line;
		Scanner sc = new Scanner(System.in);
		int people = Integer.valueOf(sc.nextLine());
		if (people < 10 || people > 100)
			System.out.println("your people doesn't correspond to question condition");
		else {
			int i = 0;
			int[][] strs = new int[people][2];
			String[] name = new String[people];
			while (sc.hasNextLine() && i < people) {
				line = sc.nextLine();
				String[] temp = line.split(" ");
				strs[i][0] = i;
				strs[i][1] = Integer.valueOf(temp[1]);
				name[i] = temp[0];
				i++;
			}
			/*
			 * Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes
			 * les données.
			 */
			int min = strs[0][1];
			int res = 0;
			for (int j = 1; j < strs.length; j++) {
				if (strs[j][1] < min) {
					min = strs[j][1];
					res = j;
				}
			}
			System.out.println(name[res]);
		}

	}

}
