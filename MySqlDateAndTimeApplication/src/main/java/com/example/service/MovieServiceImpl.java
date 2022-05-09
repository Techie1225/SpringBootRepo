/*
 * package com.example.service;
 * 
 * import java.util.List;
 * 
 * import javax.persistence.EntityManager; import
 * javax.persistence.ParameterMode; import
 * javax.persistence.StoredProcedureQuery;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.example.entity.Movie; import com.example.repository.IMovieRepo;
 * 
 * @Service public class MovieServiceImpl implements IMovieService{
 * 
 * @Autowired public IMovieRepo repobj;
 * 
 * 
 * @Autowired EntityManager manager;
 * 
 * @Override public List<Movie> searchById(int min, int max) {
 * System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"); StoredProcedureQuery
 * query= manager.createStoredProcedureQuery("P_MOVIECONDITION", Movie.class);
 * query.registerStoredProcedureParameter(1, Movie.class,
 * ParameterMode.REF_CURSOR); query.registerStoredProcedureParameter(2,
 * Integer.class, ParameterMode.IN); query.registerStoredProcedureParameter(3,
 * Integer.class, ParameterMode.IN);
 * 
 * 
 * query.setParameter(2, min); query.setParameter(3, max);
 * 
 * List<Movie> list=query.getResultList();
 * System.out.println("***********************"); System.out.println(list);
 * //System.out.println(query.getResultList()); return list; }
 * 
 * }
 */