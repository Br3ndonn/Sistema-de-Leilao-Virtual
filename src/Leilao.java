import java.util.ArrayList;
import java.util.Iterator;

public class Leilao {
    private ArrayList<Lote> lotes;
    private int numeroProxLote;

    public Leilao() {
        this.lotes = new ArrayList<>();
        this.numeroProxLote = 1;
    }

    public void adicionaLote(String descricao) {
        this.lotes.add(new Lote(this.numeroProxLote, descricao));
        this.numeroProxLote++;
    }
    public void mostraLotes() {
        Iterator<Lote> it = this.lotes.iterator();
        while(it.hasNext()) {
            Lote lote = it.next();
            System.out.println(lote);
            melhorLance(lote);
        }
    }
    public void melhorLance(Lote lote) {
        Lance melhorLance = lote.getMaiorLance();
        if(melhorLance != null) {
            System.out.println("Lance: " + melhorLance.getValor());
        } else {
            System.out.println("Nenhum lance");
        }
    }
    public Lote getLote(int numero) {
        if (loteExiste(numero)) {
            Lote loteSelecionado = this.lotes.get(numero - 1);
            if(loteSelecionado.getNumero() != numero) {
                System.out.println("Erro");
            }
            return loteSelecionado;
        } else {
            return null;
        }
    }
    public ArrayList getNaoVendidos() {
        ArrayList<Lote> naoVendidos = new ArrayList<>();
        Iterator<Lote> it = this.lotes.iterator();
        while(it.hasNext()) {
            Lote lote = it.next();
            if(lote.getMaiorLance() == null) {
                naoVendidos.add(lote);
            }
        }
        return naoVendidos;
    }
    public boolean loteExiste(int numero) {
        if((numero >= 1) && (numero < this.numeroProxLote)) {
            return true;
        }
        System.out.println("Lote nº " + numero + " não existe");
        return false;
    }
    
    public void close() {
        Iterator<Lote> it = this.lotes.iterator();
        while (it.hasNext()) {
            Lote lote = it.next();
            Lance melhorLance = lote.getMaiorLance();
            if (melhorLance != null) {
                System.out.println("Lote nº: " + lote.getNumero() + "(" +
                        lote.getDescricao() + ")" + " foi vendido para " +
                        melhorLance.getLicitante().getNome() + " por " +
                        melhorLance.getValor());
            } else {
                System.out.println("Lote nº: " + lote.getNumero() + "(" +
                        lote.getDescricao() + ")" + " não foi vendido");
            }
        }
    }
}
