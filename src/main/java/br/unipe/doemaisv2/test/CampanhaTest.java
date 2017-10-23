package br.unipe.doemaisv2.test;

import br.unipe.doemaisv2.model.Campanha;
import br.unipe.doemaisv2.model.CentroRecolhimento;
import br.unipe.doemaisv2.model.Usuario;

public class CampanhaTest {
	
	public static void main(String[] args) {
		/*EntityManagerFactory fac = Persistence.createEntityManagerFactory("doemaisv2");
		EntityManager manager = fac.createEntityManager();*/
		System.out.println("Campanha COM padrão Observer.\n");
		
		Usuario criador = new Usuario();
		criador.setLogin("usuarioteste");
		
		CentroRecolhimento local = new CentroRecolhimento();
		local.setNome("Hemocentro da Paraiba");
		
		Campanha campanha = new Campanha();
		campanha.setNome("Campanha DoeMais");
		campanha.setData("23/10/2017");
		campanha.setCriador(criador);
		campanha.setLocal(local);
		
		campanha.addObserver(local);
		campanha.addObserver(criador);
		
		campanha.setAprovada(true);
		
		/*manager.getTransaction().begin();
		manager.persist(campanha);
		manager.getTransaction().commit();
		manager.close();*/
	}

}