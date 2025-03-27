package com.remington.documental.repository;

import com.remington.documental.model.HistorialDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialDocumentoRepository extends JpaRepository<HistorialDocumento, Long> {
}
