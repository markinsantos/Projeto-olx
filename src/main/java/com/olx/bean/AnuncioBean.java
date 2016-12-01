package com.olx.bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.olx.dao.Anuncio_dao;
import com.olx.dao.Imagem_dao;
import com.olx.dominio.Anuncio;
import com.olx.dominio.Imagen;
import com.olx.dominio.Usuario;
import com.olx.util.facesUtil;

@ManagedBean
@ViewScoped
public class AnuncioBean {
	Anuncio publicaCadastro = new Anuncio();

	private List<Anuncio> listaAnuncio;
	private List<Anuncio> listaAnunFiltro;
	private String nome;
	private Imagen imagem = new Imagen();

	// ----------------------------------------------------------get
	// set-----------------------------------------------------------------------------

	public Anuncio getPublicaCadastro() {
		return publicaCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPublicaCadastro(Anuncio publicaCadastro) {
		this.publicaCadastro = publicaCadastro;
	}

	public List<Anuncio> getListaAnuncio() {
		return listaAnuncio;
	}

	public void setListaAnuncio(List<Anuncio> listaAnuncio) {
		this.listaAnuncio = listaAnuncio;
	}

	public List<Anuncio> getListaAnunFiltro() {
		return listaAnunFiltro;
	}

	public void setListaAnunFiltro(List<Anuncio> listaAnunFiltro) {
		this.listaAnunFiltro = listaAnunFiltro;
	}

	// ------------------------------------------------ metodos
	// modelo-----------------------------------------------------------------------
	public void upload(FileUploadEvent evento) {
		try {

			Imagem_dao imdao = new Imagem_dao();
			UploadedFile arquivoUpload = evento.getFile();
			Path arquivoTemp = Files.createTempFile(null, null);
			Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
			imagem.setCaminho(arquivoTemp.toString());
			nome = arquivoTemp.getFileName().toString();
			Path origem = Paths.get(imagem.getCaminho());
			Path destino = Paths.get("C:/workspace/uploads/" + nome + ".jpg");
			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
			facesUtil.addMsgInfo("upload com sucesso");
			imagem.setCaminho(nome);
			imdao.salvar(imagem);
		} catch (IOException erro) {
			facesUtil.addMsgErro("erro ao carregar upload do arquivo");
			erro.printStackTrace();
		}

	}

	public void adicionar(Usuario usuario) {
		try {

			Imagem_dao imagemdao = new Imagem_dao();
			Anuncio anuncio = new Anuncio();
			Imagen imagem = imagemdao.buscar();
			anuncio.setUsuario(usuario);
			anuncio.setImagem(imagem.getCaminho());
			anuncio.setContato(publicaCadastro.getContato());
			anuncio.setNome(publicaCadastro.getNome());
			anuncio.setDescricao(publicaCadastro.getDescricao());
			anuncio.setValor(publicaCadastro.getValor());
			Anuncio_dao ad = new Anuncio_dao();
			ad.salvar(anuncio);
			imagemdao.excluir();
			facesUtil.addMsgInfo("salvo com sucesso");
			publicaCadastro = new Anuncio();
		} catch (RuntimeException e) {
			e.printStackTrace();
			facesUtil.addMsgErro("erro ao salvar Anuncio");
			publicaCadastro = new Anuncio();
		}

	}

	public void salvar() {
		try {
			if(publicaCadastro.getImagem()== null){
				publicaCadastro.setImagem("null");
			}
			Anuncio_dao ad = new Anuncio_dao();
			ad.salvar(publicaCadastro);
			// facesUtil.addMsgInfo(usuario_cadastro.toString());
			facesUtil.addMsgInfo("salvo com sucesso");
			publicaCadastro = new Anuncio();
		} catch (RuntimeException e) {
			e.printStackTrace();
			facesUtil.addMsgErro("erro ao salvar Anuncio");
		}

	}

	public void limpar() {
		publicaCadastro = new Anuncio();
	}

	public void listar(Long id) {
		try {
			Anuncio_dao ad = new Anuncio_dao();
			listaAnuncio = ad.listar(id);

		} catch (Exception e) {
			facesUtil.addMsgErro("erro ao carregar");
		}
	}

	public void busca() {

	}

	public void listar() {
		try {
			Anuncio_dao ad = new Anuncio_dao();
			listaAnuncio = ad.listar();

		} catch (Exception e) {
			facesUtil.addMsgErro("erro ao carregar");
		}
	}

	public void Anuncio() {

		System.out.println("ola");

	}
	public void carregar(){
		try {
			String valor = facesUtil.getParam("codigo");
			if(valor != null){
				Long cod = Long.parseLong(valor);
				
				Anuncio_dao ad = new Anuncio_dao();
				publicaCadastro = ad.buscar(cod);
				System.out.println(publicaCadastro.getDescricao());
			}
		} catch (Exception e) {
			facesUtil.addMsgErro("erro ao carregar");
		}
	}
	
}


