package com.learningJava;

public class PlayingCard {
    private String suit;
    private String face;
    private int internalHash;

    public PlayingCard(String suit, String face) {
        this.suit = suit;
        this.face = face;
        internalHash = 1;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }

//    @Override
//    public int hashCode() {
//        return super.hashCode();
//
//        //the hashset checks the hashcode first, and if they're equal, then it goes on to check the equals method.
//        //if the return statemet below is uncommented, the hashcode will be same and the calling code will go check the equals method, and add only one item
//        //of this class type, leaving out the rest as duplicates
//        // return internalHash;
//
//    }
//
//    @Override
//    public boolean equals(Object obj) {
////        return super.equals(obj);
//        System.out.println("-> checking for equality"); //to know when the method is called.
//
//        return true; //-> so they will always be equal
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayingCard that = (PlayingCard) o;

        if (!face.equals(that.face)) return false;
        return suit.equals(that.suit);
    }

    @Override
    public int hashCode() {
        int result = suit.hashCode();
        result = 31 * result + face.hashCode();
        return result;
    }

    /*.
     when creating your own equals or hashcode methods, stick to the following rules
        1. It should be very fast to compute
        2. It should produce a consistent result each time it's called. for eg, you wouldn't want to use
            a random number generateor, or a Date Time based algorithm that would return a different value each time the
            method is called.
        3. Objects that are considered equal should produce the same hashcode.
        4. Values used in the calculation should not be mutable.



     */
}
