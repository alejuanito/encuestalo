/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.encuestas.data.bean.ClienteBean;
import com.encuestas.data.model.Cliente;


public class ClienteBeanConverter implements DataConverter<ClienteBean,Cliente> {

    @Override
    public List<Cliente> convertList(List<ClienteBean> dataList) {
        List<Cliente> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }	
        for (ClienteBean local : dataList) {
            data.add(convert(local));
        }
        return data;
    }

    @Override
    public Cliente convert(ClienteBean cliente) {
        if (cliente == null) {
            return null;
        }
        Cliente clienteBean = new Cliente();
       
        clienteBean.setEmpresa(new EmpresaBeanConverter().convert(cliente.getEmpresa()));
        clienteBean.setPersona(new PersonaBeanConverter().convert(cliente.getPersona()));
        clienteBean.setIdCliente(cliente.getIdCliente());
        clienteBean.setInPromocion(cliente.getInPromocion());
        
        return clienteBean;
    }
    
}
