package utfpr.ct.dainf.if62c.avaliacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class ProcessaLancamentos {
    //throw new UnsupportedOperationException("Não implementado");
    private BufferedReader reader;

    public ProcessaLancamentos(File arquivo) throws FileNotFoundException {
        //throw new UnsupportedOperationException("Não implementado");
        reader = new BufferedReader(new FileReader(arquivo));
    }

    public ProcessaLancamentos(String path) throws FileNotFoundException {
        //throw new UnsupportedOperationException("Não implementado");
        reader = new BufferedReader(new FileReader(new File(path)));
    }
    
    private String getNextLine() throws IOException {
        //throw new UnsupportedOperationException("Não implementado");
        return reader.readLine();
    }
    
    private Lancamento processaLinha(String linha) {
        //throw new UnsupportedOperationException("Não implementado");
        Integer cta = Integer.valueOf(linha.substring(0,6));
        Integer d = Integer.valueOf(linha.substring(12,14));
        Integer m = Integer.valueOf(linha.substring(10,12));
        Integer y = Integer.valueOf(linha.substring(6,10));
        
        GregorianCalendar gregoriano = new GregorianCalendar((int)y,(int)m-1,(int)d);
        
        Date date = new Date(gregoriano.getTimeInMillis());
        
        String desc = linha.substring(14,74).trim();
        double valorR = Double.valueOf(linha.substring(74,84));
        double valorC = Double.valueOf(linha.substring(84,86))*0.01;
        
        return new Lancamento(cta,date,desc,valorR+valorC);
    }
    
    private Lancamento getNextLancamento() throws IOException {
        //throw new UnsupportedOperationException("Não implementado");
        String l = getNextLine();
        if (l != null){
            return processaLinha(l);
        }
        else{
            return null;
        }
    }
    
    public List<Lancamento> getLancamentos() throws IOException {
        List<Lancamento> list = new ArrayList<>();
        
        while(this.getNextLine() != null){
            list.add(this.getNextLancamento());
        }
        LancamentoComparator compare = new LancamentoComparator();
        list.sort(compare);
        reader.close();
        return list;
    }
    
}
