package com.booleanuk;

import java.util.HashMap;
import java.util.Stack;

public class Scrabble {
    HashMap<Character, Integer> alphabet = new HashMap<>();
    String word;
    public Scrabble(String word) {
        this.word = word;

        alphabet.put('A', 1);
        alphabet.put('B', 3);
        alphabet.put('C', 3);
        alphabet.put('D', 2);
        alphabet.put('E', 1);
        alphabet.put('F', 4);
        alphabet.put('G', 2);
        alphabet.put('H', 4);
        alphabet.put('I', 1);
        alphabet.put('J', 8);
        alphabet.put('K', 5);
        alphabet.put('L', 1);
        alphabet.put('M', 3);
        alphabet.put('N', 1);
        alphabet.put('O', 1);
        alphabet.put('P', 3);
        alphabet.put('Q', 10);
        alphabet.put('R', 1);
        alphabet.put('S', 1);
        alphabet.put('T', 1);
        alphabet.put('U', 1);
        alphabet.put('V', 4);
        alphabet.put('W', 4);
        alphabet.put('X', 8);
        alphabet.put('Y', 4);
        alphabet.put('Z', 10);

        // Stack<Character> chars = new Stack<>();

    }

    public int score() {
        int totalscore = 0;
        int doubleword = 1;
        int tripleword = 1;
        int wordlength = word.length();

        for (int i=0; i<wordlength; i++){
            char c = word.toUpperCase().charAt(i);

            if (Character.isWhitespace(c)){
                i++;

            } else if (i==0 & c=='{') {
                if (word.charAt(2) == '}'){
                    totalscore += (alphabet.get(word.toUpperCase().charAt(i+1)) * 2);
                    i++;
                }
                else if (word.charAt(wordlength-1) == '}'){
                    doubleword = 2;
                    if (word.charAt(1) == '['){
                        if (word.charAt(3) == ']'){
                            totalscore += (alphabet.get(word.toUpperCase().charAt(i+2)) * 3);
                            i++;
                            i++;
                        }
                        else if (word.charAt(wordlength-2) == ']'){
                            tripleword = 3;
                            i++;
                        }
                        else {
                            return 0;
                        }
                    }
                }
                else {
                    return 0;
                }
            }

            else if (i==0 & c=='[') {
                if (word.charAt(2) == ']'){
                    totalscore += (alphabet.get(word.toUpperCase().charAt(i+1)) * 3);
                    i++;
                }
                else if (word.charAt(wordlength-1) == ']'){
                    tripleword = 3;
                    if (word.charAt(1) == '{'){
                        if (word.charAt(3) == '}'){
                            totalscore += (alphabet.get(word.toUpperCase().charAt(i+2)) * 2);
                            i++;
                            i++;
                        }
                        else if (word.charAt(wordlength-2) == '}'){
                            doubleword = 2;
                            i++;
                        }
                        else {
                            return 0;
                        }
                    }
                }
                else {
                    return 0;
                }

            } else if (c=='}') {
                if (i>1 && word.charAt(i-2) == '{'){
                    totalscore += 0;
                } else if (word.charAt(0)=='{') {
                    totalscore += 0;
                } else if (word.charAt(1)=='{') {
                    totalscore += 0;
                } else{
                    return 0;
                }

            } else if (c==']') {
                if (i>1 && word.charAt(i-2) == '['){
                    totalscore += 0;
                } else if (word.charAt(0)=='[') {
                    totalscore += 0;
                } else if (word.charAt(1)=='[') {
                    totalscore += 0;
                } else{
                    return 0;
                }
            } else if (i!=0 & c == '{') {
                if (word.charAt(i+2) == '}'){
                    totalscore += (alphabet.get(word.toUpperCase().charAt(i+1)) * 2);
                    i++;
                }
                else {
                    return 0;
                }
            } else if (i!=0 & c == '[') {
                if (word.charAt(i+2) == ']'){
                    totalscore += (alphabet.get(word.toUpperCase().charAt(i+1)) * 3);
                    i++;
                }
                else {
                    return 0;
                }
            } else if (Character.isLetter(c)) {
                totalscore += alphabet.get(c);
            } else {
                    return 0;
                }
            }

        return totalscore * doubleword * tripleword;
    }

}
