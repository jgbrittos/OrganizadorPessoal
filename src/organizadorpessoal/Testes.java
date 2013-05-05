package organizadorpessoal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Testes {
	
	public static File criaDiretorios(String nome) throws IOException{
		File diretorioTeste = new File(nome);
		diretorioTeste.mkdir();
		/*diretorioTeste.getTotalSpace();
		diretorioTeste.getFreeSpace();
		diretorioTeste.getUsableSpace();*/
		
		return diretorioTeste;
	}
	
	public static void renomeiaDiretorios(File diretorioASerRenomeado, String nome) throws IOException{
		File diretorioAuxiliar = new File(nome);
		diretorioASerRenomeado.renameTo(diretorioAuxiliar);
	}
	
	public static void excluirDiretorios(File diretorioASerRenomeado, String nome) throws IOException{
		File diretorioAuxiliar = new File(nome);
		diretorioASerRenomeado.renameTo(diretorioAuxiliar);
	}
	
	public static File criaArquivos(File caminho, String nome) throws IOException{
		File arquivo = new File(caminho, nome);
		arquivo.createNewFile();
		return arquivo;
	}
	
	public static void renomeiaArquivos(File diretorioDoArquivoASerRenomeado, String NovoNomeDoArquivo){
		File diretorioAuxiliar = new File(NovoNomeDoArquivo);
		diretorioDoArquivoASerRenomeado.renameTo(diretorioAuxiliar);
	}
	
	public static void excluirArquivos(File diretorioDoArquivoASerExcluido) throws IOException{
		diretorioDoArquivoASerExcluido.delete();
	}
	
	public static String capturaHoraEDataDoSistema(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  
		String horaEData = (sdf.format(new Date()));
		return horaEData;
	}
	
	public static void criaLogDeInformacoesDoDiretorio(File diretorio, String[] textoASerEscrtito, String[] tipoDeArquivo) throws IOException{
		
		File arquivo = criaArquivos(diretorio, "Log de Informações dos Arquivos Neste Diretorio.txt");	
                
		FileWriter fw = new FileWriter(arquivo, true);
		
		BufferedWriter bw = new BufferedWriter(fw);
		
		int numeroDeArquivosNoDiretorio = textoASerEscrtito.length;
		int auxiliar = 0;
		
		bw.write("---------------------------------------------------");
		bw.newLine();
		for(auxiliar = 0; auxiliar != numeroDeArquivosNoDiretorio; auxiliar++){
			bw.write(textoASerEscrtito[auxiliar] + " - " + tipoDeArquivo[auxiliar]);
			bw.newLine();
		}
		
		String horaEData = capturaHoraEDataDoSistema();
		
		bw.newLine();
		bw.write("ÚLTIMA MODIFICAÇÃO = " + horaEData);
		bw.newLine();
		bw.close();
		fw.close();
		
	}
	
	public static void abrirQualquerTipoDeArquivo(File diretorio) throws IOException{
		java.awt.Desktop.getDesktop().open(diretorio);
	}
	
	public static void escrever(File diretorio, String[] textoASerEscrtito, String[] tipoDeArquivo) throws IOException{
		
/*		File arquivo = criaArquivos(diretorio, "Lista de Arquivos Neste Diretorio.txt");
		
		FileWriter fw = new FileWriter(arquivo, true);
		
		BufferedWriter bw = new BufferedWriter(fw);
		
		int numeroDeArquivosNoDiretorio = textoASerEscrtito.length;
		int auxiliar = 0;
		
		bw.write("---------------------------------------------------");
		bw.newLine();
		for(auxiliar = 0; auxiliar != numeroDeArquivosNoDiretorio; auxiliar++){
			bw.write(textoASerEscrtito[auxiliar] + " - " + tipoDeArquivo[auxiliar]);
			bw.newLine();
		}
	
		bw.newLine();
		bw.close();
		fw.close();
		*/
		
	}
	
	public static String[] identificaSeEArquivoOuPasta(File diretorio, int numeroDeArquivosNoDiretorio, File[] listaDeArquivos){
		
		String []tipoDeArquivo = new String[numeroDeArquivosNoDiretorio];
		
		int i;
		
		for(i=0;i != numeroDeArquivosNoDiretorio;i++){
			File arquivoAvaliado = listaDeArquivos[i];
		     if (arquivoAvaliado.isDirectory()) {
		    	 tipoDeArquivo[i] = "É um diretório.";
		    	 
		     } else if (arquivoAvaliado.isFile()) {
                         String auxiliar = arquivoAvaliado.getName();
                         int indiceDoPonto = auxiliar.lastIndexOf(".");//ultima ocorrencia do ponto no nome do arquivo
		    	 tipoDeArquivo[i] = " É um arquivo do tipo (" + auxiliar.substring(indiceDoPonto, auxiliar.length()) + ")";
		         
		     }else{
		    	 tipoDeArquivo[i] = "Não é arquivo nem pasta!";
		     }
		}
		
		return tipoDeArquivo;
	}
	
	public static String[] criaListaDeArquivosNoDiretorio(File diretorio) throws IOException{
		
		String []arquivos;
		arquivos = diretorio.list();
                
                return arquivos;
		
	}
        
        public static String[] criaListaDeTiposDeArquivosNoDiretorio(File diretorio) throws IOException{
		
		String []listaDosNomesDosArquivos = criaListaDeArquivosNoDiretorio(diretorio);
		
		String []tipoDeArquivo;
		
		File []listaDeArquivos = new File[listaDosNomesDosArquivos.length];
		
		int numeroDeArquivosNoDiretorio = listaDosNomesDosArquivos.length;
		int auxiliar = 0;
		
		for(File lista: diretorio.listFiles()){
			listaDeArquivos[auxiliar] = lista;
			auxiliar++;
		}
		
		return tipoDeArquivo = identificaSeEArquivoOuPasta(diretorio,numeroDeArquivosNoDiretorio, listaDeArquivos);
		
	}
        
        public static String capturaDiretorioCorrente(){
           //System.out.println(System.getProperty("user.dir"));
           return System.getProperty("user.dir"); 
        }
        
	public static void main(String[] args) throws IOException {
                
                String teste = capturaDiretorioCorrente();
            
		String nomeDiretorio;
		nomeDiretorio = "C:\\teste";
		criaDiretorios(nomeDiretorio);//cria uma pasta 'teste' em 'C:\\'
		nomeDiretorio = "C:\\teste\\teste2" ;
		criaDiretorios(nomeDiretorio);//cria uma pasta 'teste2' em 'C:\\teste1'
		nomeDiretorio = "C:\\teste\\teste3" ;
		criaDiretorios(nomeDiretorio);//cria uma pasta 'teste2' em 'C:\\teste1'
		
		String nome = "testeDeCriacaoDeArquivosPorMetodo.txt";//nome do arquivo que sera criado
		String diretorioDoArquivo = "C:\\teste";//diretorio do arquivo que sera criado
		File diretorio = new File(diretorioDoArquivo);
		criaArquivos(diretorio, nome);//cria um arquivo texto no diretorio = 'diretorio' com titulo = 'nome'
		
		criaArquivos(diretorio, "testeParaRenomeio.txt");//cria um arquivo texto no diretorio = 'diretorio' com titulo = 'testeParaRenomeio'
		
		diretorioDoArquivo = "C:\\teste\\teste2";//diretorio do arquivo que sera criado
		File diretorioDoArquivoDeTeste1 = new File(diretorioDoArquivo);
		criaArquivos(diretorioDoArquivoDeTeste1, "testeDeCriacaoEmSubPastas.txt");
		
		//nome = "testeDeRenomeioDeArquivosPorMetodo.txt";
		//renomeiaArquivos(diretorio, nome);
		
		String []listaDeArquivosNoDiretorio = criaListaDeArquivosNoDiretorio(diretorio);
                String []listaDosTiposDeArquivosNoDiretorio = criaListaDeTiposDeArquivosNoDiretorio(diretorio);
                criaLogDeInformacoesDoDiretorio(diretorio,listaDeArquivosNoDiretorio,listaDosTiposDeArquivosNoDiretorio);
                /*
                 TAMBEM PODE SER ASSIM:
                 criaLogDeInformacoesDoDiretorio(diretorio,criaListaDeArquivosNoDiretorio(diretorio),criaListaDeTiposDeArquivosNoDiretorio(diretorio));
                 */
		//abrirQualquerTipoDeArquivo(diretorio);
		 
	}
}

/*
ARRUMAR AS EXCLUSOES E RENOMEIOS
PESQUISA DOS ARQUIVOS POR TITULO, AUTOR, GENERO, ANO DE LANÇAMENTO
PESQUISAR SOBRE XML
* TESTE DE COMMIT
*/