package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import veiculos.veiculosInfo;

@WebServlet(urlPatterns="/provap1")
public class UsuarioController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	private List<veiculosInfo> lista = new ArrayList<>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json="[";
		
		int id = lista.size();
		String placa = req.getParameter("placa");
		String nome = req.getParameter("nome");
		String marca = req.getParameter("marca");
		String valor = req.getParameter("valor");
		
		veiculosInfo veic = new veiculosInfo(id,placa,nome,marca,valor);
		
		lista.add(veic);
		json +="\n id: "+id+" placa: "+placa+" nome: "+nome+" marca: "+marca+" valor: "+valor+" }";
		resp.getWriter().print(json);
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id = Integer.parseInt("id");
		
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).getId() == id){
				lista.remove(i);
				i=-1;
				resp.getWriter().print("\n Vazio");
			}
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json="[";
		
		int id = Integer.parseInt("id");
		String placa = req.getParameter("placa");
		String nome = req.getParameter("nome");
		String marca = req.getParameter("marca");
		String valor = req.getParameter("valor");
		
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).getId() == id ){
				lista.get(i).setPlaca(placa);
				lista.get(i).setNome(nome);
				lista.get(i).setMarca(marca);
				lista.get(i).setValor(valor);
				json +="\n id: "+id+" placa: "+placa+" nome: "+nome+" marca: "+marca+" valor: "+valor+" }";
				resp.getWriter().print(json);
				
			}
		}
				
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int qtd=0;
		int j=0;
		
		
		//todos os veiculos 
		resp.getWriter().print("\n todos os veiculos");
		String json="[";
		for(int i=0;i<lista.size();i++){
			json += "\n todos os veiculos{ID: "+lista.get(i).getId()+", placa: "+lista.get(i).getPlaca()+", nome: "+lista.get(i).getNome()+", marca: "+lista.get(i).getMarca()+", valor: "+lista.get(i).getValor()+" } ";
			qtd++;
			if(i<lista.size())
				json+= ",";
		}
		json +="]";
		
		
		
		//qtd veiculos cadastrados
			
		json += "\n {qtd: "+qtd+" } ";
		
		
		
		
		//veiclus mais barato
		int valor=Integer.parseInt(lista.get(0).getValor());
		for(int i=0;i<lista.size();i++){
			if( Integer.parseInt(lista.get(i).getValor()) <= valor ){
				valor=Integer.parseInt(lista.get(i).getValor());
				j=i;
				}
			
		}
		json += "\n veiclus mais barato {ID: "+lista.get(j).getId()+", placa: "+lista.get(j).getPlaca()+", nome: "+lista.get(j).getNome()+", marca: "+lista.get(j).getMarca()+", valor: "+lista.get(j).getValor()+" } ";
		
		
	
		
		
		//veiclus mais caro
		
		valor=Integer.parseInt(lista.get(0).getValor());
		
			for(int i=0;i<lista.size();i++){
			if( Integer.parseInt(lista.get(i).getValor()) >= valor ){
				valor=Integer.parseInt(lista.get(i).getValor());
				j=i;
				}
			
			
			
		}
		json += "\n veiclus mais caro {ID: "+lista.get(j).getId()+", placa: "+lista.get(j).getPlaca()+", nome: "+lista.get(j).getNome()+", marca: "+lista.get(j).getMarca()+", valor: "+lista.get(j).getValor()+" } ";
			
		json +="]";
		
		resp.getWriter().print(json);
		
		
		
	}
	
}
