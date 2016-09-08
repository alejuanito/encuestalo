/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service;

import com.encuestas.data.bean.ClienteBean;
import com.encuestas.data.model.Cliente;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ClienteService {

    ClienteBean createCliente(ClienteBean cliente, String userName);

    ClienteBean actualizar (ClienteBean clienteBean);

    List<Cliente> findCliente(String nuDocumento, String coTipoDocumento);

    List<ClienteBean> getClientePromocion(Integer idEmpresa, Boolean inPromocion, Integer idPromocion, Integer idLocal);

    /**
     * Consulta a cliente paginado
     * @param apPersona apellido paterno
     * @param amPersona apellido materno
     * @param noPersona nombres
     * @param coTipoDocumento tipo de documento
     * @param nuDocumento número de documento
     * @param idLocal identifcador del local
     * @param edadMin edad minima de consulta
     * @param edadMax edad maxima de consulta
     * @param inPromocional si tiene o no promocion activado
     * @param page pagina de consulta
     * @param size tamanio de la pagina
     * @return pagina con los clientes resultado de la consulta
     */
    Page<ClienteBean> consultaCliente (String apPersona, String amPersona,
                          String noPersona, String coTipoDocumento,
                          String nuDocumento,
                          Integer idLocal, Integer edadMin, Integer edadMax,
                          Boolean inPromocional, Integer page, Integer size);

    /**
     * Consulta a cliente sin paginación
     * @param apPersona apellido paterno
     * @param amPersona apellido materno
     * @param noPersona nombres
     * @param coTipoDocumento tipo de documento
     * @param nuDocumento número de documento
     * @param idLocal identifcador del local
     * @param edadMin edad minima de consulta
     * @param edadMax edad maxima de consulta
     * @param inPromocional si tiene o no promocion activado
     * @return lista de resultados de la consulta
     */
    List<ClienteBean> consultaCliente (String apPersona, String amPersona,
                                       String noPersona, String coTipoDocumento,
                                       String nuDocumento,
                                       Integer idLocal, Integer edadMin, Integer edadMax,
                                       Boolean inPromocional);
}
