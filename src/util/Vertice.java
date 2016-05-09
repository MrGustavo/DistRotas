package util;

/**
 * Classe V�rtice do Grafo.
 * @author Gustavo Henrique.
 * @author Leonardo Melo.
 * @since 16 abr. 2016.
 *
 */

public class Vertice {

	private int grau;
	private boolean foiVisitado = false;
	private Object objeto;

	
	public boolean foiVisitado() {
		return foiVisitado;
	}

	public void setFoiVisitado(boolean foiVisitado) {
		this.foiVisitado = foiVisitado;
	}
	
	/*___________________________________________________________________________________________*/
	/**
	 * Construtor da classe.	
	 * @param objeto - Objeto do v�rtice.
	 */
	public Vertice(Object objeto){
		this.setObjeto(objeto);
		grau = 0;
		//listaArestas = new ArrayList<Aresta>();
	}

	/*___________________________________________________________________________________________*/
	/**
	 * Retorna o grau do v�rtice.
	 * @return grau - Grau do v�rtice.
	 */
	public int getGrau() {
		return grau;
	}
	/*___________________________________________________________________________________________*/
	/**
	 * Altera o grau do v�rtice.
	 * @param grau - Novo grau do v�rtice.
	 */
	public void setGrau(int grau) {
		this.grau = grau;
	}
	/*___________________________________________________________________________________________*/
	/**
	 * Retorna a lista de arestas do v�rtice.
	 * @return listaArestas - Lista de arestas do v�rtice.
	 */
	/*public ArrayList<Aresta> getListaArestas() {
		return listaArestas;
	}*/
	/*___________________________________________________________________________________________*/
	/**
	 * Altera a lista de arestas do v�rtice.
	 * @param listaArestas - Nova lista de arestas do v�rtice.
	 */
	/*public void setListaArestas(ArrayList<Aresta> listaArestas) {
		this.listaArestas = listaArestas;
	}*/
	/*___________________________________________________________________________________________*/

	/**
	 * Retorna o objeto do v�rtice.
	 * @return objeto - Objeto do v�rtice.
	 */
	public Object getObjeto() {
		return objeto;
	}
	/*___________________________________________________________________________________________*/
	/**
	 * Altera o objeto do v�rtice.
	 * @param objeto - Novo objeto do v�rtice.
	 */
	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	/*___________________________________________________________________________________________*/
}
