package com.algaworks.awpag.awpag.api.controller;

import com.algaworks.awpag.awpag.domain.model.cliente;
import com.algaworks.awpag.awpag.domain.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    private ClienteRepository clienteRepository;

    //@PersistenceContext
    //private EntityManager manager;


    @GetMapping
    public List<cliente> listar() {
        return clienteRepository.findByNomeContaining("ato"); //consulta exata
        //consultando parte do nome "LIKE"

//        return clienteRepository.findAll();

//        return manager.createQuery("from cliente", cliente.class)
//                .getResultList();

    }
            @GetMapping("{clienteId}")
           public ResponseEntity<cliente> buscar(@PathVariable Long clienteId){
            Optional<cliente> cliente =  clienteRepository.findById(clienteId);

                  if (cliente.isPresent()) {

                      return ResponseEntity.ok(cliente.get());
                  }

                  return ResponseEntity.notFound().build();
//            return cliente.orElse(null);

           }
           @ResponseStatus(HttpStatus.CREATED)
        @PostMapping
           public cliente adicionar(@RequestBody cliente cliente) {

   return clienteRepository.save(cliente);
        }
        @PutMapping("/{clienteId}")
    public ResponseEntity<Object> atualizar(@PathVariable Long clienteId, @RequestBody  cliente cliente){
            if (!clienteRepository.existsById(clienteId)) {
                return ResponseEntity.notFound().build();
            }
            cliente.setId(clienteId);
            cliente = clienteRepository.save(cliente);
            return ResponseEntity.ok(cliente);
        }


}
