package com.microservico.estoquepreco.controller;

import com.microservico.estoquepreco.constantes.RabbitMQConstantes;
import com.microservico.estoquepreco.dto.EstoqueDTO;
import com.microservico.estoquepreco.services.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {


    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity alteraEstoque(@RequestBody  EstoqueDTO estoqueDTO){
        System.out.println(estoqueDTO.codigoProduto);
        this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_ESTOQUE, estoqueDTO);
        return new ResponseEntity(HttpStatus.OK);

    }
}
