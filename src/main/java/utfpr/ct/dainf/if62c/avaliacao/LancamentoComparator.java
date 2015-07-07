package utfpr.ct.dainf.if62c.avaliacao;

import java.util.Comparator;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class LancamentoComparator implements Comparator<Lancamento>{

    public LancamentoComparator() {
    }
    
    @Override
    public int compare(Lancamento a, Lancamento b){
        if(a.getConta().equals(b.getConta())){ ///AQUIIIIII
            long data = a.getData().getTime() - b.getData().getTime();
            return(int)data; 
        }
        else
            return a.getConta()-b.getConta();
    }
}
