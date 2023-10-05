public class TestaLeilao {
    public static void main(String[] args) {
        Leilao l1 = new Leilao();

        l1.adicionaLote("Boi nelore"); l1.adicionaLote("Boi holandes"); l1.adicionaLote("Boi gir");

        l1.getLote(1).lancePara(new Pessoa("Joao"), 1000);
        l1.getLote(1).lancePara(new Pessoa("Jose"), 1500);
        l1.getLote(1).lancePara(new Pessoa("Maria"), 1300);
        l1.getLote(2).lancePara(new Pessoa("Maria"), 2000);



        l1.mostraLotes();
        System.out.println("==================");
        System.out.println("Nao vendidos: " + l1.getNaoVendidos());
        System.out.println("==================");
        l1.close();


    }
}
