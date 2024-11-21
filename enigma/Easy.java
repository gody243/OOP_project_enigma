package enigma;

import static java.lang.System.*;

public class Easy {
    private static String e;

    public Easy() {
        choiceOfEnigma();
    }

    public static String choiceOfEnigma() {
        e = "Choose your enigma (number) : \n1:Standford\n2:Letter\n3:Ducks\n4:Prescription\n5:Lil Brother\n6:Number9\n7:The_Room\n8:Apple tree\n9:Birds\n10:Deluge";
        return e;
    }

    public void choice() {
        out.println(e);
    }
}
