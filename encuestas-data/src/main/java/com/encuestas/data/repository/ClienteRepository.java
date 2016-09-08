/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.data.repository;

import com.encuestas.data.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    List<Cliente> findByEmpresaIdEmpresaAndInPromocion(Integer idEmpresa, Boolean inPromocion);

    
    List<Cliente> findByPersonaNuDocumentoAndPersonaTipoDocumentoCoTipoDocumento(String nuDocumento, String coTipoDocumento);
//    @Query("select cli "
//            + "from Cliente cli "
//            + " where cli.idCliente not in ( :select envi.cliente.idCliente from PromocionEnviada envi where envi.promocion.idPromocion = ?3) and"
//            + " cli.inPromocion is ?2 and cli.empresa.idEmpresa = ?1 ")
//    public List<Cliente> findClientePorPromocion (Integer idEmpresa, Boolean inPromocion, Integer idPromocion);
//

    @Query(value = "select c.id_cliente, cl.id_local from ectm_cliente c\n" +
            "left join ectr_cliente_local cl on cl.id_cliente = c.id_cliente\n" +
            "left join ectm_persona p on p.id_persona = c.id_persona\n" +
            "where (cl.id_cliente is null or cl.fe_crea_registro = (select ultimo from (select id_cliente, max(fe_crea_registro) ultimo from ectr_cliente_local group by id_cliente) q where q.id_cliente = cl.id_cliente))\n" +
            "and c.id_cliente = ?1", nativeQuery = true)
    List<Object[]> consultaUltimoLocalCliente (Integer idCliente);

    @Query(value = "select c.id_cliente, cl.id_local from ectm_cliente c\n" +
            "left join ectr_cliente_local cl on cl.id_cliente = c.id_cliente\n" +
            "left join ectm_persona p on p.id_persona = c.id_persona\n" +
            "where (cl.id_cliente is null or cl.fe_crea_registro = (select ultimo from (select id_cliente, max(fe_crea_registro) ultimo from ectr_cliente_local group by id_cliente) q where q.id_cliente = cl.id_cliente))\n" +
            "and ((?1) = 0 or id_local = cast((?1) as integer))\n" +
            "and ((?2 = 0 and ?3 = 0) or (date_part('year', age(p.fe_nacimiento)) >= ?2\n" +
            "and (?3 = 0 or ?3 >= date_part('year', age(p.fe_nacimiento)))))", nativeQuery = true)
    List<Object[]> consultaLocalesCliente (Integer idLocal, Integer edadMin, Integer edadMax);

    @Query("select c from Cliente c " +
            "join c.persona p " +
            "join p.tipoDocumento t " +
            "where (c.idCliente in (:idClientes)) " +
            "and (:apPersona is null or p.apPersona like :apPersona) " +
            "and (:amPersona is null or p.amPersona like :amPersona) " +
            "and (:noPersona is null or p.noPersona like :noPersona) " +
            "and (:nuDocumento is null or p.nuDocumento like :nuDocumento) " +
            "and (:coTipoDocumento is null or t.coTipoDocumento = :coTipoDocumento) " +
            "and (:inPromocion is null or c.inPromocion = :inPromocion)")
    Page<Cliente> consultaCliente (@Param("apPersona") String apPersona,
                                   @Param("amPersona") String amPersona,
                                   @Param("noPersona") String noPersona,
                                   @Param("nuDocumento") String nuDocumento,
                                   @Param("coTipoDocumento") String coTipoDocumento,
                                   @Param("inPromocion") Boolean inPromocion,
                                   @Param("idClientes") List<Integer> idClientes,
                                   Pageable pageable);

    @Query("select c from Cliente c " +
            "join c.persona p " +
            "join p.tipoDocumento t " +
            "where (c.idCliente in (:idClientes)) " +
            "and (:apPersona is null or p.apPersona like :apPersona) " +
            "and (:amPersona is null or p.amPersona like :amPersona) " +
            "and (:noPersona is null or p.noPersona like :noPersona) " +
            "and (:nuDocumento is null or p.nuDocumento like :nuDocumento) " +
            "and (:coTipoDocumento is null or t.coTipoDocumento = :coTipoDocumento) " +
            "and (:inPromocion is null or c.inPromocion = :inPromocion)")
    List<Cliente> consultaCliente (@Param("apPersona") String apPersona,
                                   @Param("amPersona") String amPersona,
                                   @Param("noPersona") String noPersona,
                                   @Param("nuDocumento") String nuDocumento,
                                   @Param("coTipoDocumento") String coTipoDocumento,
                                   @Param("inPromocion") Boolean inPromocion,
                                   @Param("idClientes") List<Integer> idClientes);
   
}
