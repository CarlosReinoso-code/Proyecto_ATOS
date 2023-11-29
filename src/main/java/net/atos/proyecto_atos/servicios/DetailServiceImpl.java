package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.DetailDTO;
import net.atos.proyecto_atos.entidades.Detail;
import net.atos.proyecto_atos.excepciones.ResourceNotFoundException;
import net.atos.proyecto_atos.mappers.DetailMapper;
import net.atos.proyecto_atos.repositorios.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailMapper detailMapper;

    @Autowired
    private DetailRepository detailRepository;

    @Override
    public DetailDTO crearDetalle(DetailDTO detailDTO) {

        Detail detail = detailMapper.toEntity(detailDTO);
        Detail newDetail = detailRepository.save(detail);
        return detailMapper.toDto(newDetail);
    }

    @Override
    public List<DetailDTO> getTodosDetalles() {

        List<Detail> detailList = detailRepository.findAll();
        return detailList.stream().map(detailMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public DetailDTO getDetalle(long id) {

        Detail detail = detailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Detalle", "ID", id));
        return detailMapper.toDto(detail);
    }

    @Override
    public DetailDTO actualizarDetalle(DetailDTO detailDTO, long id) {

        Detail detail = detailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Detalle", "ID", id));
        detail.setBudgets(detailDTO.getBudgets());
        detail.setContents(detailDTO.getContents());
        detail.setDates(detailDTO.getDates());
        detail.setTypes(detailDTO.getTypes());
        return null;
    }

    @Override
    public void eliminarDetalle(long id) {

        Detail detail = detailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Detalle", "ID", id));
        detailRepository.delete(detail);
    }
}
