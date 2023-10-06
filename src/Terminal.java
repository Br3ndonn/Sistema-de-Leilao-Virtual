import java.util.Scanner;

public class Terminal {
    private Leilao leilao;
    private int modoAtual;

    public Terminal() {
        this.leilao = new Leilao();
        this.modoAtual = 1;
    }

    public void iniciaOperacao() {
        int opcao;

        opcao = this.getOpcao();
        while (opcao != 8) {
            switch (opcao) {
                case 1:
                    this.leilao.adicionaLote(getString("Descricao: "));
                    break;
                case 2: Lote lote = leilao.getLote(getInt("Numero do lote: "));
                	if(lote == null) {
                		break;
                	} 
                	this.leilao.getLote(lote.getNumero()).lancePara(new Pessoa(getString("nome: ")), (double) getInt("Valor: "));
                	break;
                case 3:
                    this.leilao.close();
                    break;
                case 4:
                    this.leilao = new Leilao();
                    break;
                case 5:
                    this.leilao.mostraLotes();
                    break;

            }
            opcao = getOpcao();
        }
    }

    private int getOpcao() {
        int opcao = 0;

        do {
            if (this.modoAtual == 1) {
                opcao = getInt("Opção: 1 - Adiciocar Lotes, 2 - Dar Lance, 3 - Fechar Leilão, 5 - Mostra Lotes, 8 - Sair");
                if (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5 && opcao != 8) {
                    opcao = 0;
                }
            } else {
                opcao = getInt("Opção: 4 - Novo leilão, 8 - Sair");
                if (opcao != 4 && opcao != 8) {
                    opcao = 0;
                }
            }
        } while (opcao == 0);
        return opcao;
    }

    private int getInt(String string) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entre com: " + string);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        System.out.println("Erro na leitura de dados");
        return 0;
    }
    
    

    private String getString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entre com: " + prompt);
        return scanner.nextLine();
    }
}
