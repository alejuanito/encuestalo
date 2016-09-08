/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.encuestas.data.bean.ClienteBean;
import com.encuestas.data.bean.LocalBean;
import com.encuestas.data.model.Cliente;
import com.encuestas.data.model.Local;


public class ClienteConverter implements DataConverter<Cliente,ClienteBean> {
    private Map<Integer, Local> localMap;
    private Map<Integer, Integer> clienteXLocalMap;

    public ClienteConverter () {
        localMap = null;
        clienteXLocalMap = null;
    }

    public ClienteConverter (Map<Integer, Local> localMap, Map<Integer, Integer> clienteXLocalMap) {
        this.localMap = localMap;
        this.clienteXLocalMap = clienteXLocalMap;
    }

    @Override
    public List<ClienteBean> convertList(List<Cliente> dataList) {
        List<ClienteBean> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }	
        for (Cliente local : dataList) { // tmr :'(
            data.add(convert(local));
        }
        return data;
    }

    @Override
    public ClienteBean convert(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        ClienteBean clienteBean = new ClienteBean();
        clienteBean.setEmpresa(new EmpresaConverter().convert(cliente.getEmpresa()));
        clienteBean.setPersona(new PersonaConverter().convert(cliente.getPersona()));
        clienteBean.setIdCliente(cliente.getIdCliente());
        clienteBean.setInPromocion(cliente.getInPromocion());

        if (localMap != null && clienteXLocalMap != null) {
            Integer idLocal = clienteXLocalMap.get(cliente.getIdCliente());
            if (idLocal != null) {
                LocalConverter localConverter = new LocalConverter();
                clienteBean.setUltimoLocalVisitado(localConverter.convert(localMap.get(idLocal)));
            }
        }
        return clienteBean;
    }
    
}
