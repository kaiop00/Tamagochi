public class Runner {

    public static void main(final String[] args) {

        Tamagotchi tamagotchi = new Tamagotchi(20, 10, 15, 30);
        System.out.println(tamagotchi);
        // E:20/20, S:10/10, L:15/15, D:0, I:0

        tamagotchi.brincar();
        System.out.println(tamagotchi);
        // E:18/20, S:9/10, L:12/15, D:1, I:1

        tamagotchi.comer();
        System.out.println(tamagotchi);
        // E:17/20, S:10/10, L:10/15, D:1, I:2

        tamagotchi.brincar();
        tamagotchi.brincar();

        tamagotchi.dormir();
        System.out.println(tamagotchi);
        // E:20/20, S:6/10, L:4/15, D:3, I:11 

        tamagotchi.banhar();
        System.out.println(tamagotchi);

        if(!tamagotchi.dormir()){
            System.out.println("fail: o tamagotchi não está com sono");
        } // fail: o tamagotchi não está com sono

        tamagotchi.brincar();
        tamagotchi.brincar();
        tamagotchi.brincar();
        tamagotchi.brincar();
        tamagotchi.brincar();
        System.out.println(tamagotchi);
        // E:7/20, S:0/10, L:0/15, D:8, I:18

        if(!tamagotchi.comer()){
            System.out.println("fail: o seu tamagotchi morreu.");  
        }//fail: o seu tamagotchi morreu.

        if(!tamagotchi.dormir()){
            System.out.println("fail: o seu tamagotchi morreu.");
        }//fail: o seu tamagotchi morreu.
        if(!tamagotchi.brincar()){
            System.out.println("fail: o seu tamagotchi morreu.");
        }//fail: o seu tamagotchi morreu.

        if(!tamagotchi.banhar()){
            System.out.println("fail: o seu tamagotchi morreu.");
        }//fail: o seu tamagotchi morreu.
    }
}