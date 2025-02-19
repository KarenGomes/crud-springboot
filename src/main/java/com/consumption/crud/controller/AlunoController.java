package com.consumption.crud.controller;

import com.consumption.crud.models.AlunoModel;
import com.consumption.crud.repositories.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@CrossOrigin("*")
@AllArgsConstructor
public class AlunoController {

    private AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<AlunoModel>> pegaTodasOsAlunos() {
        // Recuperando todas as entradas
        return new ResponseEntity<>(alunoRepository.findAll(), HttpStatus.OK); //OK = 200
    }

    @PostMapping
    public ResponseEntity<AlunoModel> criaNovoAluno(@RequestBody AlunoModel novaAluno) {
        // Garantindo que a nova pessoa está sem Id para que o JPA entenda que é para criar uma nova entrada
        novaAluno.setId(null); //Se o id estiver null ele cria uma nova entidade, se existir no banco de dados ele atualiza o repositório
        return new ResponseEntity<>(alunoRepository.save(novaAluno), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AlunoModel> editaAluno(@RequestBody AlunoModel novaAluno) {
        // Atualizando uma pessoa existente
        return new ResponseEntity<>(alunoRepository.save(novaAluno), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletaAluno(@PathVariable Integer id) {
        // remove uma pessoa por id
        alunoRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
