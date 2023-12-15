package com.example.scarecrow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.scarecrow.dto.Mainboard;
import com.example.scarecrow.dto.Mainboard;
import com.example.scarecrow.repository.MainboardRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MainboardService {
	
	private final MainboardRepository mainboardRepository;
	
	private Specification<Mainboard> search(String kw) {
		return new Specification<Mainboard>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<Mainboard> q, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.distinct(true);
				return cb.like(q.get("modelName"), "%" + kw + "%");
			}
		};
	}
	
	public List<Mainboard> getList() {
		return this.mainboardRepository.findAll();
	}
	
	public Page<Mainboard> getList(int page, String kw) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("id"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		Specification<Mainboard> spec = search(kw);
		return this.mainboardRepository.findAll(spec, pageable);
	}

}
