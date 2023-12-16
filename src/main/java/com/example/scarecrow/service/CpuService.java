package com.example.scarecrow.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.scarecrow.dto.Cpu;
import com.example.scarecrow.repository.CpuRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CpuService{

	private final CpuRepository cpuRepository;
	
	private Specification<Cpu> search(String kw) {
		return new Specification<Cpu>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<Cpu> q, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.distinct(true);
				return cb.like(q.get("modelName"), "%" + kw + "%");
			}
		};
	}
	
	public List<Cpu> getList() {
		return this.cpuRepository.findAll();
	}
	
	public Page<Cpu> getList(int page, String kw) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("id"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		Specification<Cpu> spec = search(kw);
		return this.cpuRepository.findAll(spec, pageable);
	}


	//상품 하나의 정보
	public Cpu getDetail(Long id){return this.cpuRepository.findById(id).get();}
	
}
