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

        /*
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Subquery<SomeColumnType> subcq = cq.subquery(SomeColumnType.class);
        Root<MyTable> from = subcq.from(MyTable.class);
        subcq.select(from.get(MyTable_.someColumn));
        subcq.where(** complex where statements **);
        subcq.groupBy(from.get(MyTable_.someColumn));
        cq.select(cb.count(subcq));
         */

        /*
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MostSeletedScoreDTO> query = cb.createQuery(MostSeletedScoreDTO.class);
        Root<Review> review = query.from(Review.class);
        Path<Object> path = review.get("cafe.cafeId");
        query.select(cb.count());
         */

//        String type = "";
//
//        if (columnName.equals("storeSize")) {
//            type = "StoreSize";
//        } else if (columnName.equals("floor")) {
//            type = "Floor";
//        } else if (columnName.equals("consentScore") || columnName.equals("wifiScore") || columnName.equals("comfortScore")) {
//            type = "Integer";
//        }

        String jpql = "select new com.wanja727.kgjguide.dto.MostSelectedDTO(a."+columnName+") " +
                        "from Review a " +
                       "where a.cafe.cafeId = :cafeId " +
                       "group by a."+columnName+" " +
                       "order by count(a."+columnName+") desc, a."+columnName+" desc ";

//        String jpql = "select new com.wanja727.kgjguide.dto.MostSeletedScoreDTO<Integer>(a.comfortScore) "+
//             "from Review a "+
//            "where a.cafe.cafeId = :cafeId "+
//            "group by a.comfortScore "+
//            "order by count(a.comfortScore) desc, a.comfortScore desc";

        System.out.println("jpql = " + jpql);

        // 조건에 따라서 각각의 where문에 parameter 설정
        TypedQuery<MostSelectedDTO> query = entityManager.createQuery(jpql, MostSelectedDTO.class);
        query.setParameter("cafeId", cafeId);

        return query.getResultList();
    }
}
