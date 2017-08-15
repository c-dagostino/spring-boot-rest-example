package com.javarticle.spring.dao;

/**
 * Created by ChrisDAgostino on 8/11/17.
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.javarticle.spring.entity.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class AuthorDAO implements IAuthorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Author GetAuthorById(int id) {
        return entityManager.find(Author.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Author> GetAllAuthors() {

        String hql = "FROM Author as a ORDER BY a.lastName";
        return (List<Author>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void UpsertAuthor(Author author) {
        Author dbItem = entityManager.find(Author.class, author.getId());

        if (dbItem != null)
        {
            dbItem.setLastName(author.getLastName());
            dbItem.setFirstName(author.getFirstName());

        }
        else {
            entityManager.persist(dbItem);
        }

    }


    @Override
    public void DeleteAuthor(int id) {
        entityManager.remove(GetAuthorById(id));
    }

}
