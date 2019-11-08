package br.ucsal.lamis.util;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.lamis.model.Bloco;
import br.ucsal.lamis.model.Laboratorio;
import br.ucsal.lamis.model.Reserva;
import br.ucsal.lamis.model.Usuario;

public class Repositorioo {
	
	private List<Laboratorio> laboratorios = new ArrayList<Laboratorio>();  
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private List<Bloco> blocos = new ArrayList<Bloco>();

	private List<Reserva> reservas = new ArrayList<Reserva>();

	//java -cp ./WebContent/WEB-INF/lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:./WebContent/WEB-INF/lib/banco --dbname.0 banco

	public Repositorioo() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		this.usuarios.add(usuario);
		
		Bloco blocoA = new Bloco();
		blocoA.setId(1);
		blocoA.setNome("BLOCO A");
		
		Bloco blocoB = new Bloco();
		blocoB.setId(2);
		blocoB.setNome("BLOCO B");
		
		this.blocos.add(blocoA);
		this.blocos.add(blocoB);
		
		Reserva reserva = new Reserva();
		reserva.setDescricao("bla");
		reserva.setId(1);
		this.reservas.add(reserva);
		
		Laboratorio lab = new Laboratorio();
		lab.setNome("Laboratorio A");
		lab.setId(1);
		lab.setDescricao("Laboratorio com máquinas que possuem autocad");
		lab.setBloco(blocoA);
		this.laboratorios.add(lab);


	}

	public List<Laboratorio> getLaboratorios() {
		return laboratorios;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	} 
	
	public void inserirUsuario(Usuario usuario) {
		Usuario ultimo = usuarios.get(this.usuarios.size()-1);
		usuario.setId(ultimo.getId()+1);
		this.usuarios.add(usuario);
	}
	
	public void removerUsuario(Integer id) {
		Usuario usuario = null;
		for (Usuario item : usuarios) {
			if(item.getId()== id) {
				usuario = item;
			}
		}
		if(usuario != null) {
			this.usuarios.remove(usuario);
		}
	}
	
	public void alterarUsuario(Usuario usuario) {
		Usuario update = null;
		for (Usuario item : usuarios) {
			if(item.getId() == usuario.getId()) {
				update = item;
			}
		}
		if(update != null) {
			update.setLogin(usuario.getLogin());
			update.setSenha(usuario.getSenha());

		}
		
	}

	public Usuario obterUsuario(Integer id) {
		Usuario usuario = null;
		for (Usuario item : usuarios) {
			if(item.getId()== id) {
				usuario = item;
			}
		}
		return usuario;
	}

	public List<Bloco> getBlocos() {
		return blocos;
	}
	
	public Bloco obterBloco(Integer id) {
		Bloco bloco = null;
		for (Bloco item : blocos) {
			if(item.getId()== id) {
				bloco = item;
			}
		}
		return bloco;
	}

	public Usuario autenticar(Usuario usuario) {
		Usuario retorno = null;
		for ( Usuario item : usuarios ) {
			if( item.getLogin().equals(usuario.getLogin())
					&& item.getSenha().equals(usuario.getSenha())) {
				retorno = item;
			}
		}
		return retorno;
	}

	public Laboratorio obterLaboratorio(Integer id) {
		Laboratorio laboratorio = null;
		for (Laboratorio item : laboratorios) {
			if(item.getId()== id) {
				laboratorio = item;
			}
		}
		return laboratorio;
	}

	public void salvarLaboratorio(Laboratorio laboratorio) {
		if(laboratorio.getId() != null && laboratorio.getId() != 0) {
			alterarLaboratorio(laboratorio);
		}else {
			inserirLaboratorio(laboratorio);
		}
	}
	
	public void alterarLaboratorio(Laboratorio laboratorio) {
		Laboratorio update = null;
		for (Laboratorio item : laboratorios) {
			if(item.getId() == laboratorio.getId()) {
				update = item;
			}
		}
		if(update != null) {
			update.setNome(laboratorio.getNome());
			update.setDescricao(laboratorio.getDescricao());
			update.setBloco(laboratorio.getBloco());
		}
	}

	public void inserirLaboratorio(Laboratorio laboratorio) {
		Laboratorio ultimo = null;
		if(laboratorios.isEmpty()) {
			laboratorio.setId(1);
		} else {
			ultimo = laboratorios.get( this.laboratorios.size()-1);
			laboratorio.setId(ultimo.getId()+1);
		}
		this.laboratorios.add(laboratorio);
	}

	public void removerLaboratorio(Integer id) {
		Laboratorio laboratorio = null;
		for (Laboratorio item : laboratorios) {
			if(item.getId()== id) {
				laboratorio = item;
			}
		}
		if(laboratorio != null) {
			this.laboratorios.remove(laboratorio);
		}
	}
	
	public void inserirReserva(Reserva reserva) {
		Reserva ultimo = null;
		if(reservas.isEmpty()) {
			reserva.setId(1);
		} else {
			ultimo = reservas.get( this.reservas.size()-1);
			reserva.setId(ultimo.getId()+1);
		}
		this.reservas.add(reserva);
	}
	
	public void removerReserva(Integer id) {
		Reserva reserva = null;
		for (Reserva item : reservas) {
			if(item.getId()== id) {
				reserva = item;
			}
		}
		if(reserva != null) {
			this.reservas.remove(reserva);
		}
	}

}
