package io.loop.test.day8;

public class T00_singleton_pattern_example {
    //private constructor to prevent external instantiation
    private T00_singleton_pattern_example(){}//this is an  empty constructor

    private static String word;

    //public getter
    public static String getWord(){//se crea un getter porque la variable es vacia
        if (word==null) {//if "word is null, goes and assign to driver.
            System.out.println("Firs time calling, object is null and assigning now");
            word = "driver";
        } else{
            System.out.println("word is already assigned and has value");
        }

        return word;
    }

}
