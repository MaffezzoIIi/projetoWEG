package br.com.projeto.projetoWeg.api.assembler;

import br.com.projeto.projetoWeg.api.model.UsuarioDTO;
import br.com.projeto.projetoWeg.api.model.input.UsuarioInputDTO;
import br.com.projeto.projetoWeg.domain.entities.Usuario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class UsuarioAssembler {

    private ModelMapper modelMapper;

    public UsuarioDTO toModel(Usuario usuario){
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public Usuario toEntity(UsuarioInputDTO usuarioInputDTO){
        return modelMapper.map(usuarioInputDTO, Usuario.class);
    }

    public List<UsuarioDTO> toCollectionModel(List<Usuario> usuarios){
        return usuarios.stream().map(this::toModel).collect(Collectors.toList());
    }

}
