package com.testefinch.lanchonete.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.testefinch.lanchonete.model.Promocao;
import com.testefinch.lanchonete.repository.PromocaoRepository;

@Service
public class PromocaoService {
	private PromocaoRepository promocaoRepository;
	
	public List<Promocao> getAllPromocao(){
		return promocaoRepository.findAll();
	}
	public Promocao createPromocao(Promocao promocao) {
		return promocaoRepository.save(promocao);
	}
	public Promocao updatePromocao(Promocao promocao, Integer id) {
		Promocao promocao_ = promocaoRepository.getOne(id);
		promocao_.setNome(promocao.getNome());
		return promocaoRepository.save(promocao);
	}
	public String deletePromocao(Integer id) {
		promocaoRepository.deleteById(id);
		return "promocao deletado com sucesso";
	}
	public Promocao getPromocao(Integer id) {
		return promocaoRepository.getOne(id);
	}
}
