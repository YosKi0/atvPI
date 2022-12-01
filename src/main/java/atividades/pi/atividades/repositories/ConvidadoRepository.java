package atividades.pi.atividades.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import atividades.pi.atividades.models.atv302;
import atividades.pi.atividades.models.convidado;

public interface ConvidadoRepository extends JpaRepository<convidado, Long>{

	List<convidado > findByEvento(atv302 evento);
	
}
