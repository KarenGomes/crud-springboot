package com.consumption.crud.controller;

import com.consumption.crud.models.PessoaModel;
import com.consumption.crud.repositories.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin("*") //para funcionar em qualquer navegador e qualquer cenario
@AllArgsConstructor
public class PessoaController {
    private PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity<List<PessoaModel>> pegaTodasAsPessoas() {
        // Recuperando todas as entradas
        return new ResponseEntity<>(pessoaRepository.findAll(), HttpStatus.OK); //OK = 200
    }

    @PostMapping
    public ResponseEntity<PessoaModel> criaNovaPessoa(@RequestBody PessoaModel novaPessoa) {
        // Garantindo que a nova pessoa está sem Id para que o JPA entenda que é para criar uma nova entrada
        novaPessoa.setId(null); //Se o id estiver null ele cria uma nova entidade, se existir no banco de dados ele atualiza o repositório
        return new ResponseEntity<>(pessoaRepository.save(novaPessoa), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PessoaModel> editaPessoa(@RequestBody PessoaModel novaPessoa) {
        // Atualizando uma pessoa existente
        return new ResponseEntity<>(pessoaRepository.save(novaPessoa), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletaPessoa(@PathVariable Integer id) {
        // remove uma pessoa por id
        pessoaRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
