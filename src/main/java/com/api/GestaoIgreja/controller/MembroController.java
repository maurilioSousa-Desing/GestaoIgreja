package com.api.GestaoIgreja.controller;

import com.api.GestaoIgreja.model.Membro;
import com.api.GestaoIgreja.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MembroController {

    @Autowired
    MembroRepository membroRepository;

    @GetMapping("/membros")
    public List<Membro> getAllMembros(){
        System.out.println("Selecionar Todos os Membros...");

        List<Membro> customers = new ArrayList<>();
        membroRepository.findAll().forEach(customers::add);

        return customers;
    }

    @PostMapping(value = "/membros/create")
    public Membro postMembro(@RequestBody Membro membro) {

        Membro _membro = membroRepository.save(new Membro(membro.getNome(), membro.getCpf()));
        return _membro;
    }

    @DeleteMapping("/membros/{id}")
    public ResponseEntity<String> deleteMembro(@PathVariable("id") long id) {
        System.out.println("Delete Membro com ID = " + id + "...");

        membroRepository.deleteById(id);

        return new ResponseEntity<>("Membro foi deletado!", HttpStatus.OK);
    }

    @DeleteMapping("/membros/delete")
    public ResponseEntity<String> deleteTodosMembros() {
        System.out.println("Deletar todos os membros...");

        membroRepository.deleteAll();

        return new ResponseEntity<>("Todos os Membros foram deletados!", HttpStatus.OK);
    }

    @GetMapping(value = "membros/cpf/{cpf}")
    public List<Membro> findByCpf(@PathVariable long cpf) {

        List<Membro> _membros = membroRepository.findByCpf(cpf);
        return _membros;
    }

    @PutMapping("/membros/{id}")
    public ResponseEntity<Membro> updateMembro(@PathVariable("id") long id, @RequestBody Membro membro) {
        System.out.println("Update do Membro com o ID = " + id + "...");

        Optional<Membro> customerData = membroRepository.findById(id);

        if (customerData.isPresent()) {
            Membro _membro = customerData.get();
            _membro.setNome(_membro.getNome());
            _membro.setCpf(_membro.getCpf());
            _membro.setAtivo(membro.isAtivo());
            return new ResponseEntity<>(membroRepository.save(_membro), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
