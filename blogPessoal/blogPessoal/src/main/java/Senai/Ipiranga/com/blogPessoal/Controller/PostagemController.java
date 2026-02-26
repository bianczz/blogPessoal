package Senai.Ipiranga.com.blogPessoal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Senai.Ipiranga.com.blogPessoal.Model.Postagem;
import Senai.Ipiranga.com.blogPessoal.Repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

	@Autowired 
	private PostagemRepository repository;
	
	@GetMapping 
	public ResponseEntity <List <Postagem >> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable  String titulo){ //pegar o texto como endereço
		return ResponseEntity.ok(repository.findByTituloContainingIgnoreCase(titulo)); //nome do metodo getbytitulo vai retornar um valor uma lista de postagens ele recebe um parametro(string) na variavel titulo
	}
	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem){//o metodo post entidade postagem recebendo um corpo de informação na variavel postagem criado na model
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));//metodo post postar uma nova postagem no status de criar um novo registro enviando um conjunto de dados do tipo repositorio dentro da variavel postagem  
	}
	@PutMapping 
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem){//o mesmo dados q vc usa pra criar vc usa para editar
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	@DeleteMapping("/id/{id}")//pra deletar o id especifico e não deletar tudo
	public void delete(@PathVariable long id ){
		repository.deleteById(id); //forma que esta no model
	}
	
	
}

