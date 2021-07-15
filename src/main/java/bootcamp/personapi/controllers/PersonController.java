package bootcamp.personapi.controllers;

import lombok.AllArgsConstructor;
import bootcamp.personapi.dto.request.PersonDTO;
import bootcamp.personapi.dto.response.MessageResponseDTO;
import bootcamp.personapi.exception.PersonNotFoundException;
import bootcamp.personapi.services.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(value = "/api/v1/people", description = "Endpoint API de Gerenciamneto de Pessoas", consumes="application/json")
@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    @ApiOperation(value = "Inserir Pessoa por ID")
    @ApiResponse(code = 201, message = "Inseriu um registro de pessoa")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    
    @ApiOperation(value = "Buscar Pessoa por ID")
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Retorno pessoa por ID", response = PersonDTO.class),
        @ApiResponse(code = 422, message = "Nenhum pessoa encontado com esse ID")})
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }
    

    @ApiOperation(value = "Listar Pessoas")
    @ApiResponse(code = 200, message = "Retorno pessoa por ID", response = PersonDTO.class, responseContainer = "List")
    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }


    @ApiOperation(value = "Atualizar Pessoa por ID")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.update(id, personDTO);
    }


    @ApiOperation(value = "Deletar Pessoa por ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}
