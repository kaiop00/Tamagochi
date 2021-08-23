import java.util.Scanner;

class Bichinho {
    private int energia;
    private int minEnergia;
    private int subEnergia;
    private int saciedade;
    private int limpeza;
    private int idade;
    private int energiaMax;
    private int saciedadeMax;
    private int limpezaMax;
    private int idadeMax;
    private int diamantes;
    private boolean alive;
    private int aux;

    Bichinho(int energiaMax, int saciedadeMax, int limpezaMax, int idadeMax) {
        this.energia = energiaMax;
        this.minEnergia = 5;
        this.energiaMax = energiaMax;
        this.saciedade = saciedadeMax;
        this.saciedadeMax = saciedadeMax;
        this.limpeza = limpezaMax;
        this.limpezaMax = limpezaMax;
        this.idadeMax = idadeMax;
        this.idade = 0;
        this.aux = 0;
        this.diamantes = 0;
        this.alive = true;
        this.subEnergia = energiaMax - minEnergia;
    }

    private boolean setEnergia(int value) {
        if(value <= 0) {
            energia = 0;
            alive = false;
            return false;
        }else if(value > energiaMax) {
            energia = energiaMax;
        }else{
            energia = value;
        }
        return true;
    }

    private boolean setSaciedade(int value) {
        if(value <= 0) {
            saciedade = 0;
            alive = false;
            return false;
        }else if(value > saciedadeMax) {
            saciedade = saciedadeMax;
        }else {
            saciedade = value;
        }
        return true;
    }

    private boolean setLimpeza(int value) {
        if(value <= 0) {
            limpeza = 0;
            alive = false;
            return false;
        }else if(value > limpezaMax) {
            limpeza = limpezaMax;
        }else {
            limpeza = value;
        }
        return true;
    }

    private void setDiamantes(int value) {
        diamantes = diamantes + value;
    }

    private boolean setIdade(int value) {
        idade = value;
        if(idade > idadeMax) {
            idade = idadeMax;
            alive = false;
            return false;
        }
        return true;
    }

    public int getEnergia() {
        return energia;
    }
    
    public boolean isAlive() {
        return alive;
    }

    public int getSaciedade() {
        return saciedade;
    }

    public int getLimpeza() {
        return limpeza;
    }

    public int getDiamantes() {
        return diamantes;
    }

    public int getIdade() {
        return idade;
    }
    boolean testaMorto() {
        if(alive){
            return false;
        }
        return true; 
    }

    

    public boolean brincar() {
        aux += 2;
        setIdade(getIdade() + 1);
        setEnergia(getEnergia() - 2);
        setSaciedade(getSaciedade() - 1);
        setLimpeza(getLimpeza() - 3);
        setDiamantes(getDiamantes() + 1);
        if(testaMorto()){
            return false;
        }
        return true;
    }

    public boolean comer() {
        
        setEnergia(getEnergia() - 1);
        setSaciedade(getSaciedade() + 4);
        setLimpeza(getLimpeza() - 2);
        setIdade(getIdade() + 1);
        if (testaMorto()){
            return false;
        }
        return true;
    }

    public boolean dormir() {
        if(energia >= subEnergia){
            return false;
            
        }else{
            setSaciedade(getSaciedade() - 2);
            while(energia != energiaMax) {
                setEnergia(getEnergia() + 1);
                setIdade(getIdade() + 1);
            }
            return true;
        }
    }

    public boolean banho() {
        setSaciedade(getSaciedade() - 1);
        setEnergia(getEnergia() - 3);
        setLimpeza(getLimpeza() + limpezaMax);
        setIdade(getIdade() + 2);
        if (testaMorto()){
            return false;
        }
        return true;
    }

    public String toString() {
        return "E: " + energia + "/" + energiaMax + " S: " + saciedade + "/" + saciedadeMax + " L: " + limpeza + "/" + limpezaMax + " D: " + diamantes + " I: " + idade;
    }
}

public class Main {
    public static void main(String[] args) {
        Bichinho tama = new Bichinho(20, 10, 15, 30);
        //System.out.println(tama);
        // E:20/20, S:10/10, L:15/15, D:0, I:0

        tama.brincar();
        //System.out.println(tama);
        // E:18/20, S:9/10, L:12/15, D:1, I:1

        tama.comer();
        //System.out.println(tama);
        // E:17/20, S:10/10, L:10/15, D:1, I:2

        tama.brincar();
        tama.brincar();

        tama.dormir();
        //System.out.println(tama);
        // E:20/20, S:6/10, L:4/15, D:3, I:11 

        tama.banho();
        //System.out.println(tama);

        if(!tama.dormir()){
            //System.out.println("fail: o tamagotchi não está com sono");
        } // fail: o tamagotchi não está com sono

        tama.brincar();
        tama.brincar();
        tama.brincar();
        tama.brincar();
        tama.brincar();
        //System.out.println(tama);
        // E:7/20, S:0/10, L:0/15, D:8, I:18
    
        
        if(!tama.comer()){
            //System.out.println("fail: o seu tamagotchi morreu.");  
        }//fail: o seu tamagotchi morreu.

        if(!tama.dormir()){
            //System.out.println("fail: o seu tamagotchi morreu.");
        }//fail: o seu tamagotchi morreu.
        if(!tama.brincar()){
            //System.out.println("fail: o seu tamagotchi morreu.");
        }//fail: o seu tamagotchi morreu.

        if(!tama.banho()){
            //System.out.println("fail: o seu tamagotchi morreu.");
        }//fail: o seu tamagotchi morreu.

        
    }
}