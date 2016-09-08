/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import com.encuestas.data.bean.ClienteLocalBean;
import java.util.ArrayList;
import java.util.List;

import com.encuestas.data.model.ClienteLocal;

/**
 *
 * @author e00309
 */
public class ClienteLocalBeanToModelConverter implements DataConverter<ClienteLocalBean, ClienteLocal> {

    @Override
    public List<ClienteLocal> convertList(List<ClienteLocalBean> dataList) {
        List<ClienteLocal> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (ClienteLocalBean tipo : dataList) {
            data.add(convert(tipo));
        }
        return data;
    }

    @Override
    public ClienteLocal convert(ClienteLocalBean clienteBean) {
        if (clienteBean == null) {
            return null;
        }
        ClienteLocal clienteLocal = new ClienteLocal();
        clienteLocal.setCliente(new ClienteBeanConverter().convert(clienteBean.getCliente()));
        clienteLocal.setFeCreaRegistro(clienteBean.getFeCreaRegistro());
        clienteLocal.setIdClienteLocal(clienteBean.getIdClienteLocal());
        clienteLocal.setLocal(new LocalBeanConverter().convert(clienteBean.getLocal()));
        return clienteLocal;
    }
    
}
