package com.example.scarecrow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.scarecrow.dto.Ssd;
import com.example.scarecrow.repository.SsdRepository;
import com.example.scarecrow.repository.SsdRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SsdService{

	private final SsdRepository ssdRepository;
	
	private Specification<Ssd> search(String kw) {
		return new Specification<Ssd>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<Ssd> q, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.distinct(true);
				return cb.like(q.get("modelName"), "%" + kw + "%");
			}
		};
	}
	
	public List<Ssd> getList() {
		return this.ssdRepository.findAll();
	}
	
	public Page<Ssd> getList(int page, String kw) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("id"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		Specification<Ssd> spec = search(kw);
		return this.ssdRepository.findAll(spec, pageable);
	}
	
}
