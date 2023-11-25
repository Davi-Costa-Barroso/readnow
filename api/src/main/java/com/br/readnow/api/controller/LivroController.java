package com.br.readnow.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.br.readnow.api.dto.LivroDTO;
import com.br.readnow.api.model.LivroModel;
import com.br.readnow.api.service.LivroService;

@Controller
public class LivroController {
    
    @Autowired
    private LivroService livroService;

    @GetMapping("livros")
    public Iterable<LivroModel> listarLivros(){
        return livroService.listarLivros();
    }

    @GetMapping("/verLivro")
    public String verLivro() {
        return "livro";
    }

    @PostMapping(value = "/cadastraLivro", consumes = "multipart/form-data")
    public ResponseEntity<?> cadastrarLivro(@RequestPart(value = "imagem") MultipartFile imagem,
                                            @RequestParam(value = "titulo") String titulo,
                                            @RequestParam(value = "autor") String autor,
                                            @RequestParam(value = "editora") String editora,
                                            @RequestParam(value = "isbn") String isbn,
                                            @RequestParam(value = "data_publi") String data_publi,
                                            @RequestParam(value = "categoria") String categoria,
                                            @RequestParam(value = "preco") double preco){
        LivroDTO livro = new LivroDTO();
        livro.setImagem(imagem);
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setEditora(editora);
        livro.setIsbn(isbn);
        livro.setData_publi(data_publi);
        livro.setCategoria(categoria);
        livro.setPreco(preco);
        return livroService.cadastrarLivro(livro);
    }
}
