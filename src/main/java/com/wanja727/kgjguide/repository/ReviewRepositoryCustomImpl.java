package com.wanja727.kgjguide.repository;

import com.wanja727.kgjguide.dto.MostSelectedDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ReviewRepositoryCustomImpl implements ReviewRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MostSelectedDTO> getMostSelected(String cafeId, String columnName) {

        String jpql = "select new com.wanja727.kgjguide.dto.MostSelectedDTO(a."+columnName+") " +
                        "from Review a " +
                       "where a.cafe.cafeId = :cafeId " +
                       "group by a."+columnName+" " +
                       "order by count(a."+columnName+") desc, a."+columnName+" desc ";

        System.out.println("jpql = " + jpql);

        TypedQuery<MostSelectedDTO> query = entityManager.createQuery(jpql, MostSelectedDTO.class);
        query.setParameter("cafeId", cafeId); // parameter 값 세팅

        return query.getResultList();
    }
}
