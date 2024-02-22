package sessao_15_exececao_personalizada;

//Exeception = obriga a tratar a execao
//RuntimeExcepiton = não obriga a tratar

public class DominioExecao extends Exception{

	private static final long serialVersionUID = 1L;
	
	public DominioExecao(String msg) {
		super(msg);
	}

}
