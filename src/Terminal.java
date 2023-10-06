import java.util.Scanner;

public class Terminal {
    private Leilao leilao;
    private int modoAtual;

    public Terminal() {
        this.leilao = new Leilao();
        this.modoAtual = 0;
    }

    public void iniciaOperacao() {
        int opcao, qtd_lotes;

        opcao = this.getOpcao();
        while (opcao != 8) {
            switch (opcao) {
                case 1: qtd_lotes = getInt("Qtd de lotes a serem adicionados: ");
                    for (int i = 0; i < qtd_lotes; i++) {
                        this.leilao.adicionaLote(getString("Descricao: "));
                    }
                        modoAtual = 1;
                    break;
                case 2: Lote lote = leilao.getLote(getInt("Numero do lote: "));
                	if(lote == null) {
                		break;
                	} 
                	this.leilao.getLote(lote.getNumero()).lancePara(new Pessoa(getString("Nome Licitante: ")), getInt("Valor: "));
                	break;
                case 3: this.leilao.close();
                    modoAtual = 0;
                    break;
                case 4: this.leilao = new Leilao();
                    modoAtual = 0;
                    break;
                case 5: this.leilao.mostraLotes();
                    break;
                case 6: this.leilao.getNaoVendidos();
                    break;
            }
            opcao = getOpcao();
        }
    }

    private int getOpcao() {
        int opcao = 0;

        do {
            if (this.modoAtual == 1) {
                opcao = getInt("2 - Dar Lance, 3 - Fechar Leilão, 5 - Mostrar Lotes, 8 - Sair");
                if (opcao != 2 && opcao != 3 && opcao != 5 && opcao != 8) {
                    opcao = 0;
                }
            } else {
                opcao = getInt("Opção: 1 - Adicionar Lotes, 4 - Novo leilão, 8 - Sair");
                if (opcao != 1 && opcao != 4 && opcao != 8) {
                    opcao = 0;
                }
            }
        } while (opcao == 0);
        return opcao;
    }

    private int getInt(String string) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("" + string);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        System.out.println("Erro na leitura de dados");
        return 0;
    }

    private String getString(String string) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("" + string);
        return scanner.nextLine();
    }
}
