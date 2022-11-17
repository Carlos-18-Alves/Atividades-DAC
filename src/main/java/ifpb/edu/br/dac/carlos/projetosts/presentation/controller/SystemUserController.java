package ifpb.edu.br.dac.carlos.projetosts.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ifpb.edu.br.dac.carlos.projetosts.business.service.ConverterService;
import ifpb.edu.br.dac.carlos.projetosts.business.service.SystemUserService;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.SystemUser;
import ifpb.edu.br.dac.carlos.projetosts.presentation.dto.UserDTO;

@RestController
@RequestMapping("api/user")
public class SystemUserController {

    @Autowired
    private SystemUserService service;
    @Autowired
    private ConverterService converterService;

    @PostMapping
    public ResponseEntity save(@RequestBody UserDTO dto) {

        try {
            SystemUser entity = converterService.dtoToUser(dto);
            entity = service.save(entity);
            dto = converterService.userToDTO(entity);
            return new ResponseEntity(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody UserDTO dto) {
        try {
            dto.setId(id);
            SystemUser entity = converterService.dtoToUser(dto);
            entity = service.update(entity);
            dto = converterService.userToDTO(entity);
            
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }   
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        try {
            service.delete(id);
            
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping
    public ResponseEntity find(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "id", required = false) Integer id
            ) {
        
        try {
            SystemUser filter = new SystemUser();
            filter.setId(id);
            filter.setName(name);
            filter.setUsername(username);
            
            List<SystemUser> entities = service.find(filter);
            List<UserDTO> dtos = converterService.userToDTO(entities);
            
            return ResponseEntity.ok(dtos);
        } catch (Exception  e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    
}
