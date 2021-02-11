package com.example.cursomc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.domain.Produto;
import com.example.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat2 = new Categoria(0,"Escritório");
		Categoria cat1 = new Categoria(1,"Informática");

		Produto p1 = new Produto(0,"Computador", 2000.00);
		
		cat1.getProdutos().add(p1);
		cat2.getProdutos().add(p1);
		Set<Categoria> categorias = new HashSet<>(Arrays.asList(cat1, cat2));
		
		p1.setCategorias(categorias);
		
		produtoRepository.save(p1);
	}

}
