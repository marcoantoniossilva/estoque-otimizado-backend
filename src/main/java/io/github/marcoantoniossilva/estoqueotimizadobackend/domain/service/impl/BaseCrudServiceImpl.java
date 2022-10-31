package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.impl;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.exception.ResourceNotFoundException;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.BaseCrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseCrudServiceImpl<ENTITY, ID> implements BaseCrudService<ENTITY, ID> {

  protected abstract JpaRepository<ENTITY, ID> getRepository();
  protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  public List<ENTITY> findAll() {
    return this.getRepository().findAll();
  }

  public Page<ENTITY> findAll(Pageable pageable) {
    return this.getRepository().findAll(pageable);
  }

  public Optional<ENTITY> findById(ID id) {
    return this.getRepository().findById(id);
  }

  public ENTITY findByIdOrException(ID id) {
    return this.getRepository().findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Recurso não encontrado!"));
  }

  public Boolean existsById(ID id) {
    return this.getRepository().existsById(id);
  }

  public Long count() {
    return this.getRepository().count();
  }

  @Transactional
  public ENTITY save(ENTITY entity) {
    LOGGER.trace("Salvando {} com valores {}", this.getGenericClassName(), entity);
    return this.getRepository().save(entity);
  }

  @Transactional
  public void deleteById(ID id) {
    LOGGER.trace("Deletando {} com id: {}", this.getGenericClassName(), id);
    this.getRepository().deleteById(id);
  }

  @Transactional
  public void delete(ENTITY entity) {
    LOGGER.trace("Deletando {} com valores: {}", this.getGenericClassName(), entity);
    this.getRepository().delete(entity);
  }

  private String getGenericClassName() {
    ParameterizedType genericSuperClass = (ParameterizedType) this.getClass().getGenericSuperclass();
    Class<?> genericClass = (Class<?>) genericSuperClass.getActualTypeArguments()[0];
    return genericClass.getSimpleName();
  }
}
