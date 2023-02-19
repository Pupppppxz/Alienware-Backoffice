package com.softwaretesting.alienware.repositories.category;

import com.softwaretesting.alienware.models.CategoryModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<CategoryModel> findAll() {
        try {
            Query query = entityManager.createNativeQuery(
                    "SELECT * FROM public.\"Categories\";",
                    CategoryModel.class
            );
            return  query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public CategoryModel findById(UUID id) {
        try {
            Query query = entityManager.createNativeQuery("select * from public.\"Categories\" c" +
                            "where c.\"CategoryId\" = ?;"
                    ,CategoryModel.class);
            query.setParameter(1,id);
            if (query.getFirstResult() == 0){
                return null;
            }
            return (CategoryModel) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UUID create(CategoryModel category) {
        try {
            Query query = entityManager.createNativeQuery("insert into public.\"Categories\" " +
                    "(\"Name\",\"CreatedAt\",\"UpdatedAt\")" +
                    "values (?,?,?) returning \"CategoryId\";",
                    UUID.class);
            query.setParameter(1, category.getCategoryName());
            query.setParameter(2, category.getCreatedAt());
            query.setParameter(3, category.getUpdatedAt());
            return (UUID) query.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public UUID deleteById(UUID id) {
        try {
            Query query = entityManager.createNativeQuery("delete from public.\"Categories\" c" +
                    "where c.\"CategoryId\" = ? returning c.\"CategoryId\"",
                    UUID.class);
            query.setParameter(1,id);
            return (UUID) query.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UUID update(CategoryModel newCategory) {
        try {
            Query query = entityManager.createNativeQuery("update public.\"Categories\" c" +
                    "set c.\"Name\" = ?, " +
                    "c.\"UpdatedAt\" = ?" +
                    "where c.\"CategoryId\" = ?" +
                    "returning c.\"CategoryId\"",
                    UUID.class
            );
            query.setParameter(1,newCategory.getCategoryName());
            query.setParameter(2,LocalDateTime.now());
            query.setParameter(3,newCategory.getId());
            return (UUID) query.getResultList().get(0);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
