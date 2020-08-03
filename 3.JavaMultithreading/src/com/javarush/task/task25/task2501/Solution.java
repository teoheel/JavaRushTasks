package com.javarush.task.task25.task2501;

/* 
Новые возможности!
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(Alphabet.A.getLetterPosition());
        System.out.println(Alphabet.B.getLetterPosition());
        System.out.println(Alphabet.C.getLetterPosition());
        System.out.println(Alphabet.D.getLetterPosition());
        System.out.println(Alphabet.E.getLetterPosition());
        System.out.println(Alphabet.F.getLetterPosition());
        System.out.println(Alphabet.G.getLetterPosition());
        System.out.println(Alphabet.H.getLetterPosition());
        System.out.println(Alphabet.I.getLetterPosition());
        System.out.println(Alphabet.J.getLetterPosition());
        System.out.println(Alphabet.K.getLetterPosition());
        System.out.println(Alphabet.L.getLetterPosition());
        System.out.println(Alphabet.M.getLetterPosition());
        System.out.println(Alphabet.N.getLetterPosition());
        System.out.println(Alphabet.O.getLetterPosition());
        System.out.println(Alphabet.P.getLetterPosition());
        System.out.println(Alphabet.Q.getLetterPosition());
        System.out.println(Alphabet.R.getLetterPosition());
        System.out.println(Alphabet.S.getLetterPosition());
        System.out.println(Alphabet.T.getLetterPosition());
        System.out.println(Alphabet.U.getLetterPosition());
        System.out.println(Alphabet.V.getLetterPosition());
        System.out.println(Alphabet.W.getLetterPosition());
        System.out.println(Alphabet.X.getLetterPosition());
        System.out.println(Alphabet.Y.getLetterPosition());
        System.out.println(Alphabet.Z.getLetterPosition());
    }

    public enum Alphabet {
        A, B, C, D, E,
        F, G, H, I, J,
        K, L, M, N, O,
        P, Q, R, S, T,
        U, V, W, X, Y, Z;

        int getLetterPosition() {
            return ordinal() + 1;
        }
    }
}
