package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(
                                            sort = {"nome"}, direction = Sort.Direction.ASC,
                                            size = 10) Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new);
    }

    @PutMapping(path = "/{id}")
    @Transactional
    public void atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(id);
        System.out.println(medico.getNome());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
