package com.learningJava;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l", "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        List<String> hellos = Arrays.asList(aText, bText, cText, dText, eText);

        System.out.println("String : Hashcode");
        hellos.forEach(s -> System.out.printf("%s : %s %n", s,  s.hashCode()));
        //Java doesn't care if it's a different object in memory when testing for equality (aText, bText, ...) using the equals method
        //In this case, it just tests the characters are same, compared to another instance

        System.out.println();

        //The HashSet -> Implements the set interface and hashes elements before adding them
        Set<String> mySet = new HashSet<>(hellos);
        System.out.println("My Set: " + mySet);
        System.out.println("# of elements in set: " + mySet.size());

        System.out.println();
        //looping through the hellos list to see which instance was taken and added to the set, and know which and which were left out
        for (String setValue : mySet){
            System.out.print("[" + setValue + "]" + ": ");

            for (int i = 0; i < hellos.size(); i++){
                if (hellos.get(i) == setValue){ //Objects.equals(hellos.get(i), setValue) gives us all the instances, we're not checking for that
                    System.out.print(i + ", ");
                }
            }

            System.out.println();
        }

        System.out.println();

        PlayingCard aceOfHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingOfClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenOfSpades = new PlayingCard("Spades", "Queen");

        List<PlayingCard> cards = Arrays.asList(aceOfHearts, queenOfSpades, kingOfClubs);
        cards.forEach(c -> System.out.println(c + " : " + c.hashCode()));

        //adding them to a set
        Set<PlayingCard> deck = new HashSet<>();

        //Sets don't allow duplicates, so it's advisable to check if the desired element was truly added
        for (PlayingCard card : cards){
            if (!deck.add(card)){
                System.out.println("duplicate found for " + card);
            }

        }
        //print deck to see the elements added
        System.out.println(deck);
    }
}
