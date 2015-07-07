
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.avaliacao.*;


/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class Avaliacao3 {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Scanner enter = new Scanner(System.in);
        System.out.println("--->");
        String nomeArq = enter.next();
        ProcessaLancamentos p = new ProcessaLancamentos(nomeArq);
        
        List<Lancamento> lista = p.getLancamentos();
        
        Integer c = null;
        System.out.println("Conta -->");
        if (enter.hasNextInt()) {
            c = enter.nextInt();
            exibeLancamentosConta(lista, c);
        }
        else {
            enter.next();
            System.out.println("Por favor, informe um valor numérico");
        }
        while(c != 0 ){
            System.out.println("Conta -->");
            if (enter.hasNextInt()) {
                c = enter.nextInt();
                exibeLancamentosConta(lista, c);
            }
            else {
                enter.next();
                System.out.println("Por favor, informe um valor numérico");
            }
        }
        
    }
    
    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {
        int index = lancamentos.indexOf(new Lancamento(conta, null, null, null)); 
        if (index < 0) {
            return;
        }
        for(int i = index ; index < lancamentos.size() && lancamentos.get(i).getConta().equals(conta) ; i++) {
            System.out.println(lancamentos.get(index));
        }
    }
 
}