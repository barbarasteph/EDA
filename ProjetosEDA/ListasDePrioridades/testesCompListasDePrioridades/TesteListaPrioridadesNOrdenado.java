package testesCompListasDePrioridades;

import java.io.IOException;
import java.util.List;

import listasDePrioridades.*;
import edaUtilListasDePrioridades.CriarInstancia;
import edaUtilListasDePrioridades.EDAConstants;
import edaUtilListasDePrioridades.EDAUtil;
import edaUtilListasDePrioridades.Operacao;

public class TesteListaPrioridadesNOrdenado {
	public static void main(String args[]){		
		try {
			for (int tamanho : CriarInstancia.tamanhoInstancias) {				
				String path = EDAConstants.caminhoPasta + "tarefa" + tamanho + ".txt";
				List<Integer> entrada = EDAUtil.getDadosIniciais(path);
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE INSER��ES
				String arquivoOperacao = "operacoesI_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				List<Operacao> operacoes = EDAUtil.getOperacoes(path);
				
				long tempoInicial = System.currentTimeMillis();				
				LPMaximaNOrdenada listaPrioridade = new LPMaximaNOrdenada(2*entrada.size());
				listaPrioridade.construir(entrada);							
			
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("I")){
						listaPrioridade.inserir(operacao.getValor());
					}
				}	
				long tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE ALTERA��ES
				arquivoOperacao = "operacoesA_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new LPMaximaNOrdenada(2*entrada.size());
				listaPrioridade.construir(entrada);							
			
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("A")){
						listaPrioridade.alterarPrioridade(operacao.getValor(), operacao.getNovoValor());
					}
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);		
				
				//Para arquivo com maior quantidade de REMOÇÃO.
				arquivoOperacao = "operacoesR_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new LPMaximaNOrdenada(2*entrada.size());
				listaPrioridade.construir(entrada);							
			
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("R")){
						listaPrioridade.remove();
					}
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);	
				
				//Para arquivo com maior quantidade de SELEÇÃO.
				arquivoOperacao = "operacoesS_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new LPMaximaNOrdenada(2*entrada.size());
				listaPrioridade.construir(entrada);							
			
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("S")){
						listaPrioridade.getMaximaPrioridade();
					}
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}