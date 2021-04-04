package dev.boxz.dev.boxz.test;

import java.util.*;

public class Main {

    public static void main (String[] args) {
    }

    public void war(Queue<Integer> a, Queue<Integer> b){
        Queue<Integer> temp=new LinkedList<> ();
        while (!a.isEmpty ()&& !b.isEmpty ()){
            if (a.element ()> b.element ()){
                a.add (a.remove ());
                a.add (b.remove ());
            }
            else if (b.element ()>a.element ()){
                b.add (b.remove ());
                b.add (a.remove ());
            }
            else if (a.element ()==b.element ()){
                while (a.element ()==b.element ()){
                    temp.add (a.remove ());
                    temp.add (b.remove ());
                    temp.add (a.remove ());
                    temp.add (b.remove ());
                }
                if (a.element ()>b.element ()){
                    while (!temp.isEmpty ()){
                        a.add (temp.remove ());
                    }
                }
                if (b.element ()>a.element ()){
                    while (!temp.isEmpty ()){
                        b.add (temp.remove ());
                    }
                }
            }
        }
    }
}
