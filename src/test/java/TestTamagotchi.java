

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;



public class TestTamagotchi {

    @Test
    public void testInicializacao(){
        Tamagotchi tamagotchi = new Tamagotchi(20, 10, 15, 30);
        assertEquals(20, tamagotchi.getEnergiaMax(),
            "Ao inicializar um tamagotchi, a energia maxima tem que ser igual ao informado no construtor.");
        assertEquals(20, tamagotchi.getEnergiaAtual(),
            "Ao inicializar um tamagotchi, a energia atual deve ser igual a energia maxima informado no construtor.");
        assertEquals(10, tamagotchi.getSaciedadeMax(),
            "Ao inicializar um tamagotchi, a saciedade maxima tem que ser igual ao informado no construtor.");
        assertEquals(10, tamagotchi.getSaciedadeAtual(),
            "Ao inicializar um tamagotchi, a saciedade atual deve ser igual a saciedade maxima informado no construtor.");
        assertEquals(15, tamagotchi.getLimpezaMax(),
            "Ao inicializar um tamagotchi, a limpeza maxima deve ser igual ao informado no construtor.");
        assertEquals(15, tamagotchi.getLimpezaAtual(),
            "Ao inicializar um tamagotchi, a limpeza atual deve ser igual a limpeza maxima informado no construtor.");
        assertEquals(30, tamagotchi.getIdadeMax(),
            "Ao inicializar um tamagotchi, a idade maxima deve ser igual ao informado no construtor.");
        assertEquals(0, tamagotchi.getIdadeAtual(),
            "Ao inicializar um tamagotchi, a idade atual deve ser igual a 0.");
        assertEquals(0, tamagotchi.getDiamantes(),
            "Ao inicializar um tamagotchi, a quantidade de diamantes deve ser igual a 0.");
        assertTrue(tamagotchi.getEstaVivo(),
            "Ao inicializar um tamagotchi, esta Vivo deve ser igual a true.");
    }

    @Test
    public void testBrincandoEAlterandoValores(){
        Tamagotchi tamagotchi = new Tamagotchi(20, 10, 15, 30);
        assertTrue(tamagotchi.brincar(),
            "Deve ser possivel o tamagotchi brinca se ele nao tiver morrido.");
        assertEquals(18, tamagotchi.getEnergiaAtual(),
            "Ao brincar, o tamagotchi gastara 2 pontos de energia");
        assertEquals(9, tamagotchi.getSaciedadeAtual(),
            "Ao brincar, o tamagotchi gastara 1 ponto de saciedade");
        assertEquals(12, tamagotchi.getLimpezaAtual(),
            "Ao brincar, o tamagotchi gastara 3 pontos de limpeza");
        assertEquals(1, tamagotchi.getDiamantes(),
            "Ao brincar, o tamagotchi ganhara 1 diamante.");
        assertEquals(1, tamagotchi.getIdadeAtual(),
            "Ao brincar, o tamagotchi aumentara a idade em 1.");
    }

    @Test
    public void testComerAlterandoValores(){
        Tamagotchi tamagotchi = new Tamagotchi(20, 10, 15, 30);
        assertTrue(tamagotchi.brincar(),
            "Deve ser possivel o tamagotchi brinca se ele nao tiver morrido.");
        assertTrue(tamagotchi.comer(),
            "Deve ser possivel o tamagotchi comer se ele nao tiver morrido.");
        assertEquals(17, tamagotchi.getEnergiaAtual(),
            "Ao comer, o tamagotchi gastara 1 ponto de energia");
        assertEquals(10, tamagotchi.getSaciedadeAtual(),
            "Ao comer, o tamagotchi ganhara 4 pontos de saciedade");
        assertEquals(10, tamagotchi.getLimpezaAtual(),
            "Ao comer, o tamagotchi gastara 2 pontos de limpeza");
        assertEquals(1, tamagotchi.getDiamantes(),
            "Ao comer, o tamagotchi nao ganhara nenhum diamante.");
        assertEquals(2, tamagotchi.getIdadeAtual(),
            "Ao comer, o tamagotchi aumentara a idade em 1.");
    }

    @Test
    public void testConsegueDormirComEnergiaLimite(){
        Tamagotchi tamagotchi = new Tamagotchi(20, 10, 15, 30);
        assertTrue(tamagotchi.brincar(),
            "Deve ser possivel o tamagotchi brinca se ele nao tiver morrido.");
        assertTrue(tamagotchi.comer(),
            "Deve ser possivel o tamagotchi comer se ele nao tiver morrido.");    
        tamagotchi.brincar();
        assertTrue(tamagotchi.dormir(),
            "Deve ser possivel o tamagotchi dormir se ele nao tiver morrido ou tiver perdido exatamente 5 pontos de energia.");
    }

    @Test
    public void testNaoConsegueDormir(){
        Tamagotchi tamagotchi = new Tamagotchi(20, 10, 15, 30);
        assertTrue(tamagotchi.brincar(),
            "Deve ser possivel o tamagotchi brinca se ele nao tiver morrido.");
        assertTrue(tamagotchi.comer(),
            "Deve ser possivel o tamagotchi comer se ele nao tiver morrido.");
        assertFalse(tamagotchi.dormir(),
            "nao deve ser possivel o tamagotchi dormir se ele nao tiver perdido pelo menos 5 pontos de energia.");
    }

    @Test
    public void testDormirAlterandoValores(){
        Tamagotchi tamagotchi = new Tamagotchi(20, 10, 15, 30);
        assertTrue(tamagotchi.brincar(),
            "Deve ser possivel o tamagotchi brinca se ele nao tiver morrido.");
        assertTrue(tamagotchi.comer(),
            "Deve ser possivel o tamagotchi comer se ele nao tiver morrido.");
        tamagotchi.brincar();
        tamagotchi.brincar();
        assertTrue(tamagotchi.dormir(),
            "Deve ser possivel o tamagotchi dormir se ele tiver perdido pelo menos 5 pontos de energia.");
        assertEquals(20, tamagotchi.getEnergiaAtual(),
            "Ao dormir, o tamagotchi ganhara a energia maxima que ele pode ter.");
        assertEquals(6, tamagotchi.getSaciedadeAtual(),
            "Ao dormir, o tamagotchi perdera 2 pontos de saciedade");
        assertEquals(4, tamagotchi.getLimpezaAtual(),
            "Ao dormir, a limpeza do tamagotchi nao mudara.");
        assertEquals(3, tamagotchi.getDiamantes(),
            "Ao dormir, os diamantes do tamagotchi nao mudara.");
        assertEquals(11, tamagotchi.getIdadeAtual(),
            "Ao dormir, o tamagotchi aumetara sua idade equivalente ao número de turnos que ele dormiu para recuperar sua energia maxima.");
    }

    @Test
    public void testBanharAlterandoValores(){
        Tamagotchi tamagotchi = new Tamagotchi(20, 10, 15, 30);
        assertTrue(tamagotchi.brincar(),
            "Deve ser possivel o tamagotchi brinca se ele nao tiver morrido.");
        tamagotchi.brincar();
        assertTrue(tamagotchi.comer(),
            "Deve ser possivel o tamagotchi comer se ele nao tiver morrido.");
        tamagotchi.brincar();
        assertTrue(tamagotchi.banhar(),
            "Deve ser possivel o tamagotchi banhar se ele nao tiver morrido.");
        assertEquals(10, tamagotchi.getEnergiaAtual(),
            "Ao banhar, o tamagotchi perdera 3 pontos de energia.");
        assertEquals(8, tamagotchi.getSaciedadeAtual(),
            "Ao banhar, o tamagotchi perdera 1 pontos de saciedade");
        assertEquals(15, tamagotchi.getLimpezaAtual(),
            "Ao banhar, o tamagotchi ganhara a limpeza maxima que ele pode ter.");
        assertEquals(3, tamagotchi.getDiamantes(),
            "Ao banhar, os diamantes do tamagotchi nao mudara.");
        assertEquals(6, tamagotchi.getIdadeAtual(),
            "Ao banhar, o tamagotchi aumetara sua idade em 2.");
    }   

    @Test
    public void testTamagotchiMorreuSemEnergia(){
        Tamagotchi tamagotchi = new Tamagotchi(5, 10, 15, 30);
        assertTrue(tamagotchi.brincar(),
            "Deve ser possivel o tamagotchi brinca se ele nao tiver morrido.");
        tamagotchi.brincar();
        tamagotchi.brincar();
        assertFalse(tamagotchi.dormir(),
            "nao deve ser possivel dormir se o tamagotchi morreu.");
        assertFalse(tamagotchi.getEstaVivo(),
            "Quando a energia atual do tamagotchi chega em 0, ele acaba morrendo sem energia.");
        assertEquals(0, tamagotchi.getEnergiaAtual(),
            "Quando o tamagotchi morre sem energia, a sua energia atual fica zerada.");
    }

    @Test
    public void testTamagotchiMorreuDeFome(){
        Tamagotchi tamagotchi = new Tamagotchi(20, 5, 15, 30);
        assertTrue(tamagotchi.brincar(),
            "Deve ser possivel o tamagotchi brinca se ele nao tiver morrido.");
        tamagotchi.brincar();
        tamagotchi.brincar();
        assertTrue(tamagotchi.dormir(),
            "Deve ser possivel o tamagotchi dormir se ele tiver perdido pelo menos 5 pontos de energia.");
        assertFalse(tamagotchi.comer(),
            "nao deve ser possivel comer se o tamagotchi morreu.");
        assertFalse(tamagotchi.getEstaVivo(),
            "Quando a saciedade atual do tamagotchi chega em 0, ele acaba morrendo de fome");
        assertEquals(0, tamagotchi.getSaciedadeAtual(),
            "Quando o tamagotchi morre de fome, a sua fome atual fica zerada.");
    }

    @Test
    public void testTamagotchiMorreuSujo(){
        Tamagotchi tamagotchi = new Tamagotchi(20, 10, 5, 30);
        assertTrue(tamagotchi.brincar(),
            "Deve ser possivel o tamagotchi brinca se ele nao tiver morrido.");
        tamagotchi.brincar();
        assertFalse(tamagotchi.banhar(),
            "nao deve ser possivel banhar se o tamagotchi morreu.");
        assertFalse(tamagotchi.getEstaVivo(),
            "Quando a limpeza atual do tamagotchi chega em 0, ele acaba morrendo de sujeira.");
        assertEquals(0, tamagotchi.getLimpezaAtual(),
            "Quando o tamagotchi morre de sujeira, a sua limpeza atual fica zerada.");
    }

    @Test
    public void testTamagotchiMorreuDeVelhice(){
        Tamagotchi tamagotchi = new Tamagotchi(20, 10, 15, 10);
        assertTrue(tamagotchi.brincar(),
            "Deve ser possivel o tamagotchi brinca se ele nao tiver morrido.");
        tamagotchi.brincar();
        tamagotchi.brincar();
        assertTrue(tamagotchi.dormir(),
            "Deve ser possivel o tamagotchi dormir se ele tiver perdido pelo menos 5 pontos de energia.");
        assertTrue(tamagotchi.banhar(),
            "Deve ser possivel o tamagotchi banhar se ele nao tiver morrido.");
        assertFalse(tamagotchi.getEstaVivo(),
            "Quando a idade atual ultrapassa a idade maxima, ele acaba morrendo de velhice.");
        assertEquals(10, tamagotchi.getIdadeAtual(),
            "Quando o tamagotchi morre de velhice, a sua idade atual fica igual a idade maxima.");
    }
    
    @Test
    public void testTamagotchiMorreuENaoPodeFazerAcoes(){
        Tamagotchi tamagotchi = new Tamagotchi(4, 10, 15, 10);
        assertTrue(tamagotchi.brincar(),
            "Deve ser possivel o tamagotchi brinca se ele nao tiver morrido.");
        tamagotchi.brincar();
        assertFalse(tamagotchi.getEstaVivo(),
            "Quando a energia atual do tamagotchi chega em 0, ele acaba morrendo sem energia.");
        assertFalse(tamagotchi.brincar(),
            "nao deve ser possivel brincar se o tamagotchi  morreu.");
        assertFalse(tamagotchi.banhar(),
            "nao deve ser possivel banhar se o tamagotchi morreu.");
        assertFalse(tamagotchi.comer(),
            "nao deve ser possivel comer se o tamagotchi morreu.");
        assertFalse(tamagotchi.dormir(),
            "nao deve ser possivel dormir se o tamagotchi morreu.");
        assertEquals(0, tamagotchi.getEnergiaAtual(),
            "Como nao foi possivel fazer mais ações o tamagotchi permanece com a energia atual inalterada.");
        assertEquals(8, tamagotchi.getSaciedadeAtual(),
            "Como nao foi possivel fazer mais ações o tamagotchi permanece com a saciedade atual inalterada.");
        assertEquals(9, tamagotchi.getLimpezaAtual(),
            "Como nao foi possivel fazer mais ações o tamagotchi permanece com a limpeza atual inalterada.");
        assertEquals(2, tamagotchi.getDiamantes(),
            "Como nao foi possivel fazer mais ações o tamagotchi permanece com os diamantes inalterados.");
        assertEquals(2, tamagotchi.getIdadeAtual(),
            "Como nao foi possivel fazer mais ações o tamagotchi permanece com a idade atual inalterada.");
    }
}